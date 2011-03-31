/*******************************************************************************
 * Copyright (c) 2010 Verticon, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Verticon, Inc. - initial API and implementation
 *******************************************************************************/
package com.verticon.tracker.editor.presentation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Random;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.ISetSelectionTarget;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;

import com.verticon.tracker.Animal;
import com.verticon.tracker.BeefBreed;
import com.verticon.tracker.BovineBeef;
import com.verticon.tracker.Event;
import com.verticon.tracker.MovedIn;
import com.verticon.tracker.Premises;
import com.verticon.tracker.Sex;
import com.verticon.tracker.Sighting;
import com.verticon.tracker.Slaughtered;
import com.verticon.tracker.Swine;
import com.verticon.tracker.SwineBreed;
import com.verticon.tracker.Tag;
import com.verticon.tracker.TagApplied;
import com.verticon.tracker.TrackerFactory;
import com.verticon.tracker.TrackerPlugin;
import com.verticon.tracker.WeighIn;

public class SampleTrackerProjectWizard extends BasicNewResourceWizard {

	private static final String FAKE_FOREIGN_PIN = "HA92348";

	private static final String FAKE_PIN_FOR_PREMISE = "H89234X";

	private static final String EXAMPLE_CAPTURE_TAGS_FILE_NAME = "capture.tags";

	private static final String EXAMPLE_PREMISES_DOCUMENT_NAME = "example.premises";

	private static final String EXAMPLE_ANIMAL_DOCUMENT_NAME = "example.animal";

	private WizardNewProjectCreationPage mainPage;

	private IWorkbench workbench;

	/**
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
	 *      org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench aWorkbench,
			IStructuredSelection currentSelection) {
		super.init(workbench, currentSelection);
		this.workbench = aWorkbench;
		setWindowTitle("New Tracker Project"); //$NON-NLS-1$
		setNeedsProgressMonitor(true);
	}

	/**
	 * @see org.eclipse.jface.wizard.IWizard#addPages()
	 */
	public void addPages() {
		super.addPages();
		mainPage = new WizardNewProjectCreationPage("basicNewProjectPage");//$NON-NLS-1$
		mainPage.setTitle("Tracker Example Project"); //$NON-NLS-1$
		mainPage.setDescription("Create a new Tracker Example Project"); //$NON-NLS-1$
		this.addPage(mainPage);
	}

	/**
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	public boolean performFinish() {
		// get a project handle
		final IProject newProjectHandle = mainPage.getProjectHandle();
		IPath newPath = null;
		if (!mainPage.useDefaults())
			newPath = mainPage.getLocationPath();
		final IPath newProjectPath = newPath;
		final IFile[] newFile = new IFile[1];

		// create the new project operation
		WorkspaceModifyOperation op = createNewProjectOperation(
				newProjectHandle, newProjectPath, newFile);

		// run the new project creation operation
		try {
			getContainer().run(true, true, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			// ie.- one of the steps resulted in a core exception
			Throwable t = e.getTargetException();
			if (t instanceof CoreException) {
				ErrorDialog.openError(getShell(), "Creation Problems", //$NON-NLS-1$
					null, // no special message
					((CoreException) t).getStatus());
			} else {
				// CoreExceptions are handled above, but unexpected runtime
				// exceptions and errors may still occur.
				TrackerPlugin.getDefault().getLog().log(
					new Status(IStatus.ERROR, "TrackerPlugin", 0, t//$NON-NLS-1$
						.toString(), t));
				MessageDialog.openError(getShell(), "Creation Problems", //$NON-NLS-1$
					MessageFormat.format("Internal error: {0}", //$NON-NLS-1$
						new Object[] {t.getMessage()}));
			}
			return false;
		}

		// Select the new file resource in the current view.
		//
		IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
		IWorkbenchPage page = workbenchWindow.getActivePage();
		final IWorkbenchPart activePart = page.getActivePart();
		if (activePart instanceof ISetSelectionTarget) {
			final ISelection targetSelection = new StructuredSelection(
				newFile[0]);
			getShell().getDisplay().asyncExec(new Runnable() {

				public void run() {
					((ISetSelectionTarget) activePart)
						.selectReveal(targetSelection);
				}
			});
		}

		//Make a file
		try {
			createTagIDNumberFile( newProjectHandle,   EXAMPLE_CAPTURE_TAGS_FILE_NAME);
		} catch (CoreException e) {
			MessageDialog.openError(workbenchWindow.getShell(), "Create Tags File",//$NON-NLS-1$
					e.getMessage());
				return false;
		}
		
		//Create an animal document
		WorkspaceModifyOperation animalOp = createNewAnimalDocumentOperation(
				newProjectHandle, newProjectPath, new IFile[1]);
		runOp(animalOp);

		
		// Open an editor on the new file.
		//
		try {
			IDE.openEditor(page, newFile[0], "com.verticon.tracker.transaction.editor.TrackerEditorID", true);
		} catch (PartInitException exception) {
			MessageDialog.openError(workbenchWindow.getShell(), "Open Editor",//$NON-NLS-1$
				exception.getMessage()+
				"  Will try the basic editor instead.");
			
			try {
				IDE.openEditor(page, newFile[0], true);
			} catch (PartInitException exception2) {
				MessageDialog.openError(workbenchWindow.getShell(), "Open Editor",//$NON-NLS-1$
					exception.getMessage());
				return false;
			}
			
		}
		
		 addSampleQueries(activePart);
			
		return true;
	}

	/**
	 * @param activePart
	 */
	private void addSampleQueries(final IWorkbenchPart activePart) {
		String commandId = 
			"com.verticon.tracker.ocl.query.viewer.commands.addDefaultPremisesQueries";
		 IHandlerService handlerService = (IHandlerService) activePart.getSite()
	    .getService(IHandlerService.class);
			
		executeCommand(commandId, handlerService);
	}
	

