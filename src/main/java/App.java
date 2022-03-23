import java.io.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.FileOutputStream;

public class App {
    public static SaveToFile saveToFile;
    private static String insrtSQL =  "INSERT INTO TestTable(ObjCod, ObjName) VALUES ('2', 'ермак 2 java'),('3', 'ермак 3 java')";
    private static String data = "Это тестовая строка для записи в файл!!";  // в разработке, цель писать из бд в тхт

    public static void main(String[] args) {
        saveToFile.writeUsingFileWriter(data); // пишем в файл с помощью FileWriter F:\\java\\FileWriter1.txt
        connect();
    }
    //  public void printToFile( ResultSet rs, String path ) throws IOException {
     public static void connect() {
    //  PrintStream out = new FileOutputStream("F:\\java\\FileWriter1.txt" );

        String connectionUrl = "jdbc:sqlserver://192.168.1.230:1433;databaseName=TH;user=thra;password=12345678;";
        System.out.println("прошло определение параметров");
        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
            System.out.println("Соединение с СУБД выполнено.");

            stmt.executeUpdate(insrtSQL); // пишем произвольные данные в тестовую таблицу

            ResultSet rs = stmt.executeQuery("select * from clients where [obj-type] = 'маг'");
                                          // читаем данные из боевой БД!!! не писать !!!
            while(rs.next()) {
                  System.out.println(rs.getString("obj-name"));
            }
            rs.close();
            con.close();
            System.out.println("Отключение от СУБД выполнено.");
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка SQL !");
        }
    }
}

