package poker.services.handmatchers;

import org.springframework.stereotype.Service;
import poker.model.PlayingCard;
import poker.model.PokerHand;
import poker.model.Rank;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RankCountService {
    public List<Integer> countRanks(final PokerHand hand) {
        Map<Rank, Integer> countByRank = hand.stream()
                .collect(
                        Collectors.groupingBy(
                                PlayingCard::getRank,
                                Collectors.summingInt(x -> 1)));

        return countByRank.values().stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
