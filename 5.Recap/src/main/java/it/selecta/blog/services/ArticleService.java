package it.selecta.blog.services;

import java.util.List;

import it.selecta.blog.entities.Article;

public interface ArticleService {
	void write(Article a);

	void update(int articleId, Article a);

	void delete(int articleId);

	List<Article> getAll();

	List<Article> getAllByAuthor(String email);

	Article getById(int articleId);
}
