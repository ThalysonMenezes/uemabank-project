
package ModeloDAO;

import ModeloBeans.EnderecoClienteBeans;
import ModeloConexão.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class EnderecoClienteDAO {
        ConexaoBD conex = new ConexaoBD();
        EnderecoClienteBeans cl_end = new EnderecoClienteBeans();
        
        public void CadastrarCl_end(EnderecoClienteBeans cl_end) throws SQLException{
            conex.conectar();
            try {
                conex.con.setAutoCommit(false);
                String consulta1 = "insert into endereco_cliente (cpf_cliente ,rua, bairro, numero, cidade, cep) values (?,?,?,?,?,?)";
                PreparedStatement pst = conex.con.prepareStatement(consulta1);
                pst.setInt(1, cl_end.getCpf_cliente());
                pst.setString(2, cl_end.getRua());
                pst.setString(3, cl_end.getBairro());
                pst.setInt(4, cl_end.getNumero());
                pst.setString(5, cl_end.getCidade());
                pst.setInt(6, cl_end.getCep());
                pst.execute();
                conex.con.commit();
                //JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
            } catch (SQLException ex) {
                conex.con.rollback();
                JOptionPane.showMessageDialog(null, "Erro no EnderecoCLienteDAO dos dados!"+ex);
            }
            
            conex.desconectar();
        }
        
        public void EditarClEnd(EnderecoClienteBeans cl_end) throws SQLException{
            conex.conectar();
            String consulta3 = "update endereco_cliente set cidade = ?, bairro = ?, rua = ?, numero = ?, cep = ? where cpf_cliente = ?";
            PreparedStatement pst;
            try {
                conex.con.setAutoCommit(false);
                pst = conex.con.prepareStatement(consulta3);
                pst.setString(1, cl_end.getCidade());
                pst.setString(2, cl_end.getBairro());
                pst.setString(3, cl_end.getRua());
                pst.setInt(4, cl_end.getNumero());
                pst.setInt(5, cl_end.getCep());
                pst.setInt(6, cl_end.getCpf_cliente());
                pst.execute();
                conex.con.commit();
                JOptionPane.showMessageDialog(null, "Conta do cliente alterada com sucesso");
            } catch (SQLException ex) {
                conex.con.rollback();
                JOptionPane.showMessageDialog(null, "Erro ao alterar conta: "+ex);
            }
            
            
            conex.desconectar();
        }
        
        public void ExcluirClEnd(EnderecoClienteBeans cl){
            conex.conectar();
            String consulta4 = "delete from endereco_cliente where cpf_cliente = ?";
            PreparedStatement pst;
            try {
                pst = conex.con.prepareStatement(consulta4);
                pst.setInt(1, cl_end.getCpf_cliente());
                pst.execute();
                //JOptionPane.showMessageDialog(null, "Usuário excluido com sucesso!");
            } catch (SQLException ex) {
                //JOptionPane.showMessageDialog(null, "Erro ao excluir conta: "+ex);
            }     
            conex.desconectar();
        }
}
