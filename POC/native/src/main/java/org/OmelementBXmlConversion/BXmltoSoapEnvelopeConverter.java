package org.OmelementBXmlConversion;

import io.ballerina.runtime.api.types.XmlNodeType;
import io.ballerina.runtime.api.values.BMap;
import io.ballerina.runtime.api.values.BString;
import io.ballerina.runtime.api.values.BXml;
import io.ballerina.runtime.api.values.BXmlItem;
import org.apache.axiom.om.*;
import org.apache.axiom.soap.SOAPBody;
import org.apache.axiom.soap.SOAPEnvelope;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Map;

import static org.OmelementBXmlConversion.BXmlConverter.addChildrenElements;

// NOTE: This class is not in use at the moment
public class BXmltoSoapEnvelopeConverter {

    private static final OMFactory factory = OMAbstractFactory.getOMFactory();

    public static SOAPEnvelope toSOAPEnvelope(BXml bXml) {

        BXmlItem xmlItem = (BXmlItem) bXml;

        OMNamespace namespace = factory.createOMNamespace(xmlItem.getQName().getNamespaceURI(), xmlItem.getQName().getPrefix());
        BMap<BString, BString> bMap = xmlItem.getAttributesMap();

        SOAPEnvelope soapEnvelope = OMAbstractFactory.getSOAP12Factory().createSOAPEnvelope();

        for (Map.Entry<BString, BString> attribute : bMap.entrySet()) {
            if (!attribute.getKey().getValue().startsWith(BXmlItem.XMLNS_NS_URI_PREFIX)) {
                //if this is a namespace
                Pair<String, String> pair = BXmlConverter.extractNamespace(attribute.getKey().getValue());
                OMAttribute omattribute = factory.createOMAttribute(pair.getRight(), namespace, attribute.getValue().getValue());
                soapEnvelope.addAttribute(omattribute);
            }

        }

        for (int i = 0; i < xmlItem.children().size(); i++) {
            BXml child = xmlItem.children().getItem(i);
            if (child.getNodeType() == XmlNodeType.ELEMENT) {
                BXmlItem childXmlItem = (BXmlItem) child;
                if (childXmlItem.getQName().getLocalPart().equals("Header")) {
                    addChildrenElements(soapEnvelope.getOrCreateHeader(), child);

                } else if (childXmlItem.getQName().getLocalPart().equals("Body")) {
                    SOAPBody soapBody;
                    if (soapEnvelope.getBody() == null) {
                        soapBody = OMAbstractFactory.getSOAP12Factory().createSOAPBody(soapEnvelope);
                    } else {
                        soapBody = soapEnvelope.getBody();
                    }
                    addChildrenElements(soapBody, child);
                }
            }
        }
        return soapEnvelope;
    }
}


