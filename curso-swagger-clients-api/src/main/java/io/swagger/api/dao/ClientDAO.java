package io.swagger.api.dao;

import io.swagger.model.Client;
import io.swagger.model.Clients;
import org.springframework.beans.BeanUtils;
import org.threeten.bp.LocalDate;
import org.threeten.bp.OffsetDateTime;

import java.util.Optional;
import java.util.Random;

// Classe substituta do BD
public class ClientDAO {

    private static Clients clients;

    public ClientDAO() {
        clients = new Clients();
        clients.add(mockInitial());
    }

    public Clients findAll() {
        return clients;
    }

    public Client save(Client client) {
        client.setId(generateId());
        client.setLastUpdate(OffsetDateTime.now());
        client.setStatus(true);

        clients.add(client);

        return client;
    }

    public Client update(Integer id, Client client) {
        Optional<Client> clientOptional = clients.stream().filter(c -> c.getId().equals(id)).findAny();

        if (clientOptional.isPresent()) {
            Client clientPersisted = clientOptional.get();

            BeanUtils.copyProperties(client, clientPersisted, "id", "status");
            clientPersisted.setLastUpdate(OffsetDateTime.now());
            clients.set(clients.indexOf(clientPersisted), clientPersisted);

            return clientPersisted;
        }

        return null;
    }

    public boolean delete(Integer id) {
        return clients.removeIf(c -> c.getId().equals(id));
    }

    public Client findById(Integer id) {
        Integer idToRead = null;

        for (Client client : clients) {
            if (client.getId().equals(id)) {
                idToRead = clients.indexOf(client);
            }
        }

        if (idToRead != null) {
            return clients.get(idToRead);
        }

        return null;
    }

    public Clients findByLastName(String lastName) {
        Clients result = new Clients();

        clients.stream()
                .filter(c -> c.getLastName().toLowerCase().contains(lastName.toLowerCase()))
                .forEach(result::add);

        return result;
    }

    public Client updateStatus(Integer id, String status) {
        Client clientPersisted = findById(id);

        if (clientPersisted != null) {
            clientPersisted.setStatus(status.equalsIgnoreCase("active"));
            clientPersisted.setLastUpdate(OffsetDateTime.now());
            clients.set(clients.indexOf(clientPersisted), clientPersisted);
        }

        return clientPersisted;
    }

    private Client mockInitial() {
        Client client = new Client();
        client.setId(125);
        client.setName("Bruno César");
        client.setLastName("Vicente");
        client.setInitials("BCV");
        client.setStatus(Boolean.TRUE);
        client.setType(Client.TypeEnum.INTERN);
        client.setBirthDate(LocalDate.of(1996, 3, 12));
        client.setLastUpdate(OffsetDateTime.now());

        return client;
    }

    private Integer generateId() {
        double random = Math.random() * 112;
        return new Random().nextInt((int) random) + 132;
    }
}
