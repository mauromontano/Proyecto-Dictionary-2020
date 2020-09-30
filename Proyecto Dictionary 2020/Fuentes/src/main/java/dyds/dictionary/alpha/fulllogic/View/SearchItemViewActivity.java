package dyds.dictionary.alpha.fulllogic.View;

import dyds.dictionary.alpha.fulllogic.Controller.SearchItemController;
import dyds.dictionary.alpha.fulllogic.Model.Term;
import dyds.dictionary.alpha.fulllogic.Model.TermModel;
import dyds.dictionary.alpha.fulllogic.Model.TermModelListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchItemViewActivity implements SearchItemView {

    private JTextField textField1;
    private JButton goButton;
    protected JPanel contentPane;
    private JTextPane textPane1;

    private SearchItemController searchItemController;
    private TermModel termModel;


    public SearchItemViewActivity(SearchItemController searchItemController, TermModel termModel){

        this.searchItemController = searchItemController;
        this.termModel = termModel;

        initListeners();
    }

        private void initListeners(){

        textPane1.setContentType("text/html");

        goButton.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {

                new Thread(new Runnable() {
                    @Override public void run() {

                        String name= textField1.getText();

                        try {
                            termModel.setListener(new TermModelListener(){
                                @Override
                                public void didUpdateTerm(Term t) {
                                    if(t.getDefinition()=="No Results"){
                                        updateNoResults();
                                    }
                                    else{
                                        updateText(t.getDefinition());
                                    }
                                }
                            });
                            searchItemController.onEventSearch(name);
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                }).start();

            }
        });
    }

    private void updateText(String definition){
        textPane1.setText(definition);
    }

    private void updateNoResults(){
        textPane1.setText("");
        JOptionPane.showMessageDialog(null, "No se encontraron resultados", "", JOptionPane.WARNING_MESSAGE);
    }

}
