package it.selecta.blog.repositories.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import it.selecta.blog.entities.Article;
import it.selecta.blog.entities.Author;
import it.selecta.blog.repositories.ArticleRepository;

@Component
@Scope("singleton")
public class PostgreArticleRepository implements ArticleRepository {

	private static final Logger log = LoggerFactory.getLogger(PostgreArticleRepository.class);
	private final Connection connection;
	private static final String URL = "jdbc:postgresql://localhost:5432/corso?currentSchema=blog";
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "postgres";

	private static final String SELECT_ALL = //
			"SELECT id, title, content, publicationdate, author_id " //
					+ "FROM articles";
	private static final String SELECT_ALL_BY_ID = //
			"SELECT id, title, content, publicationdate, author_id " //
					+ "FROM articles " //
					+ "WHERE id = ?";
	private static final String INSERT = //
			"INSERT INTO articles(title, content, publicationdate, author_id) " //
					+ "VALUES(?, ?, ?, ?)";
	private static final String UPDATE = //
			"UPDATE articles " //
					+ "SET title = ?, content = ? " //
					+ "WHERE id = ?";
	private static final String DELETE = "DELETE FROM articles WHERE id = ?";

	public PostgreArticleRepository() throws SQLException {
		connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}

	@Override
	public void create(Article a) {
		try (var stmt = connection.prepareStatement(INSERT)) {
			stmt.setString(1, a.getTitle());
			stmt.setString(2, a.getContent());
			stmt.setDate(3, //
					new java.sql.Date( //
							Date.from(a.getPublicationDate().toInstant(ZoneOffset.ofHours(2))).getTime()));
			stmt.setInt(4, a.getAutor().getId());
			stmt.execute();
		} catch (SQLException e) {
			log.error("Exception", e);
		}
	}

	@Override
	public Article findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(int id, Article a) {
		// TODO Auto-generated method stub

	}

	private Article map(ResultSet rs) throws SQLException {
		return new Article(rs.getInt(1), // leggo l'id
				new Author(rs.getInt(5), "", "", ""), // ancora non lo gestisco
				rs.getString(2), // leggo il titolo
				rs.getString(3), // leggo il contenuto
				// leggo la data
				LocalDateTime.ofInstant(new Date(rs.getDate(4).getTime()).toInstant(), ZoneId.systemDefault()) 
		);
	}

	@Override
	public List<Article> findAll() {
		var result = new ArrayList<Article>();
		try (var stmt = connection.prepareStatement(SELECT_ALL)) {
			try (var rs = stmt.executeQuery()) {
				while (rs.next())
					result.add(map(rs));
			}
		} catch (SQLException e) {
		}
		return result;
	}

	@Override
	public List<Article> findAllByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
