package br.com.toyoda.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.toyoda.business.SondaAction;
import br.com.toyoda.model.ActionInputModel;
import br.com.toyoda.model.Sonda;

@RestController
public class SondaService {

	@Autowired
	private SondaAction sondaService;
	
	@RequestMapping(value = "/sonda", method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Sonda>> moveSonda(@RequestBody ActionInputModel actionInputModel,
												 @RequestParam("coordenadaLimitX") int coordenadaLimitX,
												 @RequestParam("coordenadaLimitY") int coordenadaLimitY){
		List<Sonda> result = new ArrayList<Sonda>();
		System.out.println(actionInputModel.getActionInput().get(0).getInstructions());
		return new ResponseEntity<List<Sonda>>(result, HttpStatus.OK); 
	}
}
