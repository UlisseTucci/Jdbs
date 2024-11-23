package it.selecta.blog.repositories;

import java.util.List;

import it.selecta.blog.entities.Article;

// Gestisce il "CONTENITORE" dove vengono conservati i dati
public interface ArticleRepository {
	void create(Article a);

	Article findById(int id);

	void delete(int id);

	void update(int id, Article a);

	List<Article> findAll();

	List<Article> findAllByEmail(String email);
}
