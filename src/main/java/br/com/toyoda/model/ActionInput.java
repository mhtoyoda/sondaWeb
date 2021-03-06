package br.com.toyoda.model;

import java.io.Serializable;

public class ActionInput implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Sonda sonda;
	private String instructions;

	public ActionInput(){
		this.sonda = new Sonda();
	}
	
	public Sonda getSonda() {
		return sonda;
	}

	public void setSonda(Sonda sonda) {
		this.sonda = sonda;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
}