package com.iot.connector;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.mule.runtime.extension.api.annotation.param.Connection;


public class UtilityClass {
	
	public void subscribe(@Connection IotConnection c, String topic) {
		//String response = null;
		System.out.println("This is subscriber-----");
		MqttClient connection = null;
		try {
			connection=c.getConnection();
			System.out.println("Sending a get request....");
			connection.setCallback(new MqttPayloadExtract());
			//connection.connect();
			connection.subscribe(topic);
			connection.wait(1000);
			//response = new MqttPayloadExtract().getResponsePayload();
			//setPayload_data(response);
			System.out.println("Response received.");
		}
		catch(Exception e) {
			System.out.println("Error occured");
			e.printStackTrace();
		}
		//return response;
	}
	
	
	public void publish(@Connection IotConnection c, String messageString, String topic) {
		
		//String messageString = p.getPayload();
		System.out.println("This is publisher-----");
		MqttClient connection = null;
		

		try {
			connection=c.getConnection();
			//connection.connect();
			MqttMessage message = new MqttMessage();
			message.setPayload(messageString.getBytes());
			connection.publish(topic, message);
			System.out.println("\tMessage '" + messageString + "' to 'iot_data'");
			connection.disconnect();
			System.out.println("== END PUBLISHER ==");
			connection.close();
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
