package bl.repositories;

import Exceptions.ProcessorSubmissionsException;
import bt.IRule;
import bt.ISubmissionProcessor;
import dl.Player;

import java.util.List;

public class PlayerProcessor implements ISubmissionProcessor {


    @Override
    public List<Player> processSubmissions(List<Player> players, IRule rules) throws ProcessorSubmissionsException {
        if(players==null || players.isEmpty())
            throw new ProcessorSubmissionsException("Process has not players to be processed");
        players.stream().forEach(player -> rules.applyRules(player));
        return players;

    }
}
