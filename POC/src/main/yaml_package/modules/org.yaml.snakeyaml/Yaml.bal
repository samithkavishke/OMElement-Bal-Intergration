import yaml_package.java.io as javaio;
import yaml_package.java.lang as javalang;
import yaml_package.java.util as javautil;
import yaml_package.java.util.regex as javautilregex;
import yaml_package.org.yaml.snakeyaml.constructor as orgyamlsnakeyamlconstructor;
import yaml_package.org.yaml.snakeyaml.introspector as orgyamlsnakeyamlintrospector;
import yaml_package.org.yaml.snakeyaml.nodes as orgyamlsnakeyamlnodes;
import yaml_package.org.yaml.snakeyaml.representer as orgyamlsnakeyamlrepresenter;
import yaml_package.org.yaml.snakeyaml.resolver as orgyamlsnakeyamlresolver;

import ballerina/jballerina.java;

# Ballerina class mapping for the Java `org.yaml.snakeyaml.Yaml` class.
@java:Binding {'class: "org.yaml.snakeyaml.Yaml"}
public distinct class Yaml {

    *java:JObject;
    *javalang:Object;

    # The `handle` field that stores the reference to the `org.yaml.snakeyaml.Yaml` object.
    public handle jObj;

    # The init function of the Ballerina class mapping the `org.yaml.snakeyaml.Yaml` Java class.
    #
    # + obj - The `handle` value containing the Java reference of the object.
    public function init(handle obj) {
        self.jObj = obj;
    }

    # The function to retrieve the string representation of the Ballerina class mapping the `org.yaml.snakeyaml.Yaml` Java class.
    #
    # + return - The `string` form of the Java object instance.
    public function toString() returns string {
        return java:toString(self.jObj) ?: "";
    }
    # The function that maps to the `addImplicitResolver` method of `org.yaml.snakeyaml.Yaml`.
    #
    # + arg0 - The `orgyamlsnakeyamlnodes:Tag` value required to map with the Java method parameter.
    # + arg1 - The `javautilregex:Pattern` value required to map with the Java method parameter.
    # + arg2 - The `string` value required to map with the Java method parameter.
    public function addImplicitResolver(orgyamlsnakeyamlnodes:Tag arg0, javautilregex:Pattern arg1, string arg2) {
        org_yaml_snakeyaml_Yaml_addImplicitResolver(self.jObj, arg0.jObj, arg1.jObj, java:fromString(arg2));
    }

    # The function that maps to the `addTypeDescription` method of `org.yaml.snakeyaml.Yaml`.
    #
    # + arg0 - The `TypeDescription` value required to map with the Java method parameter.
    public function addTypeDescription(TypeDescription arg0) {
        org_yaml_snakeyaml_Yaml_addTypeDescription(self.jObj, arg0.jObj);
    }

    # The function that maps to the `compose` method of `org.yaml.snakeyaml.Yaml`.
    #
    # + arg0 - The `javaio:Reader` value required to map with the Java method parameter.
    # + return - The `orgyamlsnakeyamlnodes:Node` value returning from the Java mapping.
    public function compose(javaio:Reader arg0) returns orgyamlsnakeyamlnodes:Node {
        handle externalObj = org_yaml_snakeyaml_Yaml_compose(self.jObj, arg0.jObj);
        orgyamlsnakeyamlnodes:Node newObj = new (externalObj);
        return newObj;
    }

    # The function that maps to the `composeAll` method of `org.yaml.snakeyaml.Yaml`.
    #
    # + arg0 - The `javaio:Reader` value required to map with the Java method parameter.
    # + return - The `javalang:Iterable` value returning from the Java mapping.
    public function composeAll(javaio:Reader arg0) returns javalang:Iterable {
        handle externalObj = org_yaml_snakeyaml_Yaml_composeAll(self.jObj, arg0.jObj);
        javalang:Iterable newObj = new (externalObj);
        return newObj;
    }

    # The function that maps to the `dump` method of `org.yaml.snakeyaml.Yaml`.
    #
    # + arg0 - The `javalang:Object` value required to map with the Java method parameter.
    # + return - The `string` value returning from the Java mapping.
    public function dump(javalang:Object arg0) returns string {
        return java:toString(org_yaml_snakeyaml_Yaml_dump(self.jObj, arg0.jObj)) ?: "";
    }

    # The function that maps to the `dump` method of `org.yaml.snakeyaml.Yaml`.
    #
    # + arg0 - The `javalang:Object` value required to map with the Java method parameter.
    # + arg1 - The `javaio:Writer` value required to map with the Java method parameter.
    public function dump2(javalang:Object arg0, javaio:Writer arg1) {
        org_yaml_snakeyaml_Yaml_dump2(self.jObj, arg0.jObj, arg1.jObj);
    }

    # The function that maps to the `dumpAll` method of `org.yaml.snakeyaml.Yaml`.
    #
    # + arg0 - The `javautil:Iterator` value required to map with the Java method parameter.
    # + return - The `string` value returning from the Java mapping.
    public function dumpAll(javautil:Iterator arg0) returns string {
        return java:toString(org_yaml_snakeyaml_Yaml_dumpAll(self.jObj, arg0.jObj)) ?: "";
    }

    # The function that maps to the `dumpAll` method of `org.yaml.snakeyaml.Yaml`.
    #
    # + arg0 - The `javautil:Iterator` value required to map with the Java method parameter.
    # + arg1 - The `javaio:Writer` value required to map with the Java method parameter.
    public function dumpAll2(javautil:Iterator arg0, javaio:Writer arg1) {
        org_yaml_snakeyaml_Yaml_dumpAll2(self.jObj, arg0.jObj, arg1.jObj);
    }

    # The function that maps to the `dumpAs` method of `org.yaml.snakeyaml.Yaml`.
    #
    # + arg0 - The `javalang:Object` value required to map with the Java method parameter.
    # + arg1 - The `orgyamlsnakeyamlnodes:Tag` value required to map with the Java method parameter.
    # + arg2 - The `FlowStyle` value required to map with the Java method parameter.
    # + return - The `string` value returning from the Java mapping.
    public function dumpAs(javalang:Object arg0, orgyamlsnakeyamlnodes:Tag arg1, FlowStyle arg2) returns string {
        return java:toString(org_yaml_snakeyaml_Yaml_dumpAs(self.jObj, arg0.jObj, arg1.jObj, arg2.jObj)) ?: "";
    }

    # The function that maps to the `dumpAsMap` method of `org.yaml.snakeyaml.Yaml`.
    #
    # + arg0 - The `javalang:Object` value required to map with the Java method parameter.
    # + return - The `string` value returning from the Java mapping.
    public function dumpAsMap(javalang:Object arg0) returns string {
        return java:toString(org_yaml_snakeyaml_Yaml_dumpAsMap(self.jObj, arg0.jObj)) ?: "";
    }

    # The function that maps to the `equals` method of `org.yaml.snakeyaml.Yaml`.
    #
    # + arg0 - The `javalang:Object` value required to map with the Java method parameter.
    # + return - The `boolean` value returning from the Java mapping.
    public function 'equals(javalang:Object arg0) returns boolean {
        return org_yaml_snakeyaml_Yaml_equals(self.jObj, arg0.jObj);
    }

    # The function that maps to the `getClass` method of `org.yaml.snakeyaml.Yaml`.
    #
    # + return - The `javalang:Class` value returning from the Java mapping.
    public function getClass() returns javalang:Class {
        handle externalObj = org_yaml_snakeyaml_Yaml_getClass(self.jObj);
        javalang:Class newObj = new (externalObj);
        return newObj;
    }

    # The function that maps to the `getName` method of `org.yaml.snakeyaml.Yaml`.
    #
    # + return - The `string` value returning from the Java mapping.
    public function getName() returns string {
        return java:toString(org_yaml_snakeyaml_Yaml_getName(self.jObj)) ?: "";
    }

    # The function that maps to the `hashCode` method of `org.yaml.snakeyaml.Yaml`.
    #
    # + return - The `int` value returning from the Java mapping.
    public function hashCode() returns int {
        return org_yaml_snakeyaml_Yaml_hashCode(self.jObj);
    }

    # The function that maps to the `load` method of `org.yaml.snakeyaml.Yaml`.
    #
    # + arg0 - The `javaio:InputStream` value required to map with the Java method parameter.
    # + return - The `javalang:Object` value returning from the Java mapping.
    public function load(javaio:InputStream arg0) returns javalang:Object {
        handle externalObj = org_yaml_snakeyaml_Yaml_load(self.jObj, arg0.jObj);
        javalang:Object newObj = new (externalObj);
        return newObj;
    }

    # The function that maps to the `load` method of `org.yaml.snakeyaml.Yaml`.
    #
    # + arg0 - The `javaio:Reader` value required to map with the Java method parameter.
    # + return - The `javalang:Object` value returning from the Java mapping.
    public function load2(javaio:Reader arg0) returns javalang:Object {
        handle externalObj = org_yaml_snakeyaml_Yaml_load2(self.jObj, arg0.jObj);
        javalang:Object newObj = new (externalObj);
        return newObj;
    }

    # The function that maps to the `load` method of `org.yaml.snakeyaml.Yaml`.
    #
    # + arg0 - The `string` value required to map with the Java method parameter.
    # + return - The `javalang:Object` value returning from the Java mapping.
    public function load3(string arg0) returns javalang:Object {
        handle externalObj = org_yaml_snakeyaml_Yaml_load3(self.jObj, java:fromString(arg0));
        javalang:Object newObj = new (externalObj);
        return newObj;
    }

    # The function that maps to the `loadAll` method of `org.yaml.snakeyaml.Yaml`.
    #
    # + arg0 - The `javaio:InputStream` value required to map with the Java method parameter.
    # + return - The `javalang:Iterable` value returning from the Java mapping.
    public function loadAll(javaio:InputStream arg0) returns javalang:Iterable {
        handle externalObj = org_yaml_snakeyaml_Yaml_loadAll(self.jObj, arg0.jObj);
        javalang:Iterable newObj = new (externalObj);
        return newObj;
    }

    # The function that maps to the `loadAll` method of `org.yaml.snakeyaml.Yaml`.
    #
    # + arg0 - The `javaio:Reader` value required to map with the Java method parameter.
    # + return - The `javalang:Iterable` value returning from the Java mapping.
    public function loadAll2(javaio:Reader arg0) returns javalang:Iterable {
        handle externalObj = org_yaml_snakeyaml_Yaml_loadAll2(self.jObj, arg0.jObj);
        javalang:Iterable newObj = new (externalObj);
        return newObj;
    }

    # The function that maps to the `loadAll` method of `org.yaml.snakeyaml.Yaml`.
    #
    # + arg0 - The `string` value required to map with the Java method parameter.
    # + return - The `javalang:Iterable` value returning from the Java mapping.
    public function loadAll3(string arg0) returns javalang:Iterable {
        handle externalObj = org_yaml_snakeyaml_Yaml_loadAll3(self.jObj, java:fromString(arg0));
        javalang:Iterable newObj = new (externalObj);
        return newObj;
    }

    # The function that maps to the `loadAs` method of `org.yaml.snakeyaml.Yaml`.
    #
    # + arg0 - The `javaio:InputStream` value required to map with the Java method parameter.
    # + arg1 - The `javalang:Class` value required to map with the Java method parameter.
    # + return - The `javalang:Object` value returning from the Java mapping.
    public function loadAs(javaio:InputStream arg0, javalang:Class arg1) returns javalang:Object {
        handle externalObj = org_yaml_snakeyaml_Yaml_loadAs(self.jObj, arg0.jObj, arg1.jObj);
        javalang:Object newObj = new (externalObj);
        return newObj;
    }

    # The function that maps to the `loadAs` method of `org.yaml.snakeyaml.Yaml`.
    #
    # + arg0 - The `javaio:Reader` value required to map with the Java method parameter.
    # + arg1 - The `javalang:Class` value required to map with the Java method parameter.
    # + return - The `javalang:Object` value returning from the Java mapping.
    public function loadAs2(javaio:Reader arg0, javalang:Class arg1) returns javalang:Object {
        handle externalObj = org_yaml_snakeyaml_Yaml_loadAs2(self.jObj, arg0.jObj, arg1.jObj);
        javalang:Object newObj = new (externalObj);
        return newObj;
    }

    # The function that maps to the `loadAs` method of `org.yaml.snakeyaml.Yaml`.
    #
    # + arg0 - The `string` value required to map with the Java method parameter.
    # + arg1 - The `javalang:Class` value required to map with the Java method parameter.
    # + return - The `javalang:Object` value returning from the Java mapping.
    public function loadAs3(string arg0, javalang:Class arg1) returns javalang:Object {
        handle externalObj = org_yaml_snakeyaml_Yaml_loadAs3(self.jObj, java:fromString(arg0), arg1.jObj);
        javalang:Object newObj = new (externalObj);
        return newObj;
    }

    # The function that maps to the `notify` method of `org.yaml.snakeyaml.Yaml`.
    public function notify() {
        org_yaml_snakeyaml_Yaml_notify(self.jObj);
    }

    # The function that maps to the `notifyAll` method of `org.yaml.snakeyaml.Yaml`.
    public function notifyAll() {
        org_yaml_snakeyaml_Yaml_notifyAll(self.jObj);
    }

    # The function that maps to the `parse` method of `org.yaml.snakeyaml.Yaml`.
    #
    # + arg0 - The `javaio:Reader` value required to map with the Java method parameter.
    # + return - The `javalang:Iterable` value returning from the Java mapping.
    public function parse(javaio:Reader arg0) returns javalang:Iterable {
        handle externalObj = org_yaml_snakeyaml_Yaml_parse(self.jObj, arg0.jObj);
        javalang:Iterable newObj = new (externalObj);
        return newObj;
    }

    # The function that maps to the `represent` method of `org.yaml.snakeyaml.Yaml`.
    #
    # + arg0 - The `javalang:Object` value required to map with the Java method parameter.
    # + return - The `orgyamlsnakeyamlnodes:Node` value returning from the Java mapping.
    public function represent(javalang:Object arg0) returns orgyamlsnakeyamlnodes:Node {
        handle externalObj = org_yaml_snakeyaml_Yaml_represent(self.jObj, arg0.jObj);
        orgyamlsnakeyamlnodes:Node newObj = new (externalObj);
        return newObj;
    }

    # The function that maps to the `serialize` method of `org.yaml.snakeyaml.Yaml`.
    #
    # + arg0 - The `orgyamlsnakeyamlnodes:Node` value required to map with the Java method parameter.
    # + return - The `javautil:List` value returning from the Java mapping.
    public function serialize(orgyamlsnakeyamlnodes:Node arg0) returns javautil:List {
        handle externalObj = org_yaml_snakeyaml_Yaml_serialize(self.jObj, arg0.jObj);
        javautil:List newObj = new (externalObj);
        return newObj;
    }

    # The function that maps to the `setBeanAccess` method of `org.yaml.snakeyaml.Yaml`.
    #
    # + arg0 - The `orgyamlsnakeyamlintrospector:BeanAccess` value required to map with the Java method parameter.
    public function setBeanAccess(orgyamlsnakeyamlintrospector:BeanAccess arg0) {
        org_yaml_snakeyaml_Yaml_setBeanAccess(self.jObj, arg0.jObj);
    }

    # The function that maps to the `setName` method of `org.yaml.snakeyaml.Yaml`.
    #
    # + arg0 - The `string` value required to map with the Java method parameter.
    public function setName(string arg0) {
        org_yaml_snakeyaml_Yaml_setName(self.jObj, java:fromString(arg0));
    }

    # The function that maps to the `wait` method of `org.yaml.snakeyaml.Yaml`.
    #
    # + return - The `javalang:InterruptedException` value returning from the Java mapping.
    public function 'wait() returns javalang:InterruptedException? {
        error|() externalObj = org_yaml_snakeyaml_Yaml_wait(self.jObj);
        if (externalObj is error) {
            javalang:InterruptedException e = error javalang:InterruptedException(javalang:INTERRUPTEDEXCEPTION, externalObj, message = externalObj.message());
            return e;
        }
    }

    # The function that maps to the `wait` method of `org.yaml.snakeyaml.Yaml`.
    #
    # + arg0 - The `int` value required to map with the Java method parameter.
    # + return - The `javalang:InterruptedException` value returning from the Java mapping.
    public function wait2(int arg0) returns javalang:InterruptedException? {
        error|() externalObj = org_yaml_snakeyaml_Yaml_wait2(self.jObj, arg0);
        if (externalObj is error) {
            javalang:InterruptedException e = error javalang:InterruptedException(javalang:INTERRUPTEDEXCEPTION, externalObj, message = externalObj.message());
            return e;
        }
    }

    # The function that maps to the `wait` method of `org.yaml.snakeyaml.Yaml`.
    #
    # + arg0 - The `int` value required to map with the Java method parameter.
    # + arg1 - The `int` value required to map with the Java method parameter.
    # + return - The `javalang:InterruptedException` value returning from the Java mapping.
    public function wait3(int arg0, int arg1) returns javalang:InterruptedException? {
        error|() externalObj = org_yaml_snakeyaml_Yaml_wait3(self.jObj, arg0, arg1);
        if (externalObj is error) {
            javalang:InterruptedException e = error javalang:InterruptedException(javalang:INTERRUPTEDEXCEPTION, externalObj, message = externalObj.message());
            return e;
        }
    }

}

