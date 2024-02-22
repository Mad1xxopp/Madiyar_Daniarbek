import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBFuncrions_Client{
    DBFunctions db = new DBFunctions();
    Connection con = db.connect_to_db("postgres", "postgres", "w6Yh7OHK2lxxA");
    public void create_table_client(Connection con, String client_table_name){
        Statement st;
        try{
            String query = "create table if not exists " + client_table_name +  "(id SERIAL, name varchar(200), surname varchar(200), primary key(id));";
            st = con.createStatement();
            st.executeUpdate(query);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void insert_row_client(Connection con, String client_table_name, String name, String surname){
        Statement st;
        try{
            String query = String.format("insert into %s(name, surname) values('%s','%s')", client_table_name, name, surname);
            st = con.createStatement();
            st.executeUpdate(query);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void read_data_client(Connection con, String client_table_name){
        Statement st;
        ResultSet rs;
        try{
            String query = String.format("select * from %s", client_table_name);
            st = con.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                String name = rs.getString("name");
                String surname = rs.getString("surname");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
