import io.ballerina.runtime.api.values.BXml;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.example.OMElementConverter;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OMConverterTest {
     @Test
     public void testOMElementToBXml() {
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

}
