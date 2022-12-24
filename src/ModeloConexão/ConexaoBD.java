/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloConexão;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Thalyson
 */
public class ConexaoBD {
    private static final String DRIVER = "";
    private static final String URL = "";
    private static final String USER = "root";
    private static final String PASS = "";
    public Connection con;
    public Statement stm;
    public ResultSet rs;
    
    public void conectar(){
        try {
            System.setProperty("jdbc.Drivers",DRIVER);
            con = DriverManager.getConnection(URL, USER, PASS);
             //JOptionPane.showMessageDialog(null, "Conexão efetuada com sucesso!");
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "erro ao se conectar ao BD!"+ex.getMessage());
        }
    }
    
    public void executaSql(String sql){
        
        try {
            stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro executaSql\n"+ex.getMessage());
        }
        
    }
    
    public void desconectar(){
            try {
                
                con.close();
                //JOptionPane.showMessageDialog(null, "BD desconectado com sucesso!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "erro ao se desconectar do BD!"+ex.getMessage());
            }
    }
}