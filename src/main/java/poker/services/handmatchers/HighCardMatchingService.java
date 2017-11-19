package poker.services.handmatchers;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import poker.model.PokerHand;

@Service
@Order(10)
public class HighCardMatchingService implements HandMatcher {
    private static final String DESCRIPTION = "High card";

    public String description() {
        return DESCRIPTION;
    }

    public boolean matches(final PokerHand hand) {
        return true;
    }
}
