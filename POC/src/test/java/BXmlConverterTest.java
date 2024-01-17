import io.ballerina.runtime.api.creators.ValueCreator;
import io.ballerina.runtime.api.utils.StringUtils;
import io.ballerina.runtime.api.values.BMap;
import io.ballerina.runtime.api.values.BXml;
import io.ballerina.runtime.api.values.BXmlItem;
import org.apache.axiom.om.OMAttribute;
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
    public void testBXmlToOMElementWithText() {
        QName qName = new QName("http://example.org", "root");
        BXmlItem xmlItem = ValueCreator.createXmlItem(qName, false);


        Map<String,String> attributes = Map.of("attr1","value1","attr2","value2");
        BMap bMap = ValueCreator.createMapValue();

        for(Map.Entry<String, String> entry : attributes.entrySet()) {
            bMap.put(StringUtils.fromString(entry.getKey()), StringUtils.fromString(entry.getValue()));
        }

//        xmlItem.setAttributes(bMap);
//
//        ArrayList<BXml> xmlList = new ArrayList<>();
//        var descendants = omElement.getDescendants(false);
//
//        while  (descendants.hasNext()){
//            OMNode childNode = (OMNode) descendants.next();
//            if (childNode.getParent() == omElement) {
//                BXml childXml = toBXml(childNode);
//
//                xmlList.add(childXml);
//            }
//        }
//        xmlItem.setChildren(ValueCreator.createXmlSequence(xmlList));
    }
}
