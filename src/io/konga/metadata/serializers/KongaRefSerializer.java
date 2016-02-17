package io.konga.metadata.serializers;

import java.io.IOException;

import io.konga.metadata.generator.KongaRef;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class KongaRefSerializer extends JsonSerializer<KongaRef> {

	@Override
	public void serialize(KongaRef value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
		jgen.writeStartObject();
		jgen.writeObjectField(KongaRef.ID_FIELD, value.getId());
		jgen.writeObjectField(KongaRef.INDEX_FIELD, value.getIndex());
		jgen.writeObjectField(KongaRef.SOURCE_FIELD, value.getSource());
		jgen.writeObjectField(KongaRef.REASON_FIELD, value.getReason());
		// TODO More
		jgen.writeEndObject();
	}

}