# The constructor function to generate an object of `org.yaml.snakeyaml.Yaml`.
#
# + return - The new `Yaml` class generated.
public function newYaml1() returns Yaml {
    handle externalObj = org_yaml_snakeyaml_Yaml_newYaml1();
    Yaml newObj = new (externalObj);
    return newObj;
}

# The constructor function to generate an object of `org.yaml.snakeyaml.Yaml`.
#
# + arg0 - The `orgyamlsnakeyamlconstructor:BaseConstructor` value required to map with the Java constructor parameter.
# + return - The new `Yaml` class generated.
public function newYaml2(orgyamlsnakeyamlconstructor:BaseConstructor arg0) returns Yaml {
    handle externalObj = org_yaml_snakeyaml_Yaml_newYaml2(arg0.jObj);
    Yaml newObj = new (externalObj);
    return newObj;
}

# The constructor function to generate an object of `org.yaml.snakeyaml.Yaml`.
#
# + arg0 - The `orgyamlsnakeyamlconstructor:BaseConstructor` value required to map with the Java constructor parameter.
# + arg1 - The `orgyamlsnakeyamlrepresenter:Representer` value required to map with the Java constructor parameter.
# + return - The new `Yaml` class generated.
public function newYaml3(orgyamlsnakeyamlconstructor:BaseConstructor arg0, orgyamlsnakeyamlrepresenter:Representer arg1) returns Yaml {
    handle externalObj = org_yaml_snakeyaml_Yaml_newYaml3(arg0.jObj, arg1.jObj);
    Yaml newObj = new (externalObj);
    return newObj;
}

