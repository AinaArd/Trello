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
@Table(name = "desk", schema = "public")
public class Desk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private DeskState state;

    @ManyToMany(mappedBy = "desks")
    private List<User> users;

    @OneToMany(mappedBy = "deskCards")
    private List<Card> cards;

    @ManyToOne
    @JoinColumn(name = "owner")
    private User owner;


}
