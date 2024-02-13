package org.MessageContext;

import io.ballerina.runtime.api.values.BObject;
import org.apache.synapse.MessageContext;
import org.apache.synapse.mediators.AbstractMediator;

public class SampleMediator  extends AbstractMediator {

        public boolean mediate(MessageContext context) {
//            String a = "hello";
//            Set s = context.getPropertyKeySet();
            return true;
        }

        public static BObject getEnvelope1() {

//            BMessageContext bMessageContext = new BMessageContext();
            return null;
        }
}
