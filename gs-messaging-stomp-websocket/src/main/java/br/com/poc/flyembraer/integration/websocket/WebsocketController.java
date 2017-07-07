/*
 * gs-messaging-stomp-websocket 1.0 5 de jul de 2017
 *
 * Copyright (c) 2017, Focusnetworks. All rights reserved. Focusnetworks
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.poc.flyembraer.integration.websocket;

import br.com.poc.flyembraer.domain.FileWebsocketApplicationLayer;
import br.com.poc.flyembraer.integration.websocket.wrapper.FileChangeNameWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

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
		this.fileWebsocketApplicationLayer = fileWebsocketApplicationLayer;
	}

	@MessageMapping("/hello")
    @SendTo("/change-file")
    public FileChangeNameWrapper renameFile(final FileChangeNameWrapper fileChangeName) throws Exception {
		fileWebsocketApplicationLayer.rename(fileChangeName.getOldName(), fileChangeName.getNewName());
        return new FileChangeNameWrapper(fileChangeName.getOldName(), fileChangeName.getNewName());
    }

}
