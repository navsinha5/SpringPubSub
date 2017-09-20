package com.spring.mqtt.springPubSub.mqttClient;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class PubSubClient {

	private static String topicLed = "LedSwitch";
	private static int qos = 0;
	private static String broker = "tcp://localhost:1883";
	private static String clientId = "localhost";

	public void publish(String content) {

		try {
			MqttClient client = new MqttClient(broker, clientId);

			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true);
			System.out.println("Connecting to broker: " + broker);

			client.connect(connOpts);
			System.out.println("Connected");

			System.out.println("Publishing message: " + content);
			MqttMessage message = new MqttMessage(content.getBytes());
			message.setQos(qos);
			client.publish(topicLed, message);
			System.out.println("Message published");

			client.disconnect();
			System.out.println("Disconnected");
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
