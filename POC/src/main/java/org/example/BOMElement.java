package org.example;


import io.ballerina.runtime.api.types.Type;
import io.ballerina.runtime.api.types.XmlNodeType;
import io.ballerina.runtime.api.values.*;
import org.apache.axiom.om.OMElement;

import java.util.List;
import java.util.Map;

public class BOMElement implements BXml {

    private final OMElement omElement;

    public BOMElement(OMElement omElement) {
        this.omElement = omElement;
    }

    @Override
    public boolean isEmpty() {
        if (!omElement.getChildElements().hasNext()){
            return true;
        }
        return false;
    }

    @Override
    public boolean isSingleton() {
        if (omElement.getChildElements().hasNext()){
            omElement.getChildElements().next();
            if (!omElement.getChildElements().hasNext()){
                return true;
            }
        }
        return false;
    }

    @Override
    public String getItemType() {
        // TODO: 1/7/24
        if (isSingleton()){
            return "text";
        }
        else return "element";
    }

    @Override
    public String getElementName() {
        return omElement.getLocalName();
    }

    @Override
    public String getTextValue() {
        return omElement.getText();
    }

    @Override
    public BString getAttribute(String s, String s1) {
        return null;
    }

    @Override
    public BString getAttribute(String s, String s1, String s2) {
        return null;
    }

    @Override
    public BString getAttribute(BXmlQName bXmlQName) {
        return null;
    }

    @Override
    public void setAttribute(String s, String s1, String s2, String s3) {

    }

    @Override
    public void setAttribute(BXmlQName bXmlQName, String s) {

    }

    @Override
    public BMap<BString, BString> getAttributesMap() {
        return null;
    }

    @Override
    public void setAttributes(BMap<BString, BString> bMap) {

    }

    @Override
    public BXml elements() {
        return null;
    }

    @Override
    public BXml elements(String s) {
        return null;
    }

    @Override
    public BXml children() {
        return null;
    }

    @Override
    public BXml children(String s) {
        return null;
    }

    @Override
    public void setChildren(BXml bXml) {

    }

    @Override
    public void addChildren(BXml bXml) {

    }

    @Override
    public BXml strip() {
        return null;
    }

    @Override
    public XmlNodeType getNodeType() {
        return null;
    }

    @Override
    public BXml slice(long l, long l1) {
        return null;
    }

    @Override
    public BXml descendants(List<String> list) {
        return null;
    }

    @Override
    public BXml descendants() {
        return null;
    }

    @Override
    public BXml getItem(int i) {
        return null;
    }

    @Override
    public Object copy(Map<Object, Object> map) {
        return null;
    }

    @Override
    public Object frozenCopy(Map<Object, Object> map) {
        return null;
    }

    @Override
    public String stringValue(BLink bLink) {
        return null;
    }

    @Override
    public String expressionStringValue(BLink bLink) {
        return null;
    }

    @Override
    public Type getType() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public BTypedesc getTypedesc() {
        return null;
    }

    @Override
    public void build() {

    }

    @Override
    public void removeAttribute(String s) {

    }

    @Override
    public void removeChildren(String s) {

    }

    @Override
    public Object value() {
        return null;
    }

    @Override
    public Type getIteratorNextReturnType() {
        return null;
    }

    @Override
    public BIterator<?> getIterator() {
        return null;
    }
}
