
package ModeloBeans;


public class ClienteBeans {

    private String nome;
    private int CPF;
    private int telefone;
    private String nascimento;
    private int compresid;
    private String cardcode;
    
   
    public String getNome() {
        return nome;
    }

    
    public void setNome(String nome) {
        this.nome = nome;
    }

   
    public int getCPF() {
        return CPF;
    }

   
    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

   
    public int getTelefone() {
        return telefone;
    }

    
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    
    public String getNascimento() {
        return nascimento;
    }

    
    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    
    public int getCompresid() {
        return compresid;
    }

    /**
     * @param compresid the compresid to set
     */
    public void setCompresid(int compresid) {
        this.compresid = compresid;
    }

    
    public String getCardcode() {
        return cardcode;
    }

   
    public void setCardcode(String cardcode) {
        this.cardcode = cardcode;
    }
    
}
