package br.com.toyoda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SondaController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(){
		return "index";
	}
}