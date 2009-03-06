<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes" />
	
	<xsl:template match="node() | @*">
		<xsl:copy>
			<xsl:apply-templates select="node() | @*" />
		</xsl:copy>
	</xsl:template>	 
			 
    <xsl:template  match="//topic[@label='Product']">
    		<xsl:element name="topic">
    		    <xsl:attribute  name="href">
                       <xsl:value-of  select="@href" />
                </xsl:attribute> 
  				<xsl:attribute name="label">Product</xsl:attribute>
  				<xsl:element name="anchor">
  					<xsl:attribute name="id">tracker_product</xsl:attribute>
  				</xsl:element>
  			 </xsl:element>       
    </xsl:template>
 
    <xsl:template  match="//topic[@label='Editors']">
    		<xsl:element name="topic">
    		    <xsl:attribute  name="href">
                       <xsl:value-of  select="@href" />
                </xsl:attribute> 
  				<xsl:attribute name="label">Editors</xsl:attribute>
  				<xsl:element name="anchor">
  					<xsl:attribute name="id">tracker_editor</xsl:attribute>
  				</xsl:element>
  			 </xsl:element>   
    </xsl:template>
    
    <xsl:template  match="//topic[@label='Features']">
    		<xsl:element name="topic">
    		    <xsl:attribute  name="href">
                       <xsl:value-of  select="@href" />
                </xsl:attribute> 
  				<xsl:attribute name="label">Features</xsl:attribute>
  				<xsl:element name="anchor">
  					<xsl:attribute name="id">tracker_feature</xsl:attribute>
  				</xsl:element>
  			 </xsl:element>   
    </xsl:template>        


</xsl:stylesheet>