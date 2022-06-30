package cours.java.springboot.certificationbackend.services;

import cours.java.springboot.certificationbackend.dtos.FiliereDTO;
import cours.java.springboot.certificationbackend.entities.Filiere;
import cours.java.springboot.certificationbackend.exceptions.FiliereNotFoundExecption;
import cours.java.springboot.certificationbackend.mappers.MapperDTO;
import cours.java.springboot.certificationbackend.repositories.FiliereRepositorie;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class FiliereService implements IFiliereService {
    private FiliereRepositorie filiereRepositorie;
    private MapperDTO mapperDTO;

    public FiliereService(FiliereRepositorie filiereRepositorie, MapperDTO mapperDTO) {
        this.filiereRepositorie = filiereRepositorie;
        this.mapperDTO = mapperDTO;
    }

    @Override
    public List<FiliereDTO> getAllFiliere() {
        List<Filiere>filiereList=filiereRepositorie.findAll();
        List<FiliereDTO> filiereDTOList=filiereList.stream()
                .map(filiere ->mapperDTO.fromFiliere(filiere))
                .collect(Collectors.toList());
        return filiereDTOList;
    }
    @Override
    public FiliereDTO getOnFiliere(Long id) throws FiliereNotFoundExecption {
        Filiere filiere=filiereRepositorie.findById(id)
                .orElseThrow(()->new FiliereNotFoundExecption("Cette filiere n'exite pas"));
        FiliereDTO filiereDTO=mapperDTO.fromFiliere(filiere);
        return filiereDTO;
    }
    @Override
    public void existeFiliere(String libelle) throws FiliereNotFoundExecption {
        Filiere filiere=filiereRepositorie.getFiliereByLibelle(libelle);
        if (filiere!=null) throw new FiliereNotFoundExecption("Cette filiere existe deja");

    }
    @Override
    public FiliereDTO saveFiliere(FiliereDTO filiereDTO) throws FiliereNotFoundExecption {
        Filiere filiere=mapperDTO.fromFiliereDTO(filiereDTO);
        existeFiliere(filiere.getLibelle());
        Filiere filiereSaved=filiereRepositorie.save(filiere);
        return filiereDTO;
    }
    @Override
    public FiliereDTO updateFiliere(FiliereDTO filiereDTO){
        Filiere filiere=mapperDTO.fromFiliereDTO(filiereDTO);
        Filiere filiereUpdated=filiereRepositorie.save(filiere);
        return filiereDTO;
    }
    @Override
    public void deleteFiliere(long id) throws FiliereNotFoundExecption {
        getOnFiliere(id);
        filiereRepositorie.deleteById(id);
    }
}
