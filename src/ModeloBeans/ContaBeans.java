/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloBeans;


public class ContaBeans {

    /**
     * @return the pesquisa
     */
    public String getPesquisa() {
        return pesquisa;
    }

    /**
     * @param pesquisa the pesquisa to set
     */
    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    /**
     * @return the funcionario
     */
    public int getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(int funcionario) {
        this.funcionario = funcionario;
    }

    /**
     * @return the cliente
     */
    public int getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(int cliente) {
        this.cliente = cliente;
    }
    
    private String card_code;
    private Double saldo_poupanca;
    private Double saldo_corrente;
    private int corrente;
    private int poupanca;
    private String senha;
    private String n_agen;
    private int funcionario;
    private int cliente;
    private String pesquisa;
    
    public String getCard_code() {
        return card_code;
    }

    public void setCard_code(String card_code) {
        this.card_code = card_code;
    }

    public Double getSaldo_poupanca() {
        return saldo_poupanca;
    }

    public void setSaldo_poupanca(Double saldo_poupanca) {
        this.saldo_poupanca = saldo_poupanca;
    }

    public Double getSaldo_corrente() {
        return saldo_corrente;
    }

    public void setSaldo_corrente(Double saldo_corrente) {
        this.saldo_corrente = saldo_corrente;
    }

    public int getCorrente() {
        return corrente;
    }

    public void setCorrente(int corrente) {
        this.corrente = corrente;
    }

    public int getPoupanca() {
        return poupanca;
    }

    public void setPoupanca(int poupanca) {
        this.poupanca = poupanca;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getN_agen() {
        return n_agen;
    }

    public void setN_agen(String n_agen) {
        this.n_agen = n_agen;
    }
    
    //Manipulando os dados
 
    public Double setDepositarCo(Double saldo_corrente, Double deposito) {
        this.saldo_corrente = saldo_corrente + deposito;
        return this.saldo_corrente;
    }
    
    public Double setDepositarPo(Double saldo_poupanca, Double deposito) {
        this.saldo_poupanca = saldo_poupanca + deposito;
        return this.saldo_poupanca;
    }
    
    public Double setSaqueCo(Double saldo_corrente, Double saque) {
        this.saldo_corrente = saldo_corrente - saque;
        return this.saldo_corrente;
    }
    
    public Double setSaquePo(Double saldo_poupanca, Double saque) {
        this.saldo_poupanca = saldo_poupanca - saque;
        return this.saldo_poupanca;
    }
}
