package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entities.Client;
import tn.esprit.autoloc.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements IClientService {

    ClientRepository clientRepository;

    public List<Client> retrieveAllClients() {
        return clientRepository.findAll();
    }

    public Client retrieveClient(Long clientId) {
        return clientRepository.findById(clientId).get();
    }

    public Client addClient(Client c) {
        return clientRepository.save(c);
    }

    public void removeClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }

    public Client modifyClient(Client client) {
        return clientRepository.save(client);
    }

}
