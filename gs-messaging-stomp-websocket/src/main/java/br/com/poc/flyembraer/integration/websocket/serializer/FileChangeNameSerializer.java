/*
 * gs-messaging-stomp-websocket 1.0 6 de jul de 2017
 *
 * Copyright (c) 2017, Focusnetworks. All rights reserved. Focusnetworks
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.poc.flyembraer.integration.websocket.serializer;

import br.com.poc.flyembraer.integration.websocket.wrapper.FileChangeNameWrapper;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * A classe {@link FileChangeNameSerializer} e responsavel por serializar as
 * os dados de modificacao de arquivos.
 * 
 * @author João Batista
 * @version 1.0 6 de jul de 2017
 */
public class FileChangeNameSerializer extends JsonSerializer<FileChangeNameWrapper> {

	@Override
	public void serialize(final FileChangeNameWrapper fileChangeNameWrapper, final JsonGenerator jsonGenerator, final SerializerProvider serializerProvider) throws IOException {
		jsonGenerator.writeStartObject();
		jsonGenerator.writeObjectFieldStart("content");
		jsonGenerator.writeStringField("oldName", fileChangeNameWrapper.getOldName());
		jsonGenerator.writeStringField("newName", fileChangeNameWrapper.getNewName());
		jsonGenerator.writeEndObject();
		jsonGenerator.writeEndObject();	
	}
}
