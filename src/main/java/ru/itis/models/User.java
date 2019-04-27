package ru.itis.models;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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

    @LazyCollection(LazyCollectionOption.TRUE)
    @ManyToMany
    @JoinColumn(name = "userId")
    private List<Desk> desks;

//    TODO: make comments of user to tasks
//    @LazyCollection(LazyCollectionOption.TRUE)
//    @OneToMany(mappedBy = "author")
//    private List<Comment> comments;

    @LazyCollection(LazyCollectionOption.TRUE)
    @ManyToMany
    @JoinColumn(name = "userId")
    private List<Task> tasks;

    @LazyCollection(LazyCollectionOption.TRUE)
    @OneToMany(mappedBy = "owner")
    @OrderBy()
    private List<Desk> ownDesks;
}
