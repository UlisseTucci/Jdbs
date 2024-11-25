package it.selecta.jdbc.services;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import it.selecta.jdbc.entities.Contact;
import it.selecta.jdbc.entities.PhoneNumber;
import it.selecta.jdbc.repositories.ContactRepository;
import it.selecta.jdbc.repositories.PhoneNumberRepository;

@Component
@Scope("prototype")
public class AddressBookServiceImpl implements AddressBookService {

	private final ContactRepository contacts;
	private final PhoneNumberRepository numbers;

	public AddressBookServiceImpl(ContactRepository contacts, PhoneNumberRepository numbers) {
		this.contacts = contacts;
		this.numbers = numbers;
	}

	@Override
	public void addContact(Contact contact) {
		contacts.create(contact);
	}

	@Override
	public void updateContact(int contactId, Contact contact) {
		contacts.update(contactId, contact);

	}

	@Override
	public void deleteContact(int contactId) {
		contacts.delete(contactId);

	}

	@Override
	public void addPhoneNumber(int contactId, PhoneNumber number) {
		numbers.create(contactId, number);
	}

	@Override
	public void deletePhoneNumber(int phoneNumberId) {
		numbers.delete(phoneNumberId);

	}

	@Override
	public List<Contact> getAllContacts() {
		var contactList = contacts.findAll();
		contactList.forEach(c -> {
			// recupera i numeri di telefono del contatto c
			var n = numbers.findAllByContact(c.getId());
			c.getNumbers().addAll(n);
		});
		return contactList;
	}

	@Override
	public Contact getContactByPhoneNumber(String phoneNumber) {
		return contacts.getContactByPhoneNumber(phoneNumber);
	}

	@Override
	public List<Contact> getAllContactsByName(String namePart, String surnamePart) {
		var contatcList = contacts.findAll().stream().filter(c -> c.getName().contains(namePart) || c.getSurname().contains(surnamePart)).toList();          
		return contatcList;
	}

}
