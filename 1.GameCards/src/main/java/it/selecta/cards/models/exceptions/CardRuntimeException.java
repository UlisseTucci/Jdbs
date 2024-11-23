package it.selecta.cards.models.exceptions;

/**
 * Una eccezione che può verificarsi durante l'uso delle carte da gioco.
 */
public class CardRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore di default.
	 */
	public CardRuntimeException() {
		this("Exception handlings cards");
	}

	/**
	 * Costruttore.
	 * 
	 * @param message messaggio di errore.
	 */
	public CardRuntimeException(String message) {
		super(message);
	}
}
