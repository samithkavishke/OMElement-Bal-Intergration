package org.example;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;

public class Main {

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

        OMElement childElement3 = factory.createOMElement("child3", namespace);


        rootElement.addChild(childElement1);
        rootElement.addChild(childElement2);

        System.out.println(childElement1.getType());
        System.out.println(rootElement.getType());

//        System.out.println(rootElement);
    }

}
