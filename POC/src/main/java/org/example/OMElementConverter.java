package org.example;

import io.ballerina.runtime.api.creators.ValueCreator;
import io.ballerina.runtime.api.utils.StringUtils;
import io.ballerina.runtime.api.values.*;
import org.apache.axiom.om.OMElement;

import javax.xml.namespace.QName;
import java.util.ArrayList;

public class OMElementConverter {


        public static BXml getXmlItem(OMElement omElement) {
            QName qName = new QName(omElement.getNamespaceURI(),omElement.getLocalName());
            BXmlItem xmlItem = ValueCreator.createXmlItem(qName, false);

            BXml bXmlText = ValueCreator.createXmlText(StringUtils.fromString(omElement.getText()));
            ArrayList<BXml> xmlList = new ArrayList<>();
            xmlList.add(bXmlText);

            var iterator = omElement.getChildElements();

            while  (iterator.hasNext()){
                OMElement childElement = (OMElement) iterator.next();

                BXml childXml = getXmlItem(childElement);
                xmlList.add(childXml);
            }
            xmlItem.setChildren(ValueCreator.createXmlSequence(xmlList));
//            xmlItem.setChildren(new XmlSequence(xmlList));
            return xmlItem;
        }
}
