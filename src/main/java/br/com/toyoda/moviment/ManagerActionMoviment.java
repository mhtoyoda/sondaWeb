package br.com.toyoda.moviment;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ManagerActionMoviment {

	@Autowired
	@Qualifier("moveMovimentStrategy")
	private MovimentStrategy moveMovimentStrategy;

	@Autowired
	@Qualifier("rightMovimentStrategy")
	private MovimentStrategy rightMovimentStrategy;

	@Autowired
	@Qualifier("leftMovimentStrategy")
	private MovimentStrategy leftMovimentStrategy;

	private Map<String, MovimentStrategy> mapMovimentStrategy;

	public void init() {
		if (mapMovimentStrategy == null) {
			mapMovimentStrategy = new HashMap<String, MovimentStrategy>();
		}
		mapMovimentStrategy.put("M", moveMovimentStrategy);
		mapMovimentStrategy.put("R", rightMovimentStrategy);
		mapMovimentStrategy.put("L", leftMovimentStrategy);
	}

	public MovimentStrategy getMovimentStrategy(String instruction) {
		return mapMovimentStrategy.get(instruction);
	}
}