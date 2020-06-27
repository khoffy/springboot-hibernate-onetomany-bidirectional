package com.khoffylabs.Hibernatemapping;

import com.khoffylabs.Hibernatemapping.dao.ClientRepository;
import com.khoffylabs.Hibernatemapping.dao.ItemRepository;
import com.khoffylabs.Hibernatemapping.entities.Client;
import com.khoffylabs.Hibernatemapping.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@SpringBootApplication
public class HibernateMappingApplication implements CommandLineRunner {
	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ItemRepository itemRepository;

	public static void main(String[] args) {
		SpringApplication.run(HibernateMappingApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Client client1 = new Client();
		client1.setFirstName("Naruto");
		client1.setLastName("UZUMAKI");

		Item item1 = new Item();
		item1.setDesignation("ProductA");
		item1.setPrix(252.50);
		item1.setClient(client1);

		Item item2 = new Item();
		item2.setDesignation("ProductB");
		item2.setPrix(1500.50);
		item2.setClient(client1);

		clientRepository.save(client1);

		Client client2 = new Client();
		client2.setFirstName("Sasuke");
		client2.setLastName("UTCHIWA");

		Item item3 = new Item();
		item3.setDesignation("ProductC");
		item3.setPrix(252.50);
		item3.setClient(client2);

		Item item4 = new Item();
		item4.setDesignation("ProductD");
		item4.setPrix(1500.50);
		item4.setClient(client2);

		clientRepository.save(client2);
	}
}
