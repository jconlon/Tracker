TRACKER iRouter PRODUCT DOCUMENTATION

This project is the Tracker iRouter product document. Project content is textile based and Ant is used
for building the online help.  This content is also used as the context for the Tracker iRouter User Guide 
pdf which is built by Ant scripts in this project. 

This projects online help html documents are linked to an anchor in the main or root
tracker BI document built by com.verticon.tracker.doc. 

Create new docbook,html, toc.xml, and pdf documents by invoking targets in the customBuild.xml. May have to run the docbook2pdf
after build-doc.  Then make sure the anchors are manually changed in the toc to point to the correct anchor.

First two lines should look like:
<toc label="Product Family" link_to="../com.verticon.tracker.doc/toc.xml#tracker_irouter" topic="help/index.html">
<topic href="help/index.html" label="Tracker iRouter">

Also be sure that first topic is properly closed at the end of the file.