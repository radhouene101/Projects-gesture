package tn.bal.pi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Projects  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idProject")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="group_name")
    private String groupName;
    @Column(name="nominated")
    private boolean nominated;
    @Column(name="submit_date")
    private Date date;
    @Column(name="vote_number")
    private int numberOfVotes;
    @Column(name = "groupStreak")
    private int groupStreak;
    @Column(name="winner")
    private boolean winner;
    @Enumerated(EnumType.STRING)
    private TypeNiveau niveau;
    @ManyToOne
    @JoinColumn(name = "option_id")
    private Option optionSpeciality;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryProjects category;
    private String coach;
    private boolean votingpool;
    private String scolarYear;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private  User user;
    @ManyToOne(optional = true)
    private Contest contest;




}
