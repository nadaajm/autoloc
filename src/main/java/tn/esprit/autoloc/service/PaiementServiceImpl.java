package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entities.Paiement;
import tn.esprit.autoloc.repository.PaiementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaiementServiceImpl implements IPaiementService {

    PaiementRepository paiementRepository;

    public List<Paiement> retrieveAllPaiements() {
        return paiementRepository.findAll();
    }

    public Paiement retrievePaiement(Long paiementId) {
        return paiementRepository.findById(paiementId).get();
    }

    public Paiement addPaiement(Paiement c) {
        return paiementRepository.save(c);
    }

    public void removePaiement(Long paiementId) {
        paiementRepository.deleteById(paiementId);
    }

    public Paiement modifyPaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

}
