package com.spring.mqtt.springPubSub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mqtt.springPubSub.mqttClient.PubSubClient;

@Controller
public class PubSubController {
	
	PubSubClient pubSubClient = new PubSubClient();

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView();
		model.addObject("message", "This is welcome page!");
		model.setViewName("index");
		return model;

	}
	
	@RequestMapping(value = { "/buttons" }, method = RequestMethod.GET)
	public ModelAndView ledButtons() {

		ModelAndView model = new ModelAndView();
		model.setViewName("buttons");
		return model;

	}
	
	@RequestMapping(value = { "/ledOn" }, method = RequestMethod.POST)
	public String ledOn() {
		pubSubClient.publish("1");

		return "redirect:buttons";

	}
	
	@RequestMapping(value = { "/ledOff" }, method = RequestMethod.POST)
	public String ledOff() {
		pubSubClient.publish("0");

		return "redirect:buttons";

	}
	
/*	@RequestMapping(value = { "/ledSwitch" }, method = RequestMethod.POST)
	public void ledController() {
		if()

	}*/

	/*
	 * @RequestMapping(value = "/login", method = RequestMethod.GET) public
	 * ModelAndView adminPage() {
	 * 
	 * ModelAndView model = new ModelAndView(); model.addObject("title",
	 * "Spring Security Custom Login Form"); model.addObject("message",
	 * "This is protected page!"); model.setViewName("login");
	 * 
	 * return model;
	 * 
	 * }
	 */

}
