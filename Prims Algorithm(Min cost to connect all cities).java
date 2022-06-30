// Link: https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/graphs/minimum-cost-to-connect-all-cities-official/ojquestion

// Solution

import java.io.*;
import java.util.*;

public class Main {
  static class Edge implements Comparable<Edge> {
    int v;
    int wt;

    Edge(int nbr, int wt) {
      this.v = nbr;
      this.wt = wt;
    }

    @Override
    public int compareTo(Edge o) {
      return this.wt - o.wt;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int vtces = Integer.parseInt(br.readLine());
    ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    for (int i = 0; i < vtces; i++) {
      graph.add(new ArrayList<>());
    }

    int edges = Integer.parseInt(br.readLine());
    for (int i = 0; i < edges; i++) {
      String[] parts = br.readLine().split(" ");
      int v1 = Integer.parseInt(parts[0]);
      int v2 = Integer.parseInt(parts[1]);
      int wt = Integer.parseInt(parts[2]);
      graph.get(v1).add(new Edge(v2, wt));
      graph.get(v2).add(new Edge(v1, wt));
    }
    
    int cost = printMinCost(graph, vtces);
    System.out.println(cost);
  }
  
  static class Pair implements Comparable<Pair>{
      int vtx;
      int parent;
      int cost;
      
      Pair(int v, int p, int c) {
          vtx = v;
          parent = p;
          cost = c;
      }
      
      public int compareTo(Pair other) {
          return this.cost - other.cost;
      }
  }
  
  private static int printMinCost(ArrayList<ArrayList<Edge>> graph, int vtces) {
      boolean[] vis = new boolean[vtces];
      
      int ans = 0;
      
      PriorityQueue<Pair> pq = new PriorityQueue<>();
      pq.add(new Pair(0, -1, 0));
      
      while(pq.size()>0) {
          Pair rem = pq.remove();
          
          if(vis[rem.vtx] == true) {
              continue;
          }
          
          vis[rem.vtx] = true;
          
          ans += rem.cost;
          
          for(Edge nbr: graph.get(rem.vtx)) {
              if(!vis[nbr.v]) {
                  pq.add(new Pair(nbr.v, rem.vtx, nbr.wt));
              }
          }
      }
      
      return ans;
  }

}
