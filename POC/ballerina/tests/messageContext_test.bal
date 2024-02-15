import ballerina/test;

@test:Config {}
function envelopeTest() {
    MessageContext mc = new MessageContextImpl();
    xml inputXml = xml `<soapenv:Envelope xmlns:soapenv="http://www.w3.org/2003/05/soap-envelope"><soapenv:Header/><soapenv:Body><m0:getQuote xmlns:m0="http://services.samples"><m0:request><m0:symbol>IBM</m0:symbol></m0:request></m0:getQuote></soapenv:Body></soapenv:Envelope>`;

    error? Error = mc.setEnvelope(inputXml);

    test:assertEquals(Error, null, "Error setting envelope");
    test:assertEquals(mc.getEnvelope(),inputXml, "Envelope mismatch");       
}
