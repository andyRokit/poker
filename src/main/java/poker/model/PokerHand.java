package poker.model;

import poker.ApplicationException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PokerHand extends ArrayList<PlayingCard> {
    public static PokerHand fromString(final String text) {
        final List<PlayingCard> cards = Stream.of(text.split(" "))
                .map(PlayingCard::fromString)
                .collect(Collectors.toList());

        return new PokerHand(cards);
    }

    public PokerHand(final List<PlayingCard> cards) {
        super(cards);

        if (cards.size() != 5) {
            throw new ApplicationException(String.format("Hand [%s] does not contain 5 cards", this));
        }
    }

    @Override
    public String toString() {
        return stream()
                .map(PlayingCard::toString)
                .collect(Collectors.joining(" "));
    }
}
