/*
 * gs-messaging-stomp-websocket 1.0 6 de jul de 2017
 *
 * Copyright (c) 2017, Focusnetworks. All rights reserved. Focusnetworks
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.poc.flyembraer.websocket.serialize;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.com.poc.flyembraer.websocket.wrapper.FileChangeNameWrapper;

/**
 * 
 * 
 * @author João Batista
 * @version 1.0 6 de jul de 2017
 */
public class FileChangeNameSerialize extends JsonSerializer<FileChangeNameWrapper> {

	@Override
	public void serialize(final FileChangeNameWrapper fileChangeNameWrapper, final JsonGenerator jsonGenerator, final SerializerProvider serializerProvider) throws IOException {
		jsonGenerator.writeStartObject();
		jsonGenerator.writeObjectFieldStart("content");
		jsonGenerator.writeStringField("name", fileChangeNameWrapper.getFileChangeName().getName());
		jsonGenerator.writeStringField("rename", fileChangeNameWrapper.getFileChangeName().getRename());
		jsonGenerator.writeEndObject();
		jsonGenerator.writeEndObject();	
	}
}
