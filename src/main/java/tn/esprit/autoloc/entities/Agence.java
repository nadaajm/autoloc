package tn.esprit.autoloc.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "agence")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;

    @Column(nullable = false, length = 100)
    private String nom;

    @Column(nullable = false, length = 100)
    private String ville;

    @Column(nullable = false, length = 255)
    private String adresse;

    @Column(nullable = false, length = 30)
    private String telephone;

    @JsonIgnore
    @OneToMany(mappedBy = "agence", fetch = FetchType.LAZY)
    private List<Employe> employes;

    @JsonIgnore
    @OneToMany(mappedBy = "agence", fetch = FetchType.LAZY)
    private List<Vehicule> vehicules;
}