package it.selecta.cards.models.decks;

import it.selecta.cards.models.FrenchCard;

/**
 * Un mazzo di carte francesi.
 */
public class FrenchDeck extends Deck<FrenchCard> {

	/**
	 * Inizializza il mazzo di carte inserendo le carte francesi.
	 */
	@Override
	protected void initialize() {
		// 4 semi
		for (int s = 0; s < 4; s++) {
			// 13 valori per seme
			for (int v = 1; v < 14; ++v) {
				cards.add(
						// uso del builder
						FrenchCard.builder()
								// impostazione del seme
								.withSeed(FrenchCard.Seeds.values()[s])
								// impostazione del valore
								.withValue(v)
								// creazione effettiva della carta con i valori impostati in precedenza
								.build());
			}
		}
		// aggiunta del joker rosso
		cards.add(FrenchCard.builder().redJoker());
		// aggiunta del joker nero
		cards.add(FrenchCard.builder().blackJoker());
	}

}
