/*
 * gs-messaging-stomp-websocket 1.0 5 de jul de 2017
 *
 * Copyright (c) 2017, Focusnetworks. All rights reserved. Focusnetworks
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.poc.flyembraer.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import br.com.poc.flyembraer.applicationlayer.FileWebsocketApplicationLayer;
import br.com.poc.flyembraer.websocket.wrapper.FileChangeNameWrapper;

/**
 * 
 * 
 * @author João Batista
 * @version 1.0 5 de jul de 2017
 */
@Controller
public class WebsocketController {
	
	private final FileWebsocketApplicationLayer fileWebsocketApplicationLayer;
	
	@Autowired
	public WebsocketController(FileWebsocketApplicationLayer fileWebsocketApplicationLayer) {
		super();
		this.fileWebsocketApplicationLayer = fileWebsocketApplicationLayer;
	}

	@MessageMapping("/hello")
    @SendTo("/change-file")
    public FileChangeNameWrapper renameFile(final FileChangeName fileChangeName) throws Exception {
        return new FileChangeNameWrapper(fileWebsocketApplicationLayer.rename(fileChangeName));
    }
}
