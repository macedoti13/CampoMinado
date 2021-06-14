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
            
            System.out.println(" Informe o valor da linha (entre 1 e 8): ");
            linha = teclado.nextInt();
            while (!(linha > 0 && linha < 9))
            {
                System.out.println(" Informe uma linha válida! (entre 1 e 8): ");
                linha = teclado.nextInt();
            }
            
            System.out.println(" Informe o valor da coluna (entre 1 e 8): ");
            coluna = teclado.nextInt();
            while (!(coluna > 0 && coluna < 9))
            {
                System.out.println(" Informe uma coluna válida! (entre 1 e 8): ");
                coluna = teclado.nextInt();
            }
            
            if (campo[linha][coluna] != '_')
            {
                System.out.println("Esse campo ja está aberto");
                continue;
            }
    
        } while (!Auxiliar.vitoria(campo));
        
        System.out.println("FIM DE JOGO!!");
        teclado.close();
    }
}