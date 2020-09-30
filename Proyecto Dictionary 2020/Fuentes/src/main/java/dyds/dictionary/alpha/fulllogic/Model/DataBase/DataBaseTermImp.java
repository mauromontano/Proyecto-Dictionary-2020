package dyds.dictionary.alpha.fulllogic.Model.DataBase;



import java.sql.*;
public class DataBaseTermImp implements DataBaseTerm{


    public void createNewDatabase() {

        String url = "jdbc:sqlite:./dictionary.db";

        try (Connection connection = DriverManager.getConnection(url)) {
            if (connection != null) {
                DatabaseMetaData meta = connection.getMetaData();

                Statement statement = connection.createStatement();
                statement.setQueryTimeout(30);

                statement.executeUpdate("CREATE TABLE IF NOT EXISTS terms (id INTEGER PRIMARY KEY AUTOINCREMENT, term string, meaning string, source integer, fecha datetime)");

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



    public void saveTerm(String term, String meaning)
    {
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection("jdbc:sqlite:./dictionary.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            statement.executeUpdate("insert into terms values(null, '"+ term + "', '"+ meaning + "', 1 , datetime('now') )");

        }
        catch(SQLException e)
        {
            System.err.println("Error saving " + e.getMessage());
        }
        finally
        {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                System.err.println( e);
            }
        }
    }


    public String getMeaning(String term)
    {
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection("jdbc:sqlite:./dictionary.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            ResultSet rs = statement.executeQuery("select * from terms WHERE term = '" + term + "' and fecha < datetime('now', '-1 day') " );

            if (rs.next()){
                statement.executeUpdate("delete from terms WHERE term = '" + term + "'" );
            }
            else{
                rs = statement.executeQuery("select * from terms WHERE term = '" + term + "'" );
            }

            rs.next();

            return rs.getString("meaning");
        }
        catch(SQLException e)
        {
        }
        finally
        {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                System.err.println(e);
            }
        }
        return null;
    }

    public void testAntiguedad()
    {
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection("jdbc:sqlite:./dictionary.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            statement.executeUpdate("insert into terms values(null, 'entrada con mas de 1 dia de antiguedad', 'definicion de entrada con mas de 1 dia de antiguedad', 1 , datetime('2020-05-01 10:10:10') )");

            statement.executeUpdate("insert into terms values(null, 'entrada con menos de 1 dia de antiguedad', 'definicion de entrada con menos de 1 dia de antiguedad', 1 , datetime('now') )");
        }
        catch(SQLException e)
        {
            System.err.println("Error saving " + e.getMessage());
        }
        finally
        {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                System.err.println( e);
            }
        }
    }

}