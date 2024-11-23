package it.selecta.blog.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import it.selecta.blog.entities.Article;
import it.selecta.blog.entities.Author;
import it.selecta.blog.repositories.ArticleRepository;
import it.selecta.blog.services.ArticleService;

@Component
@Scope("prototype")
public class ArticleServiceImpl implements ArticleService {

	// supponiamo che ci sia un servizio di sistema che valorizzi l'utente corrente
	private static final Author currentUser = new Author(1, "Admin", "admin@mysite.com", "admin");
	
	private final ArticleRepository articleRepository;

	public ArticleServiceImpl(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}

	@Override
	public void write(Article a) {
		// salva l'articolo da qualche parte per consentirne il recupero in futuro
		// ma prima VALIDA l'informazione prima si salvarla
		a.setPublicationDate(LocalDateTime.now());
		a.setAutor(currentUser);
		articleRepository.create(a);
	}

	@Override
	public void update(int articleId, Article a) {
		// recupera l'articolo identificato dall'id passato come parametro
		// lo modifica prendendo i dati dall'articolo passato
		// lo salva nuovamente da qualche parte
		var old = articleRepository.findById(articleId);
		if (old != null) {
			articleRepository.update(articleId, a);
		}
	}

	@Override
	public void delete(int articleId) {
		// controlliamo che l'articolo esista
		var old = articleRepository.findById(articleId);
		// e se esiste lo eliminiamo dal contenitore
		if (old != null)
			articleRepository.delete(articleId);
	}

	@Override
	public List<Article> getAll() {
		// recupera tutti gli articoli da dove sono stati precedentemente salvati
		// e li mette in una lista
		return articleRepository.findAll();
	}

	@Override
	public List<Article> getAllByAuthor(String email) {
		// fa più o meno la stessa cosa del metodo precedente...
		return articleRepository.findAllByEmail(email);
	}

	@Override
	public Article getById(int articleId) {
		// recupera, dal posto in cui sono salvati gli articoli, solo l'articolo
		// che ha l'id passato (se esiste)
		var a = articleRepository.findById(articleId);
		if (a != null)
			return a;
		// perché se non esiste dobbiamo capire cosa succede!!!
		return null;
	}

}
