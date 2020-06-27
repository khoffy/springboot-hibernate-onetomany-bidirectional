package com.khoffylabs.Hibernatemapping.web;

import com.khoffylabs.Hibernatemapping.dao.ClientRepository;
import com.khoffylabs.Hibernatemapping.dao.ItemRepository;
import com.khoffylabs.Hibernatemapping.entities.Client;
import com.khoffylabs.Hibernatemapping.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class WebController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping(path = "/clients")
    public List<Client> clientList() {
        return clientRepository.findAll();
    }

    @GetMapping(path = "/items")
    public List<Item> itemList() {
        return itemRepository.findAll();
    }

    @PostMapping(path="/ajouterAchat", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Client> ajouterAchat(@RequestBody Client stageClient) {
        Client new_client = new Client();
        new_client.setLastName(stageClient.getLastName());
        new_client.setFirstName(stageClient.getFirstName());
        stageClient.getItems().forEach(item -> {
            new_client.addItem(item);
        });
        clientRepository.save(new_client);
        return clientRepository.findAll();
    }
}
