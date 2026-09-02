public class Tabuleiro {
    private String[][] casas = {
            { " ", " ", " " },
            { " ", " ", " " },
            { " ", " ", " " }
    };

    public void exibir() {
        for (String[] linha : casas) {
            for (String casa : linha) {
                System.out.print("|" + casa);
            }
            System.out.println("|");
        }
    }

    public boolean posicaoValida(int linha, int coluna) {
        return linha >= 0
                && linha < casas.length
                && coluna >= 0
                && coluna < casas[0].length;
    }

    public boolean posicaoLivre(int linha, int coluna) {
        return posicaoValida(linha, coluna)
                && casas[linha][coluna].equals(" ");

    }

    public boolean marcar(int linha, int coluna, String jogador) {
        if (!posicaoLivre(linha, coluna)) {
            return false;
        }
        casas[linha][coluna] = jogador;
        return true;
    }

    public boolean checarVitoria(String jogador) {
        for (int i = 0; i < 3; i++) {
            if (casas[i][0].equals(jogador) &&
                    casas[i][1].equals(jogador) &&
                    casas[i][2].equals(jogador)) {

                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (casas[0][i].equals(jogador) &&
                    casas[1][i].equals(jogador) &&
                    casas[2][i].equals(jogador)) {

                return true;
            }
        }

        if (casas[0][0].equals(jogador) &&
                casas[1][1].equals(jogador) &&
                casas[2][2].equals(jogador)) {

            return true;
        }

        if (casas[0][2].equals(jogador) &&
                casas[1][1].equals(jogador) &&
                casas[2][0].equals(jogador)) {

            return true;
        }

        return false;
    }

    public boolean checarEmpate() {
        for (String[] linha : casas) {
            for (String casa : linha) {
                if (casa.equals(" ")) {
                    return false;
                }
            }
        }

        return true;
    }
}
