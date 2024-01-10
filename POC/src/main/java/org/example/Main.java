package org.example;

import io.ballerina.runtime.api.values.BXml;
import org.apache.axiom.om.*;
import io.ballerina.runtime.api.utils.StringUtils;
import org.junit.Assert;

import java.util.Iterator;


public class Main {

    public static void main(String[] args) {
        // Create an OMFactory
//        OMFactory factory = OMAbstractFactory.getOMFactory();
//
//        // Create an OMNamespace with a specific URI and prefix
//        OMNamespace namespace = factory.createOMNamespace("http://example.com", "ns");
//
//        // Create an OMElement with the name "root" and the specified namespace
//        OMElement rootElement = factory.createOMElement("root", namespace);
//
//        OMElement textElement = factory.createOMElement("text", namespace);
//
//        // Add child elements to the root element
//        OMElement childElement1 = factory.createOMElement("child1", namespace);
//        childElement1.setText("Hello");
//
//        OMElement childElement2 = factory.createOMElement("child2", namespace);
//        childElement2.setText("World");
//
//        rootElement.addChild(childElement1);
//        rootElement.addChild(childElement2);
//
//        System.out.println(OMElementConverter.toBXml(rootElement));
//        System.out.println(rootElement);
////        Iterator iterator = rootElement.getChildElements();
////        System.out.println(iterator.next());
////        System.out.println(iterator.next());
////        System.out.println(rootElement.getChildElements().next());
//
////        System.out.println(rootElement);
//
////        System.out.println(rootElement.getChildElements());
//        BXml bXml = OMElementConverter.toBXml(rootElement);
//        System.out.println(bXml.children());
//
//        System.out.println(rootElement.getType());;
//
//        System.out.println();

//        OMText

//        OMFactory factory = OMAbstractFactory.getOMFactory();
//
//        // Create a root element
//        OMElement rootElement = factory.createOMElement("Root", null);
//
//        // Create a text element
//        OMText textElement = factory.createOMText("This is some text content");
//
//        // Add the text element to the root element
//        rootElement.addChild(textElement);
//
//        // Print the XML
////        System.out.println(rootElement.toString());
//        System.out.println(rootElement.getText());

//        OMFactory factory = OMAbstractFactory.getOMFactory();
//
//        // Create a root element
//        OMElement rootElement = factory.createOMElement("Root", null);
//
//        // Create a processing instruction
//        OMProcessingInstruction pi = factory.createOMProcessingInstruction(rootElement, "target", "data");
//
//        // Add the processing instruction to the root element
//        rootElement.addChild(pi);
//
//        // Print the XML
////        OMNode omelement = rootElement.getFirstOMChild();
////        System.out.println(pi);
////        System.out.println(rootElement.getDescendants(false).next());
////        System.out.println(StringUtils.fromString(pi.getTarget()));
//        System.out.println(OMElementConverter.toBXml(rootElement));
//        System.out.println(rootElement);

//        OMFactory factory = OMAbstractFactory.getOMFactory();
//        OMFactory factory = OMAbstractFactory.getOMFactory();
//
//        // Create a root element
//        OMElement rootElement = factory.createOMElement("Root", null);

//        // Create a CDATA section text with "]]>" split into two CDATA sections
//        String cdataContent = "<![CDATA[This is some CDATA content with a sequence ]]>";
//        OMText cdataText = factory.createOMText(cdataContent);
//
//        // Add the CDATA section text to the root element
//        rootElement.addChild(cdataText);
//
//        // Print the XML
//        System.out.println(rootElement.toString());
//
//        factory.createOMDocType(rootElement, "root", "http://example.com", "root.dtd", null);

        OMFactory factory = OMAbstractFactory.getOMFactory();
        OMNamespace namespace = factory.createOMNamespace("http://example.com", "ns");
        OMElement rootElement = factory.createOMElement("root", namespace);
        OMElement childElement1 = factory.createOMElement("child1", namespace);
        childElement1.setText("Hello");
        OMElement childElement2 = factory.createOMElement("child2", namespace);
        childElement2.setText("World");
        rootElement.addChild(childElement1);
        rootElement.addChild(childElement2);
        BXml bXml = OMElementConverter.toBXml(rootElement);
        System.out.println(bXml.children().size());
    }


}
