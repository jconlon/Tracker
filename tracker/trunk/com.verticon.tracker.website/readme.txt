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
   real product archives as this is taken care of by the script referring to a properties file
   in the com.verticon.tracker.product.desktop.releng that was created during the product build. 

2. Commit changes to subversion to update all the dates of the changed pages.

3. Run Buckminster: deploy.to.local.repo.dir - to move all artifacts 
   over to ~/Uploads/s3.  
   
4. Test the site from ~/Uploads/s3 /index.html  make sure you can get to all link targets.  

5. Go to com.verticon.tracker.product.desktop.releng 
and run `Sync S3.launch` to upload the http://tracker.verticon.com website

6. The netfirms_website directory has the current website http://www.verticon.com it currently will need to be manually
updated to reflect the changes done to the tracker.verticon.com website.

a. For those pages that have changed, move just replace the xml files with the ones in the html directory of this project. (This
directory is dynamically built by the above Buckminster process.

b. The corresponding html pages will also have to be manually edited to reflect changes. Carefull don't change the css or the pointers.

