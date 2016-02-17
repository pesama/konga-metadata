package io.konga.metadata.generator;

import io.konga.metadata.serializers.KongaRefDeserializer;
import io.konga.metadata.definition.KongaConstants;
import io.konga.metadata.serializers.KongaRefSerializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using=KongaRefSerializer.class)
@JsonDeserialize(using=KongaRefDeserializer.class)
public class KongaRef {
	
	public static final String ID_FIELD = "id";
	public static final String INDEX_FIELD = "index";
	public static final String SOURCE_FIELD = "source";
	public static final String REASON_FIELD = "reason";
	
	public static final String VALUE_FIELD = "value";
	
	private static Integer indexGenerator = 0;
	
	private Integer id;
	
	private Integer index;
	
	private String source;
	
	private final String reason = KongaConstants.REASON_JSON_IDENTITY_INFO;
	
	public KongaRef(Integer id, Integer index, String source) {
		this.id = id;
		this.index = index;
		this.source = source;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer value) {
		this.index = value;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getReason() {
		return reason;
	}
}
