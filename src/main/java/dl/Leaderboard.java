package dl;

import bl.omparators.PlayerPointsComparator;

import java.util.*;

public abstract class Leaderboard {

    private List<Player> ranking;

    public Leaderboard(){
        this.ranking = new ArrayList<>();
    }

    public List<Player> getRanking() {
        return ranking;
    }

    public void setRanking(List<Player> ranking) {
        this.ranking = ranking;
    }

    public void printLeaderBoard(String ruleType){

        Collections.sort(ranking , new PlayerPointsComparator());
        System.out.println("*****************LEADER BOARD*****************");
        System.out.printf("*****************RULES TYPE : %s *****************\n", ruleType);
       ranking.stream().forEach(player -> System.out.println(player.toString()));
       System.out.println("**********************************************");
    }

    public abstract void buildLeaderboard(List<Player> players);
}
