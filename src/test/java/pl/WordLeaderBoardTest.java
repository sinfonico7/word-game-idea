package pl;

import Enums.TypeOfRules;
import Exceptions.ProcessorSubmissionsException;
import Exceptions.RuleImplementationException;
import bl.RulesWord;
import bl.omparators.PlayerPointsComparator;
import bl.repositories.PlayerProcessor;
import bl.repositories.RulesRepository;
import bt.IRule;
import dl.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WordLeaderBoardTest {

    WordLeaderBoard wordLeaderBoard;
    List<Player> players;

    @Before
    public void init(){
        wordLeaderBoard = new WordLeaderBoard();
        players = getPlayersForTest();
    }

    private List<Player> getPlayersForTest() {
        List<Player> players = new ArrayList<>();
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Player player3 = new Player("Player 3");
        player1.getWords().add("cara");
        player1.getWords().add("balla");
        player2.getWords().add("call");
        player2.getWords().add("blond");
        player3.getWords().add("blonda");
        players.add(player2);
        players.add(player1);
        players.add(player3);
        return players;
    }

    @Test
    public void playerShouldIncrease20Points(){
        Player player1 = new Player("Plyaer 1");
        player1.getWords().add("cara");
        player1.getWords().add("balla");
        RulesWord rulesWord = new RulesWord();
        rulesWord.applyRules(player1);
        Assert.assertEquals(20,player1.getPoints().intValue());
    }

    @Test
    public void shouldBuildLeaderTableAndPlayer3isSecond(){
        WordLeaderBoard wordLeaderBoard = new WordLeaderBoard();
        wordLeaderBoard.buildLeaderboard(players);
        Assert.assertEquals(players.get(1),wordLeaderBoard.getRanking().get(1));

    }

    @Test(expected = RuleImplementationException.class)
    public void notImplementedRuleHasThrowException(){
        RulesRepository.getRule(TypeOfRules.AGE);
    }

    @Test(expected = ProcessorSubmissionsException.class)
    public void processSubmissionThrowsExceptionEmptyPlayers(){
        PlayerProcessor playerProcessor = new PlayerProcessor();
        IRule rule = RulesRepository.getRule(TypeOfRules.WORD);
        List<Player> emptyPlayers = new ArrayList<>();
        playerProcessor.processSubmissions(emptyPlayers,rule);
    }

    @Test(expected = ProcessorSubmissionsException.class)
    public void processSubmissionThrowsExceptionNullPlayers(){
        PlayerProcessor playerProcessor = new PlayerProcessor();
        IRule rule = RulesRepository.getRule(TypeOfRules.WORD);
        playerProcessor.processSubmissions(null,rule);
    }

    @Test
    public void PlayerComparatorNeedsSortInverted(){
        PlayerPointsComparator playerPointsComparator = new PlayerPointsComparator();
        Player firstPlacePlayer = new Player("Player first");
        Player secondPlacePlayer = new Player("Player second");
        firstPlacePlayer.setPoints(10);
        secondPlacePlayer.setPoints(0);
        int invertedValue = playerPointsComparator.compare(firstPlacePlayer,secondPlacePlayer);
        Assert.assertEquals(invertedValue,-1);
        invertedValue = playerPointsComparator.compare(secondPlacePlayer,firstPlacePlayer);
        Assert.assertEquals(invertedValue,1);
    }

    @Test
    public void PlayerComparatorNeedsSortEqual(){
        PlayerPointsComparator playerPointsComparator = new PlayerPointsComparator();
        Player firstPlacePlayer = new Player("Player first");
        Player secondPlacePlayer = new Player("Player second");
        firstPlacePlayer.setPoints(10);
        secondPlacePlayer.setPoints(10);
        int invertedValue = playerPointsComparator.compare(firstPlacePlayer,secondPlacePlayer);
        Assert.assertEquals(invertedValue,0);

    }

    @Test
    public void setEffectivePoints(){
        Player player = new Player("Player 1");
        player.setPoints(Integer.valueOf(10));
        Assert.assertEquals(player.getPoints().intValue(),10);
    }

    @Test
    public void setEffectiveWords(){
        Player player = new Player("Plyaer 1");
        List<String> words = new ArrayList<>();
        words.add("Caballo");
        player.setWords(words);
        Assert.assertEquals(player.getWords().size(),1);
    }

    @Test
    public void checkPlayerComparator(){
        Player lower = new Player("Player lower");
        Player greater = new Player("Player greater");
        lower.setPoints(10);
        greater.setPoints(20);
        Assert.assertEquals(lower.compareTo(greater),-1);
    }


}
