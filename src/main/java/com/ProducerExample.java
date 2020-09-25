package com;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

public class ProducerExample {
	
	public static void main(String[] args) {
		String topicName = "new";
		
		
		Properties configPro = new Properties();
		configPro.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		
		configPro.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.ByteArraySerializer");  
		configPro.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer"); 
		//iki kısımda; string verileri kafka'ya serialize şekilde gönderiyoruz
		
		Producer<String, String> producer = new KafkaProducer<String, String>(configPro); 
		
	//	ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName, "deneme");
		String[] array= {"canta", "cuzdan", "ayakkabi"};
		
		for(int i=0; i<array.length; i++) {
			ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName, array[i]);
			producer.send(rec);	
		}
		
		producer.close();
	}
	

}
