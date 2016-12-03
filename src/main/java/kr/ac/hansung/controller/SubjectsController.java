package kr.ac.hansung.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.StyledEditorKit.BoldAction;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.model.Subject;
import kr.ac.hansung.service.SubjectsService;

@Controller
public class SubjectsController {

	private SubjectsService subjectsService;

	@Autowired
	public void setSubjectsService(SubjectsService subjectsService) {
		this.subjectsService = subjectsService;
	}

	@RequestMapping("/gradeperyearsemester")
	public String showSubjects(Model model) {

		List<Subject> gradePerYearSemesters = subjectsService.showGradePerYearSemester();

		model.addAttribute("gradePerYearSemesters", gradePerYearSemesters);
		return "gradePerYearSemester";
	}

	@RequestMapping("/gradeperpart")
	public String showGradePerPart(Model model) {

		List<Subject> gradePerParts = subjectsService.showGradePerPart();
		int sumGrade = subjectsService.showSumGrade();

		model.addAttribute("gradePerParts", gradePerParts);
		model.addAttribute("sumGrade", sumGrade);

		return "gradePerPart";
	}

	@RequestMapping("/gradeperyearsemester/detail")
	public String showDetail(HttpServletRequest httpServletRequest, Model model) {
		int year = Integer.parseInt(httpServletRequest.getParameter("year"));
		int semester = Integer.parseInt(httpServletRequest.getParameter("semester"));

		List<Subject> subectName = subjectsService.showSubjectName(year, semester);

		model.addAttribute("subectName", subectName);

		return "detail";
	}

	@RequestMapping("/register")
	public String createSubject(Model model) {

		model.addAttribute(new Subject());
		return "registerform";
	}

	@RequestMapping("/registerentry")
	public String register(Model model) {

		List<Subject> subjects = subjectsService.get2017RegisterEntry();

		model.addAttribute("subjects", subjects);

		return "registerentry";
	}

	@RequestMapping("/docreate")
	public String docreate(Model model, @Valid Subject subject, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println("Form is invalidate");
			List<ObjectError> errors = bindingResult.getAllErrors();
			for (ObjectError error : errors)
				System.out.println(error.getDefaultMessage());
			
			return "registerform";
		}

		boolean success = subjectsService.register(subject);

		if (success)
			return "successinsert";
		else
			return "failinsert";

	}
}
