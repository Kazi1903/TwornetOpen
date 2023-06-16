package com.example.twornet.controllers;

import com.example.twornet.models.InformUser;
import com.example.twornet.models.User;
import com.example.twornet.services.ProductService;
import com.example.twornet.services.UserService;
import lombok.RequiredArgsConstructor;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ProductService productService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(User user, Model model,@RequestParam("file1") MultipartFile file1) throws IOException {
        if (!userService.createUser(user,file1)) {
            model.addAttribute("errorMessage", "Пользователь с email: " + user.getEmail() + " уже существует");
            return "registration";
        }
        return "redirect:/login";
    }

    @GetMapping("/user/{user}")
    public String userInfo(@PathVariable("user") User user, Model model, Principal principal) {
        model.addAttribute("user", user);
        model.addAttribute("products", user.getProducts());
        model.addAttribute("comment", user.getComments());
        model.addAttribute("avatar", user.getAvatar());
        model.addAttribute("polzovatel", productService.getUserByPrincipal(principal));
        // model.addAttribute("info", user.getInformUsers());
        model.addAttribute("info", user.getInformUser());
        return "user-info";
    }

    @GetMapping("/lk")
    public String TestlkInfo(Principal principal, Model model) {
        User user = new User();
        user = productService.getUserByPrincipal(principal);
        model.addAttribute("user", productService.getUserByPrincipal(principal));
        model.addAttribute("products", user.getProducts());
        model.addAttribute("info", user.getInformUser());
        model.addAttribute("avatar", user.getAvatar());
        return "lk";
    }

    @GetMapping("/edit_my_info")
    public String getEditUserInfo(Principal principal, Model model) {
        User user = new User();
        user = productService.getUserByPrincipal(principal);
        model.addAttribute("user", productService.getUserByPrincipal(principal));
        model.addAttribute("info", user.getInformUser());
        return "edit_info_user";
    }

    @PostMapping("/edit_info_user")
    public String editUserInfo(Principal principal, User user1, InformUser informUser1) {
        User user = productService.getUserByPrincipal(principal);
        InformUser informUser = user.getInformUser();
        userService.editUser(user, user1, informUser, informUser1);

        return "redirect:/lk";
    }

    @GetMapping(value = "/css/{cssFile}")
    public @ResponseBody byte[] getFile(@PathVariable("cssFile") String cssFile) throws IOException {

        InputStream in = getClass()
                .getResourceAsStream("/css/" + cssFile);
        try {
            return in.readAllBytes();
        } catch (Exception e) {
            var error = new String("ERROR: css file (/css/" + cssFile + ") not found");
            return error.getBytes();
        }
    }

    @GetMapping(value = "/js/{jsFile}")
    public @ResponseBody byte[] getJsFile(@PathVariable("jsFile") String jsFile) throws IOException {

        InputStream in = getClass()
                .getResourceAsStream("/js/" + jsFile);
        try {
            return in.readAllBytes();
        } catch (Exception e) {
            var error = new String("ERROR: js file (/js/" + jsFile + ") not found");
            return error.getBytes();
        }

    }
}
