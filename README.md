# Java_object_to_XML_REST_Response
Convert java object to XML REST response - Stackover flow - 50601912

To convert java object to XML REST response, you need to add number of JAXB annotations to your bean class to allow it to be marshalled into XML.

@XmlRootElement: This annotation is used at the top level class to indicate the root element in the XML document. The name attribute in the annotation is optional. If not specified, the class name is used as the root XML element in the document.

@XmlAttribute: This annotation is used to indicate the attribute of the root element.

@XmlElement: This annotation is used on the properties of the class which will be the sub-elements of the root element.
