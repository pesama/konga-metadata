package io.konga.metadata.definition;

/**
 * Configures a field set with extra parameters to modify the standard behavior
 * @author psanchezmarg
 *
 */
public class FieldSetConfiguration {

	/**
	 * Use a different view for rendering the fields within this set
	 */
	private String view;

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}
}
