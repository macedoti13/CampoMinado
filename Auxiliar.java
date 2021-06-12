import java.util.Random;

public class Auxiliar 
{
    /**
     * 
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
                campo[i][j] = "*"; 
            }
        }
        
        return campo; 
    }
    
    /**
     * 
     */
    public static int[][] criaCampoMinas()
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
     * 
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
} 