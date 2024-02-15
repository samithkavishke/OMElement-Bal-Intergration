import ballerina/test;

@test:Config {}
function envelopeTest() {
    MessageContext mc = new MessageContextImpl();

    error? Error = mc.setEnvelope(
        xml `<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
        <soapenv:Header/>
        <soapenv:Body>
            <m0:getQuote xmlns:m0="http://services.samples">
                <m0:request>
                    <m0:symbol>IBM</m0:symbol>
                </m0:request>
            </m0:getQuote>
        </soapenv:Body>
        </soapenv:Envelope>`);

    test:assertEquals(Error, null, "Error setting envelope");
    
       
}