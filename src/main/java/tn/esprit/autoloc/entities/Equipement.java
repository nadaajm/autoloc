package tn.esprit.autoloc.entities;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "equipement")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Equipement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipement;

    @Column(nullable = false, length = 150)
    private String libelle;

    @JsonIgnore
    @ManyToMany(mappedBy = "equipements", fetch = FetchType.LAZY)
    private Set<Vehicule> vehicules;
}

