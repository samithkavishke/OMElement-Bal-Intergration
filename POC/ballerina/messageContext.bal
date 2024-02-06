public type MessageContext object {

    isolated function getEnvelope() returns xml;

    isolated function getLocalEntry(string key) returns any;

    isolated function getMessageID() returns string;

    isolated function getProperty(string key) returns any;

    isolated function getProperties() returns map<[string,any]>;
    
    isolated function getPropertyKeySet() returns map<string>;

    isolated function getSoapAction() returns string;

    isolated function getWSAAction() returns string;

    isolated function getWSAMessageID() returns string;

    isolated function isDoingGET() returns boolean;

    isolated function isDoingMTOM() returns boolean;

    isolated function isDoingPOX() returns boolean;

    isolated function isDoingSWA() returns boolean;

    isolated function isFaultResponse() returns boolean;

    isolated function isPaused() returns boolean;

    isolated function isResponse() returns boolean;

    isolated function isServerSide() returns boolean;

    isolated function isSOAP11() returns boolean;

    isolated function setDoingGET(boolean b) returns error?;

    isolated function setDoingMTOM(boolean b) returns error?;

    isolated function setDoingPOX(boolean b) returns error?;

    isolated function setDoingSWA(boolean b) returns error?;

    isolated function setEnvelope(xml envelope) returns error?;

    isolated function setFaultResponse(boolean b) returns error?;

    isolated function setMessageID(string id) returns error?;

    isolated function setPaused(boolean b) returns error?;

    isolated function setProperty(string key, any value) returns error?;

    isolated function setResponse(boolean b) returns error?;

    isolated function setServerSide(boolean b) returns error?;

    isolated function toString() returns string;
// getProperties
// getEnvelope()
//	getLocalEntry(String key)
//	getMessageID()
//getProperty(String key) --- getPropertyKeySet()
//getSoapAction()
//getWSAAction()
//	getWSAMessageID()
// all is
//setDoingGET(boolean b)
//setEnvelope(org.apache.axio-> xml
// all sets
};

