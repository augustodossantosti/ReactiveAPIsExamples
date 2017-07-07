/*
 * gs-messaging-stomp-websocket 1.0 6 de jul de 2017
 *
 * Copyright (c) 2017, Focusnetworks. All rights reserved. Focusnetworks
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.poc.flyembraer.integration.websocket.wrapper;

import br.com.poc.flyembraer.integration.websocket.deserializer.FileChangeNameDeserializer;
import br.com.poc.flyembraer.integration.websocket.serializer.FileChangeNameSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 
 * 
 * @author João Batista
 * @version 1.0 6 de jul de 2017
 */
@JsonSerialize(using = FileChangeNameSerializer.class)
@JsonDeserialize(using = FileChangeNameDeserializer.class)
public class FileChangeNameWrapper {

	private final String oldName;
	private final String newName;


	public FileChangeNameWrapper(final String oldName, final String newName) {
		this.oldName = oldName;
		this.newName = newName;
	}

	public String getOldName() {
		return oldName;
	}

	public String getNewName() {
		return newName;
	}
}
