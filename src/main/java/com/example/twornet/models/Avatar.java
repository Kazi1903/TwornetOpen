package com.example.twornet.models;


import lombok.*;

import javax.persistence.*;

@Table(name = "avatar")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Avatar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "originalFileName")
    private String originalFileName;
    @Column(name = "size")
    private Long size;
    @Column(name = "contentType")
    private String contentType;
    @Lob
    private byte[] bytes;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User user;
}
