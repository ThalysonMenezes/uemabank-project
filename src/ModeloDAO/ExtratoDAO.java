/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloBeans.ExtratoBeans;
import ModeloConexão.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ExtratoDAO {
ConexaoBD conex = new ConexaoBD();
ExtratoBeans eb = new ExtratoBeans();
        
        public void CadastrarExtrato(ExtratoBeans eb){
            conex.conectar();
            try {
                PreparedStatement pst = conex.con.prepareStatement("insert into extrato (card_code ,ação, valor, dat) values(?,?,?,?)");
                pst.setString(1, eb.getCardcode());
                pst.setString(2, eb.getAção());
                pst.setDouble(3, eb.getValor());
                pst.setString(4, eb.getDat());
                pst.execute();
                //JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro na inserção dos dados!"+ex);
            }
            
            conex.desconectar();
        }    
}
