package com.blog.database.domain;

import lombok.*;

import javax.persistence.*;

/**
 * @author Mikhail Mikhailenko
 */
@Entity
@Table(name = "blog")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String body;

    @Column(nullable = false)
    private Data data;


    public Blog(String title, String body, Data data) {
        this.title = title;
        this.body = body;
        this.data = data;
    }
}
