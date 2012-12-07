package com.verticon.birt.report.loader;

import static com.verticon.birt.report.loader.ReportLoaderActivator.bundleMarker;
import static org.eclipse.birt.report.viewer.ViewerPlugin.BIRT_VIEWER_ROOT_PATH;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

import org.eclipse.birt.report.designer.ui.ReportPlugin;
import org.eclipse.birt.report.designer.ui.util.ExceptionUtil;
import org.eclipse.birt.report.viewer.ViewerPlugin;
import org.eclipse.birt.report.viewer.utilities.WebViewer;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.jface.preference.IPreferenceStore;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.BundleListener;
import org.osgi.framework.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Waits for the org.eclipse.birt.report.viewer and
 * org.eclipse.birt.report.designer.ui plugins to be started, then copies all
 * reports and resources from report.pack bundles to the working path of the
 * ReportViewer; sets the preference for the resource folder to be the same as
 * the working path of the ReportViewer; and starts the server if the
 * start.webserver system property is set to true.
 * 
 * @author jconlon
 * 
 */
public class ReportLoader implements BundleListener {

	private static final String START_WEBSERVER_SYSTEM_PROPERTY = "start.webserver";

	private static final String REPORT_PACK = ".report.pack";

	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(ReportLoader.class);

	/**
	 * Need to start the lazy bundle with this static call
	 */
	@SuppressWarnings("static-access")
	private static final String VIEWER_PLUGIN_ID = ViewerPlugin.getDefault().PLUGIN_ID;
	private static final String REPORT_UI_PLUGIN_ID = "org.eclipse.birt.report.designer.ui"; //$NON-NLS-1$
	private final Set<String> startedBundles = new ConcurrentSkipListSet<String>();
	private final BundleContext context;

	final static List<String> TARGET_LIST;

	static {
		String[] targets = { "org.eclipse.emf.oda.ecore",
				"com.verticon.tracker", 
				"com.verticon.location.core.model",
				"com.verticon.agriculture.core.model",
				"com.verticon.google.kmlgx.core.model",
				"com.verticon.oasis.xal.core.model",
				"com.verticon.osgi.metatype.core.model",
				"com.verticon.tracker.fair",
				"com.verticon.tracker.store.admin.model", };
		TARGET_LIST = Arrays.asList(targets);
	}

	ReportLoader(BundleContext context) {
		super();
		this.context = context;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ReportLoader []";
	}

	@Override
	public void bundleChanged(BundleEvent event) {
		Bundle bundle = event.getBundle();
		loadAndStartServer(bundle);
	}

	/**
	 * 
	 * @param bundle
	 * @return true if this bundle state initialized server loading and startup
	 */
	boolean loadAndStartServer(Bundle bundle) {
		if (startedBundles.size() == 2) {
			return true;
		}
		if (bundle.getHeaders().get(Constants.BUNDLE_SYMBOLICNAME)
				.startsWith(VIEWER_PLUGIN_ID)
				&& bundle.getState() == Bundle.ACTIVE) {
			startedBundles.add(VIEWER_PLUGIN_ID);
			logger.debug(bundleMarker, "{}: Found BIRT PLUGIN {} was started",
					this, VIEWER_PLUGIN_ID);
			if (startedBundles.size() == 2) {
				initializeResourceLoadingAndStartup();
				return true;
			}
		} else if (bundle.getHeaders().get(Constants.BUNDLE_SYMBOLICNAME)
				.startsWith(REPORT_UI_PLUGIN_ID)
				&& bundle.getState() == Bundle.ACTIVE) {
			startedBundles.add(REPORT_UI_PLUGIN_ID);
			logger.debug(bundleMarker, "{}: Found BIRT PLUGIN {} was started",
					this, REPORT_UI_PLUGIN_ID);
			if (startedBundles.size() == 2) {
				initializeResourceLoadingAndStartup();
				return true;
			}
		}
		return false;
	}

	private void initializeResourceLoadingAndStartup() {
		String wp = System.getProperty(BIRT_VIEWER_ROOT_PATH);
		loadWebServerResources(wp);
		ReportPlugin rplugin = ReportPlugin.getDefault();// This will load the
															// ReportPlugin and
															// set the resources
		IPreferenceStore ps = rplugin.getPreferenceStore();
		setUserResourcePreference(wp, ps);
		try {
			startWebAppServer();
		} catch (CoreException e) {
			logger.error(bundleMarker, this + ": Failed to start server", e);
		}
	}

	/**
	 * 
	 * @param wp
	 */
	private void loadWebServerResources(String wp) {
		logger.debug(bundleMarker, "{}: Finding and Loading Report Packs", this);

		if (wp != null) {
			File workingPath = new File(wp);
			logger.debug(bundleMarker, "{}: Working path = {}", this, wp);

			if (workingPath.isDirectory()) {
				File path = new File(workingPath, "report");
				if (!path.exists()) {
					path.mkdir();
				}
				path = new File(path, "images");
				if (!path.exists()) {
					path.mkdir();
				}

				path = new File(workingPath, "resources");
				if (!path.exists()) {
					path.mkdir();
				}

				path = new File(workingPath, "scriptlib");
				if (!path.exists()) {
					path.mkdir();
				}

				loadWebServerResources(workingPath);

			} else {
				logger.warn(bundleMarker, "{}:  {}  is not a directory", this,
						wp);
			}
		} else {
			logger.warn(bundleMarker, "{}:  {}  is null", this,
					BIRT_VIEWER_ROOT_PATH);
		}

	}

	private void loadWebServerResources(File workingPath) {
		for (Bundle bundle : context.getBundles()) {
			loadWebServerResources(workingPath, bundle);
		}
	}

