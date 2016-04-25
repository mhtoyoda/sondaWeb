package br.com.toyoda.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ActionInputModel {

	private List<ActionInput> actionInput;

	public List<ActionInput> getActionInput() {
		return actionInput;
	}

	public void setActionInput(List<ActionInput> actionInput) {
		this.actionInput = actionInput;
	}
}
