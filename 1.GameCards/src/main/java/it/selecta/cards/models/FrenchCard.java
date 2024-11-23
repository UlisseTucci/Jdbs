package it.selecta.cards.models;

import it.selecta.cards.models.exceptions.InvalidValueRuntimeException;

/**
 * Una carta da gioco francese.
 */
public class FrenchCard extends Card {

	/**
	 * I semi della carta da gioco francese.
	 */
	public enum Seeds {
		/**
		 * Cuori.
		 */
		HEARTS,
		/**
		 * Quadri.
		 */
		DIAMONDS,
		/**
		 * Fiori.
		 */
		CLUBS,
		/**
		 * Picche.
		 */
		SPADES
	}

	/**
	 * Valore utilizzato per indicare il joker.
	 */
	public static final int JOKER_VALUE = 14;
	/**
	 * Seme utilizzato per il joker rosso.
	 */
	public static final Seeds RED_JOKER_SEED = Seeds.HEARTS;
	/**
	 * Seme utilizzato per il joker nero.
	 */
	public static final Seeds BLACK_JOKER_SEED = Seeds.SPADES;

	/**
	 * Costruttore (privato perché la classe non è instanziabile direttamente ma
	 * solo attraverso il Builder).
	 * 
	 * @param seed  seme.
	 * @param value valore.
	 */
	private FrenchCard(int seed, int value) {
		super(seed, value);
	}

	@Override
	public String toString() {
		// output per un joker
		if (getValue() == JOKER_VALUE) {
			return getSeed() == RED_JOKER_SEED.ordinal() ? "RED JOKER" : "BLACK JOKER";
		}
		String[] v = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
		// leggo il seme direttamente dalla enum (values() restituisce un array con
		// tutti i valori, quindi prendo quello del seme attuale e ne leggo il nome
		// tramite name()
		String s = Seeds.values()[getSeed()].name();
		return String.format("%s of %s", v[getValue() - 1], s);
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
			if (value < 1 || value > 13) // se il valore non è valido...
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
		 * @return la carta francese con i valori impostati attraverso i metodi
		 *         withXXX().
		 */
		public FrenchCard build() {
			return new FrenchCard(seed, value);
		}

		/**
		 * @return un joker rosso.
		 */
		public FrenchCard redJoker() {
			return new FrenchCard(RED_JOKER_SEED.ordinal(), JOKER_VALUE);
		}

		/**
		 * @return un joker nero.
		 */
		public FrenchCard blackJoker() {
			return new FrenchCard(BLACK_JOKER_SEED.ordinal(), JOKER_VALUE);
		}
	}
}
