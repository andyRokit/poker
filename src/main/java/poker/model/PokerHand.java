package poker.model;

import poker.ApplicationException;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PokerHand extends ArrayList<PlayingCard> {
    public static PokerHand fromString(final String text) {
        final PokerHand hand = new PokerHand();
        Stream.of(text.split(" "))
                .map(PlayingCard::fromString)
                .forEach(hand::add);

        if (hand.size() != 5) {
            throw new ApplicationException(String.format("Hand [%s] does not contain 5 cards", text));
        }

        return hand;
    }

    @Override
    public String toString() {
        return stream()
                .map(PlayingCard::toString)
                .collect(Collectors.joining(" "));
    }
}
