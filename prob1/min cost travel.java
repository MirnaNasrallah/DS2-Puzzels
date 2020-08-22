package prob1;
import java.util.ArrayList;
import java.util.Scanner;
public class JavaApplication23 {
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 System.out.println("please enter amount M: ");
        m =sc.nextInt();
        System.out.println("please enter number of cities: ");
        sc.nextInt();
        System.out.println("please enter number of routes: ");
        int e = sc.nextInt();
        Q = new Quad[e];
      System.out.println("please enter source , destination time and cost for each route: ");
        for (int i = 0; i < e; i++) 
           Q[i] = new Quad(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt());
        System.out.println("please enter source city: ");
        int src=sc.nextInt();
        System.out.println("please enter destination city: ");
        dest = sc.nextInt();
        V = new boolean[Q.length];
        Pair travel = minCost(src,0);
        System.out.print("The route with minimum cost is ");
        System.out.println(src+"->"+reverse(travel.p).substring(0,reverse(travel.p).length()-2));
        System.out.printf("Total time %d hours Total cost = %d$\n",travel.t,travel.c);
    }

 static class Quad{
       int s,d,t,c;
       public Quad(int s,int d,int t,int c){
           this.s=s;this.d=d;this.t=t;this.c=c;
       }
   }
   static class Pair{
       int c,t;
       String p="";
       public Pair(int c,int t,String p){
           this.c=c;this.t=t;this.p=p;
       }
   }
  static Pair min(Pair a,Pair b){
       if(a.c!=b.c) return a.c<b.c?a:b;
       return a.t<b.t?a:b;
   }
 static Pair add(Pair a,Pair b){
       return new Pair(a.c+b.c,a.t+b.t,a.p+">-"+b.p);
   }
   static int dest;
   static Quad Q[];
  static int m;
  static boolean V[];
  ArrayList<String> path = new ArrayList<>();
   static Pair minCost(int src,int n){
       if(src==dest) return new Pair(-m,-1,"");
       if(n==Q.length) return new Pair(1000000,1000000,"");
       Pair c1 = minCost(src,n+1);
       Pair c2 = new Pair(1000000,1000000,src+"");
        if(src==Q[n].s && !V[n]){
         V[n] =  true;
         c2 = add(minCost(Q[n].d,0),new Pair(m*(Q[n].t+1) + Q[n].c , Q[n].t+1 , Q[n].d+""));
         V[n] = false;
              }
       return min(c1,c2);
   }
   static String reverse(String s){
       String p = "";
       for (int i = s.length()-1; i >=0; i--) 
           p+=s.charAt(i)+"";
       return p;
   }
}
