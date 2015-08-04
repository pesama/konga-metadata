package org.kongaproject.metadata.serializers;

import java.io.IOException;

import org.kongaproject.metadata.generator.KongaRef;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class KongaRefDeserializer extends JsonDeserializer<KongaRef> {

	@Override
	public KongaRef deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		JsonNode node = jp.readValueAsTree();
		Integer id = Integer.parseInt(node.get(KongaRef.ID_FIELD).asText());
		Integer index = Integer.parseInt(node.get(KongaRef.INDEX_FIELD).asText());
		String source = node.get(KongaRef.SOURCE_FIELD).asText();
		return new KongaRef(id, index, source);
	}
	

}
