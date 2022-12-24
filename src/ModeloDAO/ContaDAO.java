/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloBeans.ContaBeans;
import ModeloConexão.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ContaDAO {
        ConexaoBD conex = new ConexaoBD();
        ContaBeans conb = new ContaBeans();
        
        public void Cadastrar_conta(ContaBeans conb){
            conex.conectar();
            try {
                String consulta1 = "insert into conta (card_code, saldo_poupanca, saldo_corrente, poupanca, corrente, senha, n_agen, funcionario, cliente) values(?,?,?,?,?,?,?,?,?)";
                PreparedStatement pst = conex.con.prepareStatement(consulta1);
                pst.setString(1, conb.getCard_code());
                pst.setDouble(2, conb.getSaldo_poupanca());
                pst.setDouble(3, conb.getSaldo_corrente());
                pst.setInt(4, conb.getPoupanca());
                pst.setInt(5, conb.getCorrente());
                pst.setString(6, conb.getSenha());
                pst.setString(7, conb.getN_agen());
                pst.setInt(8, conb.getFuncionario());
                pst.setInt(9, conb.getCliente());
                pst.execute();
                //JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro na inserção dos dados!"+ex);
            }
            
            conex.desconectar();
        }
        
        public ContaBeans buscarSaldoCo(ContaBeans cb1){
            conex.conectar();
            try {
                conex.executaSql("select saldo_corrente from conta where card_code like '%"+cb1.getPesquisa()+"%'");
                conex.rs.first();
                cb1.setSaldo_corrente(conex.rs.getDouble("saldo_corrente"));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Cardcode não encontrado"+ex);
            }
            
            conex.desconectar();
            return cb1;
        }
        
        public ContaBeans buscarSaldoPo(ContaBeans cb2){
            conex.conectar();
            try {
                conex.executaSql("select saldo_poupanca from conta where card_code like '%"+cb2.getPesquisa()+"%'");
                conex.rs.first();
                cb2.setSaldo_poupanca(conex.rs.getDouble("saldo_poupanca"));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Cardcode não encontrado"+ex);
            }
            
            conex.desconectar();
            return cb2;
        }
        
        public void DepositarCo(ContaBeans cb3) throws SQLException{
            conex.conectar();
            try {
                conex.con.setAutoCommit(false);
                String consulta2 = "update conta set saldo_corrente = ? where card_code = ?";
                PreparedStatement pst = conex.con.prepareStatement(consulta2);
                pst.setDouble(1, cb3.getSaldo_corrente());
                pst.setString(2, cb3.getCard_code());
                pst.execute();
                conex.con.commit();
            } catch (SQLException ex) {
                conex.con.rollback();
                JOptionPane.showMessageDialog(null, "Erro ao depositar na conta corrente: "+ex);
            }
            
            conex.desconectar();           
        }
        
        public void DepositarPo(ContaBeans cb3) throws SQLException{
            conex.conectar();
            try {
                conex.con.setAutoCommit(false);
                String consulta3 = "update conta set saldo_poupanca = ? where card_code = ?";
                PreparedStatement pst = conex.con.prepareStatement(consulta3);
                pst.setDouble(1, cb3.getSaldo_poupanca());
                pst.setString(2, cb3.getCard_code());
                pst.execute();
                conex.con.commit();
            } catch (SQLException ex) {
                conex.con.rollback();
                JOptionPane.showMessageDialog(null, "Erro ao depositar na conta poupança: "+ex);
            }
            
            conex.desconectar();           
        }
        
        public void SaqueCo(ContaBeans cb4) throws SQLException{
            conex.conectar();
            try {
                conex.con.setAutoCommit(false);
                String consulta4 = "update conta set saldo_corrente = ? where card_code = ?";
                PreparedStatement pst = conex.con.prepareStatement(consulta4);
                pst.setDouble(1, cb4.getSaldo_corrente());
                pst.setString(2, cb4.getCard_code());
                pst.execute();
                conex.con.commit();
            } catch (SQLException ex) {
                conex.con.rollback();
                JOptionPane.showMessageDialog(null, "Não foi possivel sacar "+ex);
            }
            
            conex.desconectar();           
        }
        
         public void SaquePo(ContaBeans cb5) throws SQLException{
            conex.conectar();
            try {
                conex.con.setAutoCommit(false);
                String consulta5 = "update conta set saldo_poupanca = ? where card_code = ?";
                PreparedStatement pst = conex.con.prepareStatement(consulta5);
                pst.setDouble(1, cb5.getSaldo_poupanca());
                pst.setString(2, cb5.getCard_code());
                pst.execute();
                conex.con.commit();
            } catch (SQLException ex) {
                conex.con.rollback();
                JOptionPane.showMessageDialog(null, "Não foi possivel sacar "+ex);
            }
            
            conex.desconectar();           
        }
        public void EditarConta(ContaBeans cb6){
            conex.conectar();
            String consulta6 = "update conta set saldo_poupanca=?, saldo_corrente = ?, poupanca = ?, corrente = ?, senha = ? where card_code = ?";
            PreparedStatement pst;
            try {
                pst = conex.con.prepareStatement(consulta6);
                pst.setDouble(1, cb6.getSaldo_poupanca());
                pst.setDouble(2, cb6.getSaldo_corrente());
                pst.setInt(3, cb6.getPoupanca());
                pst.setInt(4, cb6.getCorrente());
                pst.setString(5, cb6.getSenha());
                pst.setString(6, cb6.getCard_code());
                pst.execute();
                //JOptionPane.showMessageDialog(null, "Conta alterada com sucesso");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao alterar conta: "+ex);
            }
            
            
            conex.desconectar();
        }
        
        public void ExcluirConta(ContaBeans cb){
            conex.conectar();
            String consulta7 = "delete from conta where card_code = ?";
            PreparedStatement pst;
            try {
                pst = conex.con.prepareStatement(consulta7);
                pst.setString(1, cb.getCard_code());
                pst.execute();
                //JOptionPane.showMessageDialog(null, "Usuário excluido com sucesso!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir conta: "+ex);
            }     
            conex.desconectar();
        }
}
