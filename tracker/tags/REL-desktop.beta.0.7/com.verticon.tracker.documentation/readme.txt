This project is a script repo and builder for the com.verticon.tracker documentation projects.

=======================================
Notes

The docBook external resources were added to the Tracker repository so this documentation 
project can be easily created from the repository.  This does almost double the size of 
the Verticon repository.  If in the future space becomes an issue, the svnadmin dump and
dumpfilter can be used to eliminate these externals.  See:
http://svnbook.red-bean.com/en/1.0/ch05s03.html#svn-ch-5-sect-3.1.3
for details.

See also the book Pragmatic Version Control page 143 on use of externals.

=======================================
Build Instructions

For releases:

1. Change publish date. Just update the file: /home/jconlon/Workspaces/tracker_dev-01/com.verticon.tracker.doc/docbook/bookinfo/bookinfo.xml

2. Buckminster: deploy.documentation.to.local.s3.staging - Moves all artifacts 
   over to ~/Uploads/s3.  
   
   
3. Note: This does not mirror these to S3. Go to com.verticon.tracker.product.desktop.releng 
and run `Sync S3.launch`