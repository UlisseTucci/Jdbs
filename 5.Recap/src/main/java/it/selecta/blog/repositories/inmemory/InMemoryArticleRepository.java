package it.selecta.blog.repositories.inmemory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import it.selecta.blog.entities.Article;
import it.selecta.blog.repositories.ArticleRepository;

//@Component
//@Scope("singleton")
public class InMemoryArticleRepository implements ArticleRepository {

	private static int nextId = 1;
	
	private static final Set<Article> articles = new HashSet<>();

	@Override
	public void create(Article a) {
		a.setId(nextId);
		articles.add(a);
		nextId++;
	}

	@Override
	public Article findById(int id) {
		return articles.stream().filter(a -> a.getId() == id).findAny().orElse(null);
	}

	@Override
	public void delete(int id) {
		var old = findById(id);
		if (old != null)
			articles.remove(old);
	}

	@Override
	public void update(int id, Article a) {
		var old = findById(id);
		if (old != null) {
			articles.remove(old);
			a.setId(old.getId());
			articles.add(a);
		}
	}

	@Override
	public List<Article> findAll() {
		return articles.stream().toList();
	}

	@Override
	public List<Article> findAllByEmail(String email) {
		return articles.stream().filter(a -> a.getAutor().getEmail().equals(email)).toList();
	}

}
