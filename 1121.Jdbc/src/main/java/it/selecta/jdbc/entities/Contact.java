package it.selecta.jdbc.entities;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
	private int id;
	private String name;
	private String surname;
	@Getter
	private final List<PhoneNumber> numbers = new ArrayList<>();
}
