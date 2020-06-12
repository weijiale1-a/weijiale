package com.mdy.controller;


import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.baomidou.mybatisplus.plugins.Page;
import com.mdy.entity.EmpInfo;
import com.mdy.service.IDepInfoService;
import com.mdy.service.IEmpInfoService;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mdy
 * @since 2020-05-19
 */
@Controller
@Scope("singleton")
@RequestMapping("/empC")
public class EmpInfoController {

	@Autowired
	private IEmpInfoService iempservice;
	
	@Autowired
	private IDepInfoService idepservice;
	
	//时间格式处理
	@InitBinder
	public void userDate(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));//true是可以为空
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView addBeFore(EmpInfo emp) {
		ModelAndView mav = new ModelAndView("add");
		mav.addObject("depAll", idepservice.selectList(null));
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String add(EmpInfo emp,Model m) {
		boolean flag = iempservice.insert(emp);
		if(flag) {
			return "redirect:/empC/select/1";
		}
		m.addAttribute("msg","员工添加失败");
		return "fail";
	}
	
	@RequestMapping(value = "/{eid}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("eid") int id, Model m) {
		boolean flag = iempservice.deleteById(id);

		if(flag) {
			return "redirect:/empC/select/1";
		}
		m.addAttribute("msg","员工删除失败");
		return "fail";
	}
	
	@RequestMapping(value = "/changeBeFore/{eid}", method = RequestMethod.GET)
	public ModelAndView changeBeFore(@PathVariable("eid") int id) {
		ModelAndView mav = new ModelAndView("updateEmp");
		mav.addObject("empOne",  iempservice.selectById(id));
		mav.addObject("depAll", idepservice.selectList(null));
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public String change(EmpInfo emp,Model m) {
		boolean flag = iempservice.updateById(emp);
		
		if(flag) {
			return "redirect:/empC/select/1";
		}
		m.addAttribute("msg","员工修改失败");
		return "fail";
	}
	
	@RequestMapping(value = "/select/{pageNo}",method = RequestMethod.GET)
	public ModelAndView select(@PathVariable(value = "pageNo") int pageNo) {
		ModelAndView mav = new ModelAndView("show");
		mav.addObject("empAll",  iempservice.selectPage(new Page<EmpInfo>(pageNo,3)));
		mav.addObject("depAll",idepservice.selectList(null));
		return mav;
	}
	
}

