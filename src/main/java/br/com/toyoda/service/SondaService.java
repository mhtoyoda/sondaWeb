package br.com.toyoda.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.toyoda.business.SondaAction;
import br.com.toyoda.model.ActionInput;
import br.com.toyoda.model.ActionInputModel;
import br.com.toyoda.model.Planalto;
import br.com.toyoda.model.Sonda;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class SondaService {

	private Logger log = Logger.getLogger(SondaService.class);
	
	@Autowired
	private SondaAction sondaService;
	
	@RequestMapping(value = "/sonda", method = RequestMethod.POST,
					consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Sonda>> moveSonda(@RequestBody String json){
		
		List<Sonda> result = new ArrayList<Sonda>();
		ActionInputModel actionInputModel = null;
		try {
			actionInputModel = new ObjectMapper().readValue(json, ActionInputModel.class);
		} catch (IOException e) {
			return new ResponseEntity<List<Sonda>>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		log.info(Planalto.MALHA_MARTE.getCoordenadaLimitX()+" "+Planalto.MALHA_MARTE.getCoordenadaLimitY());
		for (ActionInput actionInput : actionInputModel.getActionInputList()) {
			Sonda sonda = sondaService.action(actionInput);
			result.add(sonda);
		}
		return new ResponseEntity<List<Sonda>>(result, HttpStatus.OK); 
	}
}