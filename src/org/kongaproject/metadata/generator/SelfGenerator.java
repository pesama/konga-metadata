package org.kongaproject.metadata.generator;

import java.io.FileWriter;

import org.kongaproject.metadata.definition.KongaDefinition;
import org.kongaproject.metadata.definition.KongaMetadata;
import org.kongaproject.metadata.generator.KongaGenerator;

public class SelfGenerator {

	public SelfGenerator() throws Exception {
		KongaDefinition definition = new KongaDefinition("Konga Metadata", "org.kongaproject.metadata.definition");
		
		KongaMetadata metadata = KongaGenerator.readPackage(definition);
		
		System.out.println("parsing");
		
		String metadataJson = metadata.toJson();
		
		FileWriter fw = new FileWriter("./metadata.json");
		fw.write(metadataJson);
		fw.close();
		
		System.out.println("ready");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			new SelfGenerator();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
