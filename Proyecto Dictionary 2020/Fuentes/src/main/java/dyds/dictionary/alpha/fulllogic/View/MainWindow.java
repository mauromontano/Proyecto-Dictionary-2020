package dyds.dictionary.alpha.fulllogic.View;


import dyds.dictionary.alpha.fulllogic.Controller.ControllerModule;
import dyds.dictionary.alpha.fulllogic.Controller.SearchItemController;

public class MainWindow {


  public static void main(String[] args) {

    SearchItemController searchItemController= ControllerModule.getInstance().getSearchItemController();

    SearchItemViewModule searchItemViewModule = SearchItemViewModule.getInstance();

    searchItemViewModule.openSearchItemViewWindow(searchItemController);

  }


}
