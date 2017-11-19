package poker.model;

import poker.ApplicationException;

import java.util.Arrays;

public enum Rank {
    TWO('2'),
    THREE('3'),
    FOUR('4'),
    FIVE('5'),
    SIX('6'),
    SEVEN('7'),
    EIGHT('8'),
    NINE('9'),
    TEN('T'),
    JACK('J'),
    QUEEN('Q'),
    KING('K'),
    ACE('A');

    private char symbol;

    Rank(char symbol) {
        this.symbol = symbol;
    }

    public static Rank fromSymbol(char symbol) {
        return Arrays.stream(Rank.values())
                .filter(e -> e.symbol == symbol)
                .findFirst()
                .orElseThrow(() -> new ApplicationException(symbol + " is not a valid rank"));
    }

    public char toSymbol() {
        return this.symbol;
    }
}
