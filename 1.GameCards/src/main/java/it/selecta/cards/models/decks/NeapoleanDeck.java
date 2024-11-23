package it.selecta.cards.models.decks;

import it.selecta.cards.models.NeapoleanCard;
import it.selecta.cards.models.NeapoleanCard.Seeds;

public class NeapoleanDeck extends Deck<NeapoleanCard> {

	/**
	 * Inizializzazione del mazzo di carte napoletane.
	 */
	@Override
	protected void initialize() {
		// 4 semi
		for (int s = 0; s < 4; s++) {
			// 10 valori per seme
			for (int v = 1; v < 11; ++v) {
				cards.add(
						// uso del builder
						NeapoleanCard.builder()
								// impostazione del seme
								.withSeed(Seeds.values()[s])
								// impostazione del valore
								.withValue(v)
								// creazione della carta
								.build());
			}
		}
	}

}
