import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Cliente implements IDados{
    protected int id;
    protected String nome;
    protected String celular;
    protected String email;
    protected LocalDate dataCadastro;
    protected List<Veiculo> listaDeVeiculos; // Associção Bidirecional com multiplicidade 1(cliente) para Muitos(veiculo).
    protected Pontuacao pontuacao; // Associação Unidirecional

    public Cliente(int id, String nome, String celular, String email, LocalDate dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.celular = celular;
        this.email = email;
        this.dataCadastro = dataCadastro;
        this.listaDeVeiculos = new ArrayList<Veiculo>(); // Desta forma ao instanciar um cliente eu inicializo a lista de veiculos dele.
        this.pontuacao = new Pontuacao(); // Ao criar um Cliente, seja PF ou PJ ele já vem com pontuação inicializada, assim respeitando a composição.
    }

    @Override
    public String getDados(){
        StringBuilder dados = new StringBuilder();
        dados.append("Nome...............: " + nome).append("\n");
        dados.append("Celular............: " + celular).append("\n");
        dados.append("E-mail.............: " + email).append("\n");
        dados.append("Data de Cadastro...: " + dataCadastro).append("\n");
        return dados.toString();
    }
    @Override
    public String getDados(String observacao){
        StringBuilder dados = new StringBuilder(getDados());
        dados.append("Observação.....: "+ observacao);
        return dados.toString();
    }
    public abstract boolean temDescontoAniversario();

    public void addVeiculo(Veiculo veiculo) {
        this.listaDeVeiculos.add(veiculo);
        veiculo.setCliente(this);
    }

    public void removeVeiculo(Veiculo veiculo) {
        this.listaDeVeiculos.remove(veiculo);
        veiculo.setCliente(null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public List<Veiculo> getListaDeVeiculos() {
        return listaDeVeiculos;
    }

    public void setListaDeVeiculos(List<Veiculo> listaDeVeiculos) {
        this.listaDeVeiculos = listaDeVeiculos;
    }

    public Pontuacao getPontuacao() {
        return pontuacao;
    }

    // Não se dever ter setPontuacao por causa da composição.

    @Override
    public String toString() {
        return "Informaçãoes do Cliente:\n" +
                "Identificação......: " + id +
                " | Nome..............: " + nome +
                " | Celular...........: " + celular +
                " | E-mail............: " + email +
                " | Data de Cadastro..: " + dataCadastro +
                " | Número de Veículos: " + listaDeVeiculos.size();
    }
}
