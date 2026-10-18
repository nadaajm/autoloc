package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entities.Contrat;
import tn.esprit.autoloc.repository.ContratRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContratServiceImpl implements IContratService {

    ContratRepository contratRepository;

    public List<Contrat> retrieveAllContrats() {
        return contratRepository.findAll();
    }

    public Contrat retrieveContrat(Long contratId) {
        return contratRepository.findById(contratId).get();
    }

    public Contrat addContrat(Contrat c) {
        return contratRepository.save(c);
    }

    public void removeContrat(Long contratId) {
        contratRepository.deleteById(contratId);
    }

    public Contrat modifyContrat(Contrat contrat) {
        Contrat existing = contratRepository.findById(contrat.getIdContrat()).get();
        existing.setDateSignature(contrat.getDateSignature());
        existing.setMontantTotal(contrat.getMontantTotal());
        existing.setValide(contrat.getValide());
        existing.setReservation(contrat.getReservation());
        return contratRepository.save(existing);
    }

}
