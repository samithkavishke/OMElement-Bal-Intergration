package org.SOAPElementCreation;

import io.ballerina.runtime.api.values.BMap;
import io.ballerina.runtime.api.values.BString;
import io.ballerina.runtime.api.values.BXml;
import io.ballerina.runtime.api.values.BXmlItem;
import io.ballerina.runtime.internal.values.XmlPi;
import org.apache.axiom.om.*;
import org.apache.axiom.soap.SOAPEnvelope;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.Map;

import static org.OmelementBXmlConversion.BXmlConverter.toOMElement;

public class BXmltoSoapEnvelopeConverter {

    private static final OMFactory factory = OMAbstractFactory.getOMFactory();

    private static Pair<String, String> extractNamespace(String value) {
        // {https://example.com}attr1 -> {https://example.com} attr1
        if (value.startsWith("{")) {
            int index = value.indexOf("}");
            String ns = value.substring(1, index);
            String localName = value.substring(index + 1);
            return Pair.of(ns, localName);
        }

        return Pair.of("", value);
    }
    public static SOAPEnvelope toSOAPEnvelope(BXml bXml) {




        BXmlItem xmlItem = (BXmlItem) bXml;

        OMNamespace namespace = factory.createOMNamespace(xmlItem.getQName().getNamespaceURI(), xmlItem.getQName().getPrefix());
        BMap<BString, BString> bMap = xmlItem.getAttributesMap();

        SOAPEnvelope soapEnvelope = OMAbstractFactory.getSOAP11Factory().createSOAPEnvelope(namespace);
        // create a map of namespaces with key:"" and value:null
        Map<String, OMNamespace> namespaceMap = new HashMap<>();
        namespaceMap.put("", null);

        for (Map.Entry<BString, BString> entry : bMap.entrySet()) {
            //TODO: handle namespace
            if (entry.getKey().getValue().startsWith(BXmlItem.XMLNS_NS_URI_PREFIX)) {
                //if this is a namespace
                Pair<String, String> pair = extractNamespace(entry.getKey().getValue());
                OMNamespace omNamespace = factory.createOMNamespace(entry.getValue().getValue(), pair.getRight());
                namespaceMap.put(entry.getValue().getValue(), omNamespace);
            }
        }
        for (Map.Entry<BString, BString> attribute : bMap.entrySet()) {
            if (!attribute.getKey().getValue().startsWith(BXmlItem.XMLNS_NS_URI_PREFIX)) {
                //if this is a namespace
                Pair<String, String> pair = extractNamespace(attribute.getKey().getValue());
                OMAttribute omattribute = factory.createOMAttribute(pair.getRight(), namespaceMap.get(pair.getLeft()),  attribute.getValue().getValue());
                soapEnvelope.addAttribute(omattribute);
                //TODO: previously used OMAttribute creation method research why it was changed to attribute.
//                rootElement.addAttribute(attribute.getKey().getValue(), attribute.getValue().getValue(), namespaceMap.get(attribute.getKey().getValue()));
            }

        }

        for (int i = 0; i < xmlItem.children().size(); i++) {
            BXml child = xmlItem.children().getItem(i);
            switch (child.getNodeType()) {
                case ELEMENT:
                    OMElement childElement = toOMElement(child);
                    if (childElement.getLocalName().equals("Header")) {
                        soapEnvelope.getHeader().addChild(childElement);
                    } else if (childElement.getLocalName().equals("Body")) {
                        soapEnvelope.getBody().addChild(childElement);
                    } else {
                        soapEnvelope.addChild(childElement);
                    }
                    break;
                case TEXT:
                    OMText omText = factory.createOMText(soapEnvelope, child.getTextValue());
                    soapEnvelope.addChild(omText);
                    break;
                case COMMENT:
                    OMComment omComment = factory.createOMComment(soapEnvelope, child.getTextValue());
                    soapEnvelope.addChild(omComment);
                    break;
                case PI:
                    XmlPi xmlPi = (XmlPi) child;
                    OMProcessingInstruction omProcessingInstruction = factory.createOMProcessingInstruction(null, xmlPi.getTarget(), xmlPi.getData());
                    soapEnvelope.addChild(omProcessingInstruction);
                    break;
                default:
                    break;
            }}

        return soapEnvelope;
    }


}
