package text;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by william on 10/4/16.
 */
public interface TextSync {

    String INPUT = "TextLinesTopic";

    @Input(TextSync.INPUT)
    SubscribableChannel textLines();
}
