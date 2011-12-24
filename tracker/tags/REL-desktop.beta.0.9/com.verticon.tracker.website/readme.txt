This project is a builder for the com.verticon.tracker website.

=======================================
Notes

The docBook external resources reside in /opt/Docbook/Silkpage and are referenced
by the build.

build.properties specify build PROPERTIES (duh)

cfg/catalog.xml specify critical xml resources.  (Don't forget next time!)

?Does the website.database.xml need to be in the repo?

=======================================
Build Instructions

For Product releases:
0. Prepare and upload product and documentation artifacts.  See com.verticon.tracker.product.desktop.releng and
   com.verticon.tracker.documentation readme.txt instructions.
    
1. Note it is not necessary to manually edit the file names in the downloads page to match the 
   real product archives as this is taken care of by the script referring to an properties file
   in the com.verticon.tracker.product.desktop.releng that was created during the product build. 

2. Run Buckminster: deploy.to.local.repo.dir - to move all artifacts 
   over to ~/Uploads/s3.  
   
3. Test the site from ~/Uploads/s3 /index.html  make sure you can get to all link targets.  

4. Go to com.verticon.tracker.product.desktop.releng 
and run `Sync S3.launch`