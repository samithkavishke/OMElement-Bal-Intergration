//package org.MessageContext;
//
//import org.apache.axis2.context.ConfigurationContext;
//import org.apache.axis2.context.MessageContext;
//import org.apache.axis2.engine.AxisConfiguration;
//import org.apache.synapse.config.SynapseConfiguration;
//import org.apache.synapse.core.SynapseEnvironment;
//import org.apache.synapse.core.axis2.Axis2MessageContext;
//import org.apache.synapse.core.axis2.Axis2SynapseEnvironment;
//
//public class BMessageContext extends Axis2MessageContext implements BHanlde {
//    public BMessageContext(MessageContext axisMsgCtx, SynapseConfiguration synCfg, SynapseEnvironment synEnv) {
//        super(axisMsgCtx, synCfg, synEnv);
//    }
//
//    public BMessageContext(SynapseConfiguration synCfg) {
//        this(new org.apache.axis2.context.MessageContext(),
//                synCfg, new Axis2SynapseEnvironment(new ConfigurationContext(new AxisConfiguration()), synCfg));
//    }
//    public BMessageContext() {
//        this(new SynapseConfiguration());
//    }
//}
