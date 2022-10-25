package com.ssafy.emp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.emp.model.Emp;
import com.ssafy.emp.model.service.EmpService;

@Controller
public class MainController {

	@Autowired
	private EmpService empService;
	
	//처음화면------------------------------------------------------------
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	//추가하기------------------------------------------------------------
	@RequestMapping(value = "/insert", method=RequestMethod.POST)
	public String insert(@ModelAttribute Emp emp) {
		if(empService.insertEmp(emp)) {
			return "redirect:/list";
		}else {
			return "index";
		}
	}
	
	//전체보기------------------------------------------------------------
	@RequestMapping(value = "/list", method=RequestMethod.GET)
	public String list(Model model) {
		List<Emp> list=empService.listEmp();
		model.addAttribute("list", list);
		return "list";
	}
	// 검색하기(조건: 사번 5이하, 부서는 '발'을 포함)---------------------------
	@RequestMapping(value="/searchEmp", method = RequestMethod.GET)
	public String listSearchEmp(Model model) {
		// Map객체에 각각 필드의 key와 value를 저장
		Map<String,String> map=new HashMap<>();
		map.put("eno", "5");
		map.put("dept", "%"+ "발" + "%");   // %발%
		
		List<Emp> list=empService.getEmpByEnoAndDept(map);
		model.addAttribute("list", list);
		return "list";
	}
	
	// 수정하기(화면)---------------------------------------------------
	@RequestMapping(value = "/updateEmp", method = RequestMethod.POST)
	public String update(@ModelAttribute Emp emp) {
		return "updateEmp";
	}
	
	// 수정하기---------------------------------------------------------
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateProc(@ModelAttribute Emp emp) throws Exception  {
		if(empService.updateEmp(emp)) {
			return "redirect:/list";
		}else {
			return "list";
		}
	}
	
	// 삭제하기------------------------------------------------------	
	@RequestMapping(value = "/deleteEmp", method = RequestMethod.GET)
	public String delete(@RequestParam int eno) throws Exception {
		empService.deleteEmp(eno);
		return "redirect:/list";
	}
		
	// 검색하기(조건: eno로 찾기)----------------------------------------
	@RequestMapping(value="/searchNo", method = RequestMethod.GET)
	public String searchNo(@RequestParam int eno, Model model) {
		Emp emp=empService.searchNo(eno);
		model.addAttribute("emp",emp);
		return "searchNo";
	}
}

/* 
@ModelAttribute Emp emp는 아래와 동일
Emp emp = new Emp();
emp.setNo(request.getParameter("eno"))
emp.setName(request.getParameter("ename"))
emp.setPhone(request.getParameter("phone"))
emp.setDept(request.getParameter("dept"))
*/










































