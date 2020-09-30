package dyds.dictionary.alpha.fulllogic.Model.DataBase;

public class DataBaseModule {

    private static DataBaseModule instance;
    private DataBaseTerm dataBaseTerm;

    private DataBaseModule(){

        dataBaseTerm = new DataBaseTermImp();
    }

    public static DataBaseModule getInstance(){
        if(instance == null){
            instance = new DataBaseModule();
        }
        return instance;
    }

    public DataBaseTerm getDataBaseTerm(){
        return dataBaseTerm;
    }


}
