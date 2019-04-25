package ru.itis.models;

import lombok.*;
import ru.itis.forms.EditForm;

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

    @ManyToMany(mappedBy = "deskMembers")
    private List<Desk> desks;

    @OneToMany(mappedBy = "author")
    private List<Comment> comments;

    public User(String login, String hashPassword, String name) {
        this.login = login;
        this.hashPassword = hashPassword;
        this.name = name;
    }

    public static User from(EditForm editForm){
        return User.builder()
                .login(editForm.getLogin())
                .name(editForm.getName())
                .hashPassword(editForm.getPassword())
                .build();
    }
}
