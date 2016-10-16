package text;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface TextSync {

    String INPUT = "TextLinesTopic";

    @Input(TextSync.INPUT)
    SubscribableChannel textLines();
}