# The constructor function to generate an object of `org.yaml.snakeyaml.Yaml`.
#
# + arg0 - The `orgyamlsnakeyamlconstructor:BaseConstructor` value required to map with the Java constructor parameter.
# + arg1 - The `orgyamlsnakeyamlrepresenter:Representer` value required to map with the Java constructor parameter.
# + arg2 - The `DumperOptions` value required to map with the Java constructor parameter.
# + return - The new `Yaml` class generated.
public function newYaml4(orgyamlsnakeyamlconstructor:BaseConstructor arg0, orgyamlsnakeyamlrepresenter:Representer arg1, DumperOptions arg2) returns Yaml {
    handle externalObj = org_yaml_snakeyaml_Yaml_newYaml4(arg0.jObj, arg1.jObj, arg2.jObj);
    Yaml newObj = new (externalObj);
    return newObj;
}

# The constructor function to generate an object of `org.yaml.snakeyaml.Yaml`.
#
# + arg0 - The `orgyamlsnakeyamlconstructor:BaseConstructor` value required to map with the Java constructor parameter.
# + arg1 - The `orgyamlsnakeyamlrepresenter:Representer` value required to map with the Java constructor parameter.
# + arg2 - The `DumperOptions` value required to map with the Java constructor parameter.
# + arg3 - The `LoaderOptions` value required to map with the Java constructor parameter.
# + return - The new `Yaml` class generated.
public function newYaml5(orgyamlsnakeyamlconstructor:BaseConstructor arg0, orgyamlsnakeyamlrepresenter:Representer arg1, DumperOptions arg2, LoaderOptions arg3) returns Yaml {
    handle externalObj = org_yaml_snakeyaml_Yaml_newYaml5(arg0.jObj, arg1.jObj, arg2.jObj, arg3.jObj);
    Yaml newObj = new (externalObj);
    return newObj;
}

