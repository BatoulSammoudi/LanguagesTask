package axsos.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import axsos.mvc.models.Language;
import axsos.mvc.service.LanguageService;

@Controller
public class LanguageController {
	public final LanguageService languageService;

	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}

	@RequestMapping("/languages")
	public String listAll(Model model, @ModelAttribute("language") Language language) {
		List<Language> list = languageService.allLanguages();
		model.addAttribute("list", list);
		return "index.jsp";
	}

	@PostMapping("/languages")
	public String newLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors())
			return "index.jsp";
		else {
			languageService.createNew(language);
			return "redirect:/languages";
		}

	}

	@GetMapping("/languages/{id}/show")
	public String showLanguage(@PathVariable("id") Integer id, Model model) {
		Language language = languageService.find(id);
		//if (language != null) {
			model.addAttribute("language", language);
			
			return "/show.jsp";
		//} else {
			//return "redirect:/index.jsp";
		//}
		

	}
	
	@RequestMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Language language = languageService.find(id) ; 
        model.addAttribute("language", language);
        return "/edit.jsp";
    }
    
    @RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "/edit.jsp";
        } else {
            languageService.updated(language);
            return "redirect:/languages";
        }
    }
    @RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Integer id) {
        languageService.deleteLanguage(id) ; 
        return "redirect:/languages";
    }
}
