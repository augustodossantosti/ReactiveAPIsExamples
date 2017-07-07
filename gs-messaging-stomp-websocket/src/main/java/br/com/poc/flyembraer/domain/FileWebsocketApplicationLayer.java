/*
 * gs-messaging-stomp-websocket 1.0 5 de jul de 2017
 *
 * Copyright (c) 2017, Focusnetworks. All rights reserved. Focusnetworks
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.poc.flyembraer.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * A classe <code>FileWebsocketApplicationLayer</code> contem metodos de
 * servicos referentes a arquivos.
 * 
 * @author João Batista
 * @version 1.0 5 de jul de 2017
 */
@Component
public class FileWebsocketApplicationLayer {
	
	private final FileNameModifier fileNameModifier;
	
	@Autowired
	public FileWebsocketApplicationLayer(final FileNameModifier fileNameModifier) {
		this.fileNameModifier = fileNameModifier;
	}

	public void rename(final String oldName, final String newName) throws Exception {
		fileNameModifier.renameFile(oldName, newName);
	}

}
