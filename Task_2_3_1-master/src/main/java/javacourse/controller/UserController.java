package javacourse.controller;

import javacourse.model.User;
import javacourse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {


    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users-list";
    }

    @GetMapping(value = "user-create")
    public String createUseForm(User user) {
        System.out.println("метод get /user-create");
        return "user-create";
    }

    @PostMapping(value = "user-create")
    public String addUser(User user) {
        System.out.println("метод post /user-create");
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("user-delete")
    public String deleteUser(Long id) {
        userService.deleteUserById(id);
        return "redirect:users";
    }

    @GetMapping(value = "user-update")
    public String updateUserForm(Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping(value = "user-update")
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }
}
