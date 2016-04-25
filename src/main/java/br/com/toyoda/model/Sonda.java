package br.com.toyoda.model;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.toyoda.direction.Direction;

@XmlRootElement
public class Sonda {

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