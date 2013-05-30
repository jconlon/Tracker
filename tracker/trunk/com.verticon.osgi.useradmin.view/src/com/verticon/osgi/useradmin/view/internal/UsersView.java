package com.verticon.osgi.useradmin.view.internal;

import static com.google.common.collect.Sets.newHashSet;
import static com.verticon.osgi.useradmin.view.internal.Activator.getDefault;
import static com.verticon.osgi.useradmin.view.internal.SelectionState.NOTHING;
import static com.verticon.osgi.useradmin.view.internal.SelectionState.NOT_ADMINISTRATOR;
import static com.verticon.osgi.useradmin.view.internal.SelectionState.NO_ADMINISTRATORS;
import static com.verticon.osgi.useradmin.view.internal.SelectionState.NO_USER_ADMIN;
import static com.verticon.osgi.useradmin.view.internal.SelectionState.instance;

import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.part.ViewPart;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.useradmin.Authorization;
import org.osgi.service.useradmin.Group;
import org.osgi.service.useradmin.Role;
import org.osgi.service.useradmin.User;
import org.osgi.service.useradmin.UserAdmin;
import org.osgi.service.useradmin.UserAdminEvent;
import org.osgi.service.useradmin.UserAdminListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verticon.osgi.useradmin.authenticator.UserState;
import com.verticon.osgi.useradmin.authenticator.UserStateChangeListener;
import com.verticon.osgi.useradmin.ui.AdminResetPasswordDialog;
import com.verticon.osgi.useradmin.ui.Utils;
import com.verticon.osgi.useradmin.view.internal.UsersContentProvider.PropertiesNode;

/**
 * View for managing the OSGi UserAdmin Service database. <br>
 * <br>
 * This view will allow an authenticated User that is in the 'administrators'
 * Group to manage the creation and removal of Users, Groups, Group members, and
 * Group required members. <br>
 * <br>
 * A tree view visualizes the database. Nodes selected in the tree will enable
 * actions on a pull down menu. <br>
 * <br>
 * First step is for the user to pull down the menu and sign on with a username
 * and password. Once authenticated as the user and authorized as an
 * administrator all the nodes in the database will be shown in the tree.
 * 
 * If there is no administrators group and no user with the username the
 * administrator group and the user will be created, with the user give the
 * password and placed in the group. <br>
 * <br>
 * If the user has no password than the one from the prompt will be set. Note:
 * this is how to reset a password. Delete the property. <br>
 * <br>
 * This view works in conjunction with the Properties View to edit and create
 * properties for the Users and Groups.
 * 
 * <ul>
 * Here are the actions.
 * <li>Create a User</li>
 * <li>Create a Group</li>
 * <li>Remove a User,Group, Member, Required Member</li>
 * <li>Refresh the Tree</li>
 * <li>Authorize a User to a Group</li>
 * <li>Authenticate the current user as the administrator</li>
 * <li>Add roles to members</li>
 * 
 * </ul>
 * 
 * @author jconlon
 * 
 */
