package ru.itis.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Created by timurbadretdinov on Apr, 2019
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "task", schema = "public")
@ToString(exclude = "card_id")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;
}
