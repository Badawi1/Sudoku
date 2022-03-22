/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoko;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author HP
 */
public class Gui extends JFrame{
    private JTextField f[][]= new JTextField[9][9];
   // private JPanel p[][]= new JPanel [3][3];
private JButton check = new JButton("Finish");
 int N = 9; 
 Sudoku sudoku;
 boolean checker = true;
        //Sudoku sudoku = new Hard(N); 
        String arr [] []=new String[9][9];
        String solvearr[][]=new String[9][9];
        
    public Gui(String z){
     
     super("Sudoku");
     
     // Polymorphism
     if(z.equals("Easy"))
     {
         sudoku = new Easy(N);
     }
     else if(z.equals("Medium"))
     {
         sudoku = new Medium(N);
     }
     else if(z.equals("Hard"))
     {
         sudoku = new Hard(N);
     }
     
     sudoku.fill();
     
     for(int i = 0 ; i < 9 ; i ++){
     for(int j = 0 ;  j < 9 ;j++){
     
     solvearr[i][j]=String.valueOf(sudoku.Sudoko[i][j]);
     
     }
     }
     
     sudoku.Remove();
     
     for(int i = 0 ; i < 9 ; i ++){
     for(int j = 0 ;  j < 9 ;j++){
     
     arr[i][j]=String.valueOf(sudoku.Sudoko[i][j]);
     
     }
     }
     
     
     
         
        setSize(700,700);
        
        for(int x=0; x<=8; x++){
            for(int y=0; y<=8; y++){
                f[x][y]=new JTextField(10);
             add(f[x][y]);    
        
            }
        }




     /*  for(int x=0; x<=2; x++){
            for(int y=0; y<=2; y++){
                p[x][y]=new JPanel(new GridLayout(3,3));
            }
        }*/

        setLayout(new GridLayout(10,10,10,10));

/*        for(int u=0; u<=2; u++){
            for(int i=0; i<=2; i++){    
                for(int x=0; x<=2; x++ ){
                    for(int y=0; y<=2; y++){
                        p[u][i].add(f[y+u*3][x+i*3]);
                       
                    }
                }
            add(p[u][i]);
            }
        }*/
         for(int x=0; x<=8; x++){
            for(int y=0; y<=8; y++){
                if(Integer.valueOf(arr[x][y])==0)
                {
                    f[x][y].setText("");
                    f[x][y].setHorizontalAlignment(SwingConstants.CENTER);
                }
                else
                {
                f[x][y].setText(arr[x][y]);
                f[x][y].setHorizontalAlignment(SwingConstants.CENTER);
                }
            }
        }
          for(int x=0; x<=8; x++){
            for(int y=0; y<=8; y++){
if(!f[x][y].getText().equals("")){
f[x][y].setEditable(false);
f[x][y].setBackground(new Color(44,195,135));
}
        }
        }
        check.setSize(20,10);
       add(check);
       check.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent ae) {
             
     
             
             for(int x=0; x<=8; x++){
            for(int y=0; y<=8; y++){
                if(!f[x][y].getText().toString().equals(solvearr[x][y]))
                {
                    checker = false;
                }
                
                
               // f[x][y].setText(solvearr[x][y]);
              //  f[x][y].setEditable(false);
            }
        }
             if(checker)
             {
                 JOptionPane.showMessageDialog(null, "You Won","Congratulations",JOptionPane.INFORMATION_MESSAGE);
                 Gui.this.setVisible(false);
                 System.exit(0);
                
             }
             else
             {
                 JOptionPane.showMessageDialog(null, "You Lost","Hard Luck",JOptionPane.INFORMATION_MESSAGE);
                Gui.this.setVisible(false);
                System.exit(0);
             }
             

             
         }
     });
       
       
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    }

