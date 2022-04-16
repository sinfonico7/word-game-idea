package dl;

import java.util.ArrayList;
import java.util.List;

public class Player implements Comparable<Player>{

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    private String playerName;
    private List<String> words;
    private Integer points;

    public Player(String playerName){
        this.playerName = playerName;
        words = new ArrayList<>();
        points = 0;
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public void setPoints(int points){
        this.points = points;
    }

    public synchronized void addPoints(int points){
        this.points += points;
    }

    @Override
    public String toString() {
        return String.format("Player name : %s | Points : %s | Words : %s |",this.getPlayerName(), this.getPoints(), buildWords());
    }

    private String buildWords(){
        StringBuilder sb = new StringBuilder();
        this.words.stream().forEach(word -> {
            sb.append(String.format("%s ",word));
        });
        return sb.toString();
    }

    public int compareTo(Player player) {
        return this.points.compareTo(player.points);
    }

}
