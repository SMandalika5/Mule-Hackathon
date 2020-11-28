package com.iot.connector;


import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;




public class IotConnection {
	
	MqttClient  con = null;
	IotConfiguration c=null;
	
	//private static final Logger LOGGER = LoggerFactory.getLogger(IotConnection.class);
	
	public IotConnection(IotConfiguration c) {
		this.c=c;
		
	}
	
	public MqttClient createConnection(String protocol, String host, String basepath) {
		MqttClient connection = null;
		//tcp://test.mosquitto.org:1883
	   
	    System.out.println("Creating connection "+ protocol + host );
	    try {
	    	//tcp://test.mosquitto.org:1883
	    	connection = new MqttClient(protocol + host, MqttClient.generateClientId());
	    	//connection.setCallback(new SimpleMqttCallBack());
	    	connection.connect();
	    	//connection.subscribe("iot_data");
			//System.out.println("== STARTED SUBSCRIBER ==");			
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return (MqttClient)connection;
	}
	
	public MqttClient getConnection() {
		this.con = createConnection(c.getProtocol(), c.getHost(), c.getBasepath());
		System.out.println("Connection Requested in getConnection()");
		return this.con;
	}
	
	public void invalidate() {
		if(this.con != null) {
			
				System.out.println("Invalidating MQTT Connection");
				try {
					((MqttClient) con).disconnect();
				} catch (MqttException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
			
			}
			
				
		
	}

}
