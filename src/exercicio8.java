import java.util.HashSet;
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

    // ATENÇÃO: Para simular a "Rodada B", você deve comentar este método inteiro
    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}

public class BibliotecaTeste {
    public static void main(String[] args) {

        HashSet<Livro> biblioteca = new HashSet<>();

        Livro l1 = new Livro("Clean Code", "978-0132350884");
        Livro l2 = new Livro("Clean Code", "978-0132350884");

        biblioteca.add(l1);
        biblioteca.add(l2);

        System.out.println("Tamanho da biblioteca: " + biblioteca.size());

        /*
         * --- EXPLICAÇÕES ---
         * * * Rodada A (Com equals e hashCode ativados):
         * O tamanho impresso será 1. Como os dois livros têm o mesmo ISBN, o hashCode
         * gerado é o mesmo, e o equals garante que são iguais. O HashSet percebe que
         * é uma duplicata e ignora a inserção do 'l2'.
         * * * Rodada B (Comentando o hashCode na classe Livro):
         * O tamanho impresso será 2. O tamanho mudou porque quebramos o contrato!
         * Sem o hashCode sobrescrito, o Java usa o comportamento padrão da classe Object,
         * que gera números diferentes baseados nos endereços de memória de 'l1' e 'l2'.
         * Ao ver números (hashes) diferentes, o HashSet assume imediatamente que são
         * objetos completamente diferentes e os adiciona em espaços separados, sequer
         * chegando a usar o equals().
         * * * O que o HashSet usa internamente para detectar duplicatas?
         * O HashSet (que usa um HashMap internamente) faz uma validação em DUAS ETAPAS
         * para ser muito rápido:
         * 1º Passo (Rápido): Ele chama o hashCode() do objeto. Se o hash gerado for
         * diferente de todos que já estão lá, ele insere o objeto direto.
         * 2º Passo (Lento): Se o hash gerado for IGUAL a um que já existe (uma "colisão"),
         * aí sim ele chama o equals() para verificar caracter por caracter se os objetos
         * são realmente iguais ou se foi apenas uma coincidência matemática do hash.
         * Se o equals retornar true, ele descarta a duplicata.
         */
    }
}