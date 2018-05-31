/**
 * 
 */
package com.stackoverflow.demo.wrapper;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.stereotype.Component;

import com.stackoverflow.demo.bean.VisaResponse;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dharita.chokshi
 *
 */
@Component
public class JavaToXmlWrapper {

	private static final Logger LOGGER = LoggerFactory.getLogger(JavaToXmlWrapper.class);

	/**
	 * @param VisaResponse
	 * @return {@link String} object
	 */
	public String javaObjectToXML(VisaResponse visaResponse) {
		String xmlString = "";
		try {
			Marshaller marshaller = getJAXBMarshaller(visaResponse.getClass());
			StringWriter stringWriter = new StringWriter();
			marshaller.marshal(visaResponse, stringWriter);
			xmlString = stringWriter.toString();
		} catch (JAXBException e) {
			LOGGER.error(ExceptionUtils.getStackTrace(e));
		}
		return xmlString;
	}

	/**
	 * @param <T>
	 * @return {@link Marshaller} object
	 * @throws JAXBException
	 */
	private static <T> Marshaller getJAXBMarshaller(Class<T> classType) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(classType);
		Marshaller marshaller = context.createMarshaller();
		// for pretty-print XML in JAXB
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		return marshaller;
	}

}
