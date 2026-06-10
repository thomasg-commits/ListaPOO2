class Produto {
    String nome;
    double preco;

    // Construtor
    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // Sobrescrevendo o método toString() herdado da classe Object
    @Override
    public String toString() {
        return "Produto{nome='" + nome + "', preco=" + preco + "}";
    }
}

public class Exercicio2 {
    public static void main(String[] args) {
        Produto p1 = new Produto("Notebook", 4500.0);
        Produto p2 = new Produto("Mouse", 120.0);

        // 1. Executando novamente a impressão direta
        System.out.println(p1);
        System.out.println(p2);

        // 2. Testando a concatenação com uma String
        System.out.println("Item: " + p1);

        /*
         * SAÍDA E EXPLICAÇÕES:
         * * O que mudou na saída?
         * Agora a saída é legível e exibe os dados reais do objeto:
         * Produto{nome='Notebook', preco=4500.0}
         * Produto{nome='Mouse', preco=120.0}
         * Isso ocorre porque o System.out.println() chama automaticamente o toString()
         * do objeto. Como nós o sobrescrevemos (@Override), ele parou de usar o padrão
         * de "endereço de memória" e passou a usar a formatação que nós definimos.
         * * O toString() é chamado automaticamente na concatenação?
         * Sim! A saída da terceira impressão será:
         * Item: Produto{nome='Notebook', preco=4500.0}
         * Quando você usa o operador '+' para juntar uma String ("Item: ") com um
         * objeto (p1), o Java inteligentemente invoca o método toString() do objeto
         * por baixo dos panos para converter aquele objeto em texto antes de junt