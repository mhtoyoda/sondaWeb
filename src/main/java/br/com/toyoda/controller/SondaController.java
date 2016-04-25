package br.com.toyoda.controller;

import java.util.List;




import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Lists;

import br.com.toyoda.model.ActionInput;
import br.com.toyoda.model.ActionInputModel;

@Controller
public class SondaController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView modelAndView = new ModelAndView("index");
		ActionInputModel actionInputModel = new ActionInputModel();
		List<ActionInput> list = Lists.newArrayList(new ActionInput(),new ActionInput());
		actionInputModel.setActionInput(list);
		modelAndView.addObject("actionInputModel", actionInputModel);
		return modelAndView;
	}
}