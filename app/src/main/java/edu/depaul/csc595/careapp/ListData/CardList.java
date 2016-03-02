package edu.depaul.csc595.careapp.ListData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Miller on 12/02/2016.
 */
public class CardList {

    public List<Card> PROFILES = new ArrayList<>();
    public Map<String, Card> PROFILE_MAP = new HashMap<>();

    public void addItem(Card card) {
        PROFILES.add(card);
        PROFILE_MAP.put(card.getTitle(), card);
    }
}
