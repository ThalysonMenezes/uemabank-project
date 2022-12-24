
package ModeloBeans;


public class EnderecoFunc {

        private String cidade;
        private String bairro;
        private String rua;
        private int cep;
        private int numero;
        private int cpf_func;
    
    public int getCpf_func() {
        return cpf_func;
    }

    public void setCpf_func(int cpf_func) {
        this.cpf_func = cpf_func;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
