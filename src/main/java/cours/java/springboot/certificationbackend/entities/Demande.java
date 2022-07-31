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
    @Column(columnDefinition="LONGTEXT",length = 2000)
    private String contenu;
    private String telephone;
    private Date dateDemande;
    @Enumerated(EnumType.STRING)
    private Statut statutDemande;
    @ManyToOne
    private Etudiant etudiant;
    @ManyToOne
    private Departement departement;
}
