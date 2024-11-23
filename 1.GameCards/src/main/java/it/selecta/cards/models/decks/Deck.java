package it.selecta.cards.models.decks;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import it.selecta.cards.models.Card;

/**
 * Un mazzo di carte.
 * 
 * @param <C> il tipo di carta mantenuto nel mazzo di carte.
 */
public abstract class Deck<C extends Card> implements Iterable<C> {
	/**
	 * Le carte nel mazzo.
	 */
	protected final List<C> cards;

	/**
	 * Costruttore (protected, perché richiamabile solo dalle sottoclassi, visto che
	 * la classe è astratta).
	 */
	protected Deck() {
		cards = new LinkedList<>();

		initialize();
	}

	/**
	 * Richiamato dal costruttore per mettere le carte nel mazzo (ecco perché è
	 * protected).
	 */
	protected abstract void initialize();

	/**
	 * Iteratore sulle carte (usiamo lo stesso iteratore della lista di carte, tanto
	 * lo scopo è quello di scorrere quella lista!!!).
	 */
	@Override
	public Iterator<C> iterator() {
		return cards.iterator();
	}

	/**
	 * Mescola il mazzo di carte.
	 */
	public void shuffle() {
		// la classe Collections (con la s finale) è una classe di utilità che contiene
		// tanti metodi utili
		Collections.shuffle(cards);
	}

}
