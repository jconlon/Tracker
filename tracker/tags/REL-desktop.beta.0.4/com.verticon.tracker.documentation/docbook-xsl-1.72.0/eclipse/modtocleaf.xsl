<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" indent="yes"/>
    <xsl:param name="topic.link_to">../com.verticon.tracker.doc/toc.xml#tracker_product</xsl:param>
	<xsl:param name="topic.label">WRONG LABEL</xsl:param>
		<!--adds 
		link_to="$link_to" 
		label="$label"
		As a toc attribute
		 -->
    
    <xsl:template match="/toc">
        <xsl:message>
 		    Adding attributes to toc 
 		    link_to is <xsl:copy-of select="$topic.link_to"/>
 		    and 
 		    label is <xsl:copy-of select="$topic.label"/>
 		    toc attributes are
			<xsl:for-each select="attribute::*">
				<xsl:value-of select="name(.)" />="<xsl:value-of select="." />"
			</xsl:for-each>
		</xsl:message>
        <xsl:copy>
                <xsl:apply-templates select="@*"/>
                <xsl:attribute name="link_to">
                	<xsl:value-of select="$topic.link_to" />
                </xsl:attribute>
                <xsl:attribute name="label">
					<xsl:value-of select="$topic.label" />
				</xsl:attribute>
                
                <xsl:apply-templates select="text()|*"/>
        </xsl:copy>
	</xsl:template>


	<xsl:template match="*|text()|@*">
        <xsl:copy>
                <xsl:apply-templates select="*|text()|@*"/>
        </xsl:copy>
	</xsl:template>

   
</xsl:stylesheet>