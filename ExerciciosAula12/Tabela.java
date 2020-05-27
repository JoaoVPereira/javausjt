
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.text.*;

public class Tabela extends AbstractTableModel {

    private String[] colunas = null;
    private ArrayList linhas = null;

    public Tabela(ArrayList lin, String[] col){
         setLinhas(lin);
         setColunas(col);
    }
    
    public ArrayList getLinhas(){
         return linhas;
    }
    
    public void setLinhas(ArrayList linhas){
         this.linhas = linhas;
    }
    public String[] getColunas(){
         return colunas;
    }
    public void setColunas(String[] colunas){
         this.colunas = colunas;
    }
    
    public int getRowCount(){
        return linhas.size();
    }
    public int getColumnCount(){
        return colunas.length;
    }
    public Object getValueAt(int numLin, int numCol){
        Object[] linha = (Object[])getLinhas().get(numLin);
        return linha[numCol];
    }

    public String getColumnName(int indice){
        return colunas[indice];
    }
   
}