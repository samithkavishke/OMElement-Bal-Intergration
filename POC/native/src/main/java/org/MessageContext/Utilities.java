//package org.MessageContext;
//
//
//
//public class Utilities {
//
////    public static void main(String[] args) throws AxisFault {
//        // Create an OMFactory
////        BasicConfigurator.configure();
////        OMFactory factory = OMAbstractFactory.getOMFactory();
////        OMNamespace namespace = factory.createOMNamespace("http://example.com","ns");
////        OMElement rootElement = factory.createOMElement("root", namespace);
////        rootElement.setText("Hello World!");
////
////        SynapseConfiguration synCfg = new SynapseConfiguration();
////        AxisConfiguration config = new AxisConfiguration();
////        Axis2MessageContext testCtx = new Axis2MessageContext(new org.apache.axis2.context.MessageContext(),
////                synCfg, new Axis2SynapseEnvironment(new ConfigurationContext(config), synCfg));
////        ((Axis2MessageContext) testCtx).getAxis2MessageContext().setConfigurationContext(new ConfigurationContext(config));
////        SOAPEnvelope envelope = OMAbstractFactory.getSOAP11Factory().getDefaultEnvelope();
////        envelope.getBody().addChild(rootElement);
////        testCtx.setEnvelope(envelope);
////        getEnvelope(testCtx);
////    }
//
//    public static void getEnvelope(BObject axis2MessageContext){
////        SOAPEnvelope envelope = axis2MessageContext.getEnvelope();
////        return toBXml(envelope);
////        return toBXml(axis2MessageContext);
//        int x = 1;
//    }
//}
