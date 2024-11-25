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

import it.selecta.jdbc.entities.PhoneNumber;
import it.selecta.jdbc.repositories.PhoneNumberRepository;

@Component
@Scope("singleton")
public class PostgresPhoneNumberRepository implements PhoneNumberRepository {

	private static final Logger log = LoggerFactory.getLogger(PostgresPhoneNumberRepository.class);
	/**
	 * Gestisce tutta la comunicazione con il database.
	 */
	private final Connection connection;

	private static final String URL = "jdbc:postgresql://127.0.0.1:5432/corso?currentSchema=rubrica";
	private static final String username = "postgres";
	private static final String password = "postgres";

	private static final String INSERT_CMD = "INSERT INTO numeri_telefonici(id, prefisso, numero, id_contatto) VALUES(?, ?, ?, ?)";
	private static final String UPDATE_CMD = "UPDATE numeri_telefonici SET prefisso = ?, numero = ? WHERE id = ?";
	private static final String DELETE_CMD = "DELETE FROM numeri_telefonici WHERE id = ?";

	public PostgresPhoneNumberRepository() throws SQLException {
		connection = DriverManager.getConnection(URL, username, password);
	}

	@Override
	public void create(int contactId, PhoneNumber phone) {
		try {
			// creo il comando (statement)
			try (var stmt = connection.prepareStatement(INSERT_CMD)) {
				// valorizzo i parametri
				stmt.setInt(1, phone.getId());
				stmt.setString(2, phone.getPrefix());
				stmt.setString(3, phone.getNumber());
				stmt.setInt(4, contactId);
				// a questo punto posso eseguire il comando
				stmt.execute();
			}
		} catch (SQLException e) {
			log.error("Ci sono problemi", e);
		}
	}

	@Override
	public void update(int phoneNumberId, PhoneNumber phone) {
		try {
			// creo il comando (statement)
			try (var stmt = connection.prepareStatement(UPDATE_CMD)) {
				// valorizzo i parametri
				stmt.setString(1, phone.getPrefix());
				stmt.setString(2, phone.getNumber());
				stmt.setInt(3, phone.getId());
				// a questo punto posso eseguire il comando
				stmt.execute();
			}
		} catch (SQLException e) {
			log.error("Ci sono problemi", e);
		}
	}

	@Override
	public void delete(int phoneNumberId) {
		try {
			// creo il comando (statement)
			try (var stmt = connection.prepareStatement(DELETE_CMD)) {
				// valorizzo i parametri
				stmt.setInt(1, phoneNumberId);
				// a questo punto posso eseguire il comando
				stmt.execute();
			}
		} catch (SQLException e) {
			log.error("Ci sono problemi", e);
		}
	}

	private static final String SELECT_ALL_BY_CUSTOMER_CMD = //
			"SELECT id, prefisso, numero, id_contatto FROM numeri_telefonici " //
					+ "WHERE id_contatto = ?";

	@Override
	public List<PhoneNumber> findAllByContact(int contactId) {
		var result = new ArrayList<PhoneNumber>();
		try (var stmt = connection.prepareStatement(SELECT_ALL_BY_CUSTOMER_CMD)) {
			stmt.setInt(1, contactId);
			try (var rs = stmt.executeQuery()) {
				while (rs.next()) {
					var id = rs.getInt(1);
					var prefix = rs.getString(2);
					var number = rs.getString(3);
					var phone = new PhoneNumber(id, prefix, number);
					result.add(phone);
				}
			}
		} catch (SQLException e) {
			log.error("Ci sono problemi", e);
		}
		return result;
	}

}
