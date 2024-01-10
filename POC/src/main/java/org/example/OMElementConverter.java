package org.example;

import io.ballerina.runtime.api.creators.ValueCreator;
import io.ballerina.runtime.api.utils.StringUtils;
import io.ballerina.runtime.api.values.*;
import org.apache.axiom.om.*;

import javax.xml.namespace.QName;
import java.util.ArrayList;

public class OMElementConverter {

        public static BXml toBXml(OMElement omElement){
            return getXmlItem(omElement);
        }

        public static  BXml toBXml(OMNode omNode) {
            if (omNode.getType() == OMNode.ELEMENT_NODE) {
                return getXmlItem((OMElement) omNode);
            } else if (omNode.getType() == OMNode.TEXT_NODE) {
                return getXmlText((OMText) omNode);
            } else if (omNode.getType() == OMNode.PI_NODE) {
                return getXmlPI((OMProcessingInstruction) omNode);
            } else if (omNode.getType() == OMNode.COMMENT_NODE) {
                return getXmlComment((OMComment) omNode);
            } else if (omNode.getType() == OMNode.SPACE_NODE) {
                return getXmlText((OMText) omNode);
            } else if (omNode.getType() == OMNode.CDATA_SECTION_NODE) {
                // check whether there is any other conversion
                return getXmlText((OMText) omNode);
            } else if (omNode.getType() == OMNode.DTD_NODE){
                return null;
            } else if (omNode.getType() == OMNode.ENTITY_REFERENCE_NODE){
                return null;
            }
            return null;
        }
        private static BXml getXmlItem(OMElement omElement) {
            QName qName = new QName(omElement.getNamespaceURI(),omElement.getLocalName());
            BXmlItem xmlItem = ValueCreator.createXmlItem(qName, false);

//            BXml bXmlText = ValueCreator.createXmlText(StringUtils.fromString(omElement.getText()));
            ArrayList<BXml> xmlList = new ArrayList<>();
//            xmlList.add(bXmlText);

            var iterator = omElement.getDescendants(false);

            while  (iterator.hasNext()){
                OMNode childNode = (OMNode) iterator.next();
                if (childNode.getParent() == omElement) {
                    BXml childXml = toBXml(childNode);

//                OMElement childElement = (OMElement) iterator.next();

//                BXml childXml = getXmlItem(childElement);
                    xmlList.add(childXml);
                }

            }
            xmlItem.setChildren(ValueCreator.createXmlSequence(xmlList));
            return xmlItem;
        }

        private static BXml getXmlText(OMText omText) {
            return ValueCreator.createXmlText(StringUtils.fromString(omText.getText()));
        }

        private static BXml getXmlPI(OMProcessingInstruction omProcessingInstruction) {
            return ValueCreator.createXmlProcessingInstruction(StringUtils.fromString(omProcessingInstruction.getTarget()),
                    StringUtils.fromString(omProcessingInstruction.getValue()));
        }

        private static BXml getXmlComment(OMComment omComment) {
            return ValueCreator.createXmlComment(StringUtils.fromString(omComment.getValue()));
        }

        private static BXml getXmlSequence(OMElement omElement) {
            ArrayList<BXml> xmlList = new ArrayList<>();
            var iterator = omElement.getChildElements();

            while  (iterator.hasNext()){
                OMElement childElement = (OMElement) iterator.next();

                BXml childXml = getXmlItem(childElement);
                xmlList.add(childXml);
            }
            return ValueCreator.createXmlSequence(xmlList);
        }
}