public class UsersView extends ViewPart implements UserAdminListener,
		UserStateChangeListener {
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(UsersView.class);

	private static final String INITIAL_ADMIN_USER_PASSWORD = "password";
	private static final String INITIAL_ADMIN_USER_NAME = "admin";

	private FilteredTree filteredTree;

	private IAction createUserAction;
	private IAction createGroupAction;
	private IAction refreshAction;

	// Conditionals
	/**
	 * Enabled on one or more groups or users but not both
	 */
	private IAction removeAction;

	/**
	 * Enabled on one user and one group
	 */
	private IAction hasRoleAction;
	private IAction isAssociatedWithAction;

	private IAction addRolesToMembersAction;
	private IAction removeRolesInMembersAction;

	private IAction addRolesToRequiredMembersAction;

	private IAction initializeAdministratorsAction;

	private IAction resetPasswordAction;

	private ServiceRegistration<?> userAdminListenerServiceRegistration;

	private ServiceRegistration<?> userStateChangeServiceRegistration;

	private final UsersContentProvider usersContentProvider = new UsersContentProvider();

	@Override
	public void createPartControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout());
		composite.setLayoutData(new GridData(GridData.FILL, GridData.FILL,
				true, true));

		createViewer(composite);
		createActions();

		getSite().setSelectionProvider(filteredTree.getViewer());

		userAdminListenerServiceRegistration = Activator.getDefault()
				.getBundle().getBundleContext()
				.registerService(UserAdminListener.class.getName(), this, null);

		userStateChangeServiceRegistration = Activator
				.getDefault()
				.getBundle()
				.getBundleContext()
				.registerService(UserStateChangeListener.class.getName(), this,
						null);
	}

	private void createViewer(Composite composite) {
		filteredTree = new FilteredTree(composite, SWT.BORDER | SWT.MULTI,
				new PatternFilter(), true);
		TreeViewer viewer = filteredTree.getViewer();

		viewer.setContentProvider(usersContentProvider);
		viewer.setLabelProvider(new UsersLabelProvider());
		viewer.setInput(Activator.getDefault());

	}

	private void createActions() {
		createUserAction = new Action() {
			@Override
			public void run() {
				createRole("user", Role.USER);
			}
		};
		createUserAction.setText("Create user");

		createGroupAction = new Action() {
			@Override
			public void run() {
				createRole("group", Role.GROUP);
			}
		};
		createGroupAction.setText("Create group");

		removeAction = new Action() {
			@Override
			public void run() {
				removeRoles();
			}
		};
		removeAction.setText("Remove");

		refreshAction = new Action() {
			@Override
			public void run() {
				filteredTree.getViewer().refresh();
			}
		};
		refreshAction.setText("Refresh");

		hasRoleAction = new Action() {
			@Override
			public void run() {
				hasRole();
			}
		};
		hasRoleAction.setText("Has Role");
		hasRoleAction
				.setToolTipText("Validates if the selected user has the role of the selected group");

		isAssociatedWithAction = new Action() {
			@Override
			public void run() {
				isAssociatedWith();
			}
		};
		isAssociatedWithAction.setText("Is Associated With");
		isAssociatedWithAction
				.setToolTipText("Validates if the selected user is in an association with the selected group.");

		addRolesToMembersAction = new Action() {
			@Override
			public void run() {
				addRolesToMembers();
			}
		};
		addRolesToMembersAction.setText("Add Roles to Group Members");
		addRolesToMembersAction
				.setToolTipText("Adds selected Roles to the selected Members of a Group");

		removeRolesInMembersAction = new Action() {
			@Override
			public void run() {
				removeRolesInMembers();
			}

		};
		removeRolesInMembersAction.setText("Remove Roles from Group Members");
		removeRolesInMembersAction
				.setToolTipText("Removes selected Roles from the selected Members of a Group");

		addRolesToRequiredMembersAction = new Action() {
			@Override
			public void run() {
				addRolesToRequiredMembers();
			}
		};
		addRolesToRequiredMembersAction
				.setText("Add Roles to Group Required Members");
		addRolesToRequiredMembersAction
				.setToolTipText("Adds selected Roles to the selected Required Members of a Group");

		initializeAdministratorsAction = new Action() {
			@Override
			public void run() {
				createInitialAdministrator();
			}
		};
		initializeAdministratorsAction.setText("Initialize Administrators");
		initializeAdministratorsAction
				.setToolTipText("Creates a new administrators group and adds a default admin user.");

		resetPasswordAction = new Action() {
			@Override
			public void run() {
				resetPassword();
			}
		};
		resetPasswordAction.setText("Reset User password");
		resetPasswordAction
				.setToolTipText("Resets a user password to a known value.");

		MenuManager menuManager = new MenuManager("#PopupMenu");

		menuManager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));

		IMenuListener listener = new IMenuListener() {
			@Override
			public void menuAboutToShow(IMenuManager manager) {
				manager.add(hasRoleAction);
				manager.add(isAssociatedWithAction);
				manager.add(new Separator());
				manager.add(createUserAction);
				manager.add(createGroupAction);
				manager.add(new Separator());
				manager.add(addRolesToMembersAction);
				manager.add(removeRolesInMembersAction);
				manager.add(addRolesToRequiredMembersAction);

				manager.add(new Separator());
				manager.add(removeAction);
				manager.add(new Separator());
				manager.add(refreshAction);
				manager.add(new Separator());
				manager.add(initializeAdministratorsAction);
				manager.add(resetPasswordAction);
				SelectionState state = evaluateState();

				removeRolesInMembersAction.setEnabled(false);
				removeAction.setEnabled(false);
				hasRoleAction.setEnabled(false);
				isAssociatedWithAction.setEnabled(false);
				addRolesToMembersAction.setEnabled(false);
				addRolesToRequiredMembersAction.setEnabled(false);
				createUserAction.setEnabled(false);
				createGroupAction.setEnabled(false);
				initializeAdministratorsAction.setEnabled(false);
				resetPasswordAction.setEnabled(false);
				refreshAction.setEnabled(false);
				// System.out.printf("State = %s%n", state);
				logger.debug(Activator.bundleMarker, "Selection State {}",
						state);

				switch (state) {
				case USER:
					resetPasswordAction.setEnabled(true);
				case GROUP:
				case GROUPS:
				case USERS:
					removeAction.setEnabled(true);
					createUserAction.setEnabled(true);
					createGroupAction.setEnabled(true);
					refreshAction.setEnabled(true);
					break;
				case ROLE_AND_GROUP:
					hasRoleAction.setEnabled(true);
					isAssociatedWithAction.setEnabled(true);
					removeAction.setEnabled(true);
					createUserAction.setEnabled(true);
					createGroupAction.setEnabled(true);
					refreshAction.setEnabled(true);
					break;
				case ROLES_AND_ONE_MEMBERS:
					addRolesToMembersAction.setEnabled(true);
					createUserAction.setEnabled(true);
					createGroupAction.setEnabled(true);
					refreshAction.setEnabled(true);
					break;
				case ROLES_AND_ONE_REQUIRED_MEMBERS:
					addRolesToRequiredMembersAction.setEnabled(true);
					createUserAction.setEnabled(true);
					createGroupAction.setEnabled(true);
					refreshAction.setEnabled(true);
					break;
				case NO_ADMINISTRATORS:
					createUserAction.setEnabled(false);
					createGroupAction.setEnabled(false);
					refreshAction.setEnabled(false);
					initializeAdministratorsAction.setEnabled(true);
					break;
				case NOT_ADMINISTRATOR:
					createUserAction.setEnabled(false);
					createGroupAction.setEnabled(false);
					refreshAction.setEnabled(false);
					break;
				case ROLES_IN_MEMBERS:
					removeRolesInMembersAction.setEnabled(true);
					createUserAction.setEnabled(true);
					createGroupAction.setEnabled(true);
					refreshAction.setEnabled(true);
					break;
				case ROLES_IN_REQUIRED_MEMBERS:
					removeRolesInMembersAction.setEnabled(true);
					createUserAction.setEnabled(true);
					createGroupAction.setEnabled(true);
					refreshAction.setEnabled(true);
					break;
				case NO_USER_ADMIN:
					break;
				case NOTHING:
				default:
					createUserAction.setEnabled(true);
					createGroupAction.setEnabled(true);
					refreshAction.setEnabled(true);
					break;
				}

			}

		};

		menuManager.addMenuListener(listener);
		menuManager.setRemoveAllWhenShown(true);
		getSite().registerContextMenu(menuManager,
				getSite().getSelectionProvider());
		Tree tree = filteredTree.getViewer().getTree();
		tree.setMenu(menuManager.createContextMenu(tree));
	}

	private SelectionState evaluateState() {

		SelectionState state = NOTHING;
		if (Activator.getDefault().getUserAdmin() == null) {
			state = NO_USER_ADMIN;
		} else if (!getDefault().hasAdministrator()) {
			state = NO_ADMINISTRATORS;
		} else if (!getDefault().isUserAdmininistrator()) {
			state = NOT_ADMINISTRATOR;
		} else {
			state = instance(getSelection());
		}
		return state;
	}

	@Override
	public void setFocus() {
		filteredTree.getFilterControl().setFocus();
	}

	/**
	 * Validate if the selected user has the role of the selected group group
	 */
	private void hasRole() {
		User user = null;
		Role role = null;
		IStructuredSelection selection = getSelection();
		for (Iterator<?> i = selection.iterator(); i.hasNext();) {
			Object o = i.next();
			if (o instanceof Role) {
				Role r = (Role) o;
				if (Role.USER == r.getType()) {
					user = (User) r;
				} else {
					role = r;
				}
			}
		}

		if (user == null || role == null) {
			MessageDialog.openError(getSite().getShell(),
					"Has Role Validation",
					"Selection must be a Role and an User.");
			return;
		}

		String results = has(user, role);
		if (results.contains("NOT in")) {
			MessageDialog.openError(getSite().getShell(),
					"Has Role Validation Failed", results);
		} else {
			MessageDialog.openInformation(getSite().getShell(),
					"Has Role Validation", results);
		}
	}

	/**
	 * Validate if the selected user has the role of the selected group group
	 */
	private void isAssociatedWith() {
		User user = null;
		Role role = null;
		IStructuredSelection selection = getSelection();
		for (Iterator<?> i = selection.iterator(); i.hasNext();) {
			Object o = i.next();
			if (o instanceof Role) {
				Role r = (Role) o;
				if (Role.USER == r.getType()) {
					user = (User) r;
				} else {
					role = r;
				}
			}
		}

		if (user == null || role == null) {
			MessageDialog.openError(getSite().getShell(),
					"Is Associated With Validation",
					"Selection must be a Role and an User.");
			return;
		}

		String results = isAssociated(user, role);
		if (results.contains("NOT in")) {
			MessageDialog.openError(getSite().getShell(),
					"Is Associated With Validation Failed", results);
		} else {
			MessageDialog.openInformation(getSite().getShell(),
					"Is Associated With Validation", results);
		}
	}

	/**
	 * This will present a dialog to the user requesting userName and Password
	 * If this is the first time the service is being used and there is no
	 * administrators group one will be created.
	 */
	private void createInitialAdministrator() {

		UserAdmin userAdmin = Activator.getDefault().getUserAdmin();

		// If there is no administrators group set one up
		Group administrators = (Group) userAdmin
				.getRole(Activator.ADMINISTRATORS);
		if (administrators != null) {
			MessageDialog.openError(getSite().getShell(),
					"UserAdmin DB Initialization Failed",
					"Admin group already exists!");

			return;
		}

		// Is there a user?
		Role role = userAdmin.getRole(INITIAL_ADMIN_USER_NAME);
		if (role != null && role.getType() != Role.USER) {
			MessageDialog.openError(getSite().getShell(),
					"UserAdmin DB Initialization Failed", String.format(
							"Role name %s exists but it is not a user.",
							INITIAL_ADMIN_USER_NAME));
			return;
		}
		User user = null;
		if (role != null) {
			user = (User) role;
			try {
				boolean ok = Utils.isAuthenticate(user,
						INITIAL_ADMIN_USER_PASSWORD);
				if (!ok) {
					MessageDialog
							.openError(
									getSite().getShell(),
									"UserAdmin DB Initialization Failed",
									String.format(
											"Role name %s exists but failed authentication.",
											INITIAL_ADMIN_USER_NAME));
					return;
				}
			} catch (Exception e) {
				MessageDialog.openError(getSite().getShell(),
						"UserAdmin DB Initialization Failed",
						e.getLocalizedMessage());
				return;
			}
		} else {
			user = (User) userAdmin.createRole(INITIAL_ADMIN_USER_NAME,
					Role.USER);
			try {
				Utils.resetPassword(user, INITIAL_ADMIN_USER_PASSWORD);
			} catch (Exception e) {
				MessageDialog.openError(getSite().getShell(),
						"UserAdmin DB Initialization Failed",
						e.getLocalizedMessage());
				return;
			}
		}

		administrators = (Group) userAdmin.createRole(Activator.ADMINISTRATORS,
				Role.GROUP);

		administrators.addMember(user);

		MessageDialog
				.openInformation(
						getSite().getShell(),
						"UserAdmin DB Initialization",
						String.format(
								"New administrator %s created. Signon to manage the database.",
								INITIAL_ADMIN_USER_NAME));
		logger.info(Activator.bundleMarker,
				"New administrators group and administrator user {} created.",
				INITIAL_ADMIN_USER_NAME);
		return;

	}

	private String has(User user, Role role) {
		Authorization authorization = Activator.getDefault().getUserAdmin()
				.getAuthorization(user);
		boolean ok = authorization.hasRole(role.getName());
		// System.out.println("In group " + role.getName() + " ? " + ok);
		String result = String.format("%s is %s the Group named %s.",
				user.getName(), ok ? "in" : "NOT in", role.getName());
		return result;
	}

	private String isAssociated(User user, Role role) {
		Authorization authorization = Activator.getDefault().getUserAdmin()
				.getAuthorization(user);
		boolean ok = Utils.isAssociatedWith(authorization, role, Activator
				.getDefault().getUserAdmin());
		// System.out.println("In group " + role.getName() + " ? " + ok);
		String result = String.format(
				"%s is %s association with the Group named %s.",
				user.getName(), ok ? "in" : "NOT in", role.getName());
		return result;
	}

	private void createRole(String who, int type) {
		InputDialog dialog = new InputDialog(getSite().getShell(), "Create "
				+ who, "Name", "", null);
		if (dialog.open() != InputDialog.OK) {
			return;
		}

		String value = dialog.getValue();

		if (value.trim().length() == 0) {
			MessageDialog.openError(getSite().getShell(), "Create " + who,
					"Name cannot be empty.");
			return;
		}

		Role newRole = null;

		try {
			newRole = getDefault().getUserAdmin().createRole(value, type);
		} catch (RuntimeException e) {
			getDefault().getLog().log(
					new Status(IStatus.ERROR, Activator.PLUGIN_ID, e
							.getMessage(), e));
		}

		if (newRole == null) {
			return;
		}

		IStructuredSelection selection = getSelection();
		for (Iterator<?> i = selection.iterator(); i.hasNext();) {
			Object o = i.next();
			if (o instanceof PropertiesNode) {
				PropertiesNode node = (PropertiesNode) o;
				if (node.getType() == PropertiesNode.MEMBERS) {
					node.getParent().addMember(newRole);
					logger.info(Activator.bundleMarker,
							"Added {} to {} members.", newRole.getName(), node
									.getParent().getName());
				} else {
					node.getParent().addRequiredMember(newRole);
					logger.info(Activator.bundleMarker,
							"Added {} to {} requried members.",
							newRole.getName(), node.getParent().getName());
				}
			}
		}
	}

	private void removeRoles() {
		IStructuredSelection selection = getSelection();

		try {
			for (Iterator<?> i = selection.iterator(); i.hasNext();) {
				Object o = i.next();
				if (o instanceof Role) {
					Role role = (Role) o;
					removeFromAllGroups(role);
					UserAdmin userAdmin = getDefault().getUserAdmin();
					userAdmin.removeRole(role.getName());
					logger.info(Activator.bundleMarker, "Removed {}.",
							role.getName());
				}
			}
			filteredTree.getViewer().setInput(getDefault());
		} catch (RuntimeException e) {
			getDefault().getLog().log(
					new Status(IStatus.ERROR, Activator.PLUGIN_ID, e
							.getMessage(), e));
		}
	}

	/**
	 * This is a workaround of a bug in the felix implementation that does not
	 * remove roles from groups when the roles are removed individually.
	 * 
	 * @param role
	 */
	private void removeFromAllGroups(Role role) {
		for (PropertiesNode[] nodes : usersContentProvider.nodesCache.values()) {
			for (PropertiesNode node : nodes) {
				boolean removed = node.getParent().removeMember(role);
				if (removed) {
					logger.info(Activator.bundleMarker,
							"Removed {} from {} members.", role.getName(), node
									.getParent().getName());
				}

			}
		}
	}

	private void resetPassword() {
		IStructuredSelection selection = getSelection();
		User user = (User) selection.getFirstElement();

		AdminResetPasswordDialog dialog = new AdminResetPasswordDialog(
				getSite().getShell());
		dialog.create();

		if (dialog.open() == Window.OK) {

			String password = dialog.getPassword();

			try {
				Utils.resetPassword(user, password);

				MessageDialog.openInformation(getSite().getShell(),
						"Password Reset", "Changed password.");
				logger.info(Activator.bundleMarker, "Reset {} password.",
						user.getName());

			} catch (Exception e) {
				MessageDialog.openError(getSite().getShell(), "Password Reset",
						e.getLocalizedMessage());
			}
		}

	}

	/**
	 * There are Users and one Group Members selected add the users to the Group
	 * members.
	 */
	private void addRolesToMembers() {
		IStructuredSelection selection = getSelection();
		Set<Role> roles = newHashSet();
		Group group = null;
		for (Iterator<?> i = selection.iterator(); i.hasNext();) {
			Object o = i.next();
			if (o instanceof Role) {

				roles.add((Role) o);

			} else if (o instanceof PropertiesNode) {
				group = ((PropertiesNode) o).getParent();
			}
		}
		for (Role role : roles) {
			group.addMember(role);
			logger.info(Activator.bundleMarker, "Added {} to {} members.",
					role, group.getName());
		}

	}

	private void removeRolesInMembers() {
		IStructuredSelection selection = getSelection();
		Set<Role> roles = newHashSet();
		Group group = null;
		for (Iterator<?> i = selection.iterator(); i.hasNext();) {
			Object o = i.next();
			if (o instanceof Role) {

				roles.add((Role) o);

			} else if (o instanceof PropertiesNode) {
				group = ((PropertiesNode) o).getParent();
			}
		}
		for (Role role : roles) {
			group.removeMember(role);
			logger.info(Activator.bundleMarker, "Added {} to {} members.",
					role, group.getName());
		}

	}

	/**
	 * There are Users and one Group Members selected add the users to the Group
	 * required members.
	 */
	private void addRolesToRequiredMembers() {
		IStructuredSelection selection = getSelection();
		Set<Role> roles = newHashSet();
		Group group = null;
		for (Iterator<?> i = selection.iterator(); i.hasNext();) {
			Object o = i.next();
			if (o instanceof Role) {

				roles.add((Role) o);

			} else if (o instanceof PropertiesNode) {
				group = ((PropertiesNode) o).getParent();
			}
		}
		for (Role role : roles) {
			group.addRequiredMember(role);
			logger.info(Activator.bundleMarker,
					"Added {} to {} required members.", role, group.getName());
		}
	}

	@Override
	public void roleChanged(UserAdminEvent event) {
		getSite().getShell().getDisplay().asyncExec(new Runnable() {
			@Override
			public void run() {
				if (!filteredTree.isDisposed()) {
					filteredTree.getViewer().refresh();
				}
			}
		});
	}

	@Override
	public void dispose() {
		super.dispose();
		userStateChangeServiceRegistration.unregister();
		userAdminListenerServiceRegistration.unregister();
	}

	private IStructuredSelection getSelection() {
		return (IStructuredSelection) filteredTree.getViewer().getSelection();
	}

	@Override
	public void handle(String userName, UserState oldState, UserState newState) {
		roleChanged(null);

	}
}
