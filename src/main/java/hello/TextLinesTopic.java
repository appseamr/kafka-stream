package hello;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KStreamBuilder;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

@EnableBinding(Processor.class)
public class TextLinesTopic {

    @ServiceActivator(inputChannel = "TextLinesTopic", outputChannel = "WordsWithCountsTopic")
    public String transform(Object payload) {

        String text = (String) payload;
        String countMsg = "";

        Pattern pattern = Pattern.compile("\\W+", Pattern.UNICODE_CHARACTER_CLASS);
        List<String> tokens = Arrays.asList(pattern.split(text.toLowerCase()));

        for (String token: tokens) {
            countMsg += token + "|";
        }

        System.out.print("Transformeeeeeeeer");

        return countMsg;
    }
}
