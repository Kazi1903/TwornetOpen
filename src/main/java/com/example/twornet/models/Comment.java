package com.example.twornet.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(name = "review")
    String review;
    @Column(name = "rating")
    int rating;
    @Column(name = "name_of_created")
    String nameOfCreated;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn
    private User user;

    // private LocalDateTime dateOfCreated;
    @JoinColumn(name = "date_of_created")
    private String dateOfCreated;

    @PrePersist
    private void init() {
        int min1, hours1, day1, month1, year1;
        LocalDateTime data;
        data = LocalDateTime.now();
        min1 = data.getMinute();
        hours1 = data.getHour();
        day1 = data.getDayOfMonth();
        month1 = data.getMonthValue();
        year1 = data.getYear();
        dateOfCreated = Integer.toString(day1) + "." + Integer.toString(month1) + "." + Integer.toString(year1) + " " + Integer.toString(hours1) + ":" + Integer.toString(min1);
    }
}
