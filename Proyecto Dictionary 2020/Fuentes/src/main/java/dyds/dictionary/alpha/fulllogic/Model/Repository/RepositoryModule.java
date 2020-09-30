package dyds.dictionary.alpha.fulllogic.Model.Repository;

import dyds.dictionary.alpha.fulllogic.Model.DataBase.DataBaseModule;

public class RepositoryModule {

    private Repository repository;
    private static RepositoryModule instance;

    private RepositoryModule(){

        DataBaseModule dataBaseModule = DataBaseModule.getInstance();

        repository = new RepositoryImp(dataBaseModule.getDataBaseTerm());
    }

    public static RepositoryModule getInstance(){
        if(instance == null){
            instance = new RepositoryModule();
        }
        return instance;
    }

    public Repository getRepository(){
        return repository;
    }

}
