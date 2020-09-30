package dyds.dictionary.alpha.fulllogic.Controller;

import dyds.dictionary.alpha.fulllogic.View.SearchItemView;

public interface SearchItemController {


    void setSearchItemView(SearchItemView searchItemView);


    void onEventSearch(String term);

}
