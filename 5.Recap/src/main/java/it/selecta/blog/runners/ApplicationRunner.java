package it.selecta.blog.runners;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.selecta.blog.entities.Article;
import it.selecta.blog.entities.Author;
import it.selecta.blog.entities.Comment;
import it.selecta.blog.services.ArticleService;
import it.selecta.blog.services.CommentService;

@Component
public class ApplicationRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(ApplicationRunner.class);

	private final ArticleService articleService;
	private final CommentService commentService;

	public ApplicationRunner(ArticleService articleService, CommentService commentService) {
		this.articleService = articleService;
		this.commentService = commentService;
	}

	@Override
	public void run(String... args) throws Exception {
		var currentUser = new Author(1, "Archimede", "pitagorico@paperopoli.com", "archi");

		// TODO: siamo proprio sicuri che ai servizi arrivino tutte queste
		// informazioni?
		var article = new Article(1, currentUser, "Articolo 1", "Contenuto dell'articolo n. 1", //
				LocalDateTime.now().minusYears(1));
		articleService.write(article);
		var comment = new Comment(1, currentUser, article, "Contenuto del commento all'articolo n. 1", //
				LocalDateTime.now());
		commentService.write(comment);

		var article2 = new Article(1234, currentUser, "Articolo 2", "Contenuto dell'articolo n. 2", //
				LocalDateTime.now());
		articleService.write(article2);

		articleService.getAll().forEach(a -> log.info("{}", a));
	}

}
