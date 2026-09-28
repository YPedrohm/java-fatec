public class Main {
    import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class SistemaCompleto {

    // 1. Função estática com retorno e parâmetros que lança exceção (throw)
    public static double calcularMedia(double nota1, double nota2) {
        // Validação usando throw
        if (nota1 < 0 || nota1 > 10 || nota2 < 0 || nota2 > 10) {
            throw new IllegalArgumentException("As notas devem estar entre 0 e 10!");
        }
        return (nota1 + nota2) / 2.0;
    }

    // 2. Função para gravar dados em arquivo (FileWriter + BufferedWriter)
    public static void salvarNoArquivo(String nomeArquivo, String conteudo) {
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            // 'true' ativa o modo append (adiciona sem sobrescrever)
            fw = new FileWriter(nomeArquivo, true);
            bw = new BufferedWriter(fw);
            
            bw.write(conteudo);
            bw.newLine(); // Adiciona uma quebra de linha
            
        } catch (IOException e) {
            System.out.println("Erro ao gravar no arquivo: " + e.getMessage());
        } finally {
            // Bloco 'finally' garante o fechamento do recurso
            try {
                if (bw != null) bw.close();
                if (fw != null) fw.close();
            } catch (IOException e) {
                System.out.println("Erro ao fechar arquivo de escrita.");
            }
        }
    }

    // 3. Função para ler dados do arquivo (FileReader + BufferedReader)
    public static void lerDoArquivo(String nomeArquivo) {
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(nomeArquivo);
            br = new BufferedReader(fr);
            
            String linha;
            System.out.println("\n--- Conteúdo Salvo no Arquivo ---");
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        } finally {
            try {
                if (br != null) br.close();
                if (fr != null) fr.close();
            } catch (IOException e) {
                System.out.println("Erro ao fechar arquivo de leitura.");
            }
        }
    }

    public static void main(String[] args) {
        // USO DE TIPOS PRIMITIVOS E LITERAIS
        int matricula = 10_001;              // Literal inteiro com underscore
        long codigoRegistro = 987_654_321L;   // Literal long com sufixo L
        float taxaProcessamento = 0.05f;     // Literal float com sufixo f
        boolean processadoSucesso = false;
        String caminhoArquivo = "relatorio.txt";

        // USO DE SCANNER (Entrada pelo console)
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do aluno: ");
        String nomeAluno = scanner.nextLine();

        // USO DE JOPTIONPANE (Interface gráfica para capturar notas)
        String inputNota1 = JOptionPane.showInputDialog(null, "Digite a 1ª nota de " + nomeAluno + ":", "Entrada de Notas", JOptionPane.QUESTION_MESSAGE);
        String inputNota2 = JOptionPane.showInputDialog(null, "Digite a 2ª nota de " + nomeAluno + ":", "Entrada de Notas", JOptionPane.QUESTION_MESSAGE);

        // TRATAMENTO DE EXCEÇÕES (try...catch...finally)
        try {
            // Converter Strings da caixa de diálogo para double
            double nota1 = Double.parseDouble(inputNota1);
            double nota2 = Double.parseDouble(inputNota2);

            // Chamada da função estática
            double media = calcularMedia(nota1, nota2);
            processadoSucesso = true;

            // Formatação do resultado
            String resultadoMsg = "Aluno: " + nomeAluno + " | Matrícula: " + matricula + " | Média: " + media;

            // USO DE JOPTIONPANE (Mensagem de saída)
            JOptionPane.showMessageDialog(null, resultadoMsg, "Resultado Final", JOptionPane.INFORMATION_MESSAGE);

            // Gravação dos dados no arquivo em disco
            salvarNoArquivo(caminhoArquivo, resultadoMsg);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro: Digite apenas números válidos para as notas!", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Nota Inválida", JOptionPane.WARNING_MESSAGE);
        } finally {
            System.out.println("Processamento do aluno finalizado (bloco finally executado).");
        }

        // CONFIRMAÇÃO COM JOPTIONPANE
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja visualizar o relatório completo de dados gravados?", "Confirmar Leitura", JOptionPane.YES_NO_OPTION);
        
        if (opcao == JOptionPane.YES_OPTION) {
            // Leitura e exibição do arquivo no console
            lerDoArquivo(caminhoArquivo);
        } else {
            System.out.println("Leitura do arquivo ignorada pelo usuário.");
        }

        scanner.close(); // Fechamento do Scanner
    }
}
    
}
