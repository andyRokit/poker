package poker.services.handmatchers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import poker.model.PokerHand;

import java.util.Arrays;
import java.util.List;

@Service
@Order(3)
public class FourOfAKindMatchingService implements HandMatcher {
    private static final String DESCRIPTION = "Four of a kind";
    private static final List<Integer> MATCHING_RANK_COUNTS = Arrays.asList(1, 4);

    @Autowired
    private RankCountService rankCountService;

    public String description() {
        return DESCRIPTION;
    }

    public boolean matches(final PokerHand hand) {
        List<Integer> rankCounts = rankCountService.countRanks(hand);
        return MATCHING_RANK_COUNTS.equals(rankCounts);
    }
}
