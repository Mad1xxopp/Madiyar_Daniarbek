import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DBFunctions_JDJS{
    DBFunctions db = new DBFunctions();
    Connection con = db.connect_to_db("postgres", "postgres", "w6Yh7OHK2lxxA");

    public void create_table_jdjs(Connection con, String jdjs_table_name){
        Statement st;
        try{
            String query = "create table if not exists " + jdjs_table_name + "(id SERIAL, vacancy varchar(200), primary key(id));";
            st = con.createStatement();
            st.executeUpdate(query);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void saveVacancyToDatabase(Connection con, String jdjs_table_name, String vacancy){
        Statement st;
        try {
            String query = String.format("insert into %s(vacancy) values('%s')", jdjs_table_name, vacancy);
            st = con.createStatement();
            st.executeUpdate(query);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    public void deleteVacancyFromDatabase(Connection con, String jdjs_table_name, String vacancy){
        Statement st;
        try {
            String query = String.format("delete from %s where vacancy='%s'", jdjs_table_name, vacancy);
            st = con.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
