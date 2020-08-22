package prob1;
import java.util.Scanner;
public class JavaApplication21 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter number of vertices:");
       int nodes = sc.nextInt();
       GRAPH = new boolean[nodes+1][nodes+1];
        System.out.println("please enter number of edges: ");
       int edges = sc.nextInt();
        System.out.println("please enter edges in the form (u  v): ");
        for (int i = 0; i < edges; i++) {
            int s=sc.nextInt(),d=sc.nextInt();
            GRAPH[s][d]= GRAPH[d][s] = true;
        }
        isv= new boolean[GRAPH.length];
        System.out.println("please enter starting vertex: ");
        int node = sc.nextInt();
        src = node;
        System.out.println("please enter value k : ");
        int k =sc.nextInt();
        gk = k;
        clone = clone(GRAPH);
        
   System.out.printf("There are %d people with %d connections away starting from %d\n",backtrack(node,k),k,node);
    }

   static boolean GRAPH[][];
   static boolean isv[] ;
   static boolean[][] clone(boolean [][] graph){
       boolean[][] clone = new boolean[graph.length][graph[0].length];
       for (int i = 0; i < clone.length; i++) 
           for (int j = 0; j < clone.length; j++) 
               clone[i][j] = graph[i][j];
           

       return clone;
   }
   static int shortestPath(boolean graph[][],int src,int dest){
       if(src==dest) return 0;
       int min=1000000;
       for (int i = 1; i < GRAPH.length; i++) {
           if(graph[src][i] || graph[i][src]){
               graph[src][i]=graph[i][src]=false;
               min = Math.min(min,1+shortestPath(graph,i,dest));
               graph[src][i]=graph[i][src]=true;
           }
       }
       return min;
   }
   static int src,gk;
   static boolean[][] clone;
   static  int backtrack(int node,int k){
      isv[src] = true;
   if(k==0 && shortestPath(GRAPH,node,src)>=gk){ isv[node]=true;  return 1;}
            int n =0;
        for (int i = 1; i < clone.length; i++) {
            if((clone[node][i] || clone[i][node]) && !isv[i] ){
                clone[node][i] = clone[i][node] = false;
                n+= backtrack(i,k-1);
                clone[node][i] = clone[i][node] = true;
            }
        }
        return n;
        
    }
}
