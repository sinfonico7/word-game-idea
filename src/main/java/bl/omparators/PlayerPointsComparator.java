package bl.omparators;

import dl.Player;

import java.util.Comparator;

public class PlayerPointsComparator implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        int value = 0;
        if(o1.getPoints() < o2.getPoints()){
            value = 1;
        }else if (o1.getPoints() > o2.getPoints()){
            value = -1;
        }
        return value;
    }
}
