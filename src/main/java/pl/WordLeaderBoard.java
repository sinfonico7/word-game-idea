package pl;

import Enums.TypeOfRules;
import bl.repositories.PlayerProcessor;
import bl.repositories.RulesRepository;
import bt.IRule;
import bt.ISubmissionProcessor;
import dl.Leaderboard;
import dl.Player;

import java.util.List;

public class WordLeaderBoard extends Leaderboard {

    private IRule rules;
    private ISubmissionProcessor submissionProcessor;


    @Override
    public void buildLeaderboard(List<Player> players) {

        rules = RulesRepository.getRule(TypeOfRules.WORD);
        submissionProcessor = new PlayerProcessor();
        this.setRanking(submissionProcessor.processSubmissions(players, rules));
        printLeaderBoard(TypeOfRules.WORD.label);

    }

}
