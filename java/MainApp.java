import java.time.LocalDate;

public class MainApp {
    public static void main(String[] args) {

        Cor corAzul = new Cor("Azul");
        Cor corPrata = new Cor("Prata");
        Cor corVermelho = new Cor("Vermelho");

        Marca marca1 = new Marca(01, "Renault");
        Marca marca2 = new Marca(02, "Fiat");
        Marca marca3 = new Marca(03, "Volkswagen");

        Modelo modelo1 = new Modelo(01, "Jetta", 1200, ETipoCombustivel.FLEX, ECategoria.MEDIO, marca3);
        Modelo modelo2 = new Modelo(02, "Toro", 1300,ETipoCombustivel.GASOLINA, ECategoria.GRANDE, marca2);
        Modelo modelo3 = new Modelo(03, "Kwid", 600, ETipoCombustivel.GNV, ECategoria.PEQUENO, marca1);

        PessoaFisica pf1 = new PessoaFisica(
                01,
                "Luciano",
                "48 991670093",
                "luciano@gmail.com",
                LocalDate.now(),
                "000.111.333-44",
                LocalDate.of(2000,11,7)
        );

        PessoaFisica pf2 = new PessoaFisica(
                02,
                "João",
                "48 991033448",
                "joao@gmail.com",
                LocalDate.now(),
                "222.333.555-44",
                LocalDate.of(2003,07,21)
        );

        PessoaJuridica pj1 = new PessoaJuridica(
                01,
                "Conselho Federal de Ténicos - CFT",
                "0800 016 1515",
                "ouvidoria@cft.org.br",
                LocalDate.now(),
                "11.333.555/0001-44",
                "448-555-666-9"
        );

        Veiculo veiculo1 = new Veiculo(01, "RX49-A6F", "56 mil KM rodado!", modelo1, corPrata, pf1);
        pf1.addVeiculo(veiculo1);
        Veiculo veiculo2 = new Veiculo(02, "FWA6-S56", "39 mil KM rodado!", modelo2, corVermelho, pf2);
        pf2.addVeiculo(veiculo2);
        Veiculo veiculo3 = new Veiculo(03, "TR35-LK0", "70 mil KM rodado!", modelo3, corAzul, pj1);
        pj1.addVeiculo(veiculo3);

        pj1.pontuacao.adcionar(100);
        pf2.pontuacao.adcionar(75);
        pf1.pontuacao.adcionar(200);

        printDados(veiculo1);
        printDados(veiculo2);
        printDados(veiculo3);

        printCliente(pf1);
        printCliente(pf2);
        printCliente(pj1);

        printDados(pf1, "Esse Cliente sempre paga atrasado!");

        pf1.pontuacao.subtrair(150);

        printCliente(pf1);

        pf1.pontuacao.subtrair(75);
        // Nesse caso o cliente está com 50 pontos o esperado é que ele fique com 0 pontos e não uma pontuação negativa;

        printCliente(pf1);

        pf1.pontuacao.adcionar(15);
        pf1.addVeiculo(veiculo2);
        printCliente(pf1);
        printDados(pj1);
        printDados(pf2);
        printDados(pf1);

        printDados(veiculo2, "Esse veículo está com defeito na partida!");
    }

    // O polimorfismo está aplicado nos Métodos abaixo, principalmente no IDados.
    // pois ele saberá qual é o objeto(passado como parametro) que assinou esse contrato(interface)
    // e exibirá as informações conforme implementadas em suas respectivas classes;

    public static void printDados(IDados dados){
        System.out.println("--------------IDados---------------");
        System.out.println(dados.getDados() + "\n");
    }

    public static void printDados(IDados dados, String observacao){
        System.out.println("---------IDados com Observação!------");
        System.out.println(dados.getDados(observacao) + "\n");
    }

    public static void printCliente(Cliente cliente) {
        System.out.println("-----------Informações----------");
        if(cliente instanceof PessoaFisica){
            System.out.println("Dados do Cliente - Pessoa Fisica");
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + ((PessoaFisica) cliente).getCpf());
        }else{
            System.out.println("Dados do Cliente - Pessoa Juridica");
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CNPJ: " + ((PessoaJuridica) cliente).getCnpj() );
        }
        int x = 1;
        System.out.println("--------Lista de Veiculos-------");
        for(Veiculo veiculo : cliente.getListaDeVeiculos()){
            System.out.println(x + "° Veículo: " + veiculo.getModelo().getDescricao());
            x ++;
        }
        System.out.println("Quantidade de Pontos: " + cliente.getPontuacao().getQuantidade() + "\n");
    }
}
