
package ModeloDAO;

import ModeloBeans.ClienteBeans;
import ModeloConexão.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ClienteDAO {
        ConexaoBD conex = new ConexaoBD();
        ClienteBeans cl = new ClienteBeans();
        
        public void Cadastrar_cl(ClienteBeans cl) throws SQLException{
            conex.conectar();
            try {
                conex.con.setAutoCommit(false);
                String consulta1 = "insert into cliente (cpf_cliente, nome, telefone, nascimento, comp_resid, card_code) values(?,?,?,?,?,?)";
                PreparedStatement pst = conex.con.prepareStatement(consulta1);
                pst.setInt(1, cl.getCPF());
                pst.setString(2, cl.getNome());
                pst.setInt(3, cl.getTelefone());
                pst.setString(4, cl.getNascimento());
                pst.setInt(5, cl.getCompresid());
                pst.setString(6, cl.getCardcode());
                pst.execute();
                conex.con.commit();
                //JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
            } catch (SQLException ex) {
                conex.con.rollback();
                JOptionPane.showMessageDialog(null, "Erro na inserção dos dados do cliente!"+ex);
            }
            
            conex.desconectar();
        }
        
        public void Inserir_card(ClienteBeans cl) throws SQLException{
            conex.conectar();
            try {
                conex.con.setAutoCommit(false);
                String consulta2 = "update cliente set card_code=? where cpf_cliente =?";
                PreparedStatement pst = conex.con.prepareStatement(consulta2);
                pst.setString(1, cl.getCardcode());
                pst.setInt(2, cl.getCPF());
                pst.execute();
                conex.con.commit();
                //JOptionPane.showMessageDialog(null, "Conta do cliente criada com sucesso");
            } catch (SQLException ex) {
                conex.con.rollback();
                JOptionPane.showMessageDialog(null, "Erro ao criar conta: "+ex);
            }
            
            conex.desconectar();
        }
        
        public void EditarCl(ClienteBeans cl) throws SQLException{
            conex.conectar();
            String consulta3 = "update cliente set nome=?, telefone = ?, nascimento = ? where cpf_cliente = ?";
            PreparedStatement pst;
            try {
                conex.con.setAutoCommit(false);
                pst = conex.con.prepareStatement(consulta3);
                pst.setString(1, cl.getNome());
                pst.setInt(2, cl.getTelefone());
                pst.setString(3, cl.getNascimento());
                pst.setInt(4, cl.getCPF());
                pst.execute();
                conex.con.commit();
                //JOptionPane.showMessageDialog(null, "Conta do cliente alterada com sucesso");
            } catch (SQLException ex) {
                conex.con.rollback();
                JOptionPane.showMessageDialog(null, "Erro ao alterar conta: "+ex);
            }
            
            
            conex.desconectar();
        }
        
        public void ExcluirCl(ClienteBeans cl){
            conex.conectar();
            String consulta4 = "delete from cliente where cpf_cliente = ?";
            PreparedStatement pst;
            try {
                pst = conex.con.prepareStatement(consulta4);
                pst.setInt(1, cl.getCPF());
                pst.execute();
                //JOptionPane.showMessageDialog(null, "Usuário excluido com sucesso!");
            } catch (SQLException ex) {
                //JOptionPane.showMessageDialog(null, "Erro ao excluir conta: "+ex);
            }     
            conex.desconectar();
        }
        
        
}
