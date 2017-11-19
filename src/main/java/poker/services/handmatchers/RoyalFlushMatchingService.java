package poker.services.handmatchers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import poker.model.PokerHand;
import poker.model.Rank;

import static poker.model.Rank.ACE;
import static poker.model.Rank.KING;

@Service
@Order(1)
public class RoyalFlushMatchingService implements HandMatcher {
    private static final String DESCRIPTION = "Royal flush";

    @Autowired
    private StraightFlushMatchingService straightFlushMatchingService;

    @Override
    public String description() {
        return DESCRIPTION;
    }

    @Override
    public boolean matches(PokerHand hand) {
        return straightFlushMatchingService.matches(hand) && containsRank(hand, ACE) && containsRank(hand, KING);
    }

    private boolean containsRank(final PokerHand hand, final Rank rank) {
        return hand.stream().anyMatch(card -> card.getRank().equals(rank));
    }
}
