//Direitos Autorais, PUCRS/Escola Politécnica
import java.util.Scanner;

/**
 * Escreva a descrição da classe Teste aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class MainApp
{
    public static void main(String[] args)
    {
        char[][] campo;
        int [][] minas;
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
        
        System.out.println("CAMPO MINADO!!");
        do
        {
            rodada += 1;
            System.out.println("\nRodada: " + rodada);
            Auxiliar.dump(campo);
            
            do 
            {
                System.out.print("\nLinha: ");
                linha = teclado.nextInt();
                
                System.out.print("Coluna: ");
                coluna = teclado.nextInt();
                
                if ((campo[linha][coluna] != '_') && ((linha < 9 && linha > 0) && (coluna < 9 && coluna > 0)))
                {
                    System.out.println("Esse campo já está sendo mostardo");
                }
                else if (linha < 1 || linha > 8 || coluna < 1 || coluna > 8)
                {
                    System.out.println("Campo inválido, digite números entre 1 e 8");
                }
                
                
            } while((linha < 1 && linha > 8) && (coluna < 1 && coluna > 8) || (campo[linha][coluna] != '_'));
            
        } while(!Auxiliar.vitoria(campo));
    }
}
