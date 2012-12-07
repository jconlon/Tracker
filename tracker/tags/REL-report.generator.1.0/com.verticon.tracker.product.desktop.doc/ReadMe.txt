TRACKER DESKTOP PRODUCT DOCUMENTATION

This project is the Tracker BI Toolkit product document. Project content is docbook based and Buckminster is used
for building the online help.  This content is also used as the context for the Tracker BI Toolkit User Guide 
pdf which is built by scripts in the com.verticon.tracker.documentation project. 

This projects online help html documents are linked to an anchor in the main or root
tracker BI document built by com.verticon.tracker.doc. 

Create new html documents by invoking Buckminster action 'create-doc' the combinded docbook, html
and a new toc.xml will be generated.  This toc.xml controls the table of contents 
in the Eclipse help.  

It will have to be manually edited to make anchors for the editors and for the features:

<topic href="html//editors/editors.html" label="Provisioned Editors">
   <anchor id="tracker_editor_premises"/>
   <anchor id="tracker_editor_metatype"/>
   <anchor id="tracker_editor_agriculture"/>
   <anchor id="tracker_editor_fair"/>
   <anchor id="tracker_editor"/>
</topic>
<topic href="html//features/features.html" label="Provisioned Features">
   <anchor id="tracker_feature"/>
</topic>

So that the editors and the features can link to this document in the online help.