	/**
	 * @param commandId
	 * @param handlerService
	 */
	private void executeCommand(final String commandId,
			final IHandlerService handlerService) {
		Display.getDefault().asyncExec(new Runnable() {
		    public void run() {
		    	try {
					handlerService.executeCommand(commandId,null);
				} catch (Exception e) {
					e.printStackTrace();
				} 
		    }
		});
	}
	
	
	private boolean runOp(IRunnableWithProgress op){
		// run the new project creation operation
		try {
			getContainer().run(true, true, op);
			return true;
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			// ie.- one of the steps resulted in a core exception
			Throwable t = e.getTargetException();
			if (t instanceof CoreException) {
				ErrorDialog.openError(getShell(), "Creation Problems", //$NON-NLS-1$
					null, // no special message
					((CoreException) t).getStatus());
			} else {
				// CoreExceptions are handled above, but unexpected runtime
				// exceptions and errors may still occur.
				TrackerPlugin.getDefault().getLog().log(
					new Status(IStatus.ERROR, "TrackerPlugin", 0, t//$NON-NLS-1$
						.toString(), t));
				MessageDialog.openError(getShell(), "Creation Problems", //$NON-NLS-1$
					MessageFormat.format("Internal error: {0}", //$NON-NLS-1$
						new Object[] {t.getMessage()}));
			}
			return false;
		}
	}
	


	/**
	 * @param newProjectHandle
	 * @param newProjectPath
	 * @param newFile
	 * @return
	 */
	private WorkspaceModifyOperation createNewProjectOperation(
			final IProject newProjectHandle, final IPath newProjectPath,
			final IFile[] newFile) {
		WorkspaceModifyOperation op = new WorkspaceModifyOperation() {

			@SuppressWarnings("deprecation")
			protected void execute(IProgressMonitor monitor)
				throws CoreException {
				try {
					monitor.beginTask("Creating New Project", 3000);//$NON-NLS-1$

					monitor.setTaskName("Create a project descriptor");//$NON-NLS-1$
					monitor.worked(1000);
					IWorkspace workspace = ResourcesPlugin.getWorkspace();
					final IProjectDescription description = workspace
						.newProjectDescription(newProjectHandle.getName());
					description.setLocation(newProjectPath);

					monitor.setTaskName("Create the new project");//$NON-NLS-1$
					newProjectHandle.create(description,
						new SubProgressMonitor(monitor, 1000));

					if (monitor.isCanceled())
						throw new OperationCanceledException();

					monitor.setTaskName("Open the new project");//$NON-NLS-1$
					newProjectHandle
						.open(new SubProgressMonitor(monitor, 1000));

					if (monitor.isCanceled())
						throw new OperationCanceledException();

					monitor.setTaskName("Create the new file");//$NON-NLS-1$
					monitor.worked(1000);
					newFile[0] = newProjectHandle
						.getFile(EXAMPLE_PREMISES_DOCUMENT_NAME);//$NON-NLS-1$
					ResourceSet resourceSet = new ResourceSetImpl();

					URI fileURI = URI.createPlatformResourceURI(newFile[0]
						.getFullPath().toString());

					Resource resource = resourceSet.createResource(fileURI);

					// Add the initial model object to the contents.
					//
					createPremisesModel(resource);

					try {
						// Save the contents of the resource to the file system.
						//
						resource.save(Collections.EMPTY_MAP);
					} catch (IOException e) {
						e.printStackTrace();
					}

				} finally {
					monitor.done();
				}
			}
		};
		return op;
	}
	
	
	
