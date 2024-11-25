package it.selecta.jdbc.repositories;

import java.util.List;

import it.selecta.jdbc.entities.Contact;

public interface ContactRepository {
	/**
	 * Aggiunge un contatto alla tabella dei contatti del database.
	 * 
	 * @param contact dati da aggiungere.
	 */
	void create(Contact contact);

	/**
	 * Modifica un contatto esistente nella tabella dei contatti.
	 * 
	 * @param contactId chiave.
	 * @param contact   dati.
	 */
	void update(int contactId, Contact contact);

	/**
	 * Elimina un contatto dalla tabella.
	 * 
	 * @param contactId chiave.
	 */
	void delete(int contactId);

	/**
	 * Recupera tutti i contatti.
	 * 
	 * @return l'elenco di tutti i contatti.
	 */
	List<Contact> findAll();
	
	/**
	 * Recupera un contatto da un numero di telefono
	 * 
	 * @param phoneNumber stringa del numero di telefono
	 */
	Contact getContactByPhoneNumber(String phoneNumber);
}
