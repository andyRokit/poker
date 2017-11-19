package poker.services.handmatchers;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import poker.model.PokerHand;

import java.util.List;
import java.util.stream.Collectors;

import static poker.model.Rank.ACE;

@Service
@Order(6)
public class StraightMatchingService implements HandMatcher {
    private static final String DESCRIPTION = "Straight";
    private static final Integer HIGH_ACE_ORDINAL = ACE.ordinal();
    private static final Integer LOW_ACE_ORDINAL = -1;

    public String description() {
        return DESCRIPTION;
    }

    @Override
    public boolean matches(PokerHand hand) {
        final List<Integer> acesHigh = hand.stream()
                .map(card -> card.getRank().ordinal())
                .sorted()
                .collect(Collectors.toList());

        final List<Integer> acesLow = acesHigh.stream()
                .map(ordinal -> ordinal.equals(HIGH_ACE_ORDINAL)?LOW_ACE_ORDINAL:ordinal)
                .sorted()
                .collect(Collectors.toList());

        return isSequential(acesHigh) || isSequential(acesLow);
    }

    private boolean isSequential(final List<Integer> orderedList) {
        for(int i = 1;i<orderedList.size();i++) {
            if(orderedList.get(i) != orderedList.get(i-1) + 1) {
                return false;
            }
        }

        return true;
    }
}
