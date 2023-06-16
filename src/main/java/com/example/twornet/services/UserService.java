package com.example.twornet.services;

import com.example.twornet.models.Avatar;
import com.example.twornet.models.Image;
import com.example.twornet.models.InformUser;
import com.example.twornet.models.User;
import com.example.twornet.models.enums.Role;
import com.example.twornet.repositories.AvatarRepository;
import com.example.twornet.repositories.InformUserRepository;
import com.example.twornet.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final InformUserRepository informUserRepository;
    private final AvatarRepository avatarRepository;

    public boolean createUser(User user, MultipartFile file1) throws  IOException{
        String email = user.getEmail();
        if (userRepository.findByEmail(email) != null) return false;

        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.ROLE_USER);

        Avatar avatar = new Avatar();


        avatar= toAvatarEntity(file1);
        avatar.setUser(user);

        InformUser informUser = new InformUser();
        informUser.setUser(user);
        informUser.setInform("Не заполнено");
        informUser.setObrazovanie("Не заполнено");
        informUser.setYearsJobs("Не заполнено");
        log.info("Saving new User with email: {}", email);
        userRepository.save(user);
        informUserRepository.save(informUser);
        avatarRepository.save(avatar);
        return true;
    }

    public boolean editUser(User user, User user1, InformUser informUser, InformUser informUser1) {
        String email = user.getEmail();
        if (userRepository.findByEmail(email) == null) return false;

        user.setLastName(user1.getLastName());
        user.setName(user1.getName());
        user.setFatherName(user1.getFatherName());
        user.setPhoneNumber(user1.getPhoneNumber());

        informUser.setUser(user);
        informUser.setInform(informUser1.getInform());
        informUser.setObrazovanie(informUser1.getObrazovanie());
        informUser.setYearsJobs(informUser1.getYearsJobs());

        userRepository.save(user);
        informUserRepository.save(informUser);
        return true;
    }

    public List<User> list() {
        return userRepository.findAll();
    }

    public void banUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            if (user.isActive()) {
                user.setActive(false);
                log.info("Ban user with id = {}; email: {}", user.getId(), user.getEmail());
            } else {
                user.setActive(true);
                log.info("Unban user with id = {}; email: {}", user.getId(), user.getEmail());
            }
        }
        userRepository.save(user);
    }

    public void changeUserRoles(User user, Map<String, String> form) {
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());
        user.getRoles().clear();
        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userRepository.save(user);
    }

    private Avatar toAvatarEntity(MultipartFile file) throws IOException {
        Avatar avatar = new Avatar();
        avatar.setName(file.getName());
        avatar.setOriginalFileName(file.getOriginalFilename());
        avatar.setContentType(file.getContentType());
        avatar.setSize(file.getSize());
        avatar.setBytes(file.getBytes());
        return avatar;
    }
}
