package org.example;

import io.ballerina.runtime.api.types.XmlNodeType;
import io.ballerina.runtime.api.values.BMap;
import io.ballerina.runtime.api.values.BString;
import io.ballerina.runtime.api.values.BXml;
import io.ballerina.runtime.api.values.BXmlItem;
import io.ballerina.runtime.internal.values.XmlPi;
import org.apache.axiom.om.*;

import java.util.Map;

public class BXmlConverter {

    private static final OMFactory factory = OMAbstractFactory.getOMFactory();

    public BXml GetXmlItem(){
        OMNamespace namespace = factory.createOMNamespace("http://example.com", "ns");
        OMElement rootElement = factory.createOMElement("root", namespace);
        rootElement.setText("Hello World!");
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
        BXmlItem xmlItem = (BXmlItem) bXml;

        OMNamespace namespace = factory.createOMNamespace(xmlItem.getQName().getNamespaceURI(), xmlItem.getQName().getPrefix());
        OMElement rootElement = factory.createOMElement(xmlItem.getQName().getLocalPart(), namespace);

        BMap<BString, BString> bMap = xmlItem.getAttributesMap();
        for (Map.Entry<BString, BString> entry : bMap.entrySet()) {
            if (!entry.getValue().getValue().equals(namespace.getNamespaceURI())) {
                // Test Case: BXmlConverterTest.testBXmlToOMElementWithChildren
                if (xmlItem.getQName().getPrefix() == "") {
                    namespace = factory.createOMNamespace(xmlItem.getQName().getNamespaceURI(), null);
                    rootElement.setNamespace(namespace);
                }
                OMAttribute attribute = factory.createOMAttribute(entry.getKey().getValue(), namespace, entry.getValue().getValue());
                rootElement.addAttribute(attribute);
            }
        }

        for (int i = 0; i < xmlItem.children().size(); i++) {
            BXml child = xmlItem.children().getItem(i);
            if (child.getNodeType() == XmlNodeType.TEXT) {
                String text = child.getTextValue();
                OMText omText = factory.createOMText(rootElement, text);
                rootElement.addChild(omText);

            } else if (child.getNodeType() == XmlNodeType.ELEMENT) {
                OMElement childElement = toOMElement(child);
                rootElement.addChild(childElement);

            } else if (child.getNodeType() == XmlNodeType.PI) {
                XmlPi xmlPi = (XmlPi) child;
                OMProcessingInstruction omProcessingInstruction = factory.createOMProcessingInstruction(null, xmlPi.getTarget(), xmlPi.getData());
                rootElement.addChild(omProcessingInstruction);

            } else if (child.getNodeType() == XmlNodeType.COMMENT) {
                OMComment omComment = factory.createOMComment(rootElement, child.getTextValue());
                rootElement.addChild(omComment);
            }
        }
        return rootElement;
    }

}
