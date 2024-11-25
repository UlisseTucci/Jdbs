package it.selecta.jdbc.runners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.selecta.jdbc.entities.Contact;
import it.selecta.jdbc.entities.PhoneNumber;
import it.selecta.jdbc.services.AddressBookService;

@Component
public class TesterRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(TesterRunner.class);

	private final AddressBookService service;

	TesterRunner(AddressBookService service) {
		this.service = service;
	}

	@Override
	public void run(String... args) throws Exception {
		var c1 = new Contact(1, "Paperino", "Paolino");
		var p1 = new PhoneNumber(1, "0000", "1234567890");
		var p2 = new PhoneNumber(2, "0000", "1313131313");
		var c2 = new Contact(2, "Paperon", "De Paperoni");
		/*
		service.addContact(c1);
		service.addContact(c2);
		service.addPhoneNumber(1, p1);
		service.addPhoneNumber(1, p2);
		service.addPhoneNumber(2, new PhoneNumber(3, "4444", "4444444444"));
		*/

		//service.getAllContacts().forEach(i -> log.info("{}", i));
		
		
		log.info("{}",service.getContactByPhoneNumber("1234567890"));
		
		//service.getAllContactsByName("in", "Paoli").forEach(i -> log.info("{}", i));
		
	}

}
