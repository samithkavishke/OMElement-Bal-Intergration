import ballerina/jballerina.java; 

isolated function getEnvelope(MessageContextImpl messagecontext) returns xml = @java:Method {
    'class: "org.MessageContext.Utilities",
    name: "getEnvelope"
} external;

