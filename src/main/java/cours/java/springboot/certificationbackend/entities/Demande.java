package cours.java.springboot.certificationbackend.entities;

import cours.java.springboot.certificationbackend.enums.Statut;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.awt.*;
import java.util.Date;

@Entity(name = "demandes")
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String objet;
    private TextArea contenu;
    private Date dateDemande;
    private Statut statutDemande;
    @ManyToOne
    private Etudiant etudiant;
    @ManyToOne
    private Departement departement;
}
