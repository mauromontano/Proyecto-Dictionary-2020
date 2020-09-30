package dyds.dictionary.alpha.fulllogic.Model.Repository;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dyds.dictionary.alpha.fulllogic.Model.DataBase.DataBaseTerm;
import dyds.dictionary.alpha.fulllogic.Model.DataBase.WikipediaAPI;
import dyds.dictionary.alpha.fulllogic.Model.Term;
import dyds.dictionary.alpha.fulllogic.View.TextHtmlImp;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.io.IOException;
import java.util.Map;
import java.util.Set;


public class RepositoryImp implements Repository {

    private DataBaseTerm db;

    RepositoryImp(DataBaseTerm db) {

        this.db = db;
        db.createNewDatabase();

    }

    public Term getDefinition(String name){

        String definition = searchInService(name);
        Term finalTerm = new Term(name);
        finalTerm.setDefinition(definition);

        return finalTerm;
    }

    private String searchInService(String name) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://en.wikipedia.org/w/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        WikipediaAPI wikiAPI = retrofit.create(WikipediaAPI.class);

        String definition = db.getMeaning(name);

        if (definition != null) {
            definition = "[*]" + definition;
        } else {

            Response<String> callResponse;

            try {
                callResponse = wikiAPI.getTerm(name).execute();

                Gson gson = new Gson();
                JsonObject jobj = gson.fromJson(callResponse.body(), JsonObject.class);
                JsonObject query = jobj.get("query").getAsJsonObject();
                JsonObject pages = query.get("pages").getAsJsonObject();
                Set<Map.Entry<String, JsonElement>> pagesSet = pages.entrySet();
                Map.Entry<String, JsonElement> first = pagesSet.iterator().next();
                JsonObject page = first.getValue().getAsJsonObject();
                JsonElement extract = page.get("extract");

                if (extract == null) {
                    definition = "No Results";
                } else {
                    definition = extract.getAsString().replace("\\n", "\n");
                    definition = TextHtmlImp.textToHtml(definition, name);

                    db.saveTerm(name, definition);
                }

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return definition;
    }

    public void test(){
        db.testAntiguedad();
    }
}

