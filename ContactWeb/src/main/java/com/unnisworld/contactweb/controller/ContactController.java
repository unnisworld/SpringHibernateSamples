package com.unnisworld.contactweb.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.unnisworld.contactweb.domainobjects.Contact;
import com.unnisworld.contactweb.repository.ContactRepository;

@Controller
@SessionAttributes
public class ContactController {

	@Autowired
	private ContactRepository contactRepository;
	
    @RequestMapping("/contacts")
    public ModelAndView showContacts() {
 
        return new ModelAndView("contact", "contact", new Contact());
    }
	
    @RequestMapping("/index")
    public String listContacts(Map<String, Object> map) {
 
        map.put("contact", new Contact());
        map.put("contactList", contactRepository.listContact());
 
        return "contact";
    }
 
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("contact")
    Contact contact, BindingResult result) {
 
    	contactRepository.addContact(contact);
 
        return "redirect:/index";
    }
 
    @RequestMapping("/delete/{contactId}")
    public String deleteContact(@PathVariable("contactId")
    Integer contactId) {
 
    	contactRepository.removeContact(contactId);
 
        return "redirect:/index";
    }
}
