package br.com.poc.flyembraer.integration.websocket.transformer;

import org.springframework.integration.file.transformer.AbstractFilePayloadTransformer;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A classe {@link FileTransformer} realiza a leitura do conteudo do arquivo
 * e retorno suas informacoes.
 *
 * @author Daniel Silveira
 * @version 1.0 28/06/2017
 */
@Component
public class FileTransformer extends AbstractFilePayloadTransformer<String> {

	private final Charset charset = Charset.defaultCharset();
	private static final String MESSAGE = "{\"fileName\": \"%s\", \"content\": \"%s\"}";

	@Override
	public final String transformFile(final File file) throws Exception {
		final List<String> lines = Files.readAllLines(Paths.get(file.getPath()), charset);
		final String content = lines.stream().collect(Collectors.joining(", "));
		return String.format(MESSAGE, file.getName(), content);
	}
}