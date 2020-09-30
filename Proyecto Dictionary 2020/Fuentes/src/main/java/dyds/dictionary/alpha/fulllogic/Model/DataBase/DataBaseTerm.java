package dyds.dictionary.alpha.fulllogic.Model.DataBase;

public interface DataBaseTerm {

    String getMeaning(String term);

    void saveTerm(String term, String meaning);

    void createNewDatabase();

    void testAntiguedad();
}
