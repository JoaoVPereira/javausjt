import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.awt.*;

public class Teste extends JFrame {
   Connection conn = null;
   Temperatura temperatura;
   PreparedStatement stm = null;
   ResultSet rs = null;
   public Teste(){
      super("Tabela");
      criarLabel();
      criarTabela();

     
   }
   public void criarLabel(){
      JPanel painel = new JPanel();
      painel.setLayout(new FlowLayout());
      
      JLabel labe1 = new JLabel("Média =");
      JLabel label1 = new JLabel();
      
      JLabel labe2 = new JLabel("Maior =");
      JLabel label2 = new JLabel();
      
      JLabel labe3 = new JLabel("Menor =");
      JLabel label3 = new JLabel();
      
      painel.add(labe1);
      painel.add(label1);
      painel.add(labe2);
      painel.add(label2);
      painel.add(labe3);
      painel.add(label3);
      add(painel, BorderLayout.SOUTH);
   }
   
   
   
   public void criarTabela(){
     ArrayList dados = new ArrayList<>();
     String [] colunas = new String[]{"ID", "Temperatura"};
     String sql = "SELECT * FROM temperatura ORDER BY valor DESC ";
     
     
     try {
           //int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de temperaturas"));
           ConexaoBD bd = new ConexaoBD();
           Connection conn = bd.obtemConexao();
           PreparedStatement ps = conn.prepareStatement(sql);             
              
           ResultSet rs = ps.executeQuery(sql);
           rs.first();
           //ps.setInt(1, quantidade);
           do{
               
               dados.add(new Object[]{rs.getInt("id"),rs.getDouble("valor")});      
           }while(rs.next());
     }
           
     catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}     
      
     JTable tabela = new JTable();   
     Tabela modelo = new Tabela(dados, colunas);
     tabela.setModel(modelo);
     JFrame tela = new JFrame();
     
     
     JPanel painel = new JPanel();
     painel.add(new JScrollPane(tabela));
     add(painel, BorderLayout.CENTER);
   }
   
      
   public static void main(String[] args) {
      Connection conn = null;
      Temperatura temperatura;
      PreparedStatement stm = null;
      ResultSet rs = null;
      
      try {
         ConexaoBD bd = new ConexaoBD();
         conn = bd.conectar();
         conn.setAutoCommit(false);
         
         
         for(int i = 0; i < 100; i++){
        	 temperatura = new Temperatura();
        	 temperatura.setValor(40*Math.random());
        	 temperatura.incluir(conn);
         }
         
         conn.commit();
         //Termometro termo = new Termometro();
         //pega as temperaturas do ultimos 30 dias
         //Temperatura[] temps = termo.ultimosDias(conn, 300);
         //imprime as temperaturas
         //for(int i = 0; i < temps.length; i++){
        	 //System.out.println(temps[i]);
         //}
      } 
      catch (Exception e) {
         e.printStackTrace();
         if (conn != null) {
            try {
               conn.rollback();
            } 
            catch (SQLException e1) {
               System.out.print(e1.getStackTrace());
            }
         }
      } 
      finally {
         if (conn != null) {
            try {
               conn.close();
            } 
            catch (SQLException e1) {
               System.out.print(e1.getStackTrace());
            }
         }
      } 
      
    Teste t = new Teste(); // chamar classe ControlFrame transformadno em objeto
    t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//oq faz quando clicar no X 
    t.setSize(400, 400); // Tamanho da janela, largura x altura
    t.setVisible(true); // Janela estará visivel*/
    t.setLocationRelativeTo(null); // Iniciar no centro da Tela
    t.setResizable(false); 
     
   }
}