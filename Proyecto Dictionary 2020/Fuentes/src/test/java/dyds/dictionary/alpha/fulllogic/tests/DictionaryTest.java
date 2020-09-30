package dyds.dictionary.alpha.fulllogic.tests;

import dyds.dictionary.alpha.fulllogic.Model.Repository.Repository;
import dyds.dictionary.alpha.fulllogic.Model.Repository.RepositoryModule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DictionaryTest {

    @Test
    public void test() throws Exception {
        
        //Arrange
        Repository repo= RepositoryModule.getInstance().getRepository();
        repo.test();

        // Act & Assert.

        String sinResultados= repo.getDefinition("estaPalabraNoExiste").getDefinition();
        String buscarOk= repo.getDefinition("audi").getDefinition();
        String Mas1DiaAntiguedad= repo.getDefinition("entrada con mas de 1 dia de antiguedad").getDefinition();
        String yaSeEncuentraEnCache= repo.getDefinition("entrada con menos de 1 dia de antiguedad").getDefinition();

        //Test de buscar palabra en Wikipedia y guardar su definicion en la cache

        try {
            assertNotEquals(buscarOk, null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Test de que la palabra ingresada no tiene definicion en Wikipedia

        try {
            assertEquals(sinResultados, "No Results");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Test de entrada guardada en la cacha con mas de 1 dia de antiguedad

        try {
            assertEquals(Mas1DiaAntiguedad, "No Results");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Test de que la entrada ya esta almacenada en la cache y tiene menos de 1 dia de antiguedad

        try {
            assertEquals(yaSeEncuentraEnCache, "[*]definicion de entrada con menos de 1 dia de antiguedad");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
