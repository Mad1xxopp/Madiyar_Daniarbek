import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBFunctions_Admin{
    DBFunctions db = new DBFunctions();
    Connection con = db.connect_to_db("postgres", "postgres", "w6Yh7OHK2lxxA");
    public void create_table_admin(Connection con, String admin_table_name){
        Statement st;
        try{
            String query = "create table if not exists " + admin_table_name + "(id SERIAL, name varchar(200), surname varchar(200), primary key(id));";
            st = con.createStatement();
            st.executeUpdate(query);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void insert_row_admin(Connection con, String admin_table_name, String name, String surname){
        Statement st;
        try{
            String query = String.format("insert into %s(name, surname) values('%s','%s')", admin_table_name, name, surname);
            st = con.createStatement();
            st.executeUpdate(query);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}