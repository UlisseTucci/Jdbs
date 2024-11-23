package it.selecta.blog.services.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import it.selecta.blog.entities.Comment;
import it.selecta.blog.services.CommentService;

@Component
public class CommentServiceImpl implements CommentService {

	@Override
	public void write(Comment c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(int commentId, Comment c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int commentId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Comment> getAllByArticleId(int articleId) {
		// TODO Auto-generated method stub
		return null;
	}

}
