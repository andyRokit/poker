package poker.services.handmatchers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import poker.model.PokerHand;

import java.util.Arrays;
import java.util.List;

@Service
@Order(7)
public class ThreeOfAKindMatchingService implements HandMatcher {
    private static final String DESCRIPTION = "Three of a kind";
    private static final List<Integer> MATCHING_RANK_COUNTS = Arrays.asList(1, 1, 3);

    @Autowired
    private RankCountService rankCountService;

    public String description() {
        return DESCRIPTION;
    }

    public boolean matches(final PokerHand hand) {
        final List<Integer> rankCounts = rankCountService.countRanks(hand);
        return MATCHING_RANK_COUNTS.equals(rankCounts);
    }
}
