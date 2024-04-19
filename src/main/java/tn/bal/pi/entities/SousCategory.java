package tn.bal.pi.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "sous_category_project")
public class SousCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sousCategoryId")
    private Long id;
    @Column(name = "name")
    private String nom;
    @Column(name = "description")
    private String description;
//    @ManyToOne
//    @JoinColumn(name = "sousCategories")
//    private CategoryProjects categoriesProjects;
}
