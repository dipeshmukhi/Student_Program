package edu.student.restservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestService
{
	@RequestMapping(method=RequestMethod.GET, value="/employee")
	public @ResponseBody String getEmployee
			(@RequestParam(value="id", required=false, defaultValue="World")  String id,
			 @RequestParam(value="name", required=false, defaultValue="World")  String name) {
		return "Hello "+id+" " +name;
	}
}
