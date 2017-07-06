/*
 * gs-messaging-stomp-websocket 1.0 5 de jul de 2017
 *
 * Copyright (c) 2017, Focusnetworks. All rights reserved. Focusnetworks
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.poc.flyembraer.domain;

/**
 * 
 * 
 * @author João Batista
 * @version 1.0 5 de jul de 2017
 */
@FunctionalInterface
public interface FileRename<S, T> {
	
	public S renameFile(T t) throws Exception;	
}
