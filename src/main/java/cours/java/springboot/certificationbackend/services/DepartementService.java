package cours.java.springboot.certificationbackend.services;

import cours.java.springboot.certificationbackend.dtos.DepartementDTO;
import cours.java.springboot.certificationbackend.entities.Departement;
import cours.java.springboot.certificationbackend.exceptions.DepartementNotFoundException;
import cours.java.springboot.certificationbackend.mappers.MapperDTO;
import cours.java.springboot.certificationbackend.repositories.DepartementRepositorie;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DepartementService implements IDepartement {
    private MapperDTO mapperDTO;
    private DepartementRepositorie departementRepositorie;

    public DepartementService(MapperDTO mapperDTO, DepartementRepositorie departementRepositorie) {
        this.mapperDTO = mapperDTO;
        this.departementRepositorie = departementRepositorie;
    }

    @Override
    public List<DepartementDTO> departementDtoList() {
        List<Departement>departementList=departementRepositorie.findAll();
        List<DepartementDTO>departementDTOS=departementList.stream()
                .map(departement -> mapperDTO.fromDepartement(departement))
                .collect(Collectors.toList());
        return departementDTOS;
    }

    @Override
    public DepartementDTO getOneDepartement(Long id) throws DepartementNotFoundException {
        Departement departement=departementRepositorie.findById(id)
                .orElseThrow(()->new DepartementNotFoundException("Ce departement n'existe pas"));
        return mapperDTO.fromDepartement(departement);
    }

    @Override
    public void getDepartementByNomDepartement(String nomDepartement) throws DepartementNotFoundException {
        Departement departement=departementRepositorie.getDepartementByNomDepartement(nomDepartement);
        if (departement!=null) throw new DepartementNotFoundException("Ce departement existe deja");
    }

    @Override
    public DepartementDTO saveDepartement(DepartementDTO departementDTO) throws DepartementNotFoundException {
        Departement departement=mapperDTO.fromDepartementDTO(departementDTO);
        getDepartementByNomDepartement(departement.getNomDepartement());
        Departement departementSaved=departementRepositorie.save(departement);
        return mapperDTO.fromDepartement(departementSaved);
    }

    @Override
    public DepartementDTO updateDepartement(DepartementDTO departementDTO) {
        Departement departement=mapperDTO.fromDepartementDTO(departementDTO);
        Departement departementUpdated=departementRepositorie.save(departement);
        return mapperDTO.fromDepartement(departementUpdated);
    }

    @Override
    public void deleteDepartement(Long id) throws DepartementNotFoundException {
        Departement departement=departementRepositorie.findById(id)
                .orElseThrow(() -> new DepartementNotFoundException("Departement innexistant"));
        try {
            departementRepositorie.delete(departement);
        }catch (Exception e){
            throw new  DepartementNotFoundException("Impossible de supprimer un departement dans lequel figure des administrateur");
        }
    }
}
