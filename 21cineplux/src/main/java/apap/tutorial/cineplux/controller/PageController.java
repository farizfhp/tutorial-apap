package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PageController {
    @Autowired
    private UserService userService;

    @RequestMapping("")
    public String home(Model model, final HttpServletRequest httpreq){
        String role = userService.findUserbyUsername(httpreq.getRemoteUser()).getRole().getRole();
        model.addAttribute("role", role);
        return "home";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}