# The constructor function to generate an object of `org.yaml.snakeyaml.Yaml`.
#
# + arg0 - The `orgyamlsnakeyamlconstructor:BaseConstructor` value required to map with the Java constructor parameter.
# + arg1 - The `orgyamlsnakeyamlrepresenter:Representer` value required to map with the Java constructor parameter.
# + arg2 - The `DumperOptions` value required to map with the Java constructor parameter.
# + arg3 - The `LoaderOptions` value required to map with the Java constructor parameter.
# + arg4 - The `orgyamlsnakeyamlresolver:Resolver` value required to map with the Java constructor parameter.
# + return - The new `Yaml` class generated.
public function newYaml6(orgyamlsnakeyamlconstructor:BaseConstructor arg0, orgyamlsnakeyamlrepresenter:Representer arg1, DumperOptions arg2, LoaderOptions arg3, orgyamlsnakeyamlresolver:Resolver arg4) returns Yaml {
    handle externalObj = org_yaml_snakeyaml_Yaml_newYaml6(arg0.jObj, arg1.jObj, arg2.jObj, arg3.jObj, arg4.jObj);
    Yaml newObj = new (externalObj);
    return newObj;
}

# The constructor function to generate an object of `org.yaml.snakeyaml.Yaml`.
#
# + arg0 - The `orgyamlsnakeyamlconstructor:BaseConstructor` value required to map with the Java constructor parameter.
# + arg1 - The `orgyamlsnakeyamlrepresenter:Representer` value required to map with the Java constructor parameter.
# + arg2 - The `DumperOptions` value required to map with the Java constructor parameter.
# + arg3 - The `orgyamlsnakeyamlresolver:Resolver` value required to map with the Java constructor parameter.
# + return - The new `Yaml` class generated.
public function newYaml7(orgyamlsnakeyamlconstructor:BaseConstructor arg0, orgyamlsnakeyamlrepresenter:Representer arg1, DumperOptions arg2, orgyamlsnakeyamlresolver:Resolver arg3) returns Yaml {
    handle externalObj = org_yaml_snakeyaml_Yaml_newYaml7(arg0.jObj, arg1.jObj, arg2.jObj, arg3.jObj);
    Yaml newObj = new (externalObj);
    return newObj;
}

