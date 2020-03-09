import javax.swing.JOptionPane;

public class Solucao4 {

    public static void main (String [] args){
        int peso = Integer.parseInt (JOptionPane.showInputDialog ("Digite o peso"));

        JOptionPane.showMessageDialog (null, peso +" Kg");
    }
}