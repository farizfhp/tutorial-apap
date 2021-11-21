package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.model.RoleModel;
import apap.tutorial.cineplux.model.UserModel;
import apap.tutorial.cineplux.service.RoleService;
import apap.tutorial.cineplux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/add")
    private String addUserFormPage(Model model){
        UserModel user = new UserModel();
        List<RoleModel> listRole = roleService.getListRole();
        model.addAttribute("user", user);
        model.addAttribute("listRole", listRole);
        return "form-add-user" ;
    }

    @PostMapping(value = "/add")
    private String addUsersubmit(@ModelAttribute UserModel user, Model model) {
        userService.addUser(user);
        model.addAttribute("user", user);
        return "redirect:/";
    }

    @GetMapping("/viewall")
    private String viewAllUser(Model model){
        List<UserModel> listUser = userService.getListUser();
        model.addAttribute("listUser", listUser);
        return "viewall-user" ;
    }

    @GetMapping("/changepassword")
    private String changePasswordForm(
            @RequestParam(value = "username", required = true) String username,
            Model model
    ){
        model.addAttribute("user", userService.findUserbyUsername(username));
        return "form-change-password";
    }

    @PostMapping(value = "/changepassword")
    private String changePasswordSubmit(
            @ModelAttribute String gajelas, String oldPassword, String newPassword, String confirmPassword, Model model, final HttpServletRequest httpreq
    ) {
        UserModel user = userService.findUserbyUsername(httpreq.getRemoteUser());
        if (userService.isMatch(oldPassword, user.getPassword())){
            if (!oldPassword.equals(newPassword)){
                if (newPassword.equals(confirmPassword)){
                    userService.setPassword(user, newPassword);

                    model.addAttribute("message", "Password berhasil diubah");

                }else {
                    model.addAttribute("message", "Password konfirmasi tidak sama");
                }
            }
            else {
                model.addAttribute("message", "Password lama dan baru sama");
            }

        }else {
            model.addAttribute("message", "Password lama salah");
        }
        return "home";
    }

    @GetMapping("/delete/{username}")
    public String deleteUser(
            @PathVariable(required = false) String username,
            Model model
    ){
        if (username == null) {
            model.addAttribute("command", "delete");
            model.addAttribute("type", "user");
            model.addAttribute("message", "Anda tidak memasukkan username");
            return "failed";
        }
        UserModel user = userService.findUserbyUsername(username);
        if(username == null) {
            model.addAttribute("command", "delete");
            model.addAttribute("type", "penjaga");
            model.addAttribute("message", "Tidak ada penjaga dengan nomor tersebut");
            return "failed";
        }
        model.addAttribute("message", "user telah dihapus");
        model.addAttribute("namaUser", user.getNama());
        model.addAttribute("username", user.getUsername());
        userService.deleteUser(user);
        List<UserModel> listUser = userService.getListUser();
        model.addAttribute("listUser", listUser);
        return "viewall-user" ;
    }
}