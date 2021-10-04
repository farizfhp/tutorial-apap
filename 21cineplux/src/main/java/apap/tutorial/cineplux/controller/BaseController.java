package apap.tutorial.cineplux.controller;
import apap.tutorial.cineplux.model.BioskopModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.LocalTime;
import java.util.Arrays;

@Controller
public class BaseController {
    @GetMapping("/")
    private String home(
        @ModelAttribute BioskopModel bioskop,
        Model model
    ) {
            model.addAttribute("time", LocalTime.now());
            return "home";
        }
}
