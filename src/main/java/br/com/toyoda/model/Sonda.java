package br.com.toyoda.model;

import java.io.Serializable;

import br.com.toyoda.direction.Direction;

public class Sonda implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int coordinateX;
	private int coordinateY;
	private Direction direction;

	public Sonda(){}
	public Sonda(int coordinateX, int coordinateY, Direction direction) {
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
		this.direction = direction;
	}

	public int getCoordinateX() {
		return coordinateX;
	}

	public void setCoordinateX(int coordinateX) {
		this.coordinateX = coordinateX;
	}

	public int getCoordinateY() {
		return coordinateY;
	}

	public void setCoordinateY(int coordinateY) {
		this.coordinateY = coordinateY;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
}