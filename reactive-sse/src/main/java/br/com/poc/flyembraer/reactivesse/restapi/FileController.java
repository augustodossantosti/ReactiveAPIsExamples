/*
 * @(#)FileController.java 1.0 27/06/2017
 *
 * Copyright (c) 2017, Embraer. All rights reserved.
 * Embraer S/A proprietary/confidential. Use is subject to license terms.
 */

package br.com.poc.flyembraer.reactivesse.restapi;

import br.com.poc.flyembraer.reactivesse.file.FileApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;
import java.util.Date;

/**
 * A classe <code>FileController</code> e responsavel por receber
 * requisicoes referentes aos recursos de arquivos da aplicacao.
 *
 * @author Daniel Silveira
 * @version 1.0 27/06/2017
 */
@CrossOrigin(origins = "http://localhost:8888")
@RestController
public class FileController {

	private FileApplicationService fileApplicationService;

	@GetMapping(value = "/files", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<String> openFileStream() {
		return fileApplicationService.openFileStream();
	}

	@GetMapping(value = "/events/{id}")
	public Mono<Event> eventById(@PathVariable final int id) {
		return Mono.just(new Event(this, id, new Date()));
	}

	@Autowired
	public void setFileApplicationService(final FileApplicationService fileApplicationService) {
		this.fileApplicationService = fileApplicationService;
	}


}
