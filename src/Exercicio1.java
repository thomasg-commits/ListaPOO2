class Produto {
    String nome;
    double preco;

    // Construtor com os dois atributos
    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
}

public class Exercicio1 {
    public static void main(String[] args) {
        // Instanciando dois produtos
        Produto p1 = new Produto("Notebook", 4500.0);
        Produto p2 = new Produto("Mouse", 120.0);

        // Imprimindo os objetos diretamente
        System.out.println(p1);
        System.out.println(p2);

        /*
         * SAÍDA E EXPLICAÇÃO:
         * * O que aparece?
         * A saída será algo como:
         * Produto@1b6d3586
         * Produto@4554617c
         * * É legível?
         * Não, não é legível para nós. Como não sobrescrevemos o método toString(),
         * o Java usa o comportamento padrão da classe Object. Ele imprime o nome
         * da classe (Produto), seguido de um '@' e o "endereço" de memória
         * (hashcode) do objeto em formato hexadecimal. Ele não mostra os dados
         * (nome e preço) que colocamos lá dentro.
         */
    }
}