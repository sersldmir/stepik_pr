package Databases;

import java.sql.*;

public class FirstTable {

    public static Connection con;
    public static Statement st;
    static String[] names = {"Гарфилд","Том","Гудвин","Рокки","Ленивец","Пушок","Спорти","Бегемот","Пират","Гудини",
"Зорро","Саймон","Альбус","Базилио","Леопольд","Нарцисс","Атос","Каспер","Валлито","Оксфорд","Бисквит","Соня",
"Клеопатра","Цунами","Забияка","Матильда","Кнопка","Масяня","Царапка","Серсея","Ворсинка","Амели","Наоми","Маркиза","Изольда","Вальс",
"Несквик","Златан","Баскет","Изюм","Цукат","Мокко","Месси","Кокос","Адидас","Бейлиз","Тайгер","Зефир","Мохи","Валенсия",
"Баунти","Свити","Текила","Ириска","Карамель","Виски","Кукуруза","Гренка","Фасолька","Льдинка","Китана","Офелия","Дайкири",
"Брусника","Аватар","Космос","Призрак","Изумруд","Плинтус","Яндекс","Крисмас","Метеор","Оптимус","Смайлик","Цельсий","Краска","Дейзи","Пенка",
"Веста","Астра","Эйприл","Среда","Бусинка","Гайка","Елка","Золушка","Мята","Радость","Сиам","Оскар","Феликс","Гарри","Байрон",
"Чарли","Симба","Тао","Абу","Ватсон","Енисей","Измир","Кайзер","Васаби","Байкал","Багира","Айрис","Диана","Мими","Сакура",
"Индия","Тиффани","Скарлетт","Пикси","Лиззи","Алиса","Лило","Ямайка","Пэрис","Мальта","Аляска"};
    static String[] types = new String[]{"Абиссинская кошка","Австралийский мист","Американская жесткошерстная",
"Американская короткошерстная","Американский бобтейл","Американский кёрл","Балинезийская кошка",
"Бенгальская кошка", "Бирманская кошка","Бомбейская кошка","Бразильская короткошёрстная","Британская длинношерстная",
"Британская короткошерстная","Бурманская кошка","Бурмилла кошка","Гавана","Гималайская кошка","Девон-рекс","Донской сфинкс",
"Европейская короткошерстная","Египетская мау","Канадский сфинкс","Кимрик","Корат","Корниш-рекс","Курильский бобтейл",
"Лаперм","Манчкин","Мейн-ку́н","Меконгский бобтейл","Мэнкс кошка","Наполеон","Немецкий рекс","Нибелунг",
"Норвежская лесная кошка","Ориентальная кошка","Оцикет","Персидская кошка","Петерболд","Пиксибоб","Рагамаффин",
"Русская голубая кошка","Рэгдолл","Саванна","Селкирк-рекс","Сиамская кошка","Сибирская кошка","Сингапурская кошка",
"Скоттиш-фолд","Сноу-шу","Сомалийская кошка","Тайская кошка","Тойгер","Тонкинская кошка","Турецкая ангорская кошка",
"Турецкий ван","Украинский левкой","Чаузи","Шартрез","Экзотическая короткошерстная","Японский бобтейл"};


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

    public static void insert(String type) throws SQLException{
        st.execute("INSERT OR IGNORE INTO types (type) VALUES ('" + type + "')");
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

    public static void createSecondTable() throws SQLException{
        st.execute("CREATE TABLE if not exists cats (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(100) NOT NULL," + 
            "type_id INTEGER NOT NULL, age INTEGER NOT NULL, weight DOUBLE," + 
            "FOREIGN KEY(type_id) REFERENCES types(id))");
        System.out.println("Second table created");
    }


    private static ResultSet getType(String type) throws SQLException {
        Statement statement = con.createStatement();
        String query = "SELECT id, type FROM types WHERE " + type;
        return statement.executeQuery(query);
    }

    public static void insertCat(String name, String type, int age, Double weight) {
        try {
            ResultSet resultSet = getType("type = '" + type + "'");
            int id;
            if (resultSet.isBeforeFirst())
                id = resultSet.getInt("id");
            else {
                insert(type);
                id = getType("type = '" + type + "'").getInt("id");
            }
            Statement statement = con.createStatement();
            statement.execute("INSERT INTO 'cats' ('name','type_id','age','weight') " +
                    "VALUES ('" + name + "'," + id + "," + age + "," + weight + ")");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void addMoreCats(int n) throws SQLException {
        for (int i = 0; i < n; i++) {
            insertCat(names[(int) ((names.length - 1) * Math.random())], types[(int) ((types.length - 1) * Math.random())],  (int) (15 * Math.random()), 7 * Math.random());
        }
        System.out.println(n + " cats were added");
    }

    static void deleteCat(int id) throws SQLException {
        st.execute("DELETE FROM cats WHERE id = " + id);
        System.out.println("The cat with number " + id + " was deleted\n");
    }
    
    static void deleteCatWhere(String where) throws SQLException {
        st.execute("DELETE FROM cats WHERE " + where);
        System.out.println("All cats suitable for the condition '" + where + "' were deleted\n");
    }
    
    static void updateCat(int id, String set) throws SQLException {
        st.execute("UPDATE cats SET " + set + "WHERE id = " + id);
        System.out.println("The cat with number " + id + " was changed according to the criteria\n");
    }
    
    static String getCat(int id) {
        try {
            return st.executeQuery("SELECT name FROM cats WHERE id = " + id).getString("name") + "\n";
        } catch (SQLException e) {
            return "does not exist\n";
        }
    }

    static void printCatWhere(String where) throws SQLException {
        System.out.println("All the cats suitable for the condition '" + where + "':");
        ResultSet resultSet = st.executeQuery("SELECT * FROM cats WHERE " + where);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println(id + " - " + name);
        }
        resultSet.close();
        System.out.println();
    }

    static void printAllCats() throws SQLException {
        System.out.println("All cats:");
        ResultSet resultSet = st.executeQuery("SELECT * FROM cats");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println(id + " - " + name);
        }
        System.out.println();
    }


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        FirstTable.Conn();
        FirstTable.CreateDB();
        FirstTable.InsertDB();
        FirstTable.arr_insert(types);
        FirstTable.delete_type(1);
        FirstTable.update_type(2, "Cutie");
        // FirstTable.get_all_types();
        // FirstTable.get_type(5);
        // FirstTable.get_type_where("'С%'");
        // FirstTable.createSecondTable();
        // FirstTable.insertCat("Bib", "fox", 3, 4.3);
        // System.out.println("Inserted non-existent type");
        // FirstTable.insertCat("Bob", "Тойгер", 5, 5.3);
        // System.out.println("Inserted existent type");
        // FirstTable.addMoreCats(3);
        // FirstTable.deleteCat(7);
        // FirstTable.deleteCatWhere("name = 'Bob'");
        // FirstTable.updateCat(8, "name = 'bol'");
        FirstTable.printAllCats();
        FirstTable.printCatWhere("cats.id = 10");
        FirstTable.getCat(9);
        FirstTable.CloseDB();
    }
}
