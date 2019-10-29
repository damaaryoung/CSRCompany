package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.Date;


@Controller
public class AppController {
 
    @Autowired
    private CSRService service;
     
    // handler methods...
    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Tbl_Csr> listCSR = service.listAll();
        model.addAttribute("listCSR", listCSR);
         
        return "index";
    }
    
    @RequestMapping("/new")
    public String showNewMemberPage(Model model) {
    	Tbl_Csr csr = new Tbl_Csr();
        model.addAttribute("csr", csr);
         
        return "new_csr";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCsr(@ModelAttribute("csr") Tbl_Csr csr) {
        service.save(csr);
         
        return "redirect:/";
    }
    
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditCsrPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_csr");
        Tbl_Csr tbl_csr = service.get(id);
        mav.addObject("tbl_csr", tbl_csr);
         
        return mav;
    }
    
    
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateCsr(@ModelAttribute("tbl_csr") Tbl_Csr tbl_csr) {
        service.save(tbl_csr);
         
        return "redirect:/";
    }
    
    @RequestMapping("/delete/{id}")
    public String deleteCSR(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";       
    }
}

