//Direitos Autorais, PUCRS/Escola Politécnica

import java.util.Random;

public class Auxiliar 
{
    /**
     * Cria uma matriz de Strings 10x10, com o símbulo "?" 
     * em todos os espaços.
     * 
     * @return a mtriz criada.
     */
    public static String[][] criaCampo()
    {
        int i;
        int j;
        String[][] campo = new String[10][10];
        for (i = 0; i < 10; i += 1)
        {
            for (j = 0; j < 10; j += 1)
            {
                campo[i][j] = "?"; 
            }
        }
        
        return campo; 
    }
    
    /**
     * Cria uma matriz de inteiros 10x10 com o numero 0 
     * em todas as casas.
     * 
     * @return a matriz criada.
     * 
     */
    public static int[][] criaMinas()
    {
        int i;
        int j;
        int[][] minas = new int[10][10];
        for (i = 0; i < 10; i += 1)
        {
            for (j = 0; j < 10; j += 1)
            {
                minas[i][j] = 0; 
            }
        }
        
        return minas;
    }
    
    /**
     * Sorteia 10 lugares aleatórios na matriz das minas 
     * e coloca insere o valor -1 nesses 10 lugares.
     * 
     * Esses valores representam as minas.
     * 
     * @param minas: o tabuleiro das minas.
     */
    public void implantaMinas(int[][] minas)
    {
        Random random = new Random();
        boolean ocupado;
        int i;
        int j;
        for (i = 0; i < 10; i += 1)
        {
            do {
                i = random.nextInt(8) + 1;
                j = random.nextInt(8) + 1;
                
                if (minas[i][j] == -1)
                {
                    ocupado = true;
                }
                else
                {
                    ocupado = false;
                }
                
            } while(ocupado);
            
            minas[i][j] = -1; 
        }
    }
    
    /**
     * Esse método atribui o valor nos campos em que não tem minas, 
     * a quantidade de minas próximas a ele.
     * 
     * @param minas: o tabuleiro das minas.
     */
    public void preencheCampo(int[][] minas)
    {
        int i;
        int j;
        int linha;
        int coluna;
        for (linha = 1; linha < 9; linha += 1)
        {
            for (coluna = 1; coluna < 9; coluna += 1)
            {
                for (i = -1; i <= 1; i += 1)
                {
                    for (j = -1; j <= 1; j += 1)
                    {
                        if (minas[linha][coluna] != -1)
                        {
                            if (minas[linha + i][coluna + j] == -1)
                            {
                                minas[linha][coluna] += 1;
                            }
                        }
                    }
                }    
            }
        }
    }
    
    /**
     * Esse método verifica se o jogador venceu a partida.
     * 
     * Ele cria um contador que cnta a quantidade de casas
     * que ainda não foram reveladas.
     * 
     * Se a contagem for 10, é porque só restam as 10 bombas no tabuleiro.
     * 
     * @param campo: o tabuleiro do campo.
     */
    public boolean vitoria(String[][] campo)
    {
        int linha;
        int coluna;
        int contagem;
        
        contagem = 0;
        
        for (linha = 1; linha < 9; linha += 1)
        {
            for (coluna = 1; coluna < 9; coluna += 1)
            {
                if (campo[linha][coluna] == "?" )
                {
                    contagem += 1;
                }   
            }
        }
        
        if (contagem == 10)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
} 