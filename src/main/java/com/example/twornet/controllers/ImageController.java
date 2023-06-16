package com.example.twornet.controllers;

import com.example.twornet.models.Avatar;
import com.example.twornet.models.Image;
import com.example.twornet.repositories.AvatarRepository;
import com.example.twornet.repositories.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;

@RestController
@RequiredArgsConstructor
public class ImageController {
    private final ImageRepository imageRepository;
    private final AvatarRepository avatarRepository;

    @GetMapping("/images/{id}")
    private ResponseEntity<?> getImageById(@PathVariable Long id) {
        Image image = imageRepository.findById(id).orElse(null);
        return ResponseEntity.ok()
                .header("fileName", image.getOriginalFileName())
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(image.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(image.getBytes())));
    }

    @GetMapping("/avatar/{id}")
    private ResponseEntity<?> getAvatarById(@PathVariable Long id) {
        Avatar avatar = avatarRepository.findById(id).orElse(null);
        return ResponseEntity.ok()
                .header("fileName", avatar.getOriginalFileName())
                .contentType(MediaType.valueOf(avatar.getContentType()))
                .contentLength(avatar.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(avatar.getBytes())));
    }
}
