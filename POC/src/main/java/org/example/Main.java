package org.example;

import io.ballerina.runtime.api.creators.ValueCreator;
import io.ballerina.runtime.api.values.BString;
import io.ballerina.runtime.api.values.BXml;
import io.ballerina.runtime.api.values.BXmlItem;
import org.apache.axiom.om.*;
import io.ballerina.runtime.api.utils.StringUtils;
import org.junit.Assert;

import javax.xml.namespace.QName;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;


public class Main {

    public static void main(String[] args) {
        // Create an OMFactory
        BXmlConverter bXmlConverter = new BXmlConverter();
        BXml bxml = bXmlConverter.GetXmlItem();
        OMElement omElement = bXmlConverter.toOMElement(bxml);
        System.out.println(omElement);
        System.out.println(bxml);

    }

    public static void main2(String[] args) {
        // Create an OMFactory
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
        System.out.println(bXml);
        System.out.println(rootElement);
        System.out.println(bXml.toString());
        System.out.println(rootElement.toString());
        System.out.println(bXml.children().size());
        System.out.println(bXml.children().getItem(0).children().getItem(0).toString());
        System.out.println(bXml.children().getItem(1).children().getItem(0).toString());
        Assert.assertEquals(bXml.children().size(), 2);
        Assert.assertEquals(bXml.children().getItem(0).children().getItem(0).toString(), "Hello");
        Assert.assertEquals(bXml.children().getItem(1).children().getItem(0).toString(), "World");
    }


}



