package org.kongaproject.metadata.definition;

public class Priority {
	private int results;
	private int search;
	private int update;
	private int details;
	
	public Priority() {
	}
	
	public Priority(int value) {
		results = value;
		search = value;
		update = value;
		details = value;
	}
	
	public void setDetails(org.kongaproject.metadata.definition.Priority priority, int value, int defaultValue) {
		if (value != 0) {
			priority.setDetails(value);
		} else {
			priority.setDetails(defaultValue);
		}
	}
	public void setResults(org.kongaproject.metadata.definition.Priority priority, int value, int defaultValue) {
		if (value != 0) {
			priority.setResults(value);
		} else {
			priority.setResults(defaultValue);
		}
	}
	public void setSearch(org.kongaproject.metadata.definition.Priority priority, int value, int defaultValue) {
		if (value != 0) {
			priority.setSearch(value);
		} else {
			priority.setSearch(defaultValue);
		}
	}
	public void setUpdate(org.kongaproject.metadata.definition.Priority priority, int value, int defaultValue) {
		if (value != 0) {
			priority.setUpdate(value);
		} else {
			priority.setUpdate(defaultValue);
		}
	}
	
	
	/**
	 * @return the results
	 */
	public int getResults() {
		return results;
	}
	/**
	 * @param results the results to set
	 */
	public void setResults(int results) {
		this.results = results;
	}
	/**
	 * @return the search
	 */
	public int getSearch() {
		return search;
	}
	/**
	 * @param search the search to set
	 */
	public void setSearch(int search) {
		this.search = search;
	}
	/**
	 * @return the update
	 */
	public int getUpdate() {
		return update;
	}
	/**
	 * @param update the update to set
	 */
	public void setUpdate(int update) {
		this.update = update;
	}
	/**
	 * @return the details
	 */
	public int getDetails() {
		return details;
	}
	/**
	 * @param details the details to set
	 */
	public void setDetails(int details) {
		this.details = details;
	}
	
}