# The constructor function to generate an object of `org.yaml.snakeyaml.Yaml`.
#
# + arg0 - The `DumperOptions` value required to map with the Java constructor parameter.
# + return - The new `Yaml` class generated.
public function newYaml8(DumperOptions arg0) returns Yaml {
    handle externalObj = org_yaml_snakeyaml_Yaml_newYaml8(arg0.jObj);
    Yaml newObj = new (externalObj);
    return newObj;
}

# The constructor function to generate an object of `org.yaml.snakeyaml.Yaml`.
#
# + arg0 - The `LoaderOptions` value required to map with the Java constructor parameter.
# + return - The new `Yaml` class generated.
public function newYaml9(LoaderOptions arg0) returns Yaml {
    handle externalObj = org_yaml_snakeyaml_Yaml_newYaml9(arg0.jObj);
    Yaml newObj = new (externalObj);
    return newObj;
}

# The constructor function to generate an object of `org.yaml.snakeyaml.Yaml`.
#
# + arg0 - The `orgyamlsnakeyamlrepresenter:Representer` value required to map with the Java constructor parameter.
# + return - The new `Yaml` class generated.
public function newYaml10(orgyamlsnakeyamlrepresenter:Representer arg0) returns Yaml {
    handle externalObj = org_yaml_snakeyaml_Yaml_newYaml10(arg0.jObj);
    Yaml newObj = new (externalObj);
    return newObj;
}

