package com.verticon.tracker.irouter.deployment.agent;


import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.osgi.service.deploymentadmin.DeploymentAdmin;
import org.osgi.service.deploymentadmin.DeploymentException;
import org.osgi.service.deploymentadmin.DeploymentPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DeploymentAgent {
	private static final String IROUTER_DEPLOYMENTPACKAGE_DIR = "com.verticon.tracker.irouter.dp.dir";
	/**
	 * slf4j Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(DeploymentAgent.class);

	@Override
	public String toString() {
		return "DeploymentAgent";
	}

	public void setService(DeploymentAdmin deploymentAdmin) {
		if(deploymentAdmin == null){
			logger.warn(
						"{}: No DeploymentAdmin Service found, so could not load the Deployment Package",
						this);
			return;
		}
		
		String pathname = System.getProperty(IROUTER_DEPLOYMENTPACKAGE_DIR);
		logger.info("{}: Loading Deployment Packages from {}",this, pathname);
		File dir = new File(pathname);
		if(!dir.isDirectory()){
			logger.error("{}: Path to deployment package was not a directory {}", new Object[]{this, dir});
			return;
		}
		
		File[] files = dir.listFiles(new FileFilter(){

			@Override
			public boolean accept(File pathname) {
				return pathname.isFile() && pathname.getName().toLowerCase().endsWith("dp");
			}});
		if(files.length==0){
			logger.error("{}: Could not find any deployment packages at {}",this, dir);
			return;
		}
			
		for (File file : files) {
			try {
				DeploymentPackage dp = deploymentAdmin.installDeploymentPackage(new FileInputStream(file));
				logger.info("{}: Installed Deployment Package {} version {} {}", new Object[]{
						this, dp.getName(), dp.getHeader("DeploymentPackage-Version"), dp.getHeader("DeploymentPackage-Copyright")});
			
			} catch (FileNotFoundException e) {
				logger.error("{}: Could not find deployment package at {}", new Object[]{this, file});
			} catch (DeploymentException e) {
				logger.error(this+ ": Could not load deployment package at "+file, e);
			}
		}
		
	}

	public void unsetService(DeploymentAdmin deploymentAdmin) {
		//ignore
	}
	
	
}
