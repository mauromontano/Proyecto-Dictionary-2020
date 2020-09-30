package dyds.dictionary.alpha.fulllogic.Model.Repository;

import dyds.dictionary.alpha.fulllogic.Model.Term;

public interface Repository {

    Term getDefinition(String name) throws Exception;

    void test();

}
