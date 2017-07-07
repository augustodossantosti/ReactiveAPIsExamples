/*
 * @(#)ServerEventsBeans.java 1.0 27/06/2017
 *
 * Copyright (c) 2017, Embraer. All rights reserved.
 * Embraer S/A proprietary/confidential. Use is subject to license terms.
 */

package br.com.poc.flyembraer.config;

import br.com.poc.flyembraer.domain.LastModifiedFileFilter;
import br.com.poc.flyembraer.integration.websocket.transformer.FileTransformer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.channel.MessageChannels;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.filters.CompositeFileListFilter;
import org.springframework.integration.file.filters.SimplePatternFileListFilter;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.SubscribableChannel;

import java.io.File;

/**
 * A classe {@link FileIntegrationBeans} define as configuracoes dos beans responsaveis
 * por fazer integracao com arquivos.
 *
 * @author Daniel Silveira
 * @author Roberto Perillo
 * @author Joao Batista
 * @version 2.0 27/06/2017
 */
@Configuration
public class FileIntegrationBeans {

	@Bean
	public SubscribableChannel filesChannel() {
		return MessageChannels.publishSubscribe().get();
	}

	@Bean
	@InboundChannelAdapter(value = "fileInputChannel", poller = @Poller(fixedRate = "1000"))
	public MessageSource<File> fileReadingMessageSource(@Value("${input-dir:file://${HOME}/Imagens/in}") final File in,
			@Qualifier("lastModifiedFileFilter") final LastModifiedFileFilter lastModifiedFileFilter) {
		final CompositeFileListFilter<File> filters = new CompositeFileListFilter<>();
		filters.addFilter(new SimplePatternFileListFilter("*.txt"));
		filters.addFilter(lastModifiedFileFilter);
		
		final FileReadingMessageSource source = new FileReadingMessageSource();
		source.setAutoCreateDirectory(true);
		source.setDirectory(in);
		source.setFilter(filters);

		return source;
	}

	@Bean
	public IntegrationFlow integrationFlow(@Qualifier("filesChannel") final SubscribableChannel filesChannel,
			@Qualifier("fileTransformer") final FileTransformer fileTransformer,
			@Qualifier("webSocketHandler") final MessageHandler handler) {
		return IntegrationFlows
				.from("fileInputChannel")
				.transform(fileTransformer)
				.channel(filesChannel).handle(handler)
				.get();
	}
}