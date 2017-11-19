package poker.services.handmatchers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import poker.model.PokerHand;

@Service
@Order(2)
public class StraightFlushMatchingService implements HandMatcher {
    private static final String DESCRIPTION = "Straight flush";

    @Autowired
    private StraightMatchingService straightMatchingService;

    @Autowired
    private FlushMatchingService flushMatchingService;

    @Override
    public String description() {
        return DESCRIPTION;
    }

    @Override
    public boolean matches(PokerHand hand) {
        return straightMatchingService.matches(hand) && flushMatchingService.matches(hand);
    }
}
