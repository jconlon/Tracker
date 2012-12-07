<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
 	xmlns:x="http://www.w3.org/2001/XMLSchema">
 	
 	<!-- 
 	This ss removes the type suffix from the names of ECore classes created when using the new EMF project wizard with an XSD
 	input to create an Ecore metamodel.
 	
 	The following problems still exist and need to be handled manually.
 	
 	1. There may be some CDATA that is not mapped properly.
 	2. Extended types are not handled. Schemas that extend another and create types that are using base
 	types (superclasses in the ECore of the extended schema) that themselves were stripped of the suffix
 	Type using this ss or a manual method will have to have: 
 	ecore:implements="namespace:ClassName" 
 	added.
 	
 	Example:
 	
 	<complexType name="ViewerOptionsType" ecore:name="ViewerOptions" ecore:implements="kml:AbstractObject">
		<complexContent>
			<extension base="kml:AbstractObjectType">
				<sequence>
					<element ref="gx:option" maxOccurs="unbounded" />
				</sequence>
			</extension>
		</complexContent>
	</complexType>
 	
 	-->
 	
	<xsl:output method="xml" />
	
	
	<xsl:template match="x:complexType">
		<xsl:variable name= "raw_name" select="@name"/>
		<xsl:variable name="lenght" select="string-length($raw_name)"/>
		<xsl:variable name= "name_trimmed" select="substring($raw_name,1,$lenght - 4)"/>
		<xsl:copy>
			<xsl:apply-templates select="@*"/>
			<xsl:attribute name="ecore:name">
				<xsl:value-of select="$name_trimmed"></xsl:value-of>
			</xsl:attribute>
			<xsl:apply-templates/>
		</xsl:copy>
	</xsl:template>
	
	<!-- standard copy template -->
	<xsl:template match="@*|node()">
		<xsl:copy>
			<xsl:apply-templates select="@*"/>
			<xsl:apply-templates/>
		</xsl:copy>
	</xsl:template>	
</xsl:stylesheet>