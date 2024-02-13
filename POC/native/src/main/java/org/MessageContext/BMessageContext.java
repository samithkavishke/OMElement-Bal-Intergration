package org.MessageContext;

import io.ballerina.runtime.api.values.BObject;
import io.ballerina.runtime.api.values.BXml;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.soap.SOAPEnvelope;
import org.apache.axis2.AxisFault;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.engine.AxisConfiguration;
import org.apache.synapse.config.SynapseConfiguration;
import org.apache.synapse.core.SynapseEnvironment;
import org.apache.synapse.core.axis2.Axis2MessageContext;
import org.apache.synapse.core.axis2.Axis2SynapseEnvironment;

import java.util.Map;

import static org.OmelementBXmlConversion.OMElementConverter.toBXml;
import static org.SOAPElementCreation.BXmltoSoapEnvelopeConverter.toSOAPEnvelope;

public class BMessageContext extends Axis2MessageContext {
    public BMessageContext(MessageContext axisMsgCtx, SynapseConfiguration synCfg, SynapseEnvironment synEnv) {
        super(axisMsgCtx, synCfg, synEnv);
    }

    public BMessageContext(SynapseConfiguration synCfg) {
        this(new org.apache.axis2.context.MessageContext(),
                synCfg, new Axis2SynapseEnvironment(new ConfigurationContext(new AxisConfiguration()), synCfg));
    }
    public BMessageContext()  {
        this(new SynapseConfiguration());

    }

    public static void setEnvelopeUtil(Axis2MessageContext messageContext,BXml bXml) throws AxisFault{
//        OMElement omElement = toOMElement(bXml);
        SOAPEnvelope envelope = OMAbstractFactory.getSOAP11Factory().getDefaultEnvelope();
//        messageContext.setEnvelope((SOAPEnvelope) omElement);
        SOAPEnvelope soapEnvelope = toSOAPEnvelope(bXml);
        messageContext.setEnvelope(soapEnvelope);
    }

    public BObject getLocalEntry(String key) {
        return getLocalEntry(key);
    }

    public static void setContextEntries(Axis2MessageContext messageContext, Map<String,Object> entries) {
        System.out.println(entries);
        messageContext.setContextEntries(entries);
    }

    public static BXml getEnvelope(Axis2MessageContext messageContext) {
//        return messageContext.getEnvelope();
        return toBXml(messageContext.getEnvelope());
    }
}
