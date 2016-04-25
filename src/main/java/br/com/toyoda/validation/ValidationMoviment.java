package br.com.toyoda.validation;

import org.springframework.stereotype.Component;

import br.com.toyoda.model.Sonda;

@Component
public class ValidationMoviment {

	public boolean canMove(Sonda sonda, int coordinateInitialX, int coordinateInitialY){
		
		return true;
	}
}
