package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entities.Equipement;
import tn.esprit.autoloc.repository.EquipementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EquipementServiceImpl implements IEquipementService {

    EquipementRepository equipementRepository;

    public List<Equipement> retrieveAllEquipements() {
        return equipementRepository.findAll();
    }

    public Equipement retrieveEquipement(Long equipementId) {
        return equipementRepository.findById(equipementId).get();
    }

    public Equipement addEquipement(Equipement c) {
        return equipementRepository.save(c);
    }

    public void removeEquipement(Long equipementId) {
        equipementRepository.deleteById(equipementId);
    }

    public Equipement modifyEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

}
