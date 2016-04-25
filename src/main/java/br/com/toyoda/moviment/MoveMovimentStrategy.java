package br.com.toyoda.moviment;

import org.springframework.stereotype.Component;

import br.com.toyoda.model.Sonda;

@Component("moveMovimentStrategy")
public class MoveMovimentStrategy implements MovimentStrategy {

	@Override
	public Sonda executeAction(Sonda sonda) {
		sonda = sonda.getDirection().getOrientation().moviment(sonda);
		return sonda;
	}
}