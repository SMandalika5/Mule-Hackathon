package com.iot.connector;

import java.util.Map;

import org.mule.runtime.api.meta.ExpressionSupport;
import org.mule.runtime.extension.api.annotation.Expression;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;

public class IotParameters {
	
	@Parameter
	private String payload;
	@Parameter
	
	@Optional(defaultValue = "iot_data")
	private String topic;
	
	@Parameter
	@Expression(ExpressionSupport.SUPPORTED)
	private String condition;
	
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	@Parameter
	@Expression(ExpressionSupport.SUPPORTED)
	@Optional(defaultValue = "#[{}]")
	private Map<String,String> additionalData;
	
	
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}
	public String getPayload() {
		return payload;
	}
	
	public Map<String, String> getAdditionalData() {
		return additionalData;
	}
	public void setAdditionalData(Map<String, String> additionalData) {
		this.additionalData = additionalData;
	}


}