	private EObject createPremisesModel(Resource resource) {
		TrackerFactory trackerFactory = TrackerFactory.eINSTANCE;

		/* Simple Valley Ranch Premises */
		Premises premises = trackerFactory.createPremises();
		premises.setName("Simple Valley Ranch");//$NON-NLS-1$
		premises.setEmailContact("jack_condor@bogus.net");//$NON-NLS-1$
		premises.setPremisesId(FAKE_PIN_FOR_PREMISE);
		premises.setUri("http://www.simplevalleyranch.net");
		
		Calendar someBirthday = Calendar.getInstance();
		
		BovineBeef beef1 = trackerFactory.createBovineBeef();
		beef1.setBeefBreed(BeefBreed.DJ_LITERAL);
		someBirthday.add(Calendar.MONTH, -30);
		beef1.setBirthDate(someBirthday.getTime());
		beef1.setComments("Old Bully");
		beef1.setSex(Sex.M_LITERAL);
		Tag tag1 = trackerFactory.createTag();
		tag1.setId("840456789012341");
		beef1.getTags().add(tag1);
		premises.getAnimals().add(beef1);
		
		BovineBeef beef2 = trackerFactory.createBovineBeef();
		beef2.setBeefBreed(BeefBreed.DJ_LITERAL);
		someBirthday.add(Calendar.MONTH, -1);
		beef2.setBirthDate(someBirthday.getTime());
		beef2.setComments("Old Bessy");
		beef2.setSex(Sex.F_LITERAL);
		Tag tag2 = trackerFactory.createTag();
		tag2.setId("840456789012342");
		beef2.getTags().add(tag2);
		premises.getAnimals().add(beef2);
		
		BovineBeef beef3 = trackerFactory.createBovineBeef();
		beef3.setBeefBreed(BeefBreed.DJ_LITERAL);
		someBirthday.add(Calendar.MONTH, 10);
		beef3.setBirthDate(someBirthday.getTime());
		beef3.setComments("Young Billy");
		beef3.setSire(beef1);
		beef3.setDam(beef2);
		beef3.setSex(Sex.M_LITERAL);
		Tag tag3 = trackerFactory.createTag();
		tag3.setId("840456789012343");
		beef3.getTags().add(tag3);
		premises.getAnimals().add(beef3);
		
		BovineBeef beef4 = trackerFactory.createBovineBeef();
		beef4.setBeefBreed(BeefBreed.DJ_LITERAL);
		beef4.setBirthDate(someBirthday.getTime());
		beef4.setComments("Young Blackie");
		beef4.setSire(beef1);
		beef4.setDam(beef2);
		beef4.setSex(Sex.C_LITERAL);
		Tag tag4 = trackerFactory.createTag();
		tag4.setId("840456789012344");
		beef4.getTags().add(tag4);
		premises.getAnimals().add(beef4);
		
		BovineBeef beef5 = trackerFactory.createBovineBeef();
		beef5.setBeefBreed(BeefBreed.DJ_LITERAL);
		someBirthday.add(Calendar.MONTH, -7);
		beef5.setBirthDate(someBirthday.getTime());
		beef5.setComments("Brownie");
		beef5.setSex(Sex.C_LITERAL);
		Tag tag5 = trackerFactory.createTag();
		tag5.setId("840456789012345");
		beef5.getTags().add(tag5);
		premises.getAnimals().add(beef5);
		
		
		//Add some event to the animals
		createTestEvents( premises,  trackerFactory);
		
		//Add a couple of unassigned tags
		Tag tag6 = trackerFactory.createTag();
		tag6.setId("840456789012346");
		tag6.getEvents().add(trackerFactory.createTagAllocated());
		premises.getUnAppliedTags().add(tag6);
		
		Tag tag7 = trackerFactory.createTag();
		tag7.setId("840456789012347");
		tag7.getEvents().add(trackerFactory.createTagAllocated());
		premises.getUnAppliedTags().add(tag7);
		
		resource.getContents().add(premises);
		
		return premises;
	}
	
	private EObject createAnimalModel(Resource resource) {
		TrackerFactory trackerFactory = TrackerFactory.eINSTANCE;
		Swine swine = trackerFactory.createSwine();
		swine.setSwineBreed(SwineBreed.HA_LITERAL);
		swine.setComments("Created from an animal template");
		Tag tag1 = trackerFactory.createTag();
		swine.getTags().add(tag1);

		WeighIn event3 = trackerFactory.createWeighIn();
		tag1.getEvents().add(event3);
		
		Slaughtered event4 = trackerFactory.createSlaughtered();
		tag1.getEvents().add(event4);
		
		resource.getContents().add(swine);
		
		return swine;
	}

