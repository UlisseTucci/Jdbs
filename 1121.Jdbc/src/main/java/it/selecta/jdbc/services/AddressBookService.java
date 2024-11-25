package it.selecta.jdbc.services;

import java.util.List;

import it.selecta.jdbc.entities.Contact;
import it.selecta.jdbc.entities.PhoneNumber;

public interface AddressBookService {
	/**
	 * Prende un contatto e lo aggiunge al database.
	 * 
	 * @param contact il contatto da aggiungere.
	 */
	void addContact(Contact contact);

	/**
	 * Modifica un contatto.
	 * 
	 * @param contactId chiave del contatto da modificare.
	 * @param contact   i dati con cui modificare il contatto.
	 */
	void updateContact(int contactId, Contact contact);

	/**
	 * Elimina un contatto e tutti i numeri di telefono ad esso associati.
	 * 
	 * @param contactId chiave del contatto da eliminare.
	 */
	void deleteContact(int contactId);

	/**
	 * Aggiunge un numero di telefono ad un contatto.
	 * 
	 * @param contactId chiave del contatto proprietario del numero di telefono.
	 * @param number    il numero di telefono da aggiungere.
	 */
	void addPhoneNumber(int contactId, PhoneNumber number);

	/**
	 * Elimina un numero di telefono.
	 * 
	 * @param phoneNumberId chiave del numero di telefono da eliminare.
	 */
	void deletePhoneNumber(int phoneNumberId);

	/**
	 * @return tutti i contatti in rubrica.
	 */
	List<Contact> getAllContacts();

	/**
	 * Cerca un contatto a partire dal numero di telefono.
	 * 
	 * @param phoneNumber il numero di telefono.
	 * @return il contatto associato al numero di telefono.
	 */
	// TODO: cosa succede se non ci sono contatti con quel numero?
	Contact getContactByPhoneNumber(String phoneNumber);

	/**
	 * Recupera i contatti sulla base di una parte del nome o del cognome.
	 * 
	 * @param namePart    parte del nome da cercare.
	 * @param surnamePart parte del cognome da cercare.
	 * @return i contatti che rispondono alle specifiche.
	 */
	List<Contact> getAllContactsByName(String namePart, String surnamePart);
}
