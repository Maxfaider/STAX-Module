<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:output method="html" version="1.0" encoding="UTF-8"/>

<xsl:template match="/">
<XMI xmi.version="1.1" xmlns:UML="omg.org/UML1.3" timestamp="2018-08-27 16:07:19">
    <!--EL HEADER DEL XMI, APARECE LA INFORMACION DEL SOFTWARE Y LA VERSION DEL SOFTWARE-->
	<XMI.header>
		<XMI.documentation>
			<XMI.exporter>STAX</XMI.exporter>
			<XMI.exporterVersion>1.0</XMI.exporterVersion>
		</XMI.documentation>
        </XMI.header>
        <!--CONTENIDO DEL XMI COMO TAL, AQUI ES DONDE APARECEN LOS PAQUETES Y CLASES CON SUS ATRIBUTOS, METODOS Y RELACIONES-->
	<XMI.content>
            <!--LEE LOS PAQUETES, POR CADA PAQUETE COLOCA EL NOMBRE, ID ENTRE OTROS DATOS-->
            <xsl:for-each select="packect">
                <UML:Class name="STAX" xmi.id="STAX01" isRoot="true" isLeaf="false" isAbstract="false"/>
                <UML:Package  isRoot="false" isLeaf="false" isAbstract="false" visibility="public">
                    <xsl:attribute name="name">
                        <xsl:value-of select="@p_name"></xsl:value-of>
                    </xsl:attribute>
                    <xsl:attribute name="xmi.id">
                        <xsl:value-of select="@p_id"></xsl:value-of>
                    </xsl:attribute>
                    <UML:ModelElement.taggedValue>
                            <UML:TaggedValue tag="parent" value="EAPK_3D96B92B_19F7_46cd_8F72_C6858713166A"/>
                            <UML:TaggedValue tag="created" value="2014-10-26 15:56:41"/>
                            <UML:TaggedValue tag="modified" value="2014-10-26 15:56:41"/>
                            <UML:TaggedValue tag="iscontrolled" value="FALSE"/>
                            <UML:TaggedValue tag="lastloaddate" value="2014-10-26 15:56:41"/>
                            <UML:TaggedValue tag="lastsavedate" value="2014-10-26 15:56:41"/>
                            <UML:TaggedValue tag="isprotected" value="FALSE"/>
                            <UML:TaggedValue tag="usedtd" value="FALSE"/>
                            <UML:TaggedValue tag="logxml" value="FALSE"/>
                            <UML:TaggedValue tag="tpos" value="1"/>
                            <UML:TaggedValue tag="packageFlags" value="CRC=0;"/>
                            <UML:TaggedValue tag="batchsave" value="0"/>
                            <UML:TaggedValue tag="batchload" value="0"/>
                            <UML:TaggedValue tag="phase" value="1.0"/>
                            <UML:TaggedValue tag="status" value="Proposed"/>
                            <UML:TaggedValue tag="complexity" value="1"/>
                            <UML:TaggedValue tag="ea_stype" value="Public"/>
                            <UML:TaggedValue tag="eventflags" value="LNK=0999;"/>
                            <UML:TaggedValue tag="tpos" value="1"/>
                            <UML:TaggedValue tag="gentype" value="Java"/>
                    </UML:ModelElement.taggedValue>
                    <UML:Namespace.ownedElement>
                                            
	<xsl:for-each select="graph">
            <!--LEE LAS CLASES Y COLOCA LOS NOMBRES, ID VISIBILIDAD, CARACTERISTICAS(EJ:ABSTRACTA) ENTRE OTROS DATOS-->	
		<xsl:for-each select="class">
                    <UML:Class visibility="public" namespace="EAPK_46523979_DED5_419b_A525_5A13796D15C0" isRoot="false" isLeaf="false" isActive="false">
                    <xsl:attribute name="name">
                        <xsl:value-of select="@c_name"></xsl:value-of>
                    </xsl:attribute>
                    <xsl:attribute name="xmi.id">
                        <xsl:value-of select="@c_id"></xsl:value-of>
                    </xsl:attribute>
                    <xsl:attribute name="isAbstract">
                        <xsl:value-of select="@c_abstract"></xsl:value-of>
                    </xsl:attribute>
                    <UML:ModelElement.taggedValue>
                            <UML:TaggedValue tag="isSpecification" value="false"/>
                            <UML:TaggedValue tag="type" value="Class"/>
                            <UML:TaggedValue tag="#type" value="0"/>
                            <UML:TaggedValue tag="version" value="1.0"/>
                            <UML:TaggedValue tag="package">
                                <xsl:attribute name="value">
                                    <xsl:value-of select="@p_id"></xsl:value-of>
                                </xsl:attribute>
                            </UML:TaggedValue>
                            <UML:TaggedValue tag="gentype" value="Java"/>
                            <UML:TaggedValue tag="tagged" value="0"/>
                            <UML:TaggedValue tag="package_name">
                                <xsl:attribute name="value">
                                    <xsl:value-of select="@p_name"></xsl:value-of>
                                </xsl:attribute>
                            </UML:TaggedValue>
                            <UML:TaggedValue tag="phase" value="1.0"/>
                            <UML:TaggedValue tag="complexity" value="1"/>
                            <UML:TaggedValue tag="status" value="Proposed"/>
                            <UML:TaggedValue tag="tpos" value="0"/>
                            <UML:TaggedValue tag="localid" value="9"/>
                            <UML:TaggedValue tag="ea_eleType" value="element"/>
                            <UML:TaggedValue tag="eventflags" value="LNK=dd51;"/>
                            <UML:TaggedValue tag="style" value="BackColor=-1;BorderColor=-1;BorderWidth=-1;FontColor=-1;VSwimLanes=1;HSwimLanes=1;BorderStyle=0;"/>
                            
                    </UML:ModelElement.taggedValue>
                    <UML:Classifier.feature>
                        <!--LEE LOS ATRIBUTOS DE LA CLASE, COLOCA EL NOMBRE, TIPO Y VISIBILIDAD ENTRE OTROS DATOS -->
                        <xsl:for-each select="attributes/attribute">
                        <UML:Attribute  changeable="none" ownerScope="instance" targetScope="instance">
                            <xsl:attribute name="name">
                                <xsl:value-of select="@a_name"></xsl:value-of>
                            </xsl:attribute>
                            <xsl:attribute name="visibility">
                                <xsl:value-of select="@a_access"></xsl:value-of>
                            </xsl:attribute>
                            <UML:Attribute.initialValue>
                                <UML:Expression/>
                            </UML:Attribute.initialValue>
                            <UML:StructuralFeature.type>
                                <UML:Classifier >
                                    <xsl:attribute name="xmi.idref">
                                        <xsl:value-of select="@a_id"></xsl:value-of>
                                    </xsl:attribute>
                                </UML:Classifier>
                            </UML:StructuralFeature.type>
                            <UML:ModelElement.taggedValue>
                                <UML:TaggedValue tag="type">
                                    <xsl:attribute name="value">
                                        <xsl:value-of select="@a_type"></xsl:value-of>
                                    </xsl:attribute>
                                </UML:TaggedValue>
                                    <UML:TaggedValue tag="derived" value="0"/>
                                    <UML:TaggedValue tag="containment" value="Not Specified"/>
                                    <UML:TaggedValue tag="ordered" value="0"/>
                                    <UML:TaggedValue tag="collection" value="false"/>
                                    <UML:TaggedValue tag="position" value="0"/>
                                    <UML:TaggedValue tag="lowerBound" value="1"/>
                                    <UML:TaggedValue tag="upperBound" value="1"/>
                                    <UML:TaggedValue tag="duplicates" value="0"/>
                                    
                                    <UML:TaggedValue tag="localid" value="2"/>
                                    <UML:TaggedValue tag="styleex" value="IsLiteral=0;volatile=0;"/>
                            </UML:ModelElement.taggedValue>
                        </UML:Attribute>
                        <!--TERMINA LA SECCION DE LOS ATRIBUTOS Y EMPIEZA CON LOS METODOS -->
                        </xsl:for-each>
                        <!--LEE LOS METODOS DE LA CLASE, COLOCA LOS NOMBRES,ID,TIPO DE DATO DE RETORNO ENTRE OTROS DATOS -->
                        <xsl:for-each select="methods/method">
                                <UML:Operation ownerScope="instance" isQuery="false" concurrency="sequential">
                                    <xsl:attribute name="name">
                                        <xsl:value-of select="@m_name"/>
                                    </xsl:attribute>
                                    <xsl:attribute name="visibility">
                                        <xsl:value-of select="@m_access"/>
                                    </xsl:attribute>
                                <UML:ModelElement.taggedValue>
                                    <UML:TaggedValue tag="type">
                                        <xsl:attribute name="value">
                                            <xsl:value-of select="@m_return"></xsl:value-of>
                                        </xsl:attribute>
                                    </UML:TaggedValue>
                                    <UML:TaggedValue tag="const" value="false"/>
                                    <UML:TaggedValue tag="synchronised" value="0"/>
                                    <UML:TaggedValue tag="concurrency" value="Sequential"/>
                                    <UML:TaggedValue tag="position" value="0"/>
                                    <UML:TaggedValue tag="returnarray" value="0"/>
                                    <UML:TaggedValue tag="pure" value="0"/>
                                    
                                    <UML:TaggedValue tag="localid" value="2"/>
                                </UML:ModelElement.taggedValue>
                                <UML:BehavioralFeature.parameter>
                                    <UML:Parameter kind="return" visibility="public">
                                            <UML:Parameter.type>
                                                <UML:Classifier >
                                                    <xsl:attribute name="xmi.idref">
                                                        <xsl:value-of select="c_id"/>
                                                    </xsl:attribute>
                                                </UML:Classifier>
                                            </UML:Parameter.type>
                                            <UML:ModelElement.taggedValue>
                                                    <UML:TaggedValue tag="pos" value="0"/>
                                                    <UML:TaggedValue tag="type" value="void"/>
                                                    <UML:TaggedValue tag="const" value="0"/>
                                                    </UML:ModelElement.taggedValue>
                                            <UML:Parameter.defaultValue>
                                                    <UML:Expression/>
                                            </UML:Parameter.defaultValue>
                                    </UML:Parameter>
                                    <UML:Parameter name="b" kind="in" visibility="public">
                                            <UML:Parameter.type>
                                                    <UML:Classifier xmi.idref="eaxmiid0"/>
                                            </UML:Parameter.type>
                                            <UML:ModelElement.taggedValue>
                                                    <UML:TaggedValue tag="pos" value="0"/>
                                                    <UML:TaggedValue tag="type">
                                                        <xsl:attribute name="value">
                                                            <xsl:value-of select="pr_type"/>
                                                        </xsl:attribute>
                                                    </UML:TaggedValue>
                                                    <UML:TaggedValue tag="const" value="0"/>
                                                    </UML:ModelElement.taggedValue>
                                            <UML:Parameter.defaultValue>
                                                    <UML:Expression/>
                                            </UML:Parameter.defaultValue>
                                    </UML:Parameter>
                                </UML:BehavioralFeature.parameter>
                                </UML:Operation>
                        </xsl:for-each>
                        <!--TERMINA LA SECCION DE LOS METODOS Y PROSIGUE A TERMINAR CON LA CLASE-->
                    </UML:Classifier.feature>
                    </UML:Class>
                    
                    <!--AQUI TERMINA LA CLASE Y EMPIEZAN LAS RELACIONES, AUN
                    NO SE CIERRA EL CICLO QUE LEE LAS CLASES PARA SEGUIR UN ORDEN EN LOS DATOS CUANDO SE 
                    PONGAN LAS RELACIONES, LAS RELACIONES SE COLOCAN DEBAJO DE LA SUBCLASE(DE LA QUE SALE LA RELACION) -->
                    <xsl:for-each select="relations/relation">
                        <!--LEE LAS RELACIONES, COLOCA LA SUBCLASE(DE DONDE SALE) Y LA SUPERCLASE(A DONDE LLEGA)
                        (EJ:HIJO[SUBCLASE],PADRE[SUPERCLASE]), ESTO DEPENDERA DE EL TIPO DE RELACION YA QUE CADA
                        UNA TIENE UNAS CARACTERISTICAS DISTINTAS(DEPENDE DE LA RELACION CAMBIAN ATRIBUTOS EN LAS ETIQUETAS)-->
      
                            <nombre value="entro if"/>
                            <!--GENERALIZACION, COLOCA EL NOMBRE E ID DE LA SUBCLASE Y LA SUPER CLASE Y LA ID DE LA RELACION,
                            MAS DATOS DEL ESTILO DE LA LINEA ENTRE OTRAS COSAS-->
                            <xsl:if test="@r_type='generalization'">
                                <UML:Generalization visibility="public">
                                    <xsl:attribute name="subtype">
                                        <xsl:value-of select="@r_from"/>
                                    </xsl:attribute>
                                    <xsl:attribute name="supertype">
                                        <xsl:value-of select="@r_to"/>
                                    </xsl:attribute>
                                    <xsl:attribute name="xmi.id">
                                        <xsl:value-of select="@r_id"/>
                                    </xsl:attribute>
                                <UML:ModelElement.taggedValue>
                                    <UML:TaggedValue tag="style" value="3"/>
                                    <UML:TaggedValue tag="type" value="Generalization"/>
                                    <UML:TaggedValue tag="direction" value="Source -&gt; Destination"/>
                                    <UML:TaggedValue tag="linemode" value="3"/>
                                    <UML:TaggedValue tag="linecolor" value="-1"/>
                                    <UML:TaggedValue tag="linewidth" value="0"/>
                                    <UML:TaggedValue tag="seqno" value="0"/>
                                    <UML:TaggedValue tag="headStyle" value="0"/>
                                    <UML:TaggedValue tag="lineStyle" value="0"/>
                                    <UML:TaggedValue tag="localid" value="5"/>
                                    <UML:TaggedValue tag="sourceName">
                                        <xsl:attribute name="value">
                                            <xsl:value-of select="r_from"/>
                                        </xsl:attribute>
                                    </UML:TaggedValue>
                                    <UML:TaggedValue tag="targetName">
                                        <xsl:attribute name="value">
                                            <xsl:value-of select="r_to"/>
                                        </xsl:attribute>
                                    </UML:TaggedValue>
                                    <UML:TaggedValue tag="sourceType" value="Class"/>
                                    <UML:TaggedValue tag="targetType" value="Class"/>
                                    <UML:TaggedValue tag="sourceID" value="9">
                                        <xsl:attribute name="value">
                                            <xsl:value-of select="r_id_to"/>
                                        </xsl:attribute>
                                    </UML:TaggedValue>
                                    <UML:TaggedValue tag="targetID" value="11"/>
                                    <UML:TaggedValue tag="src_visibility" value="Public"/>
                                    <UML:TaggedValue tag="src_aggregation" value="0"/>
                                    <UML:TaggedValue tag="src_isOrdered" value="false"/>
                                    <UML:TaggedValue tag="src_isNavigable" value="false"/>
                                    <UML:TaggedValue tag="src_containment" value="Unspecified"/>
                                    <UML:TaggedValue tag="dst_visibility" value="Public"/>
                                    <UML:TaggedValue tag="dst_aggregation" value="0"/>
                                    <UML:TaggedValue tag="dst_isOrdered" value="false"/>
                                    <UML:TaggedValue tag="dst_isNavigable" value="true"/>
                                    <UML:TaggedValue tag="dst_containment" value="Unspecified"/>
                                    <UML:TaggedValue tag="virtualInheritance" value="0"/>
                                </UML:ModelElement.taggedValue>
                                </UML:Generalization>
                            </xsl:if>
                            <!--TERMINA GENERALIZACION Y COMIENZO EL IF DE COMPOSICION, COLOCA EL NOMBRE E ID DE LA SUBCLASE Y LA SUPER CLASE Y LA ID DE LA RELACION,
                            MAS DATOS DEL ESTILO DE LA LINEA ENTRE OTRAS COSAS, SU DIFERENCIA CON LA AGREGACION ES..... -->
                            <xsl:if test="@r_type='composite'">
                                <UML:Association visibility="public" isRoot="false" isLeaf="false" isAbstract="false">
                                    <xsl:attribute name="xmi.id">
                                        <xsl:value-of select="@r_id"/>
                                    </xsl:attribute>
                                    <UML:ModelElement.taggedValue>
                                            <UML:TaggedValue tag="style" value="3"/>
                                            <UML:TaggedValue tag="type" value="Aggregation"/>
                                            <UML:TaggedValue tag="direction" value="Source -&gt; Destination"/>
                                            <UML:TaggedValue tag="linemode" value="3"/>
                                            <UML:TaggedValue tag="linecolor" value="-1"/>
                                            <UML:TaggedValue tag="linewidth" value="0"/>
                                            <UML:TaggedValue tag="seqno" value="0"/>
                                            <UML:TaggedValue tag="subtype" value="Strong"/>
                                            <UML:TaggedValue tag="headStyle" value="0"/>
                                            <UML:TaggedValue tag="lineStyle" value="0"/>
                                            <UML:TaggedValue tag="localid" value="9"/>
                                            <UML:TaggedValue tag="sourceName">
                                                <xsl:attribute name="value">
                                                    <xsl:value-of select="r_from"/>
                                                </xsl:attribute>
                                            </UML:TaggedValue>
                                            <UML:TaggedValue tag="ea_targetName" value="Clase2">
                                                <xsl:attribute name="value">
                                                    <xsl:value-of select="@r_to"/>
                                                </xsl:attribute>
                                            </UML:TaggedValue>
                                            <UML:TaggedValue tag="ea_sourceType" value="Class"/>
                                            <UML:TaggedValue tag="ea_targetType" value="Class"/>
                                            <UML:TaggedValue tag="sourceID" value="15">
                                                <xsl:attribute name="value">
                                                    <xsl:value-of select="r_id_from"/>
                                                </xsl:attribute>
                                            </UML:TaggedValue>
                                            <UML:TaggedValue tag="targetID" value="16">
                                                <xsl:attribute name="value">
                                                    <xsl:value-of select="r_id_to"/>
                                                </xsl:attribute>
                                            </UML:TaggedValue>
                                            <UML:TaggedValue tag="virtualInheritance" value="0"/>
                                    </UML:ModelElement.taggedValue>
                                    <UML:Association.connection>
                                            <UML:AssociationEnd visibility="public" aggregation="none" isOrdered="false" targetScope="instance" changeable="none" isNavigable="false">
                                                <xsl:attribute name="type">
                                                    <xsl:value-of select="r_id_from"/>
                                                </xsl:attribute>
                                                    <UML:ModelElement.taggedValue>
                                                            <UML:TaggedValue tag="containment" value="Unspecified"/>
                                                            <UML:TaggedValue tag="sourcestyle" value="Union=0;Derived=0;AllowDuplicates=0;Owned=0;Navigable=Non-Navigable;"/>
                                                            <UML:TaggedValue tag="ea_end" value="source"/>
                                                    </UML:ModelElement.taggedValue>
                                            </UML:AssociationEnd>
                                            <UML:AssociationEnd visibility="public" aggregation="composite" isOrdered="false" targetScope="instance" changeable="none" isNavigable="true">
                                                <xsl:attribute name="value">
                                                    <xsl:value-of select="r_id_to"/>
                                                </xsl:attribute>
                                                    <UML:ModelElement.taggedValue>
                                                            <UML:TaggedValue tag="containment" value="Unspecified"/>
                                                            <UML:TaggedValue tag="deststyle" value="Union=0;Derived=0;AllowDuplicates=0;Owned=0;Navigable=Navigable;"/>
                                                            <UML:TaggedValue tag="ea_end" value="target"/>
                                                    </UML:ModelElement.taggedValue>
                                            </UML:AssociationEnd>
                                    </UML:Association.connection>
                                </UML:Association>
                                <!--TERMINA EL IF DE COMPOSICION-->
                            </xsl:if>
                            
                        <!--TERMINA CICLO FOR-EACH DE LAS RELACIONES-->
                    </xsl:for-each>
                    <!--TERMINA CICLO FOR-EACH DE LAS CLASES-->
                    </xsl:for-each>
                    <!--TERMINA CICLO FOR-EACH DE LOS DISTINTOS DIAGRAMAS(SOLO ESTA IMPLEMENTADO LA CONVERSION DE CLASES, 
                    MAS ADELANTE SE HARA EL DE LOS DEMAS DIAGRAMAS)-->
                    </xsl:for-each>
                    </UML:Namespace.ownedElement>
                    <!--CULMINA EL PAQUETE -->
                    </UML:Package>
                    <!--TERMINA CICLO FOR-EACH DE LOS PAQUETES-->
            </xsl:for-each>
            <!--CULMINA CONTENIDO XMI -->
        </XMI.content>
        <!--CIERRA XMI -->
</XMI>
<!--CIERRA EL TEMPLATE -->	
</xsl:template>
<!--TERMINA EL XSL -->
</xsl:stylesheet>