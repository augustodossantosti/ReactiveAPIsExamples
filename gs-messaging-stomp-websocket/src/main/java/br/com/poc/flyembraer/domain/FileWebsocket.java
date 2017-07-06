/*
 * gs-messaging-stomp-websocket 1.0 5 de jul de 2017
 *
 * Copyright (c) 2017, Focusnetworks. All rights reserved. Focusnetworks
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.poc.flyembraer.domain;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import br.com.poc.flyembraer.websocket.FileChangeName;

/**
 * 
 * 
 * @author João Batista
 * @version 1.0 5 de jul de 2017
 */
public class FileWebsocket implements FileRename<FileChangeName, FileChangeName> {
	
	@Override
	public FileChangeName renameFile(final FileChangeName fileChangeName) throws Exception {
		if (hasFile(fileChangeName.getName())) {
			
			Files.list(Paths.get("/home/focusnetworks/Imagens/in"))
					.filter(Files::isRegularFile)
					.map(Path::toFile)
					.filter(fileName -> fileName.getName().equals(fileChangeName.getName()))
					.findFirst()
					.map(file -> file.renameTo(new File("/home/focusnetworks/Imagens/in/" + fileChangeName.getRename())));
			return fileChangeName;
		}
		throw new Exception("File not exists");
	}
	
	public Boolean hasFile(final String nameFile) {
		return Files.exists(Paths.get("/home/focusnetworks/Imagens/in" + nameFile));
	}
}
