package text;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.Transformer;

import java.io.UnsupportedEncodingException;

@EnableBinding(TextProcessor.class)
public class TextTransformer {

    @Transformer(inputChannel = TextProcessor.INPUT, outputChannel = TextProcessor.OUTPUT)
    public Object transform(byte[] textInBytes) {

        String text = serialize(textInBytes);

        return countWords(text) + " words";
    }

    private String serialize(byte[] textInBytes) {
        try {
            return new String(textInBytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    private int countWords(String text) {
        String trim = text.trim();
        if (trim.isEmpty())
            return 0;
        return trim.split(" ").length;
    }

}
