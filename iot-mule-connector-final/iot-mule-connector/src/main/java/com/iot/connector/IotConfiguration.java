package com.iot.connector;

import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.connectivity.ConnectionProviders;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;



@Operations(IotOperations.class)
@ConnectionProviders(IotConnectionProvider.class)
public class IotConfiguration {
	
	@Parameter
	private String protocol;
	@Parameter
	private String host;
	@Parameter
	@Optional
	private String basepath;
	
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getBasepath() {
		return basepath;
	}
	public void setBasepath(String basepath) {
		this.basepath = basepath;
	}	

}
