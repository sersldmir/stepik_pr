package Databases;

import java.sql.*;

public class FirstTable {

    public static Connection con;
    public static Statement st;

    public static void Conn() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:My_cats.db");
        System.out.println("Database created");
    }
    public static void CreateDB() throws SQLException {
        st = con.createStatement();
        st.execute("CREATE TABLE if not exists types (id INTEGER PRIMARY KEY AUTOINCREMENT, type VARCHAR(100))");
        System.out.println("Table created");
    }
    public static void CloseDB() throws SQLException {
        con.close();
        st.close();
    }

    public static void InsertDB() throws SQLException {
        String s1 = "Абиссинская кошка";
        String s2 = "Австралийский мист";
        String s3 = "Американская жесткошерстная";
        st.execute("INSERT OR IGNORE INTO types (type) VALUES ('" + s1 + "')");
        st.execute("INSERT OR IGNORE INTO types (type) VALUES ('" + s2 + "')");
        st.execute("INSERT OR IGNORE INTO types (type) VALUES ('" + s3 + "')");
        System.out.println("Data added");
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        FirstTable.Conn();
        FirstTable.CreateDB();
        FirstTable.InsertDB();
        FirstTable.CloseDB();
    }
}
