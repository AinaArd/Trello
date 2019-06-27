package ru.itis.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "task", schema = "public")
@ToString(exclude = {"card", "desk"})
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String text;
    private String picturePath;

    private LocalDate term;

    @Column(name = "flag")
    private boolean flag;

    @Enumerated(EnumType.STRING)
    private TaskState state;

    @JsonIgnore
    @LazyCollection(LazyCollectionOption.TRUE)
    @ManyToOne
    @JoinColumn(name = "cardId")
    private Card card;

    @LazyCollection(LazyCollectionOption.TRUE)
    @ManyToMany(mappedBy = "tasks", cascade = CascadeType.ALL)
    private List<User> users;

    @LazyCollection(LazyCollectionOption.TRUE)
    @OrderBy("id")
    @OneToMany(mappedBy = "task")
    private List<Comment> comments;

    @JsonIgnore
    @LazyCollection(LazyCollectionOption.TRUE)
    @ManyToOne
    @JoinColumn(name = "deskId")
    private Desk desk;

//    @Transient
//    @Value("${my.files.url}")
//    private String path;

    public String getPicturePath() {
        return "C:\\AinaArd\\images\\" + picturePath;
    }

    public boolean getFlag() {
        return this.flag;
    }
}
