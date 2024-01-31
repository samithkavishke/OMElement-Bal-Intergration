import ballerina/jballerina.java; 

public isolated function getEnvelope(MessageContext MessageContext) returns xml|error = @java:Method {
    'class: "org.ballerinalang.langlib.string.FromCodePointInt",
    name: "fromCodePointInt"
} external;

