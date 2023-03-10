package ModeloBeans;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class TabelaBeans extends AbstractTableModel{

    private ArrayList linhas = null;
    private String[] colunas = null;
    
    public ArrayList getLinhas() {
        return linhas;
    }

    
    public void setLinhas(ArrayList linhas) {
        this.linhas = linhas;
    }

    
    public String[] getColunas() {
        return colunas;
    }

    
    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }
    
    public TabelaBeans (ArrayList lin, String[] col){
       setLinhas(lin);
       setColunas(col);

    }
    public int getColumnCount(){
        return colunas.length;

    }
    public int getRowCount(){
        return linhas.size();
    }
    public String getColumnName(int numCol){
            return colunas[numCol];

    }

  public Object getValueAt(int numLin, int numCol){
   Object[] linha = (Object[])getLinhas().get(numLin);
   return linha[numCol];
  } 
 }