package com.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.controller.dto.MessageDto;

@RequestMapping("/ajax")
@Controller
public class AjaxController {

	@RequestMapping("/")
	public String index() {
		return "ajax";
	}
	
	@RequestMapping("/text")
	@ResponseBody
	public String getString() {
		return "hello";
	}
	
	@RequestMapping("/json")
	@ResponseBody
	public Object getJson() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		return new MessageDto();
	}
	
}