	static double getWeigh(int mean){
		Random r = new Random();
		return r.nextInt(100) + mean;
	}
	
	private final static void createTestEvents(Premises premises, TrackerFactory trackerFactory){
		Calendar sometime = Calendar.getInstance();
		sometime.add(Calendar.MONTH, -7);
		for (Animal animal : premises.getAnimals()) {
			EList<Event> events = animal.getTags().get(0).getEvents();
			
			TagApplied event1 = trackerFactory.createTagApplied();
			events.add(event1);
			
			MovedIn event2 = trackerFactory.createMovedIn();
			event2.setSourcePin(FAKE_FOREIGN_PIN);
			events.add(event2);
			
			Sighting event3 = trackerFactory.createSighting();
			events.add(event3);
			
			WeighIn event4 = trackerFactory.createWeighIn();
			event4.setWeight(getWeigh(200));
			events.add(event4);
			
			
			for (Event event : events) {
				sometime.add(Calendar.MINUTE, 2);
				event.setDateTime(sometime.getTime());
			}
			
			
		}
		sometime.add(Calendar.MONTH, 3);
		
		for (Animal animal : premises.getAnimals()) {
			sometime.add(Calendar.MINUTE, 2);
			EList<Event> events = animal.getTags().get(0).getEvents();
			
			WeighIn event4 = trackerFactory.createWeighIn();
			event4.setWeight(getWeigh(500));
			events.add(event4);
			event4.setDateTime(sometime.getTime());
		
		}
		
	}

	private void createTagIDNumberFile(final IProject project, final String fileName) throws CoreException{
		IFile txtFile;
		FileWriter fw = null;
		File tempFile = null;
		try {
			tempFile = java.io.File.createTempFile("dump", "tmp");
			fw = new FileWriter(tempFile);
			fw.write("840456789012348\n");
			fw.write("840456789012349\n");
			fw.write("840456789012350\n");
			fw.write("840456789012351\n");
			fw.write("840456789012352\n");
			fw.write("840456789012353\n");
			fw.write("840456789012354\n");
			fw.write("840456789012355\n");
			fw.flush();
			fw.close();
		} catch (IOException e1) {
			MessageDialog.openError(getShell(), "Creation Problems", //$NON-NLS-1$
					MessageFormat.format("Internal error: {0}", //$NON-NLS-1$
						new Object[] {e1.getMessage()}));
			return;
		}
		// you need to give some name and path to the file
		txtFile = project.getFile(fileName);
		 
		if (!txtFile.exists()) {
		    try {
			txtFile.create(new FileInputStream(tempFile), true,	null);
			} catch (CoreException e) {
				MessageDialog.openError(getShell(), "Creation Problems", //$NON-NLS-1$
						MessageFormat.format("Internal error: {0}", //$NON-NLS-1$
							new Object[] {e.getMessage()}));
				return;
			} catch (IOException e) {
				MessageDialog.openError(getShell(), "Creation Problems", //$NON-NLS-1$
						MessageFormat.format("Internal error: {0}", //$NON-NLS-1$
							new Object[] {e.getMessage()}));
				return;
			}
		} 

	}
	
	/**
	 * @param newProjectHandle
	 * @param newProjectPath
	 * @param newFile
	 * @return
	 */
	private WorkspaceModifyOperation createNewAnimalDocumentOperation(
			final IProject newProjectHandle, final IPath newProjectPath,
			final IFile[] newFile) {
		WorkspaceModifyOperation op = new WorkspaceModifyOperation() {

			@SuppressWarnings("deprecation")
			protected void execute(IProgressMonitor monitor)
				throws CoreException {
				try {
					monitor.beginTask("Creating New Animal Document", 3000);//$NON-NLS-1$

					
					monitor.setTaskName("Create the new animal document");//$NON-NLS-1$
					monitor.worked(1000);
					newFile[0] = newProjectHandle
						.getFile(EXAMPLE_ANIMAL_DOCUMENT_NAME);//$NON-NLS-1$
					ResourceSet resourceSet = new ResourceSetImpl();

					URI fileURI = URI.createPlatformResourceURI(newFile[0]
						.getFullPath().toString());

					Resource resource = resourceSet.createResource(fileURI);

					// Add the initial model object to the contents.
					//
					createAnimalModel(resource);

					try {
						// Save the contents of the resource to the file system.
						//
						resource.save(Collections.EMPTY_MAP);
					} catch (IOException e) {
						e.printStackTrace();
					}

				} finally {
					monitor.done();
				}
			}
		};
		return op;
	}
}
