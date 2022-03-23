import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveToFile {

      // пишем в файл с помощью FileWriter
      public static void writeUsingFileWriter(String data){
        File file = new File("F:/java/FileWriter.txt");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            fr.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /*public static void printToFile(String path) throws FileNotFoundException {
    connect();
    //PrintStream out = new FileOutputStream( path );
    OutputStream out = new FileOutputStream( path );
    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery("select * from clients where [obj-type] = 'маг'");
            int cols = rs.getMetaData().getColumnCount();
            while( rs.next() ) {
                for( int i = 1; i < cols ; i++ ) {
                    out.printf("%s,", rs.getObject( i ) );
                }
                out.println();
            }
    // add exception handling and such...
    // or move the from here.
    out.close();
    rs.close();
}*/

}
