package text;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.Transformer;
import utils.StringSerializer;

@EnableBinding(TextProcessor.class)
public class TextTransformer {

    @Transformer(inputChannel = TextProcessor.INPUT, outputChannel = TextProcessor.OUTPUT)
    public Object transform(byte[] textInBytes) {

        String text = StringSerializer.serialize(textInBytes);

        return countWords(text) + " words";
    }

    private int countWords(String text) {
        String trim = text.trim();
        if (trim.isEmpty())
            return 0;
        return trim.split(" ").length;
    }

}
