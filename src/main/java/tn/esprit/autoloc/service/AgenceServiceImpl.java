package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entities.Agence;
import tn.esprit.autoloc.repository.AgenceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AgenceServiceImpl implements IAgenceService {

    AgenceRepository agenceRepository;

    public List<Agence> retrieveAllAgences() {
        return agenceRepository.findAll();
    }

    public Agence retrieveAgence(Long agenceId) {
        return agenceRepository.findById(agenceId).get();
    }

    public Agence addAgence(Agence c) {
        return agenceRepository.save(c);
    }

    public void removeAgence(Long agenceId) {
        agenceRepository.deleteById(agenceId);
    }

    public Agence modifyAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

}
