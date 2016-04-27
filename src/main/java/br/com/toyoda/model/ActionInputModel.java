package br.com.toyoda.model;

import java.io.Serializable;
import java.util.List;

public class ActionInputModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<ActionInput> actionInputList;

	public List<ActionInput> getActionInputList() {
		return actionInputList;
	}

	public void setActionInputList(List<ActionInput> actionInputList) {
		this.actionInputList = actionInputList;
	}
}