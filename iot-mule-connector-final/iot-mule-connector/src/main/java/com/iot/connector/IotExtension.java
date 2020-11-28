package com.iot.connector;

import org.mule.runtime.extension.api.annotation.Configurations;
import org.mule.runtime.extension.api.annotation.Extension;
import org.mule.runtime.extension.api.annotation.dsl.xml.Xml;
@Xml(prefix = "iot")
@Extension(name = "IOT")
@Configurations(IotConfiguration.class)

public class IotExtension {

}
