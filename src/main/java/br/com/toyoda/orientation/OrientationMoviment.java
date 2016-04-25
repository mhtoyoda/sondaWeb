package br.com.toyoda.orientation;

import br.com.toyoda.direction.Direction;
import br.com.toyoda.model.Sonda;

public interface OrientationMoviment {

	public Direction left();
	
	public Direction right();
	
	public Sonda moviment(Sonda sonda);
}
