package br.com.toyoda.moviment;

import br.com.toyoda.model.Sonda;

public interface MovimentStrategy {

	public Sonda executeAction(Sonda sonda);
}
