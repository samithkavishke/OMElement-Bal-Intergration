import ballerina/io;


public function main() {
    MessageContextImpl messageContext = new MessageContextImpl();
    xml envelope = messageContext.getEnvelope();
    io:println(envelope.toString());
    // io:println("Hello, World!");
}
