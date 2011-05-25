<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes" />
	
	<xsl:template match="node() | @*">
		<xsl:copy>
			<xsl:apply-templates select="node() | @*" />
		</xsl:copy>
	</xsl:template>	 
			 
    <xsl:template  match="//topic[@label='Product Family']">
    		<xsl:element name="topic">
    		    <xsl:attribute  name="href">
                       <xsl:value-of  select="@href" />
                </xsl:attribute> 
  				<xsl:attribute name="label">Product Family</xsl:attribute>
  				<xsl:element name="anchor">
  					<xsl:attribute name="id">tracker_product</xsl:attribute>
  				</xsl:element>
  			 </xsl:element>       
    </xsl:template>
 
    <xsl:template  match="//topic[@label='Provisioned Editors']">
    		<xsl:element name="topic">
    		    <xsl:attribute  name="href">
                       <xsl:value-of  select="@href" />
                </xsl:attribute> 
  				<xsl:attribute name="label">Provisioned Editors</xsl:attribute>
  				<xsl:element name="anchor">
  					<xsl:attribute name="id">tracker_editor</xsl:attribute>
  				</xsl:element>
  			 </xsl:element>   
    </xsl:template>
    
    <xsl:template  match="//topic[@label='Provisioned Features']">
    		<xsl:element name="topic">
    		    <xsl:attribute  name="href">
                       <xsl:value-of  select="@href" />
                </xsl:attribute> 
  				<xsl:attribute name="label">Provisioned Features</xsl:attribute>
  				<xsl:element name="anchor">
  					<xsl:attribute name="id">tracker_feature</xsl:attribute>
  				</xsl:element>
  			 </xsl:element>   
    </xsl:template>        


</xsl:stylesheet>