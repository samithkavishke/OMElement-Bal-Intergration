package org.OmelementBXmlConversion;

import io.ballerina.runtime.api.types.XmlNodeType;
import io.ballerina.runtime.api.values.BMap;
import io.ballerina.runtime.api.values.BString;
import io.ballerina.runtime.api.values.BXml;
import io.ballerina.runtime.api.values.BXmlItem;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.soap.*;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Map;


// NOTE: This class is not in use at the moment
public class BXmltoSoapEnvelopeConverter {

    private static final OMFactory factory = OMAbstractFactory.getOMFactory();
    private static SOAPFactory soapFactory ;

    public static SOAPEnvelope toSOAPEnvelope(BXml bXml) {

        BXmlItem xmlItem = (BXmlItem) bXml;

        OMNamespace namespace = factory.createOMNamespace(xmlItem.getQName().getNamespaceURI(), xmlItem.getQName().getPrefix());
        BMap<BString, BString> bMap = xmlItem.getAttributesMap();

        setSoapFactory(namespace.getNamespaceURI());
        SOAPEnvelope soapEnvelope = soapFactory.createSOAPEnvelope(namespace);

        for (Map.Entry<BString, BString> attribute : bMap.entrySet()) {
            if (!attribute.getKey().getValue().startsWith(BXmlItem.XMLNS_NS_URI_PREFIX)) {
                //if this is a namespace
                Pair<String, String> pair = BXmlConverter.extractNamespace(attribute.getKey().getValue());
                OMAttribute omattribute = factory.createOMAttribute(pair.getRight(), namespace, attribute.getValue().getValue());
                soapEnvelope.addAttribute(omattribute);
            }
        }

        //NOTE: SOAP Envelope can only have the following children: Header, Body, Fault (Fault is still not there)

        for (int i = 0; i < xmlItem.children().size(); i++) {
            BXml child = xmlItem.children().getItem(i);
            if (child.getNodeType() == XmlNodeType.ELEMENT) {
                BXmlItem childXmlItem = (BXmlItem) child;
                if (childXmlItem.getQName().getLocalPart().equals("Header")) {
                    BXmlConverter.addChildrenElements(soapEnvelope.getOrCreateHeader(), child);

                } else if (childXmlItem.getQName().getLocalPart().equals("Body")) {
                    SOAPBody soapBody;
                    if (soapEnvelope.getBody() == null) {
                        soapBody = soapFactory.createSOAPBody(soapEnvelope);
                    } else {
                        soapBody = soapEnvelope.getBody();
                    }
                    BXmlConverter.addChildrenElements(soapBody, child);
                }
            }
        }
        return soapEnvelope;
    }

    private static void setSoapFactory(String uri) {
        if( uri.equals(SOAP12Constants.SOAP_ENVELOPE_NAMESPACE_URI)){
            soapFactory = OMAbstractFactory.getSOAP12Factory();
        } else if (uri.equals(SOAP11Constants.SOAP_ENVELOPE_NAMESPACE_URI)) {
            soapFactory = OMAbstractFactory.getSOAP11Factory();
        }
    }
    public static void main(String[] args) {
        SOAPEnvelope soapEnvelope = OMAbstractFactory.getSOAP12Factory().createSOAPEnvelope();

        System.out.println("Hello, World!");
    }
}


