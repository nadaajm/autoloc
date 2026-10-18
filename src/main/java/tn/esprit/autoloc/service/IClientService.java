package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entities.Client;

import java.util.List;

public interface IClientService {

    public List<Client> retrieveAllClients();
    public Client retrieveClient(Long clientId);
    public Client addClient(Client c);
    public void removeClient(Long clientId);
    public Client modifyClient(Client client);

}
