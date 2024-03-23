package tn.bal.pi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class SousCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;
    @Column(name = "name")
    private String nom;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "sousCategories")
    private CategoryProjects categoriesProjects;
}
