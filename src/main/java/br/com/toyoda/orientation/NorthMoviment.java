package br.com.toyoda.orientation;

import br.com.toyoda.direction.Direction;
import br.com.toyoda.model.Planalto;
import br.com.toyoda.model.Sonda;

public class NorthMoviment implements OrientationMoviment {

	@Override
	public Direction left() {
		return Direction.W;
	}

	@Override
	public Direction right() {
		return Direction.E;
	}

	@Override
	public Sonda moviment(Sonda sonda) {
	    if(Planalto.MALHA_MARTE.getCoordenadaLimitY() >= (sonda.getCoordinateY() + 1)){	        
	        sonda.setCoordinateY(sonda.getCoordinateY() + 1);
	    }
		return sonda;
	}
}