package prob1;
import java.util.ArrayList;
import java.util.Scanner;
public class JavaApplication22 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
	System.out.println("please enter N: ");
         N =sc.nextInt();
        Maze = new boolean[N][N];
        System.out.println("please enter values for maze:");
        for (int i = 0; i < N; i++) 
            for (int j = 0; j < N; j++) 
                Maze[i][j] = sc.nextInt()==1;
         System.out.println("Solution :");
          boolean f = mazeBT(0,0);
          if(!f)
           System.out.println("no path found");
    }
    static boolean Maze[][];
   static int N;
   static boolean finish=false;
   static ArrayList<String> ar = new ArrayList<>();
   static boolean mazeBT(int i,int j){
       if(finish) return false;
              if(Maze[i][j]) return false;

   if(i==N-1 && j==N-1) {
       
       ar.add("("+i+","+j+")"); 
       System.out.println(ar.toString().replaceAll("[\\[\\]\\s+]",""));
       ar.remove(ar.size()-1);
       finish = true;
       return true;}
   
   		Maze[i][j] = true;
       boolean c1=false,c2=false,c3=false,c4=false;
       ar.add("("+i+","+j+")");
      if(i>0) {c2 = mazeBT(i-1,j);}
      if(j<N-1) {c3=mazeBT(i,j+1);}
      if(i<N-1) {c1 = mazeBT(i+1,j);}
      if(j>0){c4=mazeBT(i,j-1);}
       ar.remove(ar.size()-1);
       //Maze[i][j] = false;
       return c1||c2||c3||c4;   
   }
}