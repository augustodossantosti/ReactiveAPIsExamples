/*
 * gs-messaging-stomp-websocket 1.0 5 de jul de 2017
 *
 * Copyright (c) 2017, Focusnetworks. All rights reserved. Focusnetworks
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.poc.flyembraer.applicationlayer;

import org.springframework.stereotype.Component;

import br.com.poc.flyembraer.domain.FileWebsocket;
import br.com.poc.flyembraer.websocket.FileChangeName;

/**
 * 
 * 
 * @author João Batista
 * @version 1.0 5 de jul de 2017
 */
@Component
public class FileWebsocketApplicationLayer {
	
	private final FileWebsocket fileWebsocket;
	
	public FileWebsocketApplicationLayer() {
		super();
		this.fileWebsocket = new FileWebsocket();
	}

	public FileChangeName rename(final FileChangeName fileChangeName) throws Exception {
		return fileWebsocket.renameFile(fileChangeName);
	}

}
