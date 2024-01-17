package org.example;

import io.ballerina.runtime.api.types.XmlNodeType;
import io.ballerina.runtime.api.values.BXml;
import io.ballerina.runtime.api.values.BXmlItem;
import io.ballerina.runtime.internal.values.XmlText;
import org.apache.axiom.om.*;

public class BXmlConverter {

    private static final OMFactory factory = OMAbstractFactory.getOMFactory();
    private OMNamespace namespace;
//    private static OMFactory Factory(){
//        if (factory == null){
//            factory = OMAbstractFactory.getOMFactory();
//        }
//        return factory;
//    }

    public BXml GetXmlItem(){
//        OMFactory factory = OMAbstractFactory.getOMFactory();
        OMNamespace namespace = factory.createOMNamespace("http://example.com", "ns");
        OMElement rootElement = factory.createOMElement("root", namespace);
        OMElement childElement1 = factory.createOMElement("child1", namespace);
        childElement1.setText("Hello");
        OMElement childElement2 = factory.createOMElement("child2", namespace);
        childElement2.setText("World");
        rootElement.addChild(childElement1);
        rootElement.addChild(childElement2);
        BXml bXml = OMElementConverter.toBXml(rootElement);
        return bXml;
    }
    public static OMElement toOMElement(BXml bXml) {

        if( bXml.getNodeType() == XmlNodeType.ELEMENT){
            BXmlItem xmlItem = (BXmlItem) bXml;
            OMNamespace namespace = factory.createOMNamespace(xmlItem.getQName().getNamespaceURI(), xmlItem.getQName().getPrefix());
            OMElement rootElement = factory.createOMElement(xmlItem.getQName().getLocalPart(), namespace);

            for (int i = 0; i < xmlItem.children().size(); i++) {
                BXml child = xmlItem.children().getItem(i);
                OMElement childElement = toOMElement(child);
                rootElement.addChild(childElement);
            }
            return rootElement;
        }else if (bXml.getNodeType() == XmlNodeType.TEXT){
            XmlText xmlText = (XmlText) bXml;
//            OMElement childElement1 = factory.createOMElement("child1");
//            childElement1.setText("Hello");
        }
        return null;
    }

}
