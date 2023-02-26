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
        FirstTable.CloseDB();
    }
}
