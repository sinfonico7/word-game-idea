package bt;

import dl.Player;

import java.util.List;

public interface ISubmissionProcessor {
    List<Player>  processSubmissions(List<Player> players , IRule rules);
}
