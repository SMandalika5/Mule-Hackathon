package com.iot.connector;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;


import org.mule.runtime.extension.api.annotation.Alias;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.ParameterGroup;


public class IotOperations {


	@MediaType(value = ANY, strict =false)
	@Alias("command")
	public void giveCommand(@Connection IotConnection c, @ParameterGroup(name= "customparams") IotParameters p) {
		
		System.out.println("Start here-----");
		UtilityClass u=new UtilityClass();
		String messageString=p.getPayload();
		String topic=p.getTopic();
		
		System.out.println("Call subscriber-----");
		u.subscribe(c, topic);
		System.out.println("Call publisher-----");
		u.publish(c, messageString, topic);
		/*MqttClient connection = null;
		try {
			System.out.println("Hello this is subscriber");
			connection=c.getConnection();
			System.out.println("Sending a get request....");
			connection.setCallback(new MqttPayloadExtract());
			//connection.connect();
			connection.subscribe(p.getTopic());
			//response = new MqttPayloadExtract().getResponsePayload();
			//setPayload_data(response);
			System.out.println("Response received.");
		}
		catch(Exception e) {
			System.out.println("Error occured");
			e.printStackTrace();
		}
		
		
MqttClient connection1 = null;
String messageString = p.getPayload();

		try {
			System.out.println("Hello this is subscriber");
			connection1=c.getConnection();
			//connection.connect();
			MqttMessage message = new MqttMessage();
			message.setPayload(messageString.getBytes());
			connection1.publish(p.getPayload(), message);
			System.out.println("\tMessage '" + messageString + "' to 'iot_data'");
			connection1.disconnect();
			System.out.println("== END PUBLISHER ==");
			connection1.close();
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
	}
		

	
			

}
