import java.util.Scanner;

public class jogo_da_velha {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Tabuleiro tabuleiroNovo = new Tabuleiro();
        String jogadorAtual = "X";
        boolean jogoAtivo = true;

        while (jogoAtivo) {
            tabuleiroNovo.exibir();
            System.out.println("Jogador " + jogadorAtual + " escolha uma linha(1 - 3): ");
            String linha = ler.next();
            System.out.println("Jogador " + jogadorAtual + ", escolha uma coluna (1 - 3)");
            String coluna = ler.next();

            int linhaEscolhida;
            int colunaEscolhida;

            try {
                linhaEscolhida = Integer.parseInt(linha) - 1;
                colunaEscolhida = Integer.parseInt(coluna) - 1;
            } catch (NumberFormatException erro) {
                System.out.println("Digite apenas números entre 1 e 3");
                continue;
            }

            if (tabuleiroNovo.marcar(linhaEscolhida, colunaEscolhida, jogadorAtual)) {

                if (tabuleiroNovo.checarVitoria(jogadorAtual)) {
                    tabuleiroNovo.exibir();
                    System.out.println("Parabéns, Jogador " + jogadorAtual + " ! Vencedor!");
                    jogoAtivo = false;

                } else if (tabuleiroNovo.checarEmpate()) {
                    tabuleiroNovo.exibir();
                    System.out.println("Empate");
                    jogoAtivo = false;

                } else {
                    jogadorAtual = jogadorAtual.equals("X") ? "O" : "X";
                }

            } else {
                System.out.println("Posição inválida ou já ocupada!");
            }
        }
        ler.close();
    }

}
