package poker.services;

import org.springframework.stereotype.Service;
import poker.model.PlayingCard;

import java.util.Set;

@Service
public class PokerHandProcessorService {
    public void process(final Set<PlayingCard> hand) {
        System.out.println(hand);
    }
}
