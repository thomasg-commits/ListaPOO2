class Livro {
    String titulo;
    String isbn;

    // Construtor com os dois atributos
    public Livro(String titulo, String isbn) {
        this.titulo = titulo;
        this.isbn = isbn;
    }
}

public class Exercicio5 {
    public static void main(String[] args) {

        Livro l1 = new Livro("Clean Code", "978-0132350884");
        Livro l2 = new Livro("Clean Code", "978-0132350884");

        System.out.println("l1 == l2? " + (l1 == l2)); // Saída: false
        System.out.println("l1.equals(l2)? " + l1.equals(l2)); // Saída: false

        /*
         * --- EXPLICAÇÕES DA SAÍDA ---
         * * 1. Por que l1 == l2 retorna false?
         * Porque o operador '==' sempre compara o endereço de memória onde os objetos
         * estão armazenados. Como usamos a palavra 'new' duas vezes, criamos dois
         * objetos completamente distintos na memória, mesmo que o conteúdo dentro
         * deles seja idêntico. Logo, seus endereços são diferentes.
         * * 2. Por que .equals() também retorna false sem override?
         * Porque todas as classes em Java herdam, por padrão, da classe mãe chamada 'Object'.
         * O método .equals() original que vem da classe 'Object' é implementado de uma
         * forma muito simples: ele literalmente apenas faz 'return this == obj;'.
         * Ou seja, sem sobrescrever (@Override) esse método para ensinar o Java a comparar
         * os atributos específicos (como o isbn ou titulo), o .equals() faz exatamente
         * a mesma coisa que o operador '==': compara apenas os endereços de memória.
         */
    }
}