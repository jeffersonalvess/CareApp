package edu.depaul.csc595.careapp.ListData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Miller on 12/02/2016.
 */
public class CardList {

    public static List<Card> PROFILES = new ArrayList<>();

    public static Map<String, Card> PROFILE_MAP = new HashMap<>();

    private static void addItem(Card card) {
        PROFILES.add(card);
        PROFILE_MAP.put(card.name, card);
    }

    public static final Card[] PROFILES_ARRAY = {
            new Card(Card.Type.type_1,
                    "Barbera",
                    "Full-bodied Italian Red",
                    "Barbera is a red wine grape found primarily in Italy's Piedmont region. It produces hearty red wines with deep ruby colors, full body and low tannin levels."),

            new Card(Card.Type.type_2,
                    "Cabernet Sauvignon",
                    "Full-bodied, intense Red",
                    "Cabernet Sauvignon is a red wine known for its depth of flavor, aroma and ability to age (present by the wine’s noticeable tannins). It is full-bodied and intense, with cherry-currant and sometimes herbal flavors."),

            new Card(Card.Type.type_2,
                    "Champagne",
                    "Sparkling White from Champagne region",
                    "These wines are made effervescent by a secondary fermentation in the wine-making process. Champagnes and sparkling wines range in style from very dry (Natural), dry (brut) and slightly sweet (extra Dry) to sweet (sec and Demi-Sec). Many sparkling wines are also identified as Blanc de Blancs (wines made from white grapes) or Blanc de Noirs (wines produced from red grapes)."),

            new Card(Card.Type.type_1,
                    "Chardonnay",
                    "Popular, complex White from Burgundy",
                    "One of the world’s most popular wines, Chardonnay is a white wine originating from Burgundy.  Flavors range from clean and crisp with a hint of varietal flavor to rich and complex, vanilla, butter and oak-aged wines. Chardonnay typically balances fruit, acidity and texture."),

            new Card(Card.Type.type_1,
                    "Chenin Blanc",
                    "Fresh, light White",
                    "Chenin Blanc is a white wine with fresh, delicate floral characteristics. It grows well in warmer climates and produces light, well-balanced wines ranging from dry to off-dry (slightly sweet) styles."),

            new Card(Card.Type.type_1,
                    "Dolcetto",
                    "Light Italian Red",
                    "This red wine grape is found almost exclusively in Italy's Piedmont region. It produces light and fruity wine."),

            new Card(Card.Type.type_2,
                    "Fume Blanc",
                    "Dry White made from Sauvignon Blanc",
                    "Invented by Robert Mondavi in 1970, Fume Blanc is a Sauvignon Blanc that has been fermented in oak."),

            new Card(Card.Type.type_1,
                    "Gewürztraminer",
                    "Rich German White",
                    "Gewürztraminer is a white German wine that produced distinctive wines rich in spicy aromas and full flavors, ranging from dry to sweet. This varietal is a popular choice for Asian dishes."),

            new Card(Card.Type.type_2,
                    "Merlot",
                    "Medium to full-bodied Red",
                    "Merlot is a red wine with medium to full body with black cherry and herbal flavors. Merlot is typically smooth, soft and mellow."),

            new Card(Card.Type.type_1,
                    "Mourvedre",
                    "Rich Red from Rhone Valley",
                    "This warm-weather, red wine grape is common in Southern France's Rhone Valley. Rich in color with early aromas, often blended with Syrah.")
    };

    static {
        for (Card card : PROFILES_ARRAY) {
            addItem(card);
        }
    }
}
