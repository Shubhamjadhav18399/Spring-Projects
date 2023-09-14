package com.jspiders.springmvc1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jspiders.springmvc1.pojo.AdminPOJO;
import com.jspiders.springmvc1.pojo.StudentPOJO;
import com.jspiders.springmvc1.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;

	// Home Page Controller
	@GetMapping("/home")
	public String Home(@SessionAttribute(name = "login", required = false) AdminPOJO admin,
			                                                                ModelMap map) {

		if (admin != null) {
			return "Home";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";

	}

//	@RequestMapping(path="/home1",method=RequestMethod.GET)
//	public String Home1(){
//		return"Home";
//	}

	// Add Page Controller
	@GetMapping("/add")
	public String addPage(@SessionAttribute(name = "login", required = false) AdminPOJO admin, ModelMap map) {
		if (admin != null) {
			List<StudentPOJO> students = service.findAllStudents();
			if (!students.isEmpty()) {
				map.addAttribute("students", students);
				return "Add";
			}
			return "Add";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";

	}

	// Add Student Controller
	@PostMapping("/add")
	public String addStudent(@SessionAttribute(name = "login", required = false) AdminPOJO admin,
			@RequestParam String name, @RequestParam String email, @RequestParam long contact,
			@RequestParam String address, ModelMap map) {

		if (admin != null) {
			StudentPOJO pojo = service.addStudent(name, email, contact, address);
			List<StudentPOJO> students = service.findAllStudents();
			// Success Flow
			if (pojo != null) {
				map.addAttribute("msg", "Data Insert Successfully..!");
				map.addAttribute("students", students);
				return "Add";
			}
			// Failure Flow
			map.addAttribute("msg", "Data Not Insert Successfully..!");
			if (!students.isEmpty()) {
				map.addAttribute("students", students);
			}
			return "Add";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";

	}

	// Search Page Controller
	@GetMapping("/search")
	public String searchPage(@SessionAttribute(name = "login", required = false) AdminPOJO admin, ModelMap map) {

		if (admin != null) {
			return "Search";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}

	// Search Student Controller
	@PostMapping("/search")
	public String searchStudent(@SessionAttribute(name = "login", required = false) AdminPOJO admin,
			@RequestParam int id, ModelMap map) {

		if (admin != null) {
			StudentPOJO pojo = service.searchStudent(id);
			// Success Flow
			if (pojo != null) {
				map.addAttribute("student", pojo);
				map.addAttribute("msg", "Student data found..!");
				return "Search";
			}
			// Failure Flow
			map.addAttribute("msg", "Student Data Not Found..!");
			return "Search";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}

	// Remove Page Controller
	@GetMapping("/remove")
	public String removePage(@SessionAttribute(name = "login", required = false) AdminPOJO admin, ModelMap map) {
		if (admin != null) {
			List<StudentPOJO> students = service.findAllStudents();
			// Success Flow
			if (students != null) {
				map.addAttribute("students", students);
				return "Remove";
			}
			// failure flow
			map.addAttribute("msg", "No Data Presend...!	");
			return "Remove";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}

	// Remove Student Controller
	@PostMapping("/remove")
	public String removeStudent(@SessionAttribute(name = "login", required = false) AdminPOJO admin,
			@RequestParam int id, ModelMap map) {

		if (admin != null) {
			StudentPOJO pojo = service.removeStudent(id);
			List<StudentPOJO> students = service.findAllStudents();
			// Success Flow
			if (pojo != null) {
				map.addAttribute("msg", "Data Removed Successfully..!");
				map.addAttribute("students", students);
				return "Remove";
			}
			// Failure Flow
			map.addAttribute("msg", "Data Not Exits..!");
			map.addAttribute("students", students);
			return "Remove";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}

	// Update Page
	@GetMapping("/update")
	public String updatePage(@SessionAttribute(name = "login", required = false) AdminPOJO admin, ModelMap map) {
		if (admin != null) {
			List<StudentPOJO> students = service.findAllStudents();
			// Success
			if (students != null) {
				map.addAttribute("students", students);
				return "Update";
			}
//			//Failure
//			map.addAttribute("msg", "Data Not Present...!");
			return "Update";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}

	// Update Form Controller
	@PostMapping("/update")
	public String updateForm(@SessionAttribute(name = "login", required = false) AdminPOJO admin, @RequestParam int id,
			                                          ModelMap map) {
		if (admin != null) {
			StudentPOJO pojo = service.searchStudent(id);
			// Success flow
			if (pojo != null) {
				map.addAttribute("student", pojo);
				return "Update";
			}
			// Failure Flow
			List<StudentPOJO> students = service.findAllStudents();
			map.addAttribute("students", students);
			map.addAttribute("msg", "Data Not Found...!");
			return "Update";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}

	// Update Student Controller
	@PostMapping("/updateStudent")
	public String updateStudent(@SessionAttribute(name = "login", required = false) AdminPOJO admin,
			@RequestParam int id, @RequestParam String name, @RequestParam String email, @RequestParam long contact,
			@RequestParam String address, ModelMap map) {

		if (admin != null) {
			StudentPOJO pojo = service.updateStudent(id, name, email, contact, address);
			// Suceess
			if (pojo != null) {
				List<StudentPOJO> students = service.findAllStudents();
				map.addAttribute("students", students);
				map.addAttribute("msg", "Data Updated Successfully..!");
				return "Update";
			}
			// Failure
			List<StudentPOJO> students = service.findAllStudents();
			map.addAttribute("msg", "Data Not Updated..!");

			map.addAttribute("students", students);
			return "Update";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}

}
