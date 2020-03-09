import javax.swing.JOptionPane;
public class Solucao3 {
    public static void main (String []args){
        int dia = Integer.parseInt(JOptionPane.showInputDialog ("Digite a data"));
        int mes = Integer.parseInt(JOptionPane.showInputDialog("Digite o mes"));
        int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano"));

        JOptionPane.showMessageDialog (null, dia +" / "+ mes +" / "+ ano);
    }
}