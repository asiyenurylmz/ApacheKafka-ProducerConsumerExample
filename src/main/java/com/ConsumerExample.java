package com;



import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class ConsumerExample {
	public static void main(String[] args) {
		String topicName = "new";
		
		
		Properties configPro= new Properties();
		configPro.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		configPro.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
		configPro.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
		
		
		configPro.put(ConsumerConfig.GROUP_ID_CONFIG, "bigData2");
		configPro.put(ConsumerConfig.CLIENT_ID_CONFIG, "exam2");
		
		KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(configPro);
	
		kafkaConsumer.subscribe(Arrays.asList(topicName)); //topic i dinleyebilmek için abone oluyoruz //birden fazla topic i dinleyebilmek için argüman olarak array vermeliyiz
		
		try {
		while(true) {
			ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
			for(ConsumerRecord<String, String> record : records)
				System.out.println(record.value());
		}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		kafkaConsumer.close();
	}
}
