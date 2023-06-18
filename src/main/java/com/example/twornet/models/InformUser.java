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

    @Column(name="umor")
    private double umor;
    @Column(name="marshrut")
    private double marshrut;
    @Column(name ="punktualnost")
    private double punktualnost;
    @Column(name="opryatnost")
    private double opryatnost;
    @Column(name="mestnost")
    private double mestnost;
    @Column(name="beseda")
    private double beseda;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User user;

}
