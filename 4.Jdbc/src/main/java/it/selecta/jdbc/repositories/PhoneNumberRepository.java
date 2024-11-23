package it.selecta.jdbc.repositories;

import java.util.List;

import it.selecta.jdbc.entities.PhoneNumber;

public interface PhoneNumberRepository {
	/**
	 * Aggiunge un numero di telefono ad un contatto.
	 * 
	 * @param contactId chiave del contatto.
	 * @param phone     numero di telefono da aggiungere.
	 */
	void create(int contactId, PhoneNumber phone);

	/**
	 * Modifica un numero di telefono.
	 * 
	 * @param phoneNumberId chiave del numero di telefono da modificare.
	 * @param phone         dati per l'aggiornamento.
	 */

	void update(int phoneNumberId, PhoneNumber phone);

	/**
	 * Elimina un numero di telefono.
	 * 
	 * @param phoneNumberId chiave del numero di telefono da eliminare.
	 */
	void delete(int phoneNumberId);

	/**
	 * Recupera tutti i numeri di telefono di un contatto.
	 * 
	 * @param contactId chiave del contatto.
	 * @return tutti i numeri di telefono del contatto.
	 */
	List<PhoneNumber> findAllByContact(int contactId);
}
