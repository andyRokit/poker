package poker.model;

import poker.ApplicationException;

import java.util.Arrays;

public enum Suit {
    DIAMONDS('D'),
    CLUBS('C'),
    HEARTS('H'),
    SPADES('S');

    private char symbol;

    Suit(char symbol) {
        this.symbol = symbol;
    }

    public static Suit fromSymbol(char symbol) {
        return Arrays.stream(Suit.values())
                .filter(e -> e.symbol == symbol)
                .findFirst()
                .orElseThrow(() -> new ApplicationException(symbol + " is not a valid suit"));
    }

    public char toSymbol() {
        return this.symbol;
    }
}
