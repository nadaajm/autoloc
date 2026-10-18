package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entities.Paiement;

import java.util.List;

public interface IPaiementService {

    public List<Paiement> retrieveAllPaiements();
    public Paiement retrievePaiement(Long paiementId);
    public Paiement addPaiement(Paiement c);
    public void removePaiement(Long paiementId);
    public Paiement modifyPaiement(Paiement paiement);

}
