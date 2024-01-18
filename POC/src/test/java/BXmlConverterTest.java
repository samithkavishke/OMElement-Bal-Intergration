import io.ballerina.runtime.api.creators.ValueCreator;
import io.ballerina.runtime.api.utils.StringUtils;
import io.ballerina.runtime.api.values.BMap;
import io.ballerina.runtime.api.values.BString;
import io.ballerina.runtime.api.values.BXml;
import io.ballerina.runtime.api.values.BXmlItem;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMNode;
import org.example.BXmlConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class BXmlConverterTest {

    @Test
    public void testBXmlToOMElementWithAttributes() {
        QName qName = new QName("http://example.org", "root");
        BXmlItem xmlItem = ValueCreator.createXmlItem(qName, false);

        Map<String,String> attributes = Map.of("attr1","value1","attr2","value2");
        BMap bMap = ValueCreator.createMapValue();

        for(Map.Entry<String, String> entry : attributes.entrySet()) {
            bMap.put(StringUtils.fromString(entry.getKey()), StringUtils.fromString(entry.getValue()));
        }

        xmlItem.setAttributes(bMap);
        OMElement omElement = BXmlConverter.toOMElement(xmlItem);

        Assertions.assertEquals(omElement.getLocalName(), "root");
        Assertions.assertEquals(omElement.getNamespace().getNamespaceURI(), "http://example.org");
        Assertions.assertEquals(omElement.getAttribute(new QName("http://example.org", "attr1")).getAttributeValue(), "value1");
    }

    @Test
    public void testBXmlToOMElementWithChildren() {
        QName qName = new QName("http://example.org", "root");
        BXmlItem xmlItem = ValueCreator.createXmlItem(qName, false);

        BXmlItem child1 = ValueCreator.createXmlItem(new QName("http://example.org", "child1"), false);
        child1.setChildren(ValueCreator.createXmlText("Hello"));
        BXmlItem child2 = ValueCreator.createXmlItem(new QName("http://example.org", "child2"), false);
        child2.setChildren(ValueCreator.createXmlText("World"));

        ArrayList<BXml> xmlList = new ArrayList<>();
        xmlList.add(child1);
        xmlList.add(child2);

        xmlItem.setChildren(ValueCreator.createXmlSequence(xmlList));

        OMElement omElement = BXmlConverter.toOMElement(xmlItem);

        Assertions.assertEquals(omElement.getLocalName(), "root");
        Assertions.assertEquals(omElement.getNamespace().getNamespaceURI(), "http://example.org");

    }

    @Test
    public void testBXmlToOMElementWithComment() {
        QName qName = new QName("http://example.org", "root");
        BXmlItem xmlItem = ValueCreator.createXmlItem(qName, false);

        BXmlItem child1 = ValueCreator.createXmlItem(new QName("http://example.org", "child1"), false);
        child1.setChildren(ValueCreator.createXmlComment("Hello"));
        BXmlItem child2 = ValueCreator.createXmlItem(new QName("http://example.org", "child2"), false);
        child2.setChildren(ValueCreator.createXmlComment("World"));

        ArrayList<BXml> xmlList = new ArrayList<>();
        xmlList.add(child1);
        xmlList.add(child2);

        xmlItem.setChildren(ValueCreator.createXmlSequence(xmlList));

        OMElement omElement = BXmlConverter.toOMElement(xmlItem);

        Assertions.assertEquals(omElement.getLocalName(), "root");
        Assertions.assertEquals(omElement.getNamespace().getNamespaceURI(), "http://example.org");

    }

    @Test
    public void testBXmlToOMElementWithPI() {
        QName qName = new QName("http://example.org", "root");
        BXmlItem xmlItem = ValueCreator.createXmlItem(qName, false);

        BXmlItem child1 = ValueCreator.createXmlItem(new QName("http://example.org", "child1"), false);
        child1.setChildren(ValueCreator.createXmlProcessingInstruction("Hello", "World"));
        BXmlItem child2 = ValueCreator.createXmlItem(new QName("http://example.org", "child2"), false);
        child2.setChildren(ValueCreator.createXmlProcessingInstruction("Hello", "World"));

        ArrayList<BXml> xmlList = new ArrayList<>();
        xmlList.add(child1);
        xmlList.add(child2);

        xmlItem.setChildren(ValueCreator.createXmlSequence(xmlList));

        OMElement omElement = BXmlConverter.toOMElement(xmlItem);

        Assertions.assertEquals(omElement.getLocalName(), "root");
        Assertions.assertEquals(omElement.getNamespace().getNamespaceURI(), "http://example.org");

    }


}
