package org.example;


import org.apache.axiom.om.*;


public class Main {

    public static void main(String[] args) {
        // Create an OMFactory
        main2(args);

    }

    public static void main2(String[] args) {
        // Create an OMFactory
        OMFactory factory = OMAbstractFactory.getOMFactory();
        OMNamespace namespace = factory.createOMNamespace("http://example.com","ns");
        OMElement rootElement = factory.createOMElement("root", namespace);
        rootElement.setText("Hello World!");
        OMElement childElement1 = factory.createOMElement("child1", namespace);
        childElement1.setText("Hell<<o");
        OMElement childElement2 = factory.createOMElement("child2", namespace);
        childElement2.setText("World");
        rootElement.addChild(childElement1);
        rootElement.addChild(childElement2);
        OMText omText = factory.createOMText(rootElement, "This is a comment");
        OMText omText2 = factory.createOMText(rootElement, "\n");
        rootElement.addChild(omText);
        rootElement.addChild(omText2);
        System.out.println(rootElement);
    }


}



