package it.selecta.jdbc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneNumber {
	private int id;
	private String prefix;
	private String number;
}
