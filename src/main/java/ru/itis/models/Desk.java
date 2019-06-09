package ru.itis.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name = "desk", schema = "public")
public class Desk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private DeskState state;

    @ManyToMany(mappedBy = "desks", cascade = CascadeType.ALL)
    private List<User> users;

    @OneToMany(mappedBy = "desk")
    private List<Card> cards;

    @OneToMany(mappedBy = "desk")
    private List<Task> tasks;

    @ManyToOne
    @JoinColumn(name = "owner")
    private User owner;

    @OneToMany(mappedBy = "desk")
    private List<Message> messages;

}
