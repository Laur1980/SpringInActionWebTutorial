package org.spring.in.action.web.tutorial.controller;

import java.util.List;

import org.spring.in.action.web.tutorial.dao.SpittleRepository;
import org.spring.in.action.web.tutorial.entity.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
	
	private SpittleRepository spittleRepository;
	
	@Autowired
	public SpittleController(SpittleRepository spittleRepository){
		this.spittleRepository = spittleRepository;
	}
	
	@RequestMapping(method= RequestMethod.GET)
	public String spittles(Model model){
		List<Spittle> spittles = spittleRepository.findSpittles(Long.MAX_VALUE,20);
		System.out.println(">>> SpittleController: spittles="+spittles+"<<<");
		model.addAttribute("spittles",spittles);
		return "spittles";
	}
	
}
