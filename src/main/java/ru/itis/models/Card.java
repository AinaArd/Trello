package ru.itis.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(exclude = {"desk_cards", "card_tasks"})
@Table(name = "card", schema = "public")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "desk_cards")
    private Desk desk_cards;

    @OneToMany(mappedBy = "card")
    private List<Task> card_tasks;
}

// TODO: прикрепление файлов/фото, чеклисты, упоминания в комментах
