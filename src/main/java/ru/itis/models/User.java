package ru.itis.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import ru.itis.transfer.TaskDto;
//import ru.itis.validation.Login;

import javax.persistence.*;
import java.util.ArrayList;
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
    private Double coordinateX;
    private Double coordinateY;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany
    @JoinColumn(name = "userId")
    private List<Desk> desks;

    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private List<Task> tasks;

    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "owner")
    @OrderBy(value = "id")
    private List<Desk> ownDesks;

    public int desksNumber(){
      return ownDesks.size();
    }

    public int tasksNumber(){
        return tasks.size();
    }

}
