package com.learnings.gryffindor.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertiesUtil {

    @Value("${kafka.server}")
    public String kafkaServer;

    @Value("${kafka.topics.test_topic}")
    public String kafkaTestTopic;

}
