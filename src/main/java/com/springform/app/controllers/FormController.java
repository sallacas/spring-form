package com.springform.app.controllers;

import com.springform.app.editors.CountryPropertyEditor;
import com.springform.app.editors.NameMayusEditor;
import com.springform.app.editors.RolesEditor;
import com.springform.app.models.domain.Country;
import com.springform.app.models.domain.Role;
import com.springform.app.models.domain.User;
import com.springform.app.services.CountryService;
import com.springform.app.services.RoleService;
import com.springform.app.validators.UserValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@SessionAttributes("user")
public class FormController {
    @Autowired
    private UserValidator validator;
    @Autowired
    private CountryService countryService;
    @Autowired
    private CountryPropertyEditor countryPropertyEditor;
    @Autowired
    private RoleService roleService;
    @Autowired
    private RolesEditor rolesEditor;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(validator);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        binder.registerCustomEditor(Date.class, "birthday",new CustomDateEditor(format,false));
        binder.registerCustomEditor(String.class, "firstname",new NameMayusEditor());
        binder.registerCustomEditor(Country.class,"country",countryPropertyEditor);
        binder.registerCustomEditor(Role.class, "roles", rolesEditor);
    }
    @ModelAttribute("countrys")
    public List<String> countrys(){
        return Arrays.asList("Colombia","Venezuela","Ecuador","Argentina","Peru","Spain");
    }
    @ModelAttribute("countrysMap")
    public Map<String,String> countrysMap(){
        return new HashMap<>() {{
            put("ES", "Spain");
            put("CO", "Colombia");
            put("VEN", "Venezuela");
            put("EC", "Ecuador");
            put("ARG", "Argentina");
            put("PE", "Peru");
        }};
    }
    @ModelAttribute("countryList")
    public List<Country> countryList(){
        return countryService.list();
    }
    @GetMapping("/form")
    public String form(Model model) {
        User user = new User();
        user.setFirstname("John");
        user.setLastname("Sito");
        user.setId("1110111-K");
        user.setState(true);
        user.setValue("secret");
        user.setCountry(new Country(2, "CO", "Colombia"));
        user.setRoles(List.of(new Role(3, "ROLE_USER", "User")));
        model.addAttribute("title", "User Form");
        model.addAttribute("user", user);
        return "form";
    }
    @ModelAttribute("rolesListString")
    public List<String> rolesListString(){
        return new ArrayList<>() {{
            add("ROLE_ADMIN");
            add("ROLE_USER");
            add("ROLE_MODERATOR");
        }};
    }

    @ModelAttribute("rolesMap")
    public Map<String, String> rolesMap() {
        return new HashMap<>() {{
            put("ROLE_ADMIN", "Administrator");
            put("ROLE_USER", "User");
            put("ROLE_MODERATOR", "Moderator");
        }};
    }

    @ModelAttribute("roleList")
    public List<Role> roleList() {
        return roleService.list();
    }

    @ModelAttribute("genreListString")
    public List<String> genreListSting() {
        return Arrays.asList("Men", "Women", "Other");
    }
    @PostMapping("/form")
    public String process(@Valid User user, BindingResult result, Model model, SessionStatus status) {
        model.addAttribute("title", "Result of form");
        if (result.hasErrors()) {
            /* Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(err -> errors.put(err.getField(), "El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()))
            );
            model.addAttribute("error", errors);*/
            return "form";
        }
        model.addAttribute("user", user);
        status.setComplete();
        return "result";
    }
}
