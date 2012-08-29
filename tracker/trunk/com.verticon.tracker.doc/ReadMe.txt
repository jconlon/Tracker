TRACKER ROOT DOCUMENTATION

This project is the root tracker BI document.  Project content is docbook based and Buckminster is used
for building the online help.  This content is also used as the context for the Tracker BI Toolkit User Guide 
pdf which is built by scripts in the com.verticon.tracker.documentation project.

Create new html documents by invoking Buckminster action 'create-doc' the combinded docbook, html
and a new toc.xml will be generated.  This toc.xml controls the table of contents 
in the Eclipse help.  

It will have to be manually edited to make 2 changes:

1. modify the name:

Tracker Business Intelligence User Guide

2. Add product anchors:

<topic href="html//product/product.html" label="Tracker Product Suite">
   <anchor id="tracker_desktop"/>
   <anchor id="tracker_irouter"/>
</topic> 

So that the desktop and the irouter products can link to this document in the online help.