package poker.services.handmatchers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import poker.model.PokerHand;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.groupingBy;

@Service
@Order(9)
public class OnePairMatchingService implements HandMatcher {
    private static final String DESCRIPTION = "One pair";
    private static final List<Integer> MATCHING_RANK_COUNTS = Arrays.asList(1, 1, 1, 2);

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
