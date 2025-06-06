/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import model.Aluno;
import model.OrdenacaoMatricula;
import model.OrdenacaoMatriculaDecrescente;
import model.OrdenacaoNotaDecrescente;
import model.OrdenacaoPorNome;
import model.OrdenacaoPorNomeDecrescente;
import model.OrdenacaoPorNota;
import model.Turma;

/**
 *
 * @author Master
 */
public class ListagemTurmaUi extends javax.swing.JDialog {

     Turma turmaListagem = new Turma();    
    /**
     * Creates new form ListagemTurmaUi
     */
    public ListagemTurmaUi(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg_ordenacao = new javax.swing.ButtonGroup();
        bg_TipoOrdenacao = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        taRelatorio = new javax.swing.JTextArea();
        btFechar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        rbNome = new javax.swing.JRadioButton();
        rbMatricula = new javax.swing.JRadioButton();
        rbNota = new javax.swing.JRadioButton();
        rbCrescente = new javax.swing.JRadioButton();
        rbDecrescente = new javax.swing.JRadioButton();
        butListar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        taRelatorio.setColumns(20);
        taRelatorio.setRows(5);
        jScrollPane1.setViewportView(taRelatorio);

        btFechar.setText("Fechar");
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(" Ordenação "));

        bg_ordenacao.add(rbNome);
        rbNome.setText("Nome");

        bg_ordenacao.add(rbMatricula);
        rbMatricula.setText("Matrícula");

        bg_ordenacao.add(rbNota);
        rbNota.setText("Nota");

        bg_TipoOrdenacao.add(rbCrescente);
        rbCrescente.setText("Crescente");

        bg_TipoOrdenacao.add(rbDecrescente);
        rbDecrescente.setText("Decrescente");

        butListar.setText("Listar");
        butListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butListarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbNome)
                .addGap(18, 18, 18)
                .addComponent(rbMatricula)
                .addGap(18, 18, 18)
                .addComponent(rbNota)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(rbCrescente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbDecrescente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(butListar)
                .addGap(58, 58, 58))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbNome)
                    .addComponent(rbMatricula)
                    .addComponent(rbNota))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbCrescente)
                            .addComponent(rbDecrescente)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(butListar)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btFechar)
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btFechar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_btFecharActionPerformed

    private void butListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butListarActionPerformed
        // TODO add your handling code here:
        
        definirTurma(turmaListagem);
    }//GEN-LAST:event_butListarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ListagemTurmaUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListagemTurmaUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListagemTurmaUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListagemTurmaUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ListagemTurmaUi dialog = new ListagemTurmaUi(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bg_TipoOrdenacao;
    private javax.swing.ButtonGroup bg_ordenacao;
    private javax.swing.JButton btFechar;
    private javax.swing.JButton butListar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbCrescente;
    private javax.swing.JRadioButton rbDecrescente;
    private javax.swing.JRadioButton rbMatricula;
    private javax.swing.JRadioButton rbNome;
    private javax.swing.JRadioButton rbNota;
    private javax.swing.JTextArea taRelatorio;
    // End of variables declaration//GEN-END:variables

    public void definirTurma(Turma turma){
        
        turmaListagem = turma;
        
        taRelatorio.setText("");
        taRelatorio.append("Disciplina: "+turma.getDisciplina());
        taRelatorio.append("\n Turno: "+turma.getTurno().toString());
        taRelatorio.append("\n ---------------------------------------------------");
        taRelatorio.append("\n Professor: "+turma.getProfessor().getNome());
        taRelatorio.append("\n Titulação: "+turma.getProfessor().getTitulacao().toString());
        taRelatorio.append("\n ---------------------------------------------------");
        taRelatorio.append("\n Total de alunos: "+turma.getAlunos().size());
        
        ArrayList<Aluno> listaAlunos = turma.getAlunos();
        
        if (rbNome.isSelected()){
            if (rbCrescente.isSelected()){
                Collections.sort(listaAlunos, new OrdenacaoPorNome());
            }else if (rbDecrescente.isSelected()){
                Collections.sort(listaAlunos, new OrdenacaoPorNomeDecrescente());
            }
        }else if (rbMatricula.isSelected()){
             if (rbCrescente.isSelected()){
                Collections.sort(listaAlunos, new OrdenacaoMatricula());
            }else if (rbDecrescente.isSelected()){
                Collections.sort(listaAlunos, new OrdenacaoMatriculaDecrescente());
            }
        }else if (rbNota.isSelected()){
             if (rbCrescente.isSelected()){
                Collections.sort(listaAlunos, new OrdenacaoPorNota());
            }else if (rbDecrescente.isSelected()){
                Collections.sort(listaAlunos, new OrdenacaoNotaDecrescente());
            }
        }
        
        
        for(Aluno alu : listaAlunos){
            taRelatorio.append("\n "+alu.getNome() + " "+ alu.getMatricula()+ " - Nota ENEM: "+alu.getNotaEnem());
            
        }
        
        Aluno aluno = turma.obterAlunoMelhorNotaEnem();
                
        taRelatorio.append("\n Aluno(a) com melhor nota: "+aluno.getNome() + " - ("+aluno.getNotaEnem()+")");
    }
}
