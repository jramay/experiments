package org.jaffar.controller;

import javax.validation.Valid;

import org.jaffar.model.HomeModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
public class HomeController {

	//WELCOME
    @RequestMapping(method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		System.out.println("=========== Home Controller ===========");
		HomeModel homeModel = new HomeModel();
		homeModel.setMessage("Custom Validation Framework");
		model.addAttribute(homeModel);
		return "homePage";

	}
    
         @RequestMapping(method = RequestMethod.POST,value = "/validate")
    	public String validateForm(ModelMap model, @Valid HomeModel homeModel, BindingResult result){
             System.out.println("=========== Home Controller Validate ===========");
             if(result.hasErrors())
        	 homeModel.setMessage("Custom Validation Framework : FAILED");
             else
        	homeModel.setMessage("Custom Validation Framework : PASS");
             
             model.addAttribute(homeModel);
             return "homePage";
    	}
}
