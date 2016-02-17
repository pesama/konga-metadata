package io.konga.metadata.definition;

public class KongaDefinition {
	private String appName;
	private String modelPackage;
	
	public KongaDefinition(String name, String modelPackage) {
		this.appName = name;
		this.modelPackage = modelPackage;
	}
	
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getModelPackage() {
		return modelPackage;
	}
	public void setModelPackage(String modelPackage) {
		this.modelPackage = modelPackage;
	}
	
//	TODO Include other stuff
}
