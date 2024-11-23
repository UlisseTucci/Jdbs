package it.selecta.cards.models;

import it.selecta.cards.models.exceptions.InvalidValueRuntimeException;

/**
 * Una carta da gioco napoletana.
 */
public class NeapoleanCard extends Card {

	/**
	 * Semi napoletani.
	 */
	public enum Seeds {
		/**
		 * Denari.
		 */
		DENARI,
		/**
		 * Coppe.
		 */
		COPPE,
		/**
		 * Spade.
		 */
		SPADE,
		/**
		 * Bastoni.
		 */
		BASTONI
	}

	/**
	 * Costruttore (privato perché la classe non è instanziabile direttamente ma
	 * solo attraverso il Builder).
	 * 
	 * @param seed  seme.
	 * @param value valore.
	 */
	private NeapoleanCard(int seed, int value) {
		super(seed, value);
	}

	@Override
	public String toString() {
		// il sette di denari è detto settebello
		if (getValue() == 7 && getSeed() == 0)
			return "settebello";
		String[] v = { "asso", "due", "tre", "quattro", "cinque", "sei", "sette", "donna", "cavallo", "re" };
		// leggo il seme direttamente dalla enum (values() restituisce un array con
		// tutti i valori, quindi prendo quello del seme attuale e ne leggo il nome
		// tramite name()
		String s = Seeds.values()[getSeed()].name().toLowerCase();
		return String.format("%s di %s", v[getValue() - 1], s);
	}

	/**
	 * @return un builder per la carta da gioco.
	 */
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Classe che implementa la costruzione della carta "a pezzi".
	 */
	public static class Builder {
		/**
		 * Seme.
		 */
		private int seed;
		/**
		 * Valore.
		 */
		private int value;

		/**
		 * Imposta il valore.
		 * 
		 * @param value il valore della carta.
		 * @return il valore di this per consentire chiamate concatenate.
		 */
		public Builder withValue(int value) {
			if (value < 1 || value > 10) // se il valore non è valido...
				// ... lancio un'eccezione
				throw new InvalidValueRuntimeException(value);
			this.value = value;
			return this;
		}

		/**
		 * Imposta il seme.
		 * 
		 * @param seed il seme della carta.
		 * @return il valore di this per consentire chiamate concatenate.
		 */
		public Builder withSeed(Seeds seed) {
			this.seed = seed.ordinal();
			return this;
		}

		/**
		 * @return la carta napoletana con i valori impostati attraverso i metodi
		 *         withXXX().
		 */
		public NeapoleanCard build() {
			return new NeapoleanCard(seed, value);
		}
	}
}
