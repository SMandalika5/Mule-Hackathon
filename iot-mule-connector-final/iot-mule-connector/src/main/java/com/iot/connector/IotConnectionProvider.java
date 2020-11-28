package com.iot.connector;


import org.eclipse.paho.client.mqttv3.MqttClient;



import org.mule.runtime.api.connection.ConnectionProvider;


import org.mule.runtime.api.connection.ConnectionException;
import org.mule.runtime.api.connection.ConnectionValidationResult;
import org.mule.runtime.extension.api.annotation.param.ParameterGroup;

public class IotConnectionProvider implements ConnectionProvider<IotConnection> {
	@ParameterGroup(name="Connection")
	IotConfiguration customConfig;
	//private static final Logger LOGGER = LoggerFactory.getLogger(IotConnectionProvider.class);
	@Override
	public IotConnection connect() throws ConnectionException {
		// TODO Auto-generated method stub
		System.out.println("Initializing connection");
		return new IotConnection(customConfig);
	}

	@Override
	public void disconnect(IotConnection connection) {
		// TODO Auto-generated method stub
		System.out.println("Destrioying the Connection");
		connection.invalidate();
		
	}

	@Override
	public ConnectionValidationResult validate(IotConnection connection) {
		// TODO Auto-generated method stub
		
		MqttClient con = connection.getConnection();
		ConnectionValidationResult result = null;
		
			System.out.println("Invalidating Matt Connection");
			result = (((MqttClient)con).isConnected()) ? ConnectionValidationResult.success() : ConnectionValidationResult.failure("HTTPS Test Failed", new Exception());
			System.out.println("Invalidated Mqtt Connection");
		
		return result;
	}

	

}
