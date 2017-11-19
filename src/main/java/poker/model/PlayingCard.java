package poker.model;

import poker.ApplicationException;

public class PlayingCard {
    private Rank rank;
    private Suit suit;

    public PlayingCard(final Rank rank, final Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public static PlayingCard fromString(final String text) {
        if(text.length() != 2) {
            throw new ApplicationException("Not a valid card format: " + text);
        }

        return new PlayingCard(
                Rank.fromSymbol(text.charAt(0)),
                Suit.fromSymbol(text.charAt(1))
        );
    }

    @Override
    public String toString() {
        return String.valueOf(new char[]{rank.toSymbol(), suit.toSymbol()});
    }
}
