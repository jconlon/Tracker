TRACKER DESKTOP METATYPE EDITOR DOCUMENTATION

This project is the Tracker Agriculture editor document. Project content is docbook based and Buckminster is used
for building the online help.  This content is also used as the context for the Tracker BI Toolkit User Guide 
pdf which is built by scripts in the com.verticon.tracker.product.desktop.doc project. 

This projects online help html documents are linked to the "tracker_editor_metatype" anchor in the main or root
tracker BI document built by com.verticon.tracker.doc. 

Create new html documents by invoking Buckminster action 'create-doc' the combinded docbook, html
and a new toc.xml will be generated.  This toc.xml controls the table of contents 
in the Eclipse help.  

There should be no need for manual editing of the generated files.