package ru.itis.models;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import ru.itis.forms.EditForm;
import ru.itis.forms.UserForm;

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

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany
    @JoinColumn(name = "userId")
    private List<Desk> desks;

//    @LazyCollection(LazyCollectionOption.TRUE)
//    @OneToMany(mappedBy = "author")
//    private List<Comment> comments;

    @LazyCollection(LazyCollectionOption.TRUE)
    @ManyToMany
    @JoinColumn(name = "userId")
    private List<Task> tasks;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private List<Desk> ownDesks;
}
