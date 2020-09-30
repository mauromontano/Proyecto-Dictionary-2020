package dyds.dictionary.alpha.fulllogic.Controller;

import dyds.dictionary.alpha.fulllogic.Model.TermModel;
import dyds.dictionary.alpha.fulllogic.View.SearchItemView;

public class SearchItemControllerImp implements SearchItemController {

    private TermModel termModel;
    private SearchItemView searchItemView;


    SearchItemControllerImp(TermModel termModel) {
        this.termModel = termModel;
    }

    public SearchItemControllerImp() {
    }


    @Override
    public void setSearchItemView(SearchItemView searchItemView) {
        this.searchItemView = searchItemView;
    }


    @Override
    public void onEventSearch(String term) {
        termModel.updateTerm(term);
    }

}
