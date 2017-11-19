package poker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poker.model.PokerHand;
import poker.services.handmatchers.HandMatcher;

import java.util.List;

@Service
public class PokerHandProcessorService {
    @Autowired
    private List<HandMatcher> handMatchers;

    public void process(final PokerHand hand) {
        final HandMatcher highestRankingMatch = handMatchers.stream()
                .filter(handMatcher -> handMatcher.matches(hand))
                .findFirst()
                .get();

        System.out.println(String.format("%s => %s", hand.toString(), highestRankingMatch.description()));
    }
}
