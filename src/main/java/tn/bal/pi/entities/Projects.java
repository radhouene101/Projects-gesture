package tn.bal.pi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "projects")
@Builder
public class Projects  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idProject")
    private Long id;
    @Column(name="name")
    private String nom;
    @Column(name="group_project")
    private String group;
    @Column(name="is_nominated")
    private boolean isNominated;
    @Column(name="submit_date")
    private Date date;
    @Column(name="vote_number")
    private int numberOfVotes;
    @Column(name="winner")
    private boolean winner;
    @Enumerated(EnumType.STRING)
    private TypeNiveau niveau;
    @ManyToOne
    private Option optionSpeciality;
    @ManyToOne
    private CategoryProjects category;



}
