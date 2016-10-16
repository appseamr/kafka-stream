package sync.payment;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface PaymentSync {

    String INPUT = "reports2.reports.history_sync";

    @Input(PaymentSync.INPUT)
    SubscribableChannel paymentV1();
}
