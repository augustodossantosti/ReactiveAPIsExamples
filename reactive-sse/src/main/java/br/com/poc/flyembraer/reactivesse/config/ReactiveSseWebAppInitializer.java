/*
 * @(#)ReactiveSseWebAppInitializer.java 1.0 27/06/2017
 *
 * Copyright (c) 2017, Embraer. All rights reserved.
 * Embraer S/A proprietary/confidential. Use is subject to license terms.
 */

package br.com.poc.flyembraer.reactivesse.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * A classe {@link ReactiveSseWebAppInitializer} e a classe responsavel pela
 * inicializacao do sistema.
 *
 * @author Daniel Silveira
 * @version 1.0 27/06/2017
 */
@Import({ SpringContextConfiguration.class })
@ComponentScan(basePackages = { "br.com.poc.flyembraer.reactivesse" })
@SpringBootApplication
public class ReactiveSseWebAppInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveSseWebAppInitializer.class, args);
	}
}
