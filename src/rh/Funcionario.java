package rh;


public class Funcionario {
    private String nome;
    private String cpf;
    private String cep;
    private boolean alocado;
    
    public Funcionario(String nome, String cpf, String cep) {
        setNome(nome);
        setCpf(cpf);
        setCep(cep);
        setLocacao(false);
    }
    
    private void setNome(String nome) {
        this.nome = nome;
    }

    private void setCpf(String cpf) {
        this.cpf = cpf;
    }

    private void setCep(String cep) {
        this.cep = cep;
    }
 
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCep() {
        return cep;
    }
    
    public void setLocacao(boolean locacao) {
        this.alocado = locacao;
    }
}
