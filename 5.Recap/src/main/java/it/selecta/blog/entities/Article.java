package it.selecta.blog.entities;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// l'annotazione seguente genera equals e hashCode
// onlyExplicitlyIncluded indica che nella logica di questi due metodi
//      devono essere inclusi solo i campi che sono esplicitamente marcati
// 		con l'annotazione @EqualsAndHashCode.Include
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Article {
	// l'annotazione seguente include il campo id in equals e hashCode
	@EqualsAndHashCode.Include
	private int id;
	private Author autor;
	private String title;
	private String content;
	private LocalDateTime publicationDate;
	/*
	 * Uguale a questo:
	 * 
	 * @Override public boolean equals(Object obj) { return obj instanceof Article
	 * && obj.hashCode() == hashCode(); }
	 * 
	 * @Override public int hashCode() { return Objects.hash(id); }
	 * 
	 */
}
