/*
 * gs-messaging-stomp-websocket 1.0 6 de jul de 2017
 *
 * Copyright (c) 2017, Focusnetworks. All rights reserved. Focusnetworks
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.poc.flyembraer.websocket.wrapper;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.poc.flyembraer.websocket.FileChangeName;
import br.com.poc.flyembraer.websocket.serialize.FileChangeNameSerialize;

/**
 * 
 * 
 * @author João Batista
 * @version 1.0 6 de jul de 2017
 */
@JsonSerialize(using = FileChangeNameSerialize.class)
public class FileChangeNameWrapper {
	
	private final FileChangeName fileChangeName;

	public FileChangeNameWrapper(final FileChangeName fileChangeName) {
		super();
		this.fileChangeName = fileChangeName;
	}

	public FileChangeName getFileChangeName() {
		return fileChangeName;
	}
}