# The constructor function to generate an object of `org.yaml.snakeyaml.Yaml`.
#
# + arg0 - The `orgyamlsnakeyamlrepresenter:Representer` value required to map with the Java constructor parameter.
# + arg1 - The `DumperOptions` value required to map with the Java constructor parameter.
# + return - The new `Yaml` class generated.
public function newYaml11(orgyamlsnakeyamlrepresenter:Representer arg0, DumperOptions arg1) returns Yaml {
    handle externalObj = org_yaml_snakeyaml_Yaml_newYaml11(arg0.jObj, arg1.jObj);
    Yaml newObj = new (externalObj);
    return newObj;
}

function org_yaml_snakeyaml_Yaml_addImplicitResolver(handle receiver, handle arg0, handle arg1, handle arg2) = @java:Method {
    name: "addImplicitResolver",
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: ["org.yaml.snakeyaml.nodes.Tag", "java.util.regex.Pattern", "java.lang.String"]
} external;

function org_yaml_snakeyaml_Yaml_addTypeDescription(handle receiver, handle arg0) = @java:Method {
    name: "addTypeDescription",
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: ["org.yaml.snakeyaml.TypeDescription"]
} external;

function org_yaml_snakeyaml_Yaml_compose(handle receiver, handle arg0) returns handle = @java:Method {
    name: "compose",
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: ["java.io.Reader"]
} external;

