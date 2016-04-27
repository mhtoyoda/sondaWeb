package br.com.toyoda.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import br.com.toyoda.model.ActionInput;
import br.com.toyoda.model.Sonda;
import br.com.toyoda.moviment.ManagerActionMoviment;
import br.com.toyoda.moviment.MovimentStrategy;

@Component
public class SondaAction {
	
	@Autowired
	private ManagerActionMoviment managerActionMoviment;
	
	private void showSondaInput(ActionInput actionInput){
		Sonda sonda = actionInput.getSonda();
		System.out.println(sonda.getCoordinateX()+ " "+ sonda.getCoordinateY() + " "+sonda.getDirection().name());
		System.out.println(actionInput.getInstructions());
	}
	
	public synchronized Sonda action(ActionInput actionInput, int coordinateLimitInitialX, int coordinateLimitInitialY){
		managerActionMoviment.init();
		Sonda sonda = actionInput.getSonda();
		showSondaInput(actionInput);
		String instructions = StringUtils.trimAllWhitespace(actionInput.getInstructions()).toUpperCase();
		for(int index = 0; index < instructions.length(); index++){
			String instruction = String.valueOf(instructions.charAt(index));
			MovimentStrategy movimentStrategy = managerActionMoviment.getMovimentStrategy(instruction);
			sonda = movimentStrategy.executeAction(sonda);
		}
		return sonda;
	}
}