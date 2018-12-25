import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) throws SQLException {
	
		
		File file = new File("test.txt");
		System.out.println(file.exists());
	}
}
