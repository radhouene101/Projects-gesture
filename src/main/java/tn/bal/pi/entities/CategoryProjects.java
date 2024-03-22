package tn.bal.pi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category_project")
@Builder
public class CategoryProjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategoryProject")
    private Long id;
    @Column(name = "name")
    private String nom;
    @Column(name = "description")
    private String description;
}
