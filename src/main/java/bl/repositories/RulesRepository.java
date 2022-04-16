package bl.repositories;

import Enums.TypeOfRules;
import Exceptions.RuleImplementationException;
import bl.RulesWord;
import bt.IRule;

public class RulesRepository {

    public static IRule getRule(TypeOfRules typeOfRule) throws RuleImplementationException {
        switch (typeOfRule){
            case WORD:
                return new RulesWord();
            default:
                throw new RuleImplementationException("The type of rule is not implemented or declared yet.");

        }
    }
}