function org_yaml_snakeyaml_Yaml_composeAll(handle receiver, handle arg0) returns handle = @java:Method {
    name: "composeAll",
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: ["java.io.Reader"]
} external;

function org_yaml_snakeyaml_Yaml_dump(handle receiver, handle arg0) returns handle = @java:Method {
    name: "dump",
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: ["java.lang.Object"]
} external;

function org_yaml_snakeyaml_Yaml_dump2(handle receiver, handle arg0, handle arg1) = @java:Method {
    name: "dump",
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: ["java.lang.Object", "java.io.Writer"]
} external;

function org_yaml_snakeyaml_Yaml_dumpAll(handle receiver, handle arg0) returns handle = @java:Method {
    name: "dumpAll",
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: ["java.util.Iterator"]
} external;

function org_yaml_snakeyaml_Yaml_dumpAll2(handle receiver, handle arg0, handle arg1) = @java:Method {
    name: "dumpAll",
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: ["java.util.Iterator", "java.io.Writer"]
} external;

function org_yaml_snakeyaml_Yaml_dumpAs(handle receiver, handle arg0, handle arg1, handle arg2) returns handle = @java:Method {
    name: "dumpAs",
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: ["java.lang.Object", "org.yaml.snakeyaml.nodes.Tag", "org.yaml.snakeyaml.DumperOptions$FlowStyle"]
} external;

function org_yaml_snakeyaml_Yaml_dumpAsMap(handle receiver, handle arg0) returns handle = @java:Method {
    name: "dumpAsMap",
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: ["java.lang.Object"]
} external;

function org_yaml_snakeyaml_Yaml_equals(handle receiver, handle arg0) returns boolean = @java:Method {
    name: "equals",
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: ["java.lang.Object"]
} external;

function org_yaml_snakeyaml_Yaml_getClass(handle receiver) returns handle = @java:Method {
    name: "getClass",
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: []
} external;

function org_yaml_snakeyaml_Yaml_getName(handle receiver) returns handle = @java:Method {
    name: "getName",
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: []
} external;

function org_yaml_snakeyaml_Yaml_hashCode(handle receiver) returns int = @java:Method {
    name: "hashCode",
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: []
} external;

function org_yaml_snakeyaml_Yaml_load(handle receiver, handle arg0) returns handle = @java:Method {
    name: "load",
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: ["java.io.InputStream"]
} external;

function org_yaml_snakeyaml_Yaml_load2(handle receiver, handle arg0) returns handle = @java:Method {
    name: "load",
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: ["java.io.Reader"]
} external;

function org_yaml_snakeyaml_Yaml_load3(handle receiver, handle arg0) returns handle = @java:Method {
    name: "load",
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: ["java.lang.String"]
} external;

function org_yaml_snakeyaml_Yaml_loadAll(handle receiver, handle arg0) returns handle = @java:Method {
    name: "loadAll",
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: ["java.io.InputStream"]
} external;

function org_yaml_snakeyaml_Yaml_loadAll2(handle receiver, handle arg0) returns handle = @java:Method {
    name: "loadAll",
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: ["java.io.Reader"]
} external;

function org_yaml_snakeyaml_Yaml_loadAll3(handle receiver, handle arg0) returns handle = @java:Method {
    name: "loadAll",
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: ["java.lang.String"]
} external;

function org_yaml_snakeyaml_Yaml_loadAs(handle receiver, handle arg0, handle arg1) returns handle = @java:Method {
    name: "loadAs",
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: ["java.io.InputStream", "java.lang.Class"]
} external;

function org_yaml_snakeyaml_Yaml_loadAs2(handle receiver, handle arg0, handle arg1) returns handle = @java:Method {
    name: "loadAs",
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: ["java.io.Reader", "java.lang.Class"]
} external;

function org_yaml_snakeyaml_Yaml_loadAs3(handle receiver, handle arg0, handle arg1) returns handle = @java:Method {
    name: "loadAs",
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: ["java.lang.String", "java.lang.Class"]
} external;

function org_yaml_snakeyaml_Yaml_notify(handle receiver) = @java:Method {
    name: "notify",
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: []
} external;

function org_yaml_snakeyaml_Yaml_notifyAll(handle receiver) = @java:Method {
    name: "notifyAll",
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: []
} external;

function org_yaml_snakeyaml_Yaml_parse(handle receiver, handle arg0) returns handle = @java:Method {
    name: "parse",
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: ["java.io.Reader"]
} external;

