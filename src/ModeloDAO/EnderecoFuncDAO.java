
package ModeloDAO;

import ModeloBeans.EnderecoFunc;
import ModeloConexão.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class EnderecoFuncDAO {
        ConexaoBD conex = new ConexaoBD();
        EnderecoFunc func_end = new EnderecoFunc();
        
        public void CadastrarFunc_end(EnderecoFunc func_end) throws SQLException{
            conex.conectar();
            try {
                conex.con.setAutoCommit(false);
                PreparedStatement pst = conex.con.prepareStatement("insert into endereco_func (cpf_func ,rua, bairro, numero, cidade, cep) values(?,?,?,?,?,?)");
                pst.setInt(1, func_end.getCpf_func());
                pst.setString(2, func_end.getRua());
                pst.setString(3, func_end.getBairro());
                pst.setInt(4, func_end.getNumero());
                pst.setString(5, func_end.getCidade());
                pst.setInt(6, func_end.getCep());
                pst.execute();
                conex.con.commit();
                //JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
            } catch (SQLException ex) {
                conex.con.rollback();
                JOptionPane.showMessageDialog(null, "Erro na inserção dos dados!"+ex);
            }
            
            conex.desconectar();
        }
        
        public void EditarClEnd(EnderecoFunc func_end) throws SQLException{
            conex.conectar();
            String consulta3 = "update endereco_func set cidade = ?, bairro = ?, rua = ?, numero = ?, cep = ? where cpf_func = ?";
            PreparedStatement pst;
            try {
                conex.con.setAutoCommit(false);
                pst = conex.con.prepareStatement(consulta3);
                pst.setString(1, func_end.getCidade());
                pst.setString(2, func_end.getBairro());
                pst.setString(3, func_end.getRua());
                pst.setInt(4, func_end.getNumero());
                pst.setInt(5, func_end.getCep());
                pst.setInt(6, func_end.getCpf_func());
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
