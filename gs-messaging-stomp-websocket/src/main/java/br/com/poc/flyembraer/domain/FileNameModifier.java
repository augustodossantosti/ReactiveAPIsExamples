/*
 * gs-messaging-stomp-websocket 1.0 5 de jul de 2017
 *
 * Copyright (c) 2017, Focusnetworks. All rights reserved. Focusnetworks
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.poc.flyembraer.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * A classe <code>FileNameModifier</code> e um Domain Service responsavel
 * por realizar a alteracao do nome do arquivo.
 * 
 * @author João Batista
 * @version 1.0 5 de jul de 2017
 */
@Service
public class FileNameModifier {

	private final String path;

	public FileNameModifier(@Value("${file.path}") final String path) {
		this.path = path;
	}

	public void renameFile(final String oldName, final String newName) throws Exception {
		if (hasFile(oldName)) {
			
			Files.list(Paths.get(path))
					.filter(Files::isRegularFile)
					.map(Path::toFile)
					.filter(fileName -> fileName.getName().equals(oldName))
					.findFirst()
					.map(file -> file.renameTo(new File(path + newName)));
		} else {
			throw new Exception("File not exists");
		}

	}
	
	private Boolean hasFile(final String nameFile) {
		return Files.exists(Paths.get(path + nameFile));
	}
}
