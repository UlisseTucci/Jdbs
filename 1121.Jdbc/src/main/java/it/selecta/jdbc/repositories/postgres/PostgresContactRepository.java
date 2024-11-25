package it.selecta.jdbc.repositories.postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import it.selecta.jdbc.entities.Contact;
import it.selecta.jdbc.repositories.ContactRepository;

@Component
@Scope("singleton")
public class PostgresContactRepository implements ContactRepository {

	private static final Logger log = LoggerFactory.getLogger(PostgresContactRepository.class);
	/**
	 * Gestisce tutta la comunicazione con il database.
	 */
	private final Connection connection;

	private static final String URL = "jdbc:postgresql://127.0.0.1:5432/corso?currentSchema=rubrica";
	private static final String username = "postgres";
	private static final String password = "postgres";

	public PostgresContactRepository() throws SQLException {
		connection = DriverManager.getConnection(URL, username, password);
	}

	private static final String INSERT_CMD = "INSERT INTO contatti(id, nome, cognome) VALUES(?, ?, ?)";

	@Override
	public void create(Contact contact) {
		try {
			// creo il comando (statement)
			try (var stmt = connection.prepareStatement(INSERT_CMD)) {
				// valorizzo i parametri
				stmt.setInt(1, contact.getId());
				stmt.setString(2, contact.getName());
				stmt.setString(3, contact.getSurname());
				// a questo punto posso eseguire il comando
				stmt.execute();
			}
		} catch (SQLException e) {
			log.error("Ci sono problemi", e);
		}
	}

	private static final String UPDATE_CMD = "UPDATE contatti SET nome = ?, cognome = ? WHERE id = ?";

	@Override
	public void update(int contactId, Contact contact) {
		try {
			// creo il comando (statement)
			try (var stmt = connection.prepareStatement(UPDATE_CMD)) {
				// valorizzo i parametri
				stmt.setInt(3, contact.getId());
				stmt.setString(1, contact.getName());
				stmt.setString(2, contact.getSurname());
				// a questo punto posso eseguire il comando
				stmt.execute();
			}
		} catch (SQLException e) {
			log.error("Ci sono problemi", e);
		}
	}

	private static final String DELETE_CMD = "DELETE FROM contatti WHERE id = ?";

	@Override
	public void delete(int contactId) {
		try {
			// creo il comando (statement)
			try (var stmt = connection.prepareStatement(DELETE_CMD)) {
				// valorizzo i parametri
				stmt.setInt(1, contactId);
				// a questo punto posso eseguire il comando
				stmt.execute();
			}
		} catch (SQLException e) {
			log.error("Ci sono problemi", e);
		}
	}

	private static final String SELECT_ALL_CMD = "SELECT id, nome, cognome FROM contatti";

	@Override
	public List<Contact> findAll() {
		var result = new ArrayList<Contact>();
		try (var stmt = connection.prepareStatement(SELECT_ALL_CMD)) {
			try (var rs = stmt.executeQuery()) {
				while (rs.next()) {
					var id = rs.getInt(1);
					var name = rs.getString(2);
					var surname = rs.getString(3);
					var contact = new Contact(id, name, surname);
					result.add(contact);
				}
			}
		} catch (Exception e) {
			log.error("Ci sono problemi", e);
		}
		return result;
	}
	
	
	private static final String SELECT_CONTACT_BY_NUMBER_CMD = 
		    "SELECT contatti.id, contatti.nome, contatti.cognome " +
		    "FROM contatti " +
		    "JOIN numeri_telefonici ON contatti.id = numeri_telefonici.id_contatto " +
		    "WHERE numeri_telefonici.numero = ?";

	@Override
	public Contact getContactByPhoneNumber(String phoneNumber) {
		try (var stmt = connection.prepareStatement(SELECT_CONTACT_BY_NUMBER_CMD)) {
			stmt.setString(1, phoneNumber);
			try (var rs = stmt.executeQuery()) {
				if (rs.next()) {
					var id = rs.getInt(1);
					var name = rs.getString(2);
					var surname = rs.getString(3);
					return new Contact(id, name, surname);
				}
			}
		} catch (Exception e) {
			log.error("Ci sono problemi", e);
		}
		return null;
	}

}
