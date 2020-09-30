package dyds.dictionary.alpha.fulllogic.Controller;

import dyds.dictionary.alpha.fulllogic.Model.TermModelModule;

public class ControllerModule {

    private static ControllerModule instance;
    private SearchItemController searchItemController;

    private ControllerModule() {
        searchItemController = new SearchItemControllerImp(TermModelModule.getInstance().getTermModel());
    }

    public static ControllerModule getInstance() {
        if (instance == null) {
            instance = new ControllerModule();
        }
        return instance;
    }

    public SearchItemController getSearchItemController() {
        return searchItemController;
    }

}
