package org.example;

import io.ballerina.runtime.api.values.BMap;
import io.ballerina.runtime.api.values.BString;
import io.ballerina.runtime.api.values.BXml;
import io.ballerina.runtime.api.values.BXmlItem;
import io.ballerina.runtime.internal.values.XmlPi;
import org.apache.axiom.om.*;
import java.util.Map;

public class BXmlConverter {

    private static final OMFactory factory = OMAbstractFactory.getOMFactory();

    public static OMElement toOMElement1(BXml bXml) {
        String fis = bXml.toString();

        return toOMElement(bXml);
    }
    public static OMElement toOMElement(BXml bXml) {
        BXmlItem xmlItem = (BXmlItem) bXml;

        OMNamespace namespace = factory.createOMNamespace(xmlItem.getQName().getNamespaceURI(), xmlItem.getQName().getPrefix());
        BMap<BString, BString> bMap = xmlItem.getAttributesMap();

        OMElement rootElement = factory.createOMElement(xmlItem.getQName().getLocalPart(), namespace);

        for (Map.Entry<BString, BString> entry : bMap.entrySet()) {
            if (!entry.getValue().getValue().equals(namespace.getNamespaceURI())) {
                rootElement.addAttribute(entry.getKey().getValue(), entry.getValue().getValue(), null);
            }
        }

        for (int i = 0; i < xmlItem.children().size(); i++) {
            BXml child = xmlItem.children().getItem(i);
            switch (child.getNodeType()) {
                case ELEMENT:
                    OMElement childElement = toOMElement(child);
                    rootElement.addChild(childElement);
                    break;
                case TEXT:
                    OMText omText = factory.createOMText(rootElement, child.getTextValue());
                    rootElement.addChild(omText);
                    break;
                case COMMENT:
                    OMComment omComment = factory.createOMComment(rootElement, child.getTextValue());
                    rootElement.addChild(omComment);
                    break;
                case PI:
                    XmlPi xmlPi = (XmlPi) child;
                    OMProcessingInstruction omProcessingInstruction = factory.createOMProcessingInstruction(null, xmlPi.getTarget(), xmlPi.getData());
                    rootElement.addChild(omProcessingInstruction);
                    break;
                default:
                    break;
            }
        }
        return rootElement;
    }

}
