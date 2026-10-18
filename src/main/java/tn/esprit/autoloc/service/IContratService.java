package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entities.Contrat;

import java.util.List;

public interface IContratService {

    public List<Contrat> retrieveAllContrats();
    public Contrat retrieveContrat(Long contratId);
    public Contrat addContrat(Contrat c);
    public void removeContrat(Long contratId);
    public Contrat modifyContrat(Contrat contrat);

}