	private void loadWebServerResources(File workingPath, Bundle bundle) {
		String bundleSymbolicName = bundle.getSymbolicName();
		if (bundleSymbolicName != null
				&& bundleSymbolicName.endsWith(REPORT_PACK)) {
			logger.debug(bundleMarker, "{}: Processing reports from {}", this,
					bundleSymbolicName);
			try {
				copyBundleContents(bundle, "/report", "*.rptdesign",
						workingPath);
				copyBundleContents(bundle, "/report/images", "*", workingPath);
				copyBundleContents(bundle, "/resources", "*", workingPath);
			} catch (IOException e) {
				logger.error(bundleMarker, this + ":  Moving reports failed", e);
			}

		} else if (bundleSymbolicName.contains(".reports")) {
			logger.debug(bundleMarker, "{}: WILL NOT Process reports from {}",
					this, bundleSymbolicName);
		} else if (TARGET_LIST.contains(bundleSymbolicName)) {
			copyJar(bundle, workingPath);
		}
	}

	/**
	 * Find the jar of the bundle and move it to the scriptlib
	 * 
	 * @param bundle
	 * @param workingPath
	 */
	private void copyJar(Bundle bundle, File workingPath) {
		File destinationDirectory = new File(workingPath, "scriptlib");
		try {
			URL url = FileLocator.resolve(bundle.getEntry("/"));
			if (url.getProtocol().equals("jar")) {
				String jar = url.getFile();
				jar = jar.substring(5, jar.length() - 2);
				File jarFile = new File(jar);
				if (jarFile.exists()) {
					logger.info(
							bundleMarker,
							"{}: Found target file {} will move to {}",
							new Object[] { this, jarFile, destinationDirectory });
					copyJarIfNotExists(jarFile, destinationDirectory,
							bundle.getSymbolicName());
				} else {
					logger.warn(bundleMarker,
							"{}: target file {} doesnot exist", new Object[] {
									this, jarFile });
				}

			} else {
				logger.info(
						bundleMarker,
						"{}: Found target {} but it is not a jar so defered moving to {}",
						new Object[] { this, url, destinationDirectory });
			}
		} catch (IOException e) {
			logger.error(
					bundleMarker,
					this + ": Failed copying jar from bundle "
							+ bundle.getSymbolicName(), e);
		}
	}

	private boolean copyJarIfNotExists(File source, File destinationDirectory,
			String prefix) {
		File destination = new File(destinationDirectory, source.getName());
		if (destination.exists()) {
			logger.info(bundleMarker,
					"{}: Found existing file {} defered moving", this,
					destination);
			return false;
		}
		File oldTarget = null;
		for (File child : destinationDirectory.listFiles()) {
			if (child.getName().contains(prefix)) {
				oldTarget = child;
			}
		}
		if (oldTarget != null) {
			oldTarget.delete();
		}
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(source);
			out = new FileOutputStream(destination);
			byte buf[] = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0)
				out.write(buf, 0, len);

		} catch (Exception e) {
			logger.error(bundleMarker, this + ": Failed copying file "
					+ destination, e);
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				logger.error(bundleMarker, this + ": Failed copying file "
						+ destination, e);
			}
		}
		logger.info(bundleMarker, "{}: Copied file {}", this, destination);
		return true;

	}

	private void copyBundleContents(Bundle bundle, String path, String filter,
			File dir) throws IOException {
		Enumeration<URL> urls = bundle.findEntries(path, filter, false);
		if (urls == null) {
			return;
		}
		while (urls.hasMoreElements()) {
			URL url = urls.nextElement();
			if (url.toString().endsWith("/")) {
				continue;// Dont copy directories
			}
			File f = new File(dir, url.getFile());
			if (!f.exists()) {
				InputStream in = url.openStream();
				OutputStream out = new FileOutputStream(f);
				byte buf[] = new byte[1024];
				int len;
				while ((len = in.read(buf)) > 0)
					out.write(buf, 0, len);
				out.close();
				in.close();

				logger.info(bundleMarker, "{}: Loaded resource {}", this, f);
			} else {
				logger.debug(bundleMarker,
						"{}: Deferred loading existing resource {}", this, f);
			}

		}

	}

	private void setUserResourcePreference(String wp, IPreferenceStore ps) {
		if (wp != null) {
			String presistedResourceFolder = ps
					.getString(ReportPlugin.RESOURCE_PREFERENCE);
			if (presistedResourceFolder == null
					|| !wp.equals(presistedResourceFolder)) {
				logger.info(bundleMarker,
						"{}: Setting preference from {} to {} ", new Object[] {
								this,
								presistedResourceFolder == null ? "null"
										: presistedResourceFolder, wp });
				ps.setValue(ReportPlugin.RESOURCE_PREFERENCE, wp);
			} else {
				logger.info(bundleMarker,
						"{}: User resource folder preference already set to {} ",
								this, wp );
			}
		}

	}

	private void startWebAppServer() throws CoreException {
		String startupProp = System.getProperty(
				START_WEBSERVER_SYSTEM_PROPERTY, "false");
		if (startupProp.toLowerCase().equals("true")) {
			logger.info(bundleMarker, "{}: Starting Internal Webserver", this);
			// The following method of starting the webser
			// is not reading the user preference Report Design
			// classpaths properly, like a popup would do.
			// WebappAccessor.start("viewer", "org.eclipse.birt.report.viewer");
			// Instead mimic what happens when
			// org.eclipse.birt.report.designer.ui.ide.navigator.RunReportAction
			// is invoked and call the test report in the base directory.
			String url = "test.rptdesign";
			try {
				Map<String, String> options = new HashMap<String, String>();
				options.put(WebViewer.FORMAT_KEY, WebViewer.HTML);
				WebViewer.display(url, options);
			} catch (Exception e) {
				ExceptionUtil.handle(e);
				return;
			}
		}
	}

}
