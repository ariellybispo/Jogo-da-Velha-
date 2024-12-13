import java.util.Scanner;

public class Game {
    
    Scanner scanner = new Scanner(System.in);
    
    String[][] tabuleiro = new String[3][3];
    private  int jogador = 0;
    private int parada = 1;
    private int cont = 1;

    public Game(){
        for(int i = 0;i < 3; i++){
            for(int j = 0; j < 3; j++){
                tabuleiro[i][j] ="   ";
            }
        }
    }
      
    public static void main(String[] args) {

    Game jogo = new Game();

    jogo.execultar();

    }
    public void execultar(){
          do { 
        
          tela();
          verificarJogador();
          jogada();
          verificarpartida();

        } while (parada != 0);
    }

    public void tela(){
          System.out.println("   0   1   2");
          System.out.println("0:" + tabuleiro[0][0] + "|" + tabuleiro[0][1] +"|" + tabuleiro[0][2] );
          System.out.println("1:" + tabuleiro[1][0] + "|" + tabuleiro[1][1] +"|" + tabuleiro[1][2] );
          System.out.println("2:" + tabuleiro[2][0] + "|" + tabuleiro[2][1] +"|" + tabuleiro[2][2] );

    } 

   public int verificarJogador(){
    if (jogador ==0){
        jogador =1;
    
   } else {
    jogador = 0;
    
   }
   return jogador;
 }
     public void jogada(){
        int linhajogada,colunajogada;

     do { 
          
        System.err.println("Digite a linha escolhida:");
        linhajogada = scanner.nextInt();
        System.err.println("Digite a coluna escolhida:");
        colunajogada = scanner.nextInt();


        if (linhajogada >= 0 && linhajogada <3 && colunajogada >=0 && colunajogada < 3 && tabuleiro[linhajogada][colunajogada] == "   "){
            preenchertabuleiro(linhajogada,colunajogada);
           break;
        }else{

            System.out.println("Jogada invalida! Tente novamente.");
        }
        
    }while (true);
    
}
  public String preenchertabuleiro(int linha,int coluna){
      if(jogador == 0){
        tabuleiro[linha][coluna] = " o ";

      }else{
         tabuleiro[linha][coluna] = " x ";
      }
        return tabuleiro[linha][coluna];
    }
  
   public void verificarpartida(){
      if(cont< 9){
      for(int i = 0; i<3; i++){
        if(tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][0] == tabuleiro[i][2] && tabuleiro[i][0] != "   "){
         if (jogador == 0){
            tela();
            System.out.println("O 'o' Venceu!!!");
            parada = 0;
          }else{
            tela();
            System.out.println("O 'x' Venceu!!!");
            parada = 0;
          }
        }
      }
     //verificar colunas
     for(int i = 0; i<3; i++){
        if(tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[0][i] == tabuleiro[2][i] && tabuleiro[0][i] != "   "){
         if (jogador == 0){
            tela();
            System.out.println("O 'o' Venceu!!!");
            parada = 0;
          }else{
            tela();
            System.out.println("O 'x' Venceu!!!");
            parada = 0;
          }
        }
      }
      //verificar diagonais 
      if((tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[0][0] == tabuleiro [2][2] && tabuleiro [0][0] != "   ") ||
      (tabuleiro[2][0] == tabuleiro[1][1] && tabuleiro[2][0] == tabuleiro[0][2] && tabuleiro[2][0] != "   ")){
        if (jogador == 0){
            tela();
            System.out.println("O 'o' Venceu!!!");
            parada = 0;
          }else{
            tela();
            System.out.println("O 'x' Venceu!!!");
            parada = 0;
          }
          

      }
 
    }else{
        tela();
        System.out.println("Empate!");
        parada = 0;
    }
    cont++;
}
}


