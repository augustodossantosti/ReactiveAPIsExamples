package br.com.poc.flyembraer.reactivesse.file;

import org.springframework.integration.file.transformer.AbstractFilePayloadTransformer;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A classe {@link SseFileTransformer} realiza a leitura do conteudo do arquivo
 * e retorno suas informacoes.
 *
 * @author Daniel Silveira
 * @version 1.0 28/06/2017
 */
public class SseFileTransformer extends AbstractFilePayloadTransformer<String> {

	private volatile Charset charset = Charset.defaultCharset();
	private static final String MESSAGE = "File name: %s %s";

	public SseFileTransformer() {
	}

	protected final String transformFile(final File file) throws Exception {
		final List<String> lines = Files.readAllLines(Paths.get(file.getPath()), charset);
		final String content = lines.stream().collect(Collectors.joining("\n "));

		return String.format(MESSAGE, file.getName() + "\n", content + "\n\n");
	}


}
