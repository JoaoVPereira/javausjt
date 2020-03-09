import javax.swing.JOptionPane;

public class Solucao2 {
	public static void main (String [] args){
		int numero = Integer.parseInt (JOptionPane.showInputDialog ("Digite o numero"));
		
		JOptionPane.showMessageDialog (null,"O valor digitado é:"+ numero );
	}
}