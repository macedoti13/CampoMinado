//Direitos Autorais, PUCRS/Escola Politécnica

import java.util.Scanner;

/**
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
        Scanner teclado;
        
        campo = Auxiliar.criaCampo();
        minas = Auxiliar.criaMinas();
        Auxiliar.implantaMinas(minas);
        Auxiliar.preencheCampo(minas);
        teclado = new Scanner(System.in);
        
        System.out.println("Campo Minado!/n");
        do
        {
            Auxiliar.dump(campo);
            
            System.out.print("\nInforme o valor da linha (entre 1 e 8): ");
            linha = teclado.nextInt();
            while (!(linha > 0 && linha < 9))
            {
                System.out.print("\nInforme uma linha válida! (entre 1 e 8): ");
                linha = teclado.nextInt();
            }
            
            System.out.print("\nInforme o valor da coluna (entre 1 e 8): ");
            coluna = teclado.nextInt();
            while (!(coluna > 0 && coluna < 9))
            {
                System.out.print("\nInforme uma coluna válida! (entre 1 e 8): ");
                coluna = teclado.nextInt();
            }
            
            if (campo[linha][coluna] != '_')
            {
                System.out.println("\nEsse campo ja está aberto, tente outro:");
                continue;
            }
            else
            {
                if (minas[linha][coluna] == -1)
                {
                    System.out.println("\nOPS, havia uma mina ali, você perdeu!");
                    Auxiliar.mostrarMinas(minas);
                    break;
                }
                else 
                {
                    continue;
                }
            }
        } while (!Auxiliar.vitoria(campo));
        
        System.out.println("FIM DE JOGO!!");
        teclado.close();
    }
}