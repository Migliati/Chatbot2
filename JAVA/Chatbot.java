import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class Chatbot {
    // Array de saudações possíveis
    public static final String[] saudacoes = { "ola", "oi", "e ai", "como vai" };
    
    // Array de despedidas possíveis
    public static final String[] despedidas = { "ate logo, %s", "tchau, %s", "ate mais, %s", "ate breve, %s" };
    
    // Array de perguntas frequentes
    public static final String[] faqPerguntas = {
            "qual o seu nome",
            "qual e a sua funcao",
            "quais servicos voce oferece",
            "como posso criar uma conta ]",
            "qual e a politica de devolucao ]",
            "quais sao os horarios de funcionamento ]",
            "onde voces estao localizados ]",
            "quais sao as formas de pagamento aceitas ]",
            "voces oferecem suporte tecnico ]",
            "como posso entrar em contato ]",
            "voces tem programas de fidelidade ]"
    };
    
    // Array de respostas para as perguntas frequentes
    public static final String[] faqRespostas = {
            "ola, prazer, me chamo wall-e",
            "eu sou um chatbot desenvolvido para ajudar com suas duvidas",
            "oferecemos uma variedade de servicos, consigo responder algumas perguntas frequentes, ao clima, o dia e a hora.",
            "para criar uma conta, clique em 'registrar' no canto superior direito e siga as instrucoes",
            "nossa politica de devolucao permite devolucoes em ate 30 dias apos a compra",
            "estamos disponiveis de segunda a sexta, das 9h as 18h",
            "estamos localizados na rua exemplo, 123, centro",
            "aceitamos cartoes de credito, debito e paypal",
            "sim, oferecemos suporte tecnico 24/7 atraves do nosso site",
            "voce pode entrar em contato conosco pelo telefone (123) 456-7890 ou pelo email suporte@exemplo.com",
            "sim, temos um programa de fidelidade. consulte nosso site para mais detalhes"
    };

    public static void main(String[] args) {
        // Criar um objeto Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Mensagem de boas-vindas
        System.out.println("bem-vindo ao chatbot!");
        
        // Perguntar o nome do usuário
        System.out.println("qual e o seu nome?");
        
        // Ler o nome do usuário
        String nome = scanner.nextLine();

        // Saudar o usuário pelo nome
        System.out.println("ola, " + nome + "! como posso ajudar voce hoje?");

        // Variável para controlar se o loop continua
        boolean continuarConversando = true;
        
        // Loop principal de interação
        while (continuarConversando) {
            // Ler a entrada do usuário e converter para minúsculas
            String input = scanner.nextLine().toLowerCase();

            // Verificar se a entrada contém "saudacao"
            if (input.contains("saudacao")) {
                responderSaudacao();  // Responder com uma saudação
            } 
            // Verificar se a entrada contém "despedida"
            else if (input.contains("despedida")) {
                responderDespedida(nome);  // Responder com uma despedida
                continuarConversando = false;  // Sair do loop
            } 
            // Verificar se a entrada contém "tempo"
            else if (input.contains("tempo")) {
                informarTempo();  // Informar sobre o tempo
            } 
            // Verificar se a entrada contém "data" ou "hora"
            else if (input.contains("data") || input.contains("hora")) {
                informarDataHora();  // Informar sobre a data e hora
            } 
            // Caso contrário, verificar as perguntas frequentes
            else {
                boolean found = false;  // Variável para verificar se a pergunta foi encontrada
                for (int i = 0; i < faqPerguntas.length; i++) {
                    // Verificar se a entrada contém a pergunta frequente
                    if (input.contains(faqPerguntas[i])) {
                        System.out.println(faqRespostas[i]);  // Responder com a resposta correspondente
                        found = true;  // Marcar como encontrada
                        break;  // Sair do loop
                    }
                }
                // Se a pergunta não foi encontrada
                if (!found) {
                    System.out.println("desculpe, nao entendi. voce pode reformular sua pergunta?");
                }
            }

            // Perguntar se o usuário tem mais alguma dúvida
            if (continuarConversando) {
                perguntarMaisAlgumaDuvida();
                String continuar = scanner.nextLine().toLowerCase();
                // Verificar se o usuário deseja continuar
                if (continuar.equals("nao")) {
                    continuarConversando = false;  // Sair do loop
                }
            }
        }

        // Mensagem de despedida final
        System.out.println("obrigado por usar o chatbot! ate a proxima, " + nome + "!");
        scanner.close();  // Fechar o scanner
    }

    // Método para responder com uma saudação
    public static void responderSaudacao() {
        Random rand = new Random();  // Criar um objeto Random
        System.out.println(saudacoes[rand.nextInt(saudacoes.length)]);  // Selecionar uma saudação aleatória
    }

    // Método para responder com uma despedida
    public static void responderDespedida(String nome) {
        Random rand = new Random();  // Criar um objeto Random
        int index = rand.nextInt(despedidas.length);  // Selecionar um índice aleatório
        System.out.println(String.format(despedidas[index], nome));  // Imprimir a despedida formatada com o nome do usuário
    }

    // Método para informar sobre o tempo
    public static void informarTempo() {
        System.out.println("a previsao do tempo para hoje so deus sabe.");
    }

    // Método para informar sobre a data e hora
    public static void informarDataHora() {
        LocalDateTime dataHoraAtual = LocalDateTime.now();  // Obter a data e hora atuais
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  // Definir o formato da data e hora
        String dataHoraFormatada = dataHoraAtual.format(formatter);  // Formatar a data e hora
        System.out.println("a data e hora atuais sao: " + dataHoraFormatada);  // Imprimir a data e hora formatadas
    }

    // Método para perguntar se o usuário tem mais alguma dúvida
    public static void perguntarMaisAlgumaDuvida() {
        System.out.println("tem mais alguma duvida?");
    }
}
