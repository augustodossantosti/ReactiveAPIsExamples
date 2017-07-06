/*
 * @(#)FileApplicationService.java 1.0 30/06/2017
 *
 * Copyright (c) 2017, Embraer. All rights reserved.
 * Embraer S/A proprietary/confidential. Use is subject to license terms.
 */

package br.com.poc.flyembraer.reactivesse.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * A classe {@link FileApplicationService} contem metodos para fazer streaming
 * de Arquivos.
 *
 * @author Daniel Silveira
 * @version 1.0 30/06/2017
 */
@Service
public class FileApplicationService {

	private SubscribableChannel filesChannel;

	public Flux<String> openFileStream() {
		return Flux.create(eventSink -> {
			final MessageHandler handler = message -> eventSink.next((String)(message.getPayload()));
			eventSink.onCancel(() -> filesChannel.unsubscribe(handler));

			filesChannel.subscribe(handler);
		});
	}

	@Autowired
	public void setFilesChannel(final SubscribableChannel filesChannel) {
		this.filesChannel = filesChannel;
	}

}
