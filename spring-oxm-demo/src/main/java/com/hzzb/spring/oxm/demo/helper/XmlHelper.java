package com.hzzb.spring.oxm.demo.helper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;
import org.springframework.stereotype.Component;

@Component
public class XmlHelper {
	
	@Autowired
	private Marshaller marshaller;
	
	@Autowired
	private Unmarshaller unmarshaller;
	
	public String objToXml(Object obj) {
		StringWriter writer = new StringWriter();
		try {
			marshaller.marshal(obj, new StreamResult(writer));
		} catch (XmlMappingException | IOException e) {
			e.printStackTrace();
		}
		return writer.toString();
	}
	
	@SuppressWarnings("unchecked")
	public <T> T xmlToObj(String xml) {
		T t = null;
		try {
			t = (T) unmarshaller.unmarshal(new StreamSource(new StringReader(xml)));
		} catch (XmlMappingException | IOException e) {
			e.printStackTrace();
		}
		return t;
	}
	
}
