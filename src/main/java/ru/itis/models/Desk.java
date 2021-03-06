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

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(mappedBy = "desks", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<User> users;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "desk", fetch = FetchType.LAZY)
    private List<Card> cards;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "desk", fetch = FetchType.LAZY)
    private List<Task> tasks;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner")
    private User owner;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "desk", fetch = FetchType.LAZY)
    private List<Message> messages;

}
