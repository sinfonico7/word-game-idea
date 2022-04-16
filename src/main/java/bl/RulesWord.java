package bl;

import bt.IRule;
import dl.Player;

public class RulesWord implements IRule {

    public void applyRules(Player player) {
        for(String word : player.getWords()){
            if(word.endsWith("a")){
                player.addPoints(10);
            }
        }
    }
}
