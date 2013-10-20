This project is a releng builder for the com.verticon.tracker.product.desktop project.

=======================================
Notes

1) Most recent build used Kepler 4.3.1

2) This build requires the deltapack.  By default it looks beside the eclipse install for "deltapack/eclipse/*".  
   If your deltapack is located elsewhere, set the "deltapack" property or edit the buildProduct.xml file.  The
   version of the deltapack used should match the version of the eclipse that is running.

3) Due to bug 268867, if the buildDirectory/buildRepo is deleted/cleaned, then the repo must also be removed from 
   the workspace Available Software Sites preferences.
    
4) Use the included launch config, or run buildProduct.xml as an ant build using the same JRE as the workspace

5) The build.properties file specifically defines the JRE's for CDC-1.1/Foundation-1.1 and
   J2SE-1.6 because these are the required bundle execution environments in the example.
   The build should be run on a 1.6 VM.
   
   
=======================================
Build Instructions

For releases:
1. Old repos can be removed or left in place.  If left in place artifacts of the same 
version overwrite the preexisting ones. 
2. Product build: 
	a. Edit the compositeArtifacts.xml and compositeContent.xml to add a new directory for the product.
	b. Add delta pack for release
	c. Create or update the target platform  and export it to a directory
	c. Edit the buildProduct.properties to reference the new delta pack and the exported target as well as the 
	 release names 
	d. Run "Build Tracker.launch" - to build product and product p2 metadata
3. Feature build:
    a. Edit the compositeArtifacts.xml and compositeContent.xml to add a new directory containing the features.
    b. Categorize new feature in the categories/content.xml file.
    c. From any feature, export all new features to the repository.
       This will deploys p2 metadata to repository. (updatesite/catalog.xml specs the categories)
4. Test latest product with new features in dev workspace. (Add a local repository pointing to the relang repo.)
5. Run Sync S3.launch - Moves all artifacts over to ~/Uploads/s3 and mirrors these to S3.
6. Sync any changed documentation to S3 - see documentation
7. Change downloads page on website and sync it. - see website

=======================================
Tagging a release

HowTo? 

1. In SVN Repository View select the tracker/trunk in the context menu 
refactor>copyTo 

2. A CopyTo dialog will show. Select the tags branch in the tree.

3. In the lower part of the CopyTo dialog it will ask what name to use. Use REL-desktop.beta.1.0