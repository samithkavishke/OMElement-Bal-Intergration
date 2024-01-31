distinct class messageContextImpl {
    *MessageContext;

    isolated function getEnvelope() returns xml {
        return xml ``;
    }

    // bxml 
    isolated function getLocalEntry(string key) returns any {
        return ;
    }

    isolated function getMessageID() returns string {
        return "";
    }

    isolated function getProperties() returns map<[string, any]> {
        return {};
    }

    isolated function getProperty(string key) returns any {
        return ;
    }

    isolated function getPropertyKeySet() returns map<string> {
        return {};
    }

    isolated function getSoapAction() returns string {
        return "";
    }

    isolated function getWSAAction() returns string {
        return "";
    }

    isolated function getWSAMessageID() returns string {
        return "";
    }

    isolated function isDoingGET() returns boolean {
        return false;
    }

    isolated function isDoingMTOM() returns boolean {
        return false;
    }

    isolated function isDoingPOX() returns boolean {
        return false;
    }

    isolated function isDoingSWA() returns boolean {
        return false;
    }

    isolated function isFaultResponse() returns boolean {
        return false;
    }

    isolated function isPaused() returns boolean {
        return false;
    }

    isolated function isResponse() returns boolean {
        return false;
    }

    isolated function isSOAP11() returns boolean {
        return false;
    }

    isolated function isServerSide() returns boolean {
        return false;
    }

    isolated function setDoingGET(boolean b) returns error? {
        return;
    }

    isolated function setDoingMTOM(boolean b) returns error? {
        return;
    }

    isolated function setDoingPOX(boolean b) returns error? {
        return;
    }

    isolated function setDoingSWA(boolean b) returns error? {
        return;
    }

    isolated function setEnvelope(xml envelope) returns error? {
        return;
    }

    isolated function setFaultResponse(boolean b) returns error? {
        return;
    }

    isolated function setMessageID(string id) returns error? {
        return;
    }

    isolated function setPaused(boolean b) returns error? {
        return;
    }

    isolated function setProperty(string key, any value) returns error? {
        return;
    }

    isolated function setResponse(boolean b) returns error? {
        return;
    }

    isolated function setServerSide(boolean b) returns error? {
        return;
    }

    isolated function toString() returns string {
        return "";
    }
}