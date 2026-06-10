class Livro {
    String titulo;
    String isbn;

    // Construtor
    public Livro(String titulo, String isbn) {
        this.titulo = titulo;
        this.isbn = isbn;
    }

    // Sobrescrevendo o método equals para comparar pelo ISBN
    @Override
    public boolean equals(Object obj) {
        // 1. Otimização: se for o exato mesmo objeto na memória, já retorna true
        if (this == obj) return true;

        // 2. Segurança: se o objeto for nulo ou de outra classe, retorna false
        if (!(obj instanceof Livro)) return false;

        // 3. Cast seguro: transforma de Object genérico para Livro
        Livro outro = (Livro) obj;

        // 4. Regra de negócio: são iguais se os ISBNs forem iguais
        return this.isbn.equals(outro.isbn);
    }
}

public class Exercicio6 {
    public static void main(String[] args) {

        // Teste 1: Dois livros de mesmo ISBN mas títulos diferentes
        Livro l1 = new Livro("Clean Code", "978-0132350884");
        Livro l2 = new Livro("Código Limpo (Tradução)", "978-0132350884");

        System.out.println("Mesmo ISBN, títulos diferentes. São iguais? " + l1.equals(l2)); // true

        // Teste 2: Passando null
        System.out.println("Comparando com null: " + l1.equals(null)); // false

        // Teste 3: Passando uma String
        System.out.println("Comparando com uma String: " + l1.equals("978-0132350884")); // false

        /*
         * --- EXPLICAÇÕES E COMENTÁRIOS ---
         * * * São iguais?
         * Sim (retorna true). Como nós programamos a regra de negócio do equals() para
         * olhar EXCLUSIVAMENTE para o atributo 'isbn', o Java ignora a diferença nos
         * títulos e considera os dois objetos como logicamente iguais.
         * * * Lança exceção ao passar null ou String?
         * Não! Essa é a beleza da verificação "if (!(obj instanceof Livro))".
         * O operador 'instanceof' é muito seguro: se o objeto for 'null', ele retorna
         * 'false' silenciosamente (evitando um NullPointerException). Se passarmos uma
         * String, ele verifica que String não é do tipo Livro, e também retorna 'false'
         * (evitando um ClassCastException na linha de baixo).
         * * * Por que comparamos pelo ISBN e não pelo título?
         * Porque o ISBN atua como um "identificador único" (uma Primary Key) para um
         * livro no mundo real. Podem existir dezenas de livros diferentes com o
         * título "Matemática Básica" ou "Programação Java", de autores e editoras
         * diferentes. Usar o título para comparar poderia afirmar erroneamente que
         * dois livros diferentes são o mesmo. O ISBN garante precisão absoluta na
         * identificação.
         */
    }
}
