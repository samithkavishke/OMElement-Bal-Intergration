import ballerina/io;


public function main() {
    MessageContextImpl messageContext = new MessageContextImpl();
    xml envelope = messageContext.getEnvelope();
    xml env = messageContext.getEnvelope();
    handle envelopeHandle = messageContext.get();
    // handle oMElementUtil = getOMElementUtil();
    error? hello = messageContext.setEnvelope(xml `<soap:Envelope
            xmlns:soap="http://www.w3.org/2003/05/soap-envelope/"
soap:encodingStyle="http://www.w3.org/2003/05/soap-encoding">
  ...
  Message information goes here
  ...
</soap:Envelope>`);
    io:println(messageContext.getEnvelope());
    map<string> contextEntries = {
        "key1": "abc",
        "key2": "def"
    };


    
    messageContext.setContextEntries(contextEntries);

    any a = messageContext.getLocalEntry("key1");
    io:println(a);

    messageContext.setMessageID("1234");
    io:println(messageContext.getMessageID());

    messageContext.setProperty("key1", "value1");
    messageContext.setProperty("key2", "value2");

    map<any> properties = messageContext.getProperties();
    io:println(properties);

    io:println(messageContext.getProperty("key1"));

    io:println(messageContext.getPropertyKeySet());

    messageContext.setSoapAction("http://www.w3.org/2003/05/soap-envelope");
    io:println(messageContext.getSoapAction());

    messageContext.setWSAMessageID("1234");
    io:println(messageContext.getWSAMessageID());

    messageContext.setWSAAction("http://www.w3.org/2003/05/action");
    io:println(messageContext.getWSAAction());
    io:println("###############################################################");
    io:println(messageContext.toString());



    messageContext.setDoingGET(true);
    io:println(messageContext.isDoingGET());
}
