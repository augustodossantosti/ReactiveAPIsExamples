/*
 * @(#)LastModifiedFileFilter.java 1.0 28/06/2017
 *
 * Copyright (c) 2017, Embraer. All rights reserved.
 * Embraer S/A proprietary/confidential. Use is subject to license terms.
 */

package br.com.poc.flyembraer.reactivesse.file;

import org.springframework.integration.file.filters.AbstractFileListFilter;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * A classe {@link LastModifiedFileFilter} e responsavel por identificar modificacoes
 * nos arquivos.
 *
 * @author Daniel Silveira
 * @version 1.0 28/06/2017
 */
public class LastModifiedFileFilter extends AbstractFileListFilter<File> {

	private final Map<String, Long> filesModification = new HashMap<>();
	private final Object monitor = new Object();

	@Override
	public boolean accept(final File file) {
		synchronized (this.monitor) {
			final Long previousModifiedTime = filesModification.put(file.getName(), file.lastModified());
			return previousModifiedTime == null || previousModifiedTime != file.lastModified();
		}
	}
}
