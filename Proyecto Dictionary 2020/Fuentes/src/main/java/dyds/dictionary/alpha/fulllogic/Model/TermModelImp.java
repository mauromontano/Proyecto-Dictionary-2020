package dyds.dictionary.alpha.fulllogic.Model;


import dyds.dictionary.alpha.fulllogic.Model.Repository.Repository;

public class TermModelImp implements TermModel{

    private TermModelListener oyente;
    private Repository repo;


    TermModelImp(Repository repo) {
        this.repo = repo;
    }

    @Override
    public void updateTerm(String name) {
        try {
            oyente.didUpdateTerm(repo.getDefinition(name));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void setListener(TermModelListener listener) {
        oyente = listener;
    }
}
