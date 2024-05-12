package com.company.controller;

import com.company.entity.User;
import com.company.form.UserForm;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserServiceInter userService;

//    @RequestMapping(method = RequestMethod.GET, value = "/users")
//    public ModelAndView index(
//                        @RequestParam(value = "name", required = false) String name,
//                        @RequestParam(value = "surname", required = false) String surname,
//                        @RequestParam(value = "nid", required = false) Integer nationalityId){
//        List<User> users = userService.getAll(name,surname,nationalityId);
//        ModelAndView mv = new ModelAndView("users");
//        mv.addObject("users", users);
//
//        return mv;
//    }

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public ModelAndView index(@Valid @ModelAttribute("user") UserForm u, BindingResult bindingResult){
        ModelAndView mv = new ModelAndView("users");
        if (bindingResult.hasErrors()){
            return mv;
        }

        List<User> users = users = userService.getAll(u.getName(), u.getSurname(), u.getNationalityId());

        mv.addObject("users", users);

        return mv;
    }

    @ModelAttribute("user")
    public UserForm getEmptyUserForm(){
        return new UserForm();
    }
}
