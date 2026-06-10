public class TesteStringPool {
    public static void main(String[] args) {
        String a = "Java";
        String b = "Java";
        String c = new String("Java");

        System.out.println(a == b); // Saída: true
        System.out.println(a == c); // Saída: false
        System.out.println(a.equals(c)); // Saída: true

        /*
         * --- EXPLICAÇÕES ---
         * * 1. Por que a == b retorna true?
         * Porque as variáveis 'a' e 'b' foram criadas atribuindo o valor diretamente entre aspas
         * (literal). Nesse caso, ambas apontam para exatamente o mesmo objeto na memória. O
         * operador '==' compara se as variáveis apontam para o mesmo endereço de memória, e não o texto.
         * * 2. Por que a == c retorna false?
         * A variável 'c' foi instanciada usando a palavra-chave "new". A palavra "new" força o Java
         * a criar um objeto completamente novo em outro lugar da memória (na área Heap normal),
         * separadamente do objeto apontado por 'a' e 'b'. Como 'a' e 'c' estão em endereços de
         * memória diferentes, o '==' retorna false.
         * * 3. O que é o String Pool?
         * O String Pool (ou "piscina de strings") é uma área especial de memória gerenciada
         * pelo Java. Como Strings são usadas exaustivamente, o Java tenta economizar memória:
         * sempre que você cria uma String de forma literal (ex: "Java"), o Java guarda esse
         * texto no Pool. Se você criar outra variável com o mesmo texto literal depois, ele
         * não cria um novo objeto; ele apenas