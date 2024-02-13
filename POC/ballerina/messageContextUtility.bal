import ballerina/jballerina.java; 

// isolated function getEnvelope(MessageContextImpl messagecontext) returns xml = @java:Method {
//     'class: "org.MessageContext.Utilities",
//     name: "getEnvelope"
// } external;
isolated function initalizeMessageContext() returns handle = @java:Constructor {
    'class: "org.MessageContext.BMessageContext"} external;


isolated function setEnvelopeUtil(handle messageContext,xml envelope) returns error? = @java:Method {
    'class: "org.MessageContext.BMessageContext",
    name: "setEnvelopeUtil"
    // paramTypes: ["org.apache.synapse.core.axis2.Axis2MessageContext","bxml"]
} external;

isolated function getEnvelopeUtil(handle messageContext) returns xml = @java:Method {
    'class: "org.MessageContext.BMessageContext",
    name: "getEnvelope",
    paramTypes: ["org.apache.synapse.core.axis2.Axis2MessageContext"]
} external;

isolated function getOMElementUtil() returns handle = @java:Method {
    'class: "org.OmelementBXmlConversion.OMElementConverter",
    name: "toBXml"
} external;

// isolated function setContextEntriesUtil(handle messageContext,map<any> entries) returns handle = @java:Method {
//     'class: "org.MessageContext.BMessageContext",
//     name: "setContextEntries",
//     paramTypes: ["org.apache.synapse.core.axis2.Axis2MessageContext","java.util.Map"]
// } external;