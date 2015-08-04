package org.kongaproject.metadata.generator;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

import org.kongaproject.metadata.annotations.EntityId;
import org.kongaproject.metadata.definition.KongaEntity;
import org.kongaproject.metadata.definition.KongaMetadata;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;

public class KongaJSONGenerator extends ObjectIdGenerator<KongaRef> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2231424369067065559L;
	
	protected transient int _nextValue;
    protected final Class<?> _scope;
    
    protected KongaJSONGenerator() { this(null, -1); }

    protected KongaJSONGenerator(Class<?> scope, int nextValue) {
        _scope = scope;
        _nextValue = nextValue;
    }
	
	@Override
	public Class<?> getScope() {
		return _scope;
	}

	@Override
	public boolean canUseFor(ObjectIdGenerator<?> gen) {
		return (gen.getClass() == getClass()) && (gen.getScope() == _scope);
	}

	@Override
	public ObjectIdGenerator<KongaRef> forScope(Class<?> scope) {
		return (_scope == scope) ? this : new KongaJSONGenerator(scope, _nextValue);
	}

	@Override
	public ObjectIdGenerator<KongaRef> newForSerialization(Object context) {
		return new KongaJSONGenerator(_scope, 1);
	}

	@Override
	public com.fasterxml.jackson.annotation.ObjectIdGenerator.IdKey key(
			Object key) {
		return new IdKey(getClass(), _scope, key);
	}

	@Override
	public KongaRef generateId(Object forPojo) {
		Integer id = 0;
		String source = "";
		boolean found = false;
		
		List<KongaMetadata> registeredApplications = KongaGenerator.getAllApplications();
		for(KongaMetadata appDefinition : registeredApplications) {
			if(found) break;
			List<KongaEntity> entities = appDefinition.getEntities();
			for(KongaEntity entity : entities) {
				if(found) break;
				Class<?> classFor = entity.getClassFor();
				if(!Modifier.isFinal(classFor.getModifiers())) {
					continue;
				}
				if(classFor.isInstance(forPojo)) {
					// We have found the source
					source = entity.getName();
					
					List<Field> allFields = Arrays.asList(classFor.getDeclaredFields());
					Class<?> current = classFor.getSuperclass();
					
					while(current != null && !current.equals(Object.class)) {
						try {
							allFields.addAll(Arrays.asList(current.getDeclaredFields()));
							current = current.getSuperclass();
						} catch(Exception e) {
							// Nothing to do
							current = null;
						}
					}
					
					for(Field field : allFields) {
						if(field.isAnnotationPresent(EntityId.class)) {
							
							// TODO Change (do not change accessibility)
							field.setAccessible(true);
							try {
								id = (Integer) field.get(forPojo);
								found = true;
								break;
							} catch (IllegalArgumentException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IllegalAccessException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
		
		int index = _nextValue;
        ++_nextValue;
        return new KongaRef(id, index, source);
	}
}
