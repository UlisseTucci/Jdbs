package it.selecta.blog.services;

import java.util.List;

import it.selecta.blog.entities.Comment;

public interface CommentService {
	void write(Comment c);

	void update(int commentId, Comment c);

	void delete(int commentId);

	List<Comment> getAllByArticleId(int articleId);
}
