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

    public static void arr_insert(String arr[]) throws SQLException{
        for (String breed: arr){
            st.execute("INSERT OR IGNORE INTO types (type) VALUES ('" + breed + "')");
        }
        System.out.println("Multiple rows added");
    }

    public static void delete_type(int id) throws SQLException{
        st.execute("DELETE FROM types WHERE id = '" + id + "'");
        System.out.println("Data deleted successfully");
    }

    public static void update_type(int id, String type) throws SQLException{
        st.execute("UPDATE types SET type ='" + type + "' WHERE id = " + id);
        System.out.println("Update successful");
    }

    public static void get_type(int id) throws SQLException{
        ResultSet res = st.executeQuery("SELECT * FROM types WHERE id = " + id);
        while (res.next()){
            System.out.println("Type: " + res.getString("type"));
            System.out.println();
        } 
    }


    public static void get_type_where(String condtion) throws SQLException{
        ResultSet res = st.executeQuery("SELECT * FROM types WHERE type LIKE " + condtion);
        while (res.next()){
            System.out.println("Type: " + res.getString("type"));
            System.out.println();
        }
    }

    public static void get_all_types() throws SQLException{
        ResultSet res = st.executeQuery("SELECT * FROM types");
        while (res.next()){
            System.out.println("Type: " + res.getString("type"));
            System.out.println();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        FirstTable.Conn();
        FirstTable.CreateDB();
        FirstTable.InsertDB();
        String[] types = new String[]{"Абиссинская кошка","Австралийский мист","Американская жесткошерстная",
"Американская короткошерстная","Американский бобтейл","Американский кёрл","Балинезийская кошка",
"Бенгальская кошка", "Бирманская кошка","Бомбейская кошка","Бразильская короткошёрстная","Британская длинношерстная",
"Британская короткошерстная","Бурманская кошка","Бурмилла кошка","Гавана","Гималайская кошка","Девон-рекс","Донской сфинкс",
"Европейская короткошерстная","Египетская мау","Канадский сфинкс","Кимрик","Корат","Корниш-рекс","Курильский бобтейл",
"Лаперм","Манчкин","Мейн-ку́н","Меконгский бобтейл","Мэнкс кошка","Наполеон","Немецкий рекс","Нибелунг",
"Норвежская лесная кошка","Ориентальная кошка","Оцикет","Персидская кошка","Петерболд","Пиксибоб","Рагамаффин",
"Русская голубая кошка","Рэгдолл","Саванна","Селкирк-рекс","Сиамская кошка","Сибирская кошка","Сингапурская кошка",
"Скоттиш-фолд","Сноу-шу","Сомалийская кошка","Тайская кошка","Тойгер","Тонкинская кошка","Турецкая ангорская кошка",
"Турецкий ван","Украинский левкой","Чаузи","Шартрез","Экзотическая короткошерстная","Японский бобтейл"};

        FirstTable.arr_insert(types);
        FirstTable.delete_type(1);
        FirstTable.update_type(2, "Cutie");
        FirstTable.get_all_types();
        FirstTable.get_type(5);
        FirstTable.get_type_where("'С%'");
        FirstTable.CloseDB();
    }
}
