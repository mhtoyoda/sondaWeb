package br.com.toyoda.moviment;

import org.springframework.stereotype.Component;

import br.com.toyoda.direction.Direction;
import br.com.toyoda.model.Sonda;

@Component("leftMovimentStrategy")
public class LeftMovimentStrategy implements MovimentStrategy {

	@Override
	public Sonda executeAction(Sonda sonda) {
		Direction direction = sonda.getDirection().getOrientation().left();
		sonda.setDirection(direction);
		return sonda;
	}
}