package com.ssafy.emp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.emp.model.Emp;
import com.ssafy.emp.model.service.EmpService;

@Controller
public class MainController {

	@Autowired
	private EmpService empService;// 싱글톤 알아서 매칭시켜주기

	// 처음 화면
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	// 추가하기 화면
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute Emp emp) {
		if (empService.insertEmp(emp)) {// true가 될때
			return "redirect:/list";
		} else {
			return "index";
		}
	}

	// 전체보기
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) { // model이 리퀘스트 객체라고 생각
		List<Emp> list = empService.listEmp();
		model.addAttribute("list", list);
		return "list";
	}

	// 검색하기(사번 5이하 부서 백 포함)
	@RequestMapping(value = "/searchEmp", method = RequestMethod.GET)
	public String listSearchEmp(Model model) {
		// map객체에 각각 필드의 key와 value를 저장
		Map<String, String> map = new HashMap<>();
		map.put("eno", "5");
		map.put("dept", "%" + "엔" + "%");
		List<Emp> list = empService.getEmpByEnoAndDept(map);
		model.addAttribute("list", list);
		return "list";
	}

	// 삭제하기
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteEmp(@RequestParam(value = "eno") int eno) {
		int n = empService.deleteEmp(eno);
		if (n > 0) {
			return "redirect:/list";
		}
		return "list";
	}

	// 수정 페이지 띄우기
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute Emp emp) {
		return "updateEmp";
	}

	// 수정하기
	@RequestMapping(value = "/updateEmp", method = RequestMethod.POST)
	public String updateEmp(@ModelAttribute Emp emp) {
		if (empService.updateEmp(emp)) {
			return "redirect:/list";
		}
		return "list";
	}
	
	@GetMapping("/searchOneEmp")
    @ResponseBody
    public Emp searchOneEmp(@RequestParam int eno) {
        Emp emp = empService.selectOne(eno);
        if(emp == null) {
            emp = new Emp();
            emp.setEname("찾는 데이터가 없습니다.");
            emp.setPhone("");
            emp.setDept("");
        }
        return emp;
    }
}
/*
 * @ModelAttribute Emp emp는 아래와 동일 Emp emp = new Emp();
 * emp.setNo(request.getParameter("eno"))
 * emp.setName(request.getParameter("ename"))
 * emp.setPhone(request.getParameter("phone"))
 * emp.setDept(request.getParameter("dept"))
 */
