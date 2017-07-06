/*
 * @(#)SpringContextConfiguration.java 1.0 27/06/2017
 *
 * Copyright (c) 2017, Embraer. All rights reserved.
 * Embraer S/A proprietary/confidential. Use is subject to license terms.
 */

package br.com.poc.flyembraer.reactivesse.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * A classe {@link SpringContextConfiguration} define as configuracoes do
 * Contexto do Spring da aplicacao, com a colaboracao de classes de configuracao
 * auxiliares.
 *
 * @author Daniel Silveira
 * @version 1.0 27/06/2017
 */
@Configuration
@Import({ FileIntegrationBeans.class })
public class SpringContextConfiguration {

}
