package it.selecta.cards.models.exceptions;

import lombok.Getter;

/**
 * Segnalazione di un valore non valido nella costruzione di una carta.
 */
public class InvalidValueRuntimeException extends CardRuntimeException {
	private static final long serialVersionUID = 1L;

	/**
	 * Il valore non valido che ha causato l'eccezione.
	 */
	@Getter
	private final int invalidValue;

	/**
	 * Costruttore.
	 * 
	 * @param invalidValue il valore non valido che ha causato l'eccezione.
	 */
	public InvalidValueRuntimeException(int invalidValue) {
		super("Invalid value in card");
		this.invalidValue = invalidValue;
	}
}
