package text;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.Transformer;

@EnableBinding(TextProcessor.class)
public class TextTransformer {

    @Transformer(inputChannel = TextProcessor.INPUT, outputChannel = TextProcessor.OUTPUT)
    public Object transform(String text) {

        text = convert(text);

        return countWords(text) + " words";
    }

    private String convert(String text) {
        if (text.isEmpty())
            return "";
        String result = "";
        for (String letter : text.split(",")) {
            result += (char) Integer.parseInt(letter, 10);
        }
        return result;
    }

    private int countWords(String text) {
        String trim = text.trim();
        if (trim.isEmpty())
            return 0;
        return trim.split(" ").length;
    }

}
