package fr.esic.mastering.services;
 
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import fr.esic.mastering.entities.Formation;

import fr.esic.mastering.repository.FormationRepository;
 
import java.util.List;

import java.util.Optional;
 
@Service

public class FormationService {
 
    @Autowired

    private FormationRepository formationRepository;
 
    public List<Formation> getAllFormations() {

        return formationRepository.findAll();

    }
 
    public Optional<Formation> getFormationById(Long id) {

        return formationRepository.findById(id);

    }
 
    public Formation createFormation(Formation formation) {

        return formationRepository.save(formation);

    }
 
    public void deleteFormation(Long id) {

        formationRepository.deleteById(id);

    }

}

 