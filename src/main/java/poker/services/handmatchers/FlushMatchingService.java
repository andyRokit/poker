package poker.services.handmatchers;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import poker.model.PlayingCard;
import poker.model.PokerHand;
import poker.model.Suit;

import java.util.Map;
import java.util.stream.Collectors;

@Service
@Order(5)
public class FlushMatchingService implements HandMatcher {
    private static final String DESCRIPTION = "Flush";

    public String description() {
        return DESCRIPTION;
    }

    @Override
    public boolean matches(PokerHand hand) {
        final Map<Suit, Integer> countBySuit = hand.stream()
                .collect(
                        Collectors.groupingBy(
                                PlayingCard::getSuit,
                                Collectors.summingInt(x -> 1)));

        return countBySuit.size() == 1;
    }
}
