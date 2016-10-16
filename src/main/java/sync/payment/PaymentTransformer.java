package sync.payment;

import jdk.nashorn.internal.scripts.JO;
import org.json.JSONObject;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.Transformer;
import text.TextProcessor;
import utils.StringSerializer;

@EnableBinding(PaymentProcessor.class)
public class PaymentTransformer {

    @Transformer(inputChannel = PaymentProcessor.INPUT, outputChannel = PaymentProcessor.OUTPUT)
    public Object transform(byte[] textInBytes) {

        JSONObject paymentJson = new JSONObject(StringSerializer.serialize(textInBytes));

        return toScheduling(paymentJson);
    }

    private String toScheduling(JSONObject paymentJson) {
        JSONObject payloadJson = paymentJson.getJSONObject("payload");
        JSONObject afterJson = payloadJson.getJSONObject("after");
        JSONObject schedulingJson = new JSONObject();
        schedulingJson.put("type", 4);
        schedulingJson.put("amount", afterJson.getInt("payment_report_id"));
        return schedulingJson.toString();
    }
}
