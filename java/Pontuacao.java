public class Pontuacao {
    private int quantidade;

    public Pontuacao() {
        this.quantidade = 0;
    }

    public int adcionar(int quantidade) {
        if (quantidade > 0) {
            this.quantidade += quantidade;
        }
        return quantidade;
    }
    public int subtrair(int quantidade) {
        if(quantidade > this.quantidade) {
            // Se a quantidade que o usuario for SUBTRAIR for maior que a que está armazenada na pontuação, ele irá retornar zero.
            return this.quantidade = 0;
        } else if (quantidade < 0) {
            //Se a quantidade que ele for diminuir for menor que zero, retorna a quantidade que já está armazenada.
            return this.quantidade;
        }else  {
            // Senão irá efetuar a operação correta;
            return this.quantidade -= quantidade;
        }
    }
    public int saldo(){
        return this.quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    // Sem setQuantidade, pois só será possivel adicionar a pontuação por meio dos métodos.

    @Override
    public String toString() {
        return "Pontuação: " + this.quantidade;
    }
}
