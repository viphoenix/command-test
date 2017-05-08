package com.chengfeng;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.Properties;
import java.util.Random;

/**
 * kafka性能
 * @author chengfeng on 2016/8/26.
 */
public class KafkaThread extends Thread {

    public KafkaThread() {
        super("KafkaThread");
    }

    public void run() {

        Properties props = new Properties();
        props.put("metadata.broker.list", "10.0.53.81:9092");
        props.put("serializer.class", "kafka.serializer.StringEncoder");
//        props.put("compression.codec", "1");

        ProducerConfig config = new ProducerConfig(props);
        final String[] topics = new String[]{"test-tk"};

        final String[] options = new String[]{"123", "456", "fjkdsaf", "142rfasdf", "2fiejwif", "jfaefji23", "23fadsoc"
                , "fdsafdsa24fwe243cdas", "jiadjfiwafj", "fhfrhfwh823r22owiofewiroavwaehfuaudfaw13", "28f3cwajf24djaewr923"};

        final Random random = new Random();

        final Producer<String, String> producer = new Producer<String, String>(config);
        int counter = 0;
        while (true){
            try {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < 10; i++) {
                    stringBuilder.append(options[random.nextInt(11)]).append("#########");
                }
                String msg = stringBuilder.toString();

                System.out.println(msg.getBytes().length);
                KeyedMessage<String, String> data = new KeyedMessage<String, String>(topics[(counter++) % topics.length], String.valueOf(System.currentTimeMillis()), msg);
                producer.send(data);
                System.out.println("kafka send success!");
            } catch (Exception e) {
            }
        }

    }
}
