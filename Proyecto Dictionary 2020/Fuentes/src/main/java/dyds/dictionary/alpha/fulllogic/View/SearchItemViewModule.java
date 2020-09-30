package dyds.dictionary.alpha.fulllogic.View;

import dyds.dictionary.alpha.fulllogic.Controller.SearchItemController;
import dyds.dictionary.alpha.fulllogic.Model.TermModelModule;

import javax.swing.*;

public class SearchItemViewModule {

    private static SearchItemViewModule instance;

    private SearchItemViewModule(){ }

    public static SearchItemViewModule getInstance(){
        if(instance == null){
            instance= new SearchItemViewModule();
        }
        return instance;
    }

    public void openSearchItemViewWindow(SearchItemController searchItemController){


        SearchItemViewActivity searchItemViewActivity= new SearchItemViewActivity(searchItemController, TermModelModule.getInstance().getTermModel());

        searchItemController.setSearchItemView(searchItemViewActivity);

        JFrame frame = new JFrame("Online Dictionary");
        frame.setContentPane(searchItemViewActivity.contentPane);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
