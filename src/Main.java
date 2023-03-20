import java.sql.*;

public class Main {
    public final static String url = "JDBC:SQLITE:C:/Users/jafar/OneDrive/Desktop/ramikhra.db";
public static final Connection con;


    static {
        try {
            con = DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createDataBase() {
        try {
            Connection con = DriverManager.getConnection(url);
            if (con != null) {
                DatabaseMetaData metaData = con.getMetaData();
                System.out.println("the connection good meta is=" + metaData);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createTable() {
        // String url = "JDBC:SQLITE:C:/Users/user/Desktop/dtb_sqlite.db";
        Connection con = null;
        String q = "CREATE TABLE \"clients\" (\n" +
                "\t\"Name\"\tTEXT NOT NULL,\n" +
                "\t\"id\"\tINTEGER,\n" +
                "\t\"email\"\tTEXT NOT NULL,\n" +
                "\t\"salary\"\tREAL,\n" +
                "\tPRIMARY KEY(\"id\")\n" +
                ")";
        try {
            con = DriverManager.getConnection(url);
            if (con != null) {
                Statement st = con.createStatement();
                st.executeUpdate(q);
                System.out.println("create table successfully");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws SQLException {
        // createDataBase();
        //createTable();
     //  insertIntoTable(234,"ra@m","ramzi0");
        selectAll();
    }
    public static void  insertIntoTable(int id , String n,String a) throws SQLException {
        String query = "insert  into  clients(id,name,email)" +
                " values("+id+",'"+n+"','"+a+"');";
        Statement stm = con.createStatement();
        stm.executeUpdate(query);
}
    public static void selectAll() throws SQLException {
        String query = "select * from clients";
        Statement stm = con.createStatement();
        ResultSet resultSet = stm.executeQuery(query);
        while(resultSet.next())
        {
            System.out.println(resultSet.getInt("id")+"\t"
                    +resultSet.getString("name")+"\t");
        }
        System.out.println("done reading  table ");
}
}
