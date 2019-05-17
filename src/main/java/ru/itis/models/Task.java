package ru.itis.models;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "task", schema = "public")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String text;
    private String picturePath;

    @Column(name = "flag")
    private boolean flag;

    @Enumerated(EnumType.STRING)
    private TaskState state;

    @LazyCollection(LazyCollectionOption.TRUE)
    @ManyToOne
    @JoinColumn(name = "cardId")
    private Card card;

    @LazyCollection(LazyCollectionOption.TRUE)
    @ManyToMany(mappedBy = "tasks", cascade = CascadeType.ALL)
    private List<User> users;

    @LazyCollection(LazyCollectionOption.TRUE)
    @OneToMany(mappedBy = "task")
    private List<Comment> comments;

    @LazyCollection(LazyCollectionOption.TRUE)
    @ManyToOne
    @JoinColumn(name = "deskId")
    private Desk desk;

    public String getPicturePath() {
        return "C:\\AinaArd\\images\\" + picturePath;
    }
}
