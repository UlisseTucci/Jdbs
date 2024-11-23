package it.selecta.cards.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

// equals e hashCode basati su tutti gli attributi della classe.
@EqualsAndHashCode
// Costruttore che prevede la valorizzazione di tutti gli attributi.
// L'accesso è consentito solo alle sottoclassi (protected). 
@AllArgsConstructor(access = AccessLevel.PROTECTED)
/**
 * Una carta da gioco
 */
public abstract class Card {
	/**
	 * Il seme.
	 */
	@Getter
	private int seed;
	/**
	 * Il valore.
	 */
	@Getter
	private int value;
}
