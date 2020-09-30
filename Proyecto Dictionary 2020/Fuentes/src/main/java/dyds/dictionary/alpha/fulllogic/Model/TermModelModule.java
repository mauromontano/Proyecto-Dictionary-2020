package dyds.dictionary.alpha.fulllogic.Model;

import dyds.dictionary.alpha.fulllogic.Model.Repository.RepositoryModule;

public class TermModelModule {

    private static TermModelModule instance;
    private TermModel termModel;

    private TermModelModule() {

        RepositoryModule repositoryModule = RepositoryModule.getInstance();

        termModel = new TermModelImp(repositoryModule.getRepository());
    }

    public static TermModelModule getInstance() {
        if (instance == null) {
            instance = new TermModelModule();
        }
        return instance;
    }

    public TermModel getTermModel() {
        return termModel;
    }

}
