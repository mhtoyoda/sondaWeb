package br.com.toyoda.orientation;

import br.com.toyoda.direction.Direction;
import br.com.toyoda.model.Planalto;
import br.com.toyoda.model.Sonda;

public class EastMoviment implements OrientationMoviment {

	@Override
	public Direction left() {
		return Direction.N;
	}

	@Override
	public Direction right() {
		return Direction.S;
	}

	@Override
	public Sonda moviment(Sonda sonda) {
	    if(Planalto.MALHA_MARTE.getCoordenadaLimitX() >= (sonda.getCoordinateX() + 1)){	        
	        sonda.setCoordinateX(sonda.getCoordinateX() + 1);
	    }
		return sonda;
	}
}