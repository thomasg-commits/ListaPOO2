import java.util.Objects;

class Livro {
    String titulo;
    String isbn;

    public Livro(String titulo, String isbn) {
        this.titulo = titulo;
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Livro)) return false;
        Livro outro = (Livro) obj;
        return this.isbn.equals(outro.isbn);
    }

    // Adicionando o hashCode() usando o mesmo campo do equals()
    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}

public class Exercicio7 {
    public static void main(String[] args) {

        // Livros com o MESMO ISBN
        Livro l1 = new Livro("Clean Code", "978-0132350884");
        Livro l2 = new Livro("Código Limpo", "978-0132350884");

        // Livro com ISBN DIFERENTE
        Livro l3 = new Livro("Design Patterns", "978-0201633610");

        System.out.println("--- TESTE DE HASHCODE ---");
        System.out.println("HashCode de l1 (ISBN igual): " + l1.hashCode());
        System.out.println("HashCode de l2 (ISBN igual): " + l2.hashCode());
        System.out.println("HashCode de l3 (ISBN diferente): " + l3.hashCode());

        /*
         * --- RESPOSTAS E EXPLICAÇÕES ---
         * * * São iguais? (l1 e l2)
         * Sim! Como eles