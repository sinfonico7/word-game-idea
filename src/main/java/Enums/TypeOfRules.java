package Enums;

public enum TypeOfRules {
    WORD("Words finished with letter 'a'"), AGE("Words finished with letter 'a'"), NAME("Words finished with letter 'a'");
    public final String label;

    private TypeOfRules(String label){
        this.label = label;
    }
}
