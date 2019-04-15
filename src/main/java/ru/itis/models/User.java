package ru.itis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"user\"", schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;
    private String hashPassword;
    private String name;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @ManyToMany(mappedBy = "card_members")
    private List<Card> cards;

    @ManyToMany(mappedBy = "desk_members")
    private List<Desk> desks;

    @OneToMany(mappedBy = "author")
    private List<Comment> comments;

    public User(String login, String hashPassword, String name, Role role) {
        this.login = login;
        this.hashPassword = hashPassword;
        this.name = name;
        this.role = role;
    }
}
