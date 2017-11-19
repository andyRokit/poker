package poker.services.handmatchers;

import poker.model.PokerHand;

public interface HandMatcher {
    String description();
    boolean matches(PokerHand hand);
}
