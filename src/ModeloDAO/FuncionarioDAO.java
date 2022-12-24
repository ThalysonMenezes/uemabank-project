
package ModeloDAO;

import ModeloBeans.FuncionarioBeans;
import ModeloConexão.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class FuncionarioDAO {
        ConexaoBD conex = new ConexaoBD();
        FuncionarioBeans func = new FuncionarioBeans();
        
        public void Cadastrar_func(FuncionarioBeans func) throws SQLException{
            conex.conectar();
            try {
                conex.con.setAutoCommit(false);
                PreparedStatement pst = conex.con.prepareStatement("insert into funcionario (cpf_func, nome, card_code, telefone, cargo) values(?,?,?,?,?)");
                pst.setInt(1, func.getCPF());
                pst.setString(2, func.getNome());
                pst.setString(3, func.getCardcode());
                pst.setInt(4, func.getTelefone());
                pst.setString(5, func.getCargo());
                pst.execute();
                conex.con.commit();
                JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
            } catch (SQLException ex) {
                conex.con.rollback();
                JOptionPane.showMessageDialog(null, "Erro na inserção dos dados!"+ex);
            }
            
            conex.desconectar();
        }
        
        public void Inserir_card(FuncionarioBeans func) throws SQLException{
            conex.conectar();
            try {
                conex.con.setAutoCommit(false);
                String consulta2 = "update funcionario set card_code=? where cpf_func =?";
                PreparedStatement pst = conex.con.prepareStatement(consulta2);
                pst.setString(1, func.getCardcode());
                pst.setInt(2, func.getCPF());
                pst.execute();
                conex.con.commit();
                //JOptionPane.showMessageDialog(null, "Conta do funcionario criada com sucesso");
            } catch (SQLException ex) {
                conex.con.rollback();
                JOptionPane.showMessageDialog(null, "Erro ao criar conta: "+ex);
            }
    }
        
        public void EditarFunc(FuncionarioBeans func) throws SQLException{
            conex.conectar();
            String consulta3 = "update funcionario set nome=?, cargo = ?, telefone = ? where cpf_func = ?";
            PreparedStatement pst;
            try {
                conex.con.setAutoCommit(false);
                pst = conex.con.prepareStatement(consulta3);
                pst.setString(1, func.getNome());
                pst.setString(2, func.getCargo());
                pst.setInt(3, func.getTelefone());
                pst.setInt(4, func.getCPF());
                pst.execute();
                conex.con.commit();
                JOptionPane.showMessageDialog(null, "Conta do funcionario alterada com sucesso");
            } catch (SQLException ex) {
                conex.con.rollback();
                JOptionPane.showMessageDialog(null, "Erro ao alterar conta: "+ex);
            }
            
            
            conex.desconectar();
        }
}