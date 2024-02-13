package org.MessageContext;

import io.ballerina.runtime.api.values.BObject;
import org.apache.axis2.AxisFault;
//import org.apache.log4j.BasicConfigurator;

public class Utilities {

    public static void main(String[] args) throws AxisFault {
        BMessageContext bMessageContext = new BMessageContext();
//            bMessageContext.setProperty("key", "value");
//        bMessageContext.setEnvelope(new SOAP11EnvelopeImpl());
        System.out.println(bMessageContext.getEnvelope());
    }


    public static BObject getEnvelope() throws AxisFault {
        BMessageContext bMessageContext = new BMessageContext();
        System.out.println(bMessageContext.getEnvelope());
        return null;
    }
}
