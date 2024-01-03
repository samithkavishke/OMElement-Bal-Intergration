package org.example;

import io.ballerina.runtime.api.values.BXml;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;

public class Main {
    private static void sain() {
        BXml xml = null;
    }

    public static void main(String[] args) {
        // Create an OMFactory
        OMFactory factory = OMAbstractFactory.getOMFactory();

        // Create an OMNamespace with a specific URI and prefix
        OMNamespace namespace = factory.createOMNamespace("http://example.com", "ns");

        // Create an OMElement with the name "root" and the specified namespace
        OMElement rootElement = factory.createOMElement("root", namespace);

        // Add child elements to the root element
        OMElement childElement1 = factory.createOMElement("child1", namespace);
        childElement1.setText("Hello");

        OMElement childElement2 = factory.createOMElement("child2", namespace);
        childElement2.setText("World");

        rootElement.addChild(childElement1);
        rootElement.addChild(childElement2);

        System.out.println(rootElement);
        // Print the XML representation of the root element
        System.out.println(rootElement);
        sain();
    }
}