function org_yaml_snakeyaml_Yaml_represent(handle receiver, handle arg0) returns handle = @java:Method {
    name: "represent",
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: ["java.lang.Object"]
} external;

function org_yaml_snakeyaml_Yaml_serialize(handle receiver, handle arg0) returns handle = @java:Method {
    name: "serialize",
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: ["org.yaml.snakeyaml.nodes.Node"]
} external;

function org_yaml_snakeyaml_Yaml_setBeanAccess(handle receiver, handle arg0) = @java:Method {
    name: "setBeanAccess",
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: ["org.yaml.snakeyaml.introspector.BeanAccess"]
} external;

function org_yaml_snakeyaml_Yaml_setName(handle receiver, handle arg0) = @java:Method {
    name: "setName",
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: ["java.lang.String"]
} external;

function org_yaml_snakeyaml_Yaml_wait(handle receiver) returns error? = @java:Method {
    name: "wait",
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: []
} external;

function org_yaml_snakeyaml_Yaml_wait2(handle receiver, int arg0) returns error? = @java:Method {
    name: "wait",
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: ["long"]
} external;

function org_yaml_snakeyaml_Yaml_wait3(handle receiver, int arg0, int arg1) returns error? = @java:Method {
    name: "wait",
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: ["long", "int"]
} external;

function org_yaml_snakeyaml_Yaml_newYaml1() returns handle = @java:Constructor {
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: []
} external;

function org_yaml_snakeyaml_Yaml_newYaml2(handle arg0) returns handle = @java:Constructor {
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: ["org.yaml.snakeyaml.constructor.BaseConstructor"]
} external;

function org_yaml_snakeyaml_Yaml_newYaml3(handle arg0, handle arg1) returns handle = @java:Constructor {
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: ["org.yaml.snakeyaml.constructor.BaseConstructor", "org.yaml.snakeyaml.representer.Representer"]
} external;

function org_yaml_snakeyaml_Yaml_newYaml4(handle arg0, handle arg1, handle arg2) returns handle = @java:Constructor {
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: ["org.yaml.snakeyaml.constructor.BaseConstructor", "org.yaml.snakeyaml.representer.Representer", "org.yaml.snakeyaml.DumperOptions"]
} external;

function org_yaml_snakeyaml_Yaml_newYaml5(handle arg0, handle arg1, handle arg2, handle arg3) returns handle = @java:Constructor {
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: ["org.yaml.snakeyaml.constructor.BaseConstructor", "org.yaml.snakeyaml.representer.Representer", "org.yaml.snakeyaml.DumperOptions", "org.yaml.snakeyaml.LoaderOptions"]
} external;

function org_yaml_snakeyaml_Yaml_newYaml6(handle arg0, handle arg1, handle arg2, handle arg3, handle arg4) returns handle = @java:Constructor {
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: ["org.yaml.snakeyaml.constructor.BaseConstructor", "org.yaml.snakeyaml.representer.Representer", "org.yaml.snakeyaml.DumperOptions", "org.yaml.snakeyaml.LoaderOptions", "org.yaml.snakeyaml.resolver.Resolver"]
} external;

function org_yaml_snakeyaml_Yaml_newYaml7(handle arg0, handle arg1, handle arg2, handle arg3) returns handle = @java:Constructor {
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: ["org.yaml.snakeyaml.constructor.BaseConstructor", "org.yaml.snakeyaml.representer.Representer", "org.yaml.snakeyaml.DumperOptions", "org.yaml.snakeyaml.resolver.Resolver"]
} external;

function org_yaml_snakeyaml_Yaml_newYaml8(handle arg0) returns handle = @java:Constructor {
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: ["org.yaml.snakeyaml.DumperOptions"]
} external;

function org_yaml_snakeyaml_Yaml_newYaml9(handle arg0) returns handle = @java:Constructor {
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: ["org.yaml.snakeyaml.LoaderOptions"]
} external;

function org_yaml_snakeyaml_Yaml_newYaml10(handle arg0) returns handle = @java:Constructor {
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: ["org.yaml.snakeyaml.representer.Representer"]
} external;

function org_yaml_snakeyaml_Yaml_newYaml11(handle arg0, handle arg1) returns handle = @java:Constructor {
    'class: "org.yaml.snakeyaml.Yaml",
    paramTypes: ["org.yaml.snakeyaml.representer.Representer", "org.yaml.snakeyaml.DumperOptions"]
} external;

