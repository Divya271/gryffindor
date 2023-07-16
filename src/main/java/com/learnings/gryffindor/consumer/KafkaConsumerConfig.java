package com.learnings.gryffindor.consumer;

import com.learnings.gryffindor.utils.PropertiesUtil;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {

    private final PropertiesUtil propertiesUtil;

    public KafkaConsumerConfig(PropertiesUtil propertiesUtil) {
        this.propertiesUtil = propertiesUtil;
    }

    private ConsumerFactory<String, String> testConsumerConfig() {
        Map<String, Object> consumerConfig = new HashMap<>();
        consumerConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, propertiesUtil.kafkaServer);
        consumerConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        consumerConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        consumerConfig.put(ConsumerConfig.GROUP_ID_CONFIG, "testGroup");
        return new DefaultKafkaConsumerFactory<>(consumerConfig);
    }

    @Bean("testConsumerConfig")
    public ConcurrentKafkaListenerContainerFactory<String, String> testKafkaConsumer() {
        ConcurrentKafkaListenerContainerFactory<String, String> consumerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
        consumerContainerFactory.setConcurrency(10);
        consumerContainerFactory.setConsumerFactory(testConsumerConfig());
        return consumerContainerFactory;
    }
}
