/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import ModeloBeans.ClienteBeans;
import ModeloBeans.ContaBeans;
import ModeloBeans.EnderecoClienteBeans;
import ModeloBeans.TabelaBeans;
import ModeloConexão.ConexaoBD;
import ModeloDAO.ClienteDAO;
import ModeloDAO.ContaDAO;
import ModeloDAO.EnderecoClienteDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
public class ExibirContas extends javax.swing.JFrame {

    
    ConexaoBD conex = new ConexaoBD(); 
    int duv = 0;
    String card_code = "0";
    int flag = 0;
    
    public ExibirContas() {
        initComponents();
        jRadioButton3.setEnabled(false);
        jRadioButton4.setEnabled(false);
        jRadioButton5.setEnabled(false);
    }

     public void preencherTabela(String Sql){ 
         ArrayList dados2 = new ArrayList();
             String[] colunas = new String []{"Nome", "Conta", "Saldo Poupança", "Saldo Corrente"};
             conex.conectar();
             conex.executaSql(Sql);
      try {
          conex.rs.first();
          do{
              dados2.add(new Object[]{conex.rs.getString("nome"), conex.rs.getString("card_code"), conex.rs.getDouble("saldo_poupanca"), conex.rs.getDouble("saldo_corrente")});
          }while(conex.rs.next());
      } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"dps "+ex);
      }
       TabelaBeans contas = new TabelaBeans(dados2, colunas);
       jTable1.setModel(contas);
       jTable1.getColumnModel().getColumn(0).setPreferredWidth(348);
       jTable1.getColumnModel().getColumn(0).setResizable(false);
       jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
       jTable1.getColumnModel().getColumn(1).setResizable(false);
       jTable1.getColumnModel().getColumn(2).setPreferredWidth(101);
       jTable1.getColumnModel().getColumn(2).setResizable(false);
       jTable1.getColumnModel().getColumn(3).setPreferredWidth(95);
       jTable1.getColumnModel().getColumn(3).setResizable(false);
       jTable1.getTableHeader().setReorderingAllowed(false);
       jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
       jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       
             conex.desconectar();
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 153, 0));

        jLabel2.setFont(new java.awt.Font("Simplifica", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("UEMABANK");

        jLabel1.setForeground(new java.awt.Color(0, 153, 0));
        jLabel1.setText("jLabel1");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Simplifica", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Voltar");
        jLabel4.setOpaque(true);
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel1)
                .addGap(167, 167, 167)
                .addComponent(jLabel2)
                .addContainerGap(273, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(567, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(23, 23, 23)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(7, 7, 7)))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 650, 58);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 161, 650, 220);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(250, 70, 280, 35);

        jLabel5.setBackground(new java.awt.Color(0, 153, 0));
        jLabel5.setFont(new java.awt.Font("Simplifica", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Pesquisar");
        jLabel5.setOpaque(true);
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel5MousePressed(evt);
            }
        });
        getContentPane().add(jLabel5);
        jLabel5.setBounds(540, 70, 91, 35);

        jLabel6.setBackground(new java.awt.Color(0, 153, 0));
        jLabel6.setFont(new java.awt.Font("Simplifica", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Excluir");
        jLabel6.setOpaque(true);
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel6MousePressed(evt);
            }
        });
        getContentPane().add(jLabel6);
        jLabel6.setBounds(130, 70, 91, 35);

        jLabel7.setBackground(new java.awt.Color(0, 153, 0));
        jLabel7.setFont(new java.awt.Font("Simplifica", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Editar");
        jLabel7.setOpaque(true);
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel7MousePressed(evt);
            }
        });
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 70, 91, 35);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Cliente");
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jRadioButton1);
        jRadioButton1.setBounds(170, 110, 93, 23);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Funcionário");
        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton2MouseClicked(evt);
            }
        });
        getContentPane().add(jRadioButton2);
        jRadioButton2.setBounds(350, 110, 100, 23);

        buttonGroup5.add(jRadioButton3);
        jRadioButton3.setText("Corrente");
        jRadioButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jRadioButton3MousePressed(evt);
            }
        });
        getContentPane().add(jRadioButton3);
        jRadioButton3.setBounds(50, 130, 110, 23);

        buttonGroup5.add(jRadioButton4);
        jRadioButton4.setText("Poupança");
        jRadioButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jRadioButton4MousePressed(evt);
            }
        });
        getContentPane().add(jRadioButton4);
        jRadioButton4.setBounds(240, 130, 110, 23);

        buttonGroup5.add(jRadioButton5);
        jRadioButton5.setText("Ambas");
        jRadioButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jRadioButton5MousePressed(evt);
            }
        });
        getContentPane().add(jRadioButton5);
        jRadioButton5.setBounds(460, 130, 130, 23);

        setSize(new java.awt.Dimension(659, 420));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        // Botão voltar
        dispose();
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
        // Botão Pesquisar
    }//GEN-LAST:event_jLabel5MousePressed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed
        // Botão excluir
        if(duv != 1) {
            JOptionPane.showMessageDialog(null, "Tupla não selecionada!");
        } else {
            ClienteBeans cl = new ClienteBeans();
            EnderecoClienteBeans cl_end = new EnderecoClienteBeans();
            ClienteDAO cd = new ClienteDAO();
            EnderecoClienteDAO cl_endd = new EnderecoClienteDAO();
            ContaBeans cb = new ContaBeans();
            ContaDAO cbd = new ContaDAO();
            conex.conectar();           
            try 
            {
                conex.executaSql("select * from cliente where card_code = '"+card_code+"'");
                conex.rs.first();
                cl.setCPF(conex.rs.getInt("cpf_cliente"));
                cd.ExcluirCl(cl);
                conex.executaSql("select * from endereco_cliente where card_code = '"+card_code+"'");
                conex.rs.first();
                cl_end.setCpf_cliente(conex.rs.getInt("cpf_cliente"));
                cl_endd.ExcluirClEnd(cl_end);
                conex.executaSql("select * from conta where card_code = '"+card_code+"'");
                conex.rs.first();
                cb.setCard_code(conex.rs.getString("card_code"));
                cbd.ExcluirConta(cb);
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Erro ao excluir exibir contas "+ex);            
            }
            conex.desconectar();;
        }
    }//GEN-LAST:event_jLabel6MousePressed

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed
        // Botão editar
        if(duv != 1) {
            JOptionPane.showMessageDialog(null, "Tupla não selecionada!");
        } else {
            if(flag == 1){
            CadastrarCliente cl = new CadastrarCliente();
            conex.conectar();
            try {
                conex.executaSql("select * from cliente where card_code = '"+card_code+"'");
                conex.rs.first();
                cl.jTextField1.setText(conex.rs.getString("nome"));
                cl.jTextField3.setText(String.valueOf(conex.rs.getInt("cpf_cliente")));
                cl.jTextField3.setEnabled(false);
                cl.jTextField8.setText(String.valueOf(conex.rs.getInt("telefone")));
                cl.jTextField9.setText(conex.rs.getString("nascimento"));
                
                cl.jLabel15.setText(conex.rs.getString("card_code"));
                
                conex.executaSql("select * from endereco_cliente where cpf_cliente = '"+cl.jTextField3.getText()+"'");
                conex.rs.first();
                cl.jTextField2.setText(conex.rs.getString("cidade"));
                cl.jTextField4.setText(conex.rs.getString("bairro"));
                cl.jTextField5.setText(conex.rs.getString("rua"));
                cl.jTextField6.setText(String.valueOf(conex.rs.getInt("numero")));
                cl.jTextField7.setText(String.valueOf(conex.rs.getInt("cep")));

                cl.jLabel7.setText("editar");
            } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, "Erro: "+ex);
            }
            
            conex.desconectar();
            cl.setVisible(true);
            }
            if(flag == 2){
                CadastrarFuncionario func = new CadastrarFuncionario();
                conex.conectar();
            try {
                conex.executaSql("select * from funcionario where card_code = '"+card_code+"'");
                conex.rs.first();
                func.jTextField1.setText(conex.rs.getString("nome"));
                func.jTextField3.setText(String.valueOf(conex.rs.getInt("cpf_func")));
                func.jTextField3.setEnabled(false);
                func.jTextField10.setText(String.valueOf(conex.rs.getInt("telefone")));
                func.jTextField8.setText(conex.rs.getString("Cargo"));
                
                conex.executaSql("select * from endereco_func where cpf_func = '"+func.jTextField3.getText()+"'");
                conex.rs.first();
                func.jTextField2.setText(conex.rs.getString("cidade"));
                func.jTextField4.setText(conex.rs.getString("bairro"));
                func.jTextField5.setText(conex.rs.getString("rua"));
                func.jTextField6.setText(String.valueOf(conex.rs.getInt("numero")));
                func.jTextField7.setText(String.valueOf(conex.rs.getInt("cep")));
                
                func.jLabel7.setText("editar");
            } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, "Erro: "+ex);
            }
            conex.desconectar();
            func.setVisible(true);
            }
        }

    }//GEN-LAST:event_jLabel7MousePressed

    private void jRadioButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseClicked
        // Botão cliente
        
        buttonGroup5.clearSelection();
        if(jRadioButton1.isSelected()){
            card_code = "0";
            duv = 0;
            flag = 1;
            preencherTabela("select cl.nome, c.card_code, c.saldo_corrente, c.saldo_poupanca from cliente cl, conta c where c.card_code = cl.card_code");
            if(flag ==1){
                jRadioButton3.setEnabled(true);
                jRadioButton4.setEnabled(true);
                jRadioButton5.setEnabled(true);
            }
        }
    }//GEN-LAST:event_jRadioButton1MouseClicked

    private void jRadioButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MouseClicked
        // Botão Funcionário
        buttonGroup5.clearSelection();
        if(jRadioButton2.isSelected()){
            card_code = "0";
            duv = 0;
            flag = 2;
            preencherTabela("select func.nome, c.card_code, c.saldo_corrente, c.saldo_poupanca from funcionario func, conta c where c.card_code = func.card_code");
        if(flag ==2){
                jRadioButton3.setEnabled(true);
                jRadioButton4.setEnabled(true);
                jRadioButton5.setEnabled(true);
            }
        }
    }//GEN-LAST:event_jRadioButton2MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // tabela
        card_code = ""+jTable1.getValueAt(jTable1.getSelectedRow(), 1);
        duv = 1;
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jRadioButton3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton3MousePressed
        // Botao corrente
        if(flag == 1){
            if(jRadioButton3.isSelected()){
                preencherTabela("select * from uvwcorrenteativa");                
            }
        }else if(flag == 2){
            if(jRadioButton3.isSelected()){
                preencherTabela("select * from uvwcorrenteativafunc");                
            }
        }        
    }//GEN-LAST:event_jRadioButton3MousePressed

    private void jRadioButton4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton4MousePressed
        // Botao Poupanca
        if(flag == 1){
            if(jRadioButton4.isSelected()){
                preencherTabela("select * from uvwpoupancaativa;");                
            }
        }else if(flag == 2){
            if(jRadioButton4.isSelected()){
                preencherTabela("select * from uvwpoupancaativafunc;");                
            }
        }  
    }//GEN-LAST:event_jRadioButton4MousePressed

    private void jRadioButton5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton5MousePressed
        // Botao Ambas
        if(flag == 1){
            if(jRadioButton5.isSelected()){
                preencherTabela("select * from uvwcontaativa;;");                
            }
        }else if(flag == 2){
            if(jRadioButton5.isSelected()){
                preencherTabela("select * from uvwcontaativafunc;");                
            }
        } 
    }//GEN-LAST:event_jRadioButton5MousePressed

   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ExibirContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExibirContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExibirContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExibirContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExibirContas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup5;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
