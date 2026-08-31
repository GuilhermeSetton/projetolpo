import java.util.Scanner; 
 
public class jogo_da_velha { 
 
    static String[][] tabuleiro = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}}; 
     
    public static void main(String[] args) { 
        Scanner ler = new Scanner(System.in); 
 
        String jogadorAtual = "X"; 
        boolean jogoAtivo = true; 
 
        while(jogoAtivo){ 
            exibirTabuleiro(); 
            System.out.println("Jogador " + jogadorAtual + " escolha uma linha(1 - 3): "); 
            String linha = ler.next(); 
            System.out.println("Jogador " + jogadorAtual + ", escolha uma coluna (1 - 3)"); 
            String coluna = ler.next(); 
            
            if(tabuleiro[Integer.parseInt(linha) - 1][Integer.parseInt(coluna) - 1].equals(" ")){ 
                tabuleiro[Integer.parseInt(linha) - 1][Integer.parseInt(coluna) - 1] = jogadorAtual; 
                
                if(checarVitoria(jogadorAtual)){ 
                    exibirTabuleiro(); 
                    System.out.println("Parabéns, Jogador " + jogadorAtual + " ! Você Venceu!"); 
                    jogoAtivo = false; 
                     
                }else if (checarEmpate()){ 
                    exibirTabuleiro(); 
                    System.out.println("Empate!"); 
                    jogoAtivo = false; 
 
                }else{ 
                    jogadorAtual = (jogadorAtual.equals("X")) ? "O":"X"; 
                } 
 
                 
            }else{ 
                System.out.println("Posição já Ocupada! Tente Novamente."); 
                continue; 
            } 
        } 
         
    } 
 
    static void exibirTabuleiro(){ 
        for(String[] linha : tabuleiro){ 
            for(String coluna : linha) { 
                System.out.print("|" + coluna); 
            } 
            System.out.println("|"); 
        } 
    }  
 
    static boolean checarVitoria(String jogador){ 
        for(int i = 0; i < 3; i++){ 
            if (tabuleiro[i][0].equals(jogador) &&  
                tabuleiro[i][1].equals(jogador) &&  
                tabuleiro[i][2].equals(jogador)){ 
                 
                System.out.println("Jogador " + jogador + " venceu!"); 
                return true; 
            } 
        } 
 
        for (int i = 0; i < 3; i++) { 
            if (tabuleiro[0][i].equals(jogador) &&  
                tabuleiro[1][i].equals(jogador) &&  
                tabuleiro[2][i].equals(jogador)){ 
                 
                System.out.println("Jogador " + jogador + " venceu!"); 
                return true; 
            } 
        } 
 
        if (tabuleiro[0][0].equals(jogador) &&  
            tabuleiro[1][1].equals(jogador) &&  
            tabuleiro[2][2].equals(jogador)){ 
             
            System.out.println("Jogador " + jogador + " venceu!"); 
            return true; 
        } 

        if (tabuleiro[0][2].equals(jogador) &&  
            tabuleiro[1][1].equals(jogador) &&  
            tabuleiro[2][0].equals(jogador)){ 
             
            System.out.println("Jogador " + jogador + " venceu!"); 
            return true; 
        } 
 
        return false; 
    } 
     
    static boolean checarEmpate() { 
        for(String[] linha : tabuleiro) { 
            for(String coluna : linha){ 
                if(coluna.equals(" ")){ 
                    return false; 
                } 
            } 
        } 
 
        return true; 
    } 
}

