package cours.java.springboot.certificationbackend.dtos;

import cours.java.springboot.certificationbackend.enums.Statut;
import lombok.Data;
import java.awt.*;
import java.util.Date;

@Data
public class DemandeDTO {
    private Long id;
    private String objet;
    private String contenu;
    private Date dateDemande;
    private Statut statutDemande;
    private EtudiantDTO etudiant;
    private DepartementDTO departement;
}
