package ru.itis.models;

import lombok.*;

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

    @ManyToMany
    @JoinColumn(name = "desk_members")
    private List<User> deskMembers;

    @OneToMany(mappedBy = "desk_cards")
    private List<Card> cards;

    public Desk(String name) {
        this.name = name;
    }
}
