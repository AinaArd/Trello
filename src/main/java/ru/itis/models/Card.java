package ru.itis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "card", schema = "public")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "card")
    private List<Comment> comments;

    @ManyToMany
    @JoinColumn(name = "card_members")
    private List<User> card_members;

    @Enumerated(value = EnumType.STRING)
    private CardState state;

    private Date date;

    public Card(String name, String description, CardState state, Date date) {
        this.name = name;
        this.description = description;
        this.state = state;
        this.date = date;
    }
}

// TODO: прикрепление файлов/фото, чеклисты, упоминания в комментах
