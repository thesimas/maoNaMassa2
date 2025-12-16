<div align="center">
  <h1>🚗 Sistema de Gestão de Lavação (v2.0) </h1>
  <p>
    <strong>Projeto "Mão na Massa 2" - POO Java | IFSC Câmpus Florianópolis</strong>
  </p>
  <p>
    <img src="https://img.shields.io/badge/Java-17+-orange?style=flat&logo=java" alt="Java" />
    <img src="https://img.shields.io/badge/Nota-10%2F10-success?style=flat" alt="Nota 10" />
  </p>
</div>

## 📖 Sobre
Sistema backend em Java para gerenciamento de clientes e veículos de uma lavação. O foco do projeto foi a aplicação rigorosa dos pilares da Orientação a Objetos, incluindo tratamento de associações e contratos de interface.

<div align="center">
  <img src="./Lavacao - Heranca e associacoes.png" alt="UML" width="800px">
</div>

## 💻 Conceitos Aplicados

* **Abstração e Herança:** Classe base `Cliente` (abstrata) generalizando atributos para `PessoaFisica` e `PessoaJuridica`.
* **Polimorfismo:** Interface `IDados` permite que `Veiculo` e `Cliente` sejam processados genericamente pelo método `printDados` na Main.
* **Encapsulamento:** Atributos privados com acesso via Getters/Setters e regras de negócio protegidas (ex: saldo não negativo em `Pontuacao`).
* **Composição:** O ciclo de vida do `Motor` depende do `Modelo`, e a `Pontuacao` é inicializada obrigatoriamente junto ao `Cliente`.
* **Associação:** Relação bidirecional controlada entre `Cliente` e `Veiculo`.
* **Enums:** Uso de `ECategoria` e `ETipoCombustivel` para tipagem forte e descrições constantes.


## 👨‍💻 Autor
Desenvolvido por **Luciano Simas Junior** | IFSC Florianópolis
