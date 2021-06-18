//Direitos Autorais, PUCRS/Escola Politécnica
import java.util.Scanner;

/**
 * A classe MainApp permite jogar uma partida de Campo Minado.
 * 
 * @author Thiago Macedo (t.macedo@edu.pucrs.br).
 * 
 * @version 2021-06-18
 * 
 */
public class MainApp
{
    public static void main(String[] args)
    {
        char[][] campo;
        int[][] minas;
        int linha;
        int coluna;
        int rodada;
        Scanner teclado;
        
        campo = Auxiliar.criaCampo();
        minas = Auxiliar.criaMinas();
        Auxiliar.implantaMinas(minas);
        Auxiliar.preencheCampo(minas);
        teclado = new Scanner(System.in);
        rodada = 0;
        
        System.out.println("CAMPO MINADO!!!");
        System.out.println("Tente deixar somente as casas que contem minas!");
        do 
        {
            Auxiliar.dump(campo);
            rodada += 1;
            System.out.println("\nRodada: " + rodada);
            
            System.out.print("\nDigite o número da linha (entre 1 e 8): ");
            linha = teclado.nextInt();
            while(linha < 1 || linha > 8)
            {
                System.out.print("Linha inválida, digite novamente: ");
                linha = teclado.nextInt();
            }
            
            System.out.print("Digite o número da coluna (entre 1 e 8): ");
            coluna = teclado.nextInt();
            while(coluna < 1 || coluna > 8)
            {
                System.out.print("Coluna inválida, digite novamente: ");
                coluna = teclado.nextInt();
            }
            
            if (campo[linha][coluna] != '_')
            {
                System.out.println("Esse campo ja foi revelado, digite outro!");
                rodada -= 1;
                continue;
            }
            else
            {
                if (minas[linha][coluna] == -1)
                {
                    System.out.println("\nOps, havia uma mina ali!");
                    System.out.println("Voce perdeu!");
                    System.out.println("As minas são representadas por '*'");
                    Auxiliar.mostrarMinas(minas, campo);
                    Auxiliar.dump(campo);
                    break;
                }
                else
                {
                    Auxiliar.mostrarDicas(minas, campo, linha, coluna);
                }
            }
            
            if (Auxiliar.vitoria(campo) == true)
            {
                System.out.println("\nParabéns, você venceu!");
                Auxiliar.dump(campo);
            }
        } while (!Auxiliar.vitoria(campo));
    }
}