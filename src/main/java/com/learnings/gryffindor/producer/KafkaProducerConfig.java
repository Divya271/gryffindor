package com.learnings.gryffindor.producer;

import com.learnings.gryffindor.utils.PropertiesUtil;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    private final PropertiesUtil propertiesUtil;
    public KafkaProducerConfig(PropertiesUtil propertiesUtil) {
        this.propertiesUtil = propertiesUtil;
    }

    private ProducerFactory<String, String> testProducerConfig() {
        Map<String, Object> configMap = new HashMap<>();
        configMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, propertiesUtil.kafkaServer);
        configMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(configMap);
    }

    @Bean("testKafkaTemplate")
    public KafkaTemplate<String, String> testKafkaTemplate() {
        return new KafkaTemplate<>(testProducerConfig());
    }
}
