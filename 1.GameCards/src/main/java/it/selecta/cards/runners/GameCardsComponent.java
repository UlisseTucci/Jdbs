package it.selecta.cards.runners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.selecta.cards.models.Card;
import it.selecta.cards.models.decks.Deck;
import it.selecta.cards.models.decks.FrenchDeck;
import it.selecta.cards.models.decks.NeapoleanDeck;

@Component
public class GameCardsComponent implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(GameCardsComponent.class);

	private void printDeck(Deck<? extends Card> deck) {
		for (var c : deck) {
			LOGGER.info("{}", c);
		}
	}

	@Override
	public void run(String... args) throws Exception {
		var nd = new NeapoleanDeck();
		nd.shuffle();
		var fd = new FrenchDeck();
		printDeck(nd);
		printDeck(fd);
	}

}
