import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

   static {
      try {
         Class.forName("com.mysql.jdbc.Driver");
      } 
      catch (ClassNotFoundException e) {
         throw new RuntimeException(e);
      }
   }

   public Connection conectar() throws SQLException {
      String servidor = "localhost";
      String porta = "3306";
      String database = "clima";
      String usuario = "root";
      String senha = "jo020999";
      return DriverManager
         	.getConnection("jdbc:mysql://"+servidor+":"+porta+
            "/"+database+"?user="+usuario+"&password="+senha);
   }
   public Connection obtemConexao(){
     try{
     String servidor = "localhost";
      String porta = "3306";
      String database = "clima";
      String usuario = "root";
      String senha = "jo020999";
        
         String s = "jdbc:mysql://" + servidor + ":" + porta + "/" + database + "?verifyServerCertificate=false&useSSL=true";
         Connection c = DriverManager.getConnection(
            s,
            usuario,
          senha 
         );
         return c;
      }
      catch (Exception e){
            e.printStackTrace();
            return null;
      }
   }
}
