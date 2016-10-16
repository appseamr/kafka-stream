package sync.payment;

import org.springframework.messaging.MessageChannel;
import org.springframework.cloud.stream.annotation.Output;

public interface PaymentSource {
    String OUTPUT = "payment.event";

    @Output(PaymentSource.OUTPUT)
    MessageChannel paymentEvent();
}