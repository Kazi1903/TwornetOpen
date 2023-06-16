package com.example.twornet.models;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "informUser")
@Setter

@Getter

@AllArgsConstructor
@NoArgsConstructor
public class InformUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name="o_sebe",columnDefinition="TEXT")
    private String inform;
    @Column(name="obrazovanie")
    private String obrazovanie;
    @Column(name="years_jobs")
    private String yearsJobs;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User user;

}
