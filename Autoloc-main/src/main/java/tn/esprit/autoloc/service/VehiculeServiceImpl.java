package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entity.Vehicule;
import tn.esprit.autoloc.repository.IVehiculeRepository;
import tn.esprit.autoloc.repository.IEquipementRepository;
import tn.esprit.autoloc.Entity.Equipement;


import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class VehiculeServiceImpl implements IVehiculeService {

    private final IVehiculeRepository vehiculeRepository;
    private final IEquipementRepository equipementRepository;

    @Override
    public Vehicule create(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public List<Vehicule> findAll() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Optional<Vehicule> findById(Long id) {
        return vehiculeRepository.findById(id);
    }

    @Override
    public Vehicule update(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public void delete(Long id) {
        vehiculeRepository.deleteById(id);
    }


    @Override
    public Vehicule affecterEquipement(Long idVehicule, Long idEquipement) {
        // 1. Récupérer le véhicule
        Vehicule vehicule = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new RuntimeException("Véhicule non trouvé"));

        // 2. Récupérer l'équipement
        Equipement equipement = equipementRepository.findById(idEquipement)
                .orElseThrow(() -> new RuntimeException("Équipement non trouvé"));

        // 3. Ajouter l'équipement à la liste du véhicule (côté PROPRIÉTAIRE)
        vehicule.getEquipements().add(equipement);

        // 4. Sauvegarder → JPA insère une ligne dans vehicule_equipement
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new RuntimeException("Véhicule non trouvé"));

        Equipement equipement = equipementRepository.findById(idEquipement)
                .orElseThrow(() -> new RuntimeException("Équipement non trouvé"));

        // Retirer de la liste → JPA supprime la ligne dans vehicule_equipement
        vehicule.getEquipements().remove(equipement);

        return vehiculeRepository.save(vehicule);
    }
    // Q1 : démarre après 5 s, puis toutes les 60 s
    @Scheduled(initialDelay = 5000, fixedRate = 60000)
    public void actualiserEtatVehicules() {
        List<Vehicule> vehicules = vehiculeRepository.findAll();

        System.out.println("Nombre total de véhicules : " + vehicules.size());
        System.out.println("Actualisation effectuée le : " +
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
    }

    // Q3 : tous les lundis à 09h00
    @Scheduled(cron = "0 0 9 ? * MON")
    public void genererRapportVehicules() {
        List<Vehicule> vehicules = vehiculeRepository.findAll();
        int total = vehicules.size();

        System.out.println("===== Rapport des véhicules =====");
        System.out.println("Nombre total de véhicules : " + total);
        System.out.println("Généré le : " +
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
    }
}