package br.com.toyoda.orientation;

import br.com.toyoda.direction.Direction;
import br.com.toyoda.model.Sonda;

public class WestMoviment implements OrientationMoviment {

	@Override
	public Direction left() {
		return Direction.S;
	}

	@Override
	public Direction right() {
		return Direction.N;
	}

	@Override
	public Sonda moviment(Sonda sonda) {
		sonda.setCoordinateX(sonda.getCoordinateX() - 1);
		return sonda;
	}
}