package it.selecta.blog.entities;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
	private int id;
	private Author author;
	private Article article;
	private String content;
	private LocalDateTime publicationDate;
}
