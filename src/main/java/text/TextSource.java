package text;

import org.springframework.messaging.MessageChannel;
import org.springframework.cloud.stream.annotation.Output;

public interface TextSource {
    String OUTPUT = "WordsWithCountsTopic";

    @Output(TextSource.OUTPUT)
    MessageChannel wordCount();
}
