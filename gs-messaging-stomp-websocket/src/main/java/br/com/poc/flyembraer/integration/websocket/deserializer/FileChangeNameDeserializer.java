package br.com.poc.flyembraer.integration.websocket.deserializer;

import br.com.poc.flyembraer.integration.websocket.wrapper.FileChangeNameWrapper;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

/**
 * {@link FileChangeNameDeserializer}
 *
 * @author Daniel Silveira
 * @version 1.0 07/07/2017
 */
public final class FileChangeNameDeserializer extends JsonDeserializer<FileChangeNameWrapper> {

	@Override public FileChangeNameWrapper deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException, JsonProcessingException {
		ObjectCodec objectCodec = jsonParser.getCodec();
		JsonNode node = objectCodec.readTree(jsonParser);
		return new FileChangeNameWrapper(node.get("oldName").asText(), node.get("newName").asText());
	}
}
