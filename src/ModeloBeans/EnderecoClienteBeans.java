
package ModeloBeans;


public class EnderecoClienteBeans {

        private String cidade;
        private String bairro;
        private String rua;
        private int cep;
        private int numero;
        private int cpf_cliente;
    
    public int getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(int cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
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
