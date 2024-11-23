package it.selecta.blog.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
	private int id;
	private String username;
	private String email;
	private String displayName;
}
