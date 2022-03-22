package sudoko;

import java.lang.*; 
  

// Abstraction
abstract public class Sudoku 
{ 
    // Encapsulation
     protected int[] Sudoko[]; // Sudoko Grid
     private int N; // number of columns/rows. 
    private int B; // number of columns/rows of the box
    private int R; // number of removed digits 

    public int getN() {
        return N;
    }

    public void setN(int N) {
        this.N = N;
    }

    public int getB() {
        return B;
    }

    public void setB(int B) {
        this.B = B;
    }

    public int getR() {
        return R;
    }

    public void setR(int R) {
        this.R = R;
    }


  
    // Constructor 
    Sudoku(int N) 
    { 
        this.N = N;  
  
        Double SRNd = Math.sqrt(N); 
        B = SRNd.intValue(); 
  
        Sudoko = new int[N][N]; 
    } 
  

    // Overloading
    public void fill() 
    { 
        fillFirstRow(); 
  
        // Overloading
        fill(1,0); 
  
    } 
    
    public void fillFirstRow()
    {
              int x;
        for(int k=0;k<1;k++)
        {
            for(int q=0;q<N;q++)
            {
                do
                { 
                    x = Generator(N); 
                } 
                while (!CheckAll(k, q, x)); 
                Sudoko[k][q]=x;
            }
        }
    }
    
    
   
    public boolean CheckBox(int rowStart, int colStart, int num) 
    { 
        for (int i = 0; i<B; i++) 
            for (int j = 0; j<B; j++) 
                if (Sudoko[rowStart+i][colStart+j]==num) 
                    return false; 
  
        return true; 
    } 
    public boolean CheckRow(int i,int num) 
    { 
        for (int j = 0; j<N; j++) 
           if (Sudoko[i][j] == num) 
                return false; 
        return true; 
    } 
    
     public boolean CheckCol(int j,int num) 
    { 
        for (int i = 0; i<N; i++) 
            if (Sudoko[i][j] == num) 
                return false; 
        return true; 
    } 
     
      public boolean CheckAll(int i,int j,int num) 
    { 
        return (CheckRow(i, num) && 
                CheckCol(j, num) && 
                CheckBox(i-i%B, j-j%B, num)); 
    } 
  

    public int Generator(int num) 
    { 
        return (int) Math.floor((Math.random()*num+1)); 
    } 

    
public boolean fill(int i,int j) 
    { 

        // base case
           if(i == N - 1 && j == N)
        	return true;
        if (j == N) 
        { 
            i = i + 1; 
            j = 0; 
        }
        //transition
        for (int num = 1; num<=N; num++) 
        { 
            if (CheckAll(i, j, num)) 
            { 
                Sudoko[i][j] = num; 
                if (fill(i, j+1)) 
                    return true; 
  
                Sudoko[i][j] = 0; 
            } 
        } 
        return false; 
        
    } 

public void Remove()
{
    int cntr = R;
    while(cntr>0)
    {
        int i = (int)(Math.random() * (8 - 0 + 1) + 0);
        int j = (int)(Math.random() * (8 - 0 + 1) + 0);
        if (Sudoko[i][j] != 0) 
            { 
                cntr--; 
                Sudoko[i][j] = 0; 
            } 
    }
    
}
  
  

   
    public static void main(String[] args) 
    { 
      
    } 
} 