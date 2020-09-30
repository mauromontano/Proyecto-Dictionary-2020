package dyds.dictionary.alpha.fulllogic.Model;

public class Term {

    private String term;
    private String definition;

    public Term(String term){
        this.term=term;
    }

    public void setDefinition(String definition){

        this.definition=definition;
    }

    public String getTerm(){

        return term;
    }

    public String getDefinition(){

        return definition;
    }

}
