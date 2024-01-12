import io.ballerina.runtime.api.values.BXml;
import org.apache.axiom.om.*;
import org.example.OMElementConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OMConverterTest {
    @Test
    public void testOMElementToBXmlWithText() {
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
        Assertions.assertEquals(bXml.children().size(), 2);
        Assertions.assertEquals(bXml.children().getItem(0).children().getItem(0).toString(), "Hello");
        Assertions.assertEquals(bXml.children().getItem(1).children().getItem(0).toString(), "World");
    }

    @Test
    public void testOMElementToBXmlWithComment() {
        OMFactory factory = OMAbstractFactory.getOMFactory();
        OMNamespace namespace = factory.createOMNamespace("http://example.com", "ns");
        OMElement rootElement = factory.createOMElement("root", namespace);
        OMComment comment = factory.createOMComment(rootElement, "This is a comment");
        rootElement.addChild(comment);
        BXml bXml = OMElementConverter.toBXml(rootElement);
        Assertions.assertEquals(bXml.children().size(), 1);
        Assertions.assertEquals(bXml.children().getItem(0).toString(), "<!--This is a comment-->");
    }

    @Test
    public void testOMElementToBXmlWithPI() {
        OMFactory factory = OMAbstractFactory.getOMFactory();
        OMNamespace namespace = factory.createOMNamespace("http://example.com", "ns");
        OMElement rootElement = factory.createOMElement("root", namespace);
        OMProcessingInstruction pi = factory.createOMProcessingInstruction(rootElement, "target", "data");
        rootElement.addChild(pi);
        BXml bXml = OMElementConverter.toBXml(rootElement);
        Assertions.assertEquals(bXml.children().size(), 1);
        Assertions.assertEquals(bXml.children().getItem(0).toString(), "<?target data?>");
    }

    @Test
    public void testOMElementWithCData() {
        OMFactory factory = OMAbstractFactory.getOMFactory();
        OMNamespace namespace = factory.createOMNamespace("http://example.com", "ns");
        OMElement rootElement = factory.createOMElement("root", namespace);
        OMText cdata = factory.createOMText(rootElement, "This is a CDATA", OMNode.CDATA_SECTION_NODE);
        rootElement.addChild(cdata);
        BXml bXml = OMElementConverter.toBXml(rootElement);
        Assertions.assertEquals(bXml.children().size(), 1);
        Assertions.assertEquals(bXml.children().getItem(0).toString(), "&lt;![CDATA[This is a CDATA]]&gt;");
    }
}