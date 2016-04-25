package br.com.toyoda.moviment;

import org.springframework.stereotype.Component;

import br.com.toyoda.direction.Direction;
import br.com.toyoda.model.Sonda;

@Component("rightMovimentStrategy")
public class RightMovimentStrategy implements MovimentStrategy {

	@Override
	public Sonda executeAction(Sonda sonda) {
		Direction direction = sonda.getDirection().getOrientation().right();
		sonda.setDirection(direction);
		return sonda;
	}
}