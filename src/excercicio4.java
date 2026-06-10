public class ValidadorSenha {
    public static void main(String[] args) {

        System.out.println("--- TESTE 1: USANDO == (Incorreto) ---");
        String senhaCorreta = new String("1234");
        String tentativa = "1234";

        if (tentativa == senhaCorreta) {
            System.out.println("Acesso liberado");
        } else {
            System.out.println("Acesso negado");
        }

        /*
         * O QUE APARECE E POR QUE:
         * Aparece "Acesso negado".
         * Isso acontece porque o Java não está comparando o conteúdo "1234". Ele está
         * comparando os endereços de memória. 'senhaCorreta' foi forçada a ser um novo
         * objeto na memória convencional (Heap) através da palavra-chave 'new'. Já
         * 'tentativa' foi criada de forma literal e foi para o String Pool. Como estão
         * em lugares físicos diferentes da memória, o '==' diz que são coisas diferentes.
         */

        System.out.println("\n--- TESTE 2: USANDO .equals() (Correto) ---");
        // Corrigindo o problema substituindo == por .equals()
        if (tentativa.equals(senhaCorreta)) {
            System.out.println("Acesso liberado"); // Agora este roda!
        } else {
            System.out.println("Acesso negado");
        }

        /*
         * QUAL O RISCO DE USAR == COM STRINGS EM SISTEMAS REAIS?
         * O risco é criar falhas críticas na lógica de negócio e na segurança.
         * Em sistemas reais, as Strings raramente são escritas "na mão" pelo programador
         * lado a lado no código. Elas vêm de fontes externas: digitação do usuário, bancos
         * de dados, leitura de arquivos ou requisições web.
         * * Nesses cenários, o Java instancia essas Strings dinamicamente em diferentes
         * locais de memória. Se você usar '==', a verificação retornará 'false' na
         * enorme maioria das vezes, mesmo que a senha, o e-mail ou o nome pesquisado
         * estejam com o texto 100% correto. Isso causaria bloqueios indevidos (como um
         * login correto que sempre falha) e muita dor de cabeça para rastrear o bug.
         */
    }
}