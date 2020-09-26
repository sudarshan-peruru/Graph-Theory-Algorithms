import java.util.*;
public class DepthFirstSearchAlgoBasic {
	static int noOfNodes = 12;
	static boolean[] visited = new boolean[noOfNodes];
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(noOfNodes);
	public static void main(String[] args) {
		int start_node = 0;
		for (int k = 0; k < noOfNodes; k++) {
			visited[k] = false;
		}
		
		for(int i=0;i<noOfNodes;i++) {
			adj.add(new ArrayList<Integer>());
		}
		addEdge(adj,0,9);
		addEdge(adj,1,0);
		addEdge(adj,3,2);
		addEdge(adj,3,4);
		addEdge(adj,3,5);
		addEdge(adj,5,6);
		addEdge(adj,6,7);
		addEdge(adj,7,3);
		addEdge(adj,7,10);
		addEdge(adj,8,1);
		addEdge(adj,8,7);
		addEdge(adj,9,8);
		addEdge(adj,10,11);
		addEdge(adj,11,7);
		
		printGraph(adj);
		System.out.println();
		dfs(start_node);
	}
	
	static void printGraph(ArrayList<ArrayList<Integer>> adj) {
		for(int i=0; i < adj.size();i++) {
			System.out.println("\nAdjacency list of vertex: "+ i);
			System.out.print("head");
			for (int j = 0; j < adj.get(i).size(); j++) {
				System.out.print("->" + adj.get(i).get(j));
			}
			System.out.println();
		}
	}
	
	static void addEdge(ArrayList<ArrayList<Integer>> adj,int u, int v) {
		adj.get(u).add(v);
		//adj.get(v).add(u);
	}
	
	static void dfs(int at) {
		if(visited[at]) {
			return;
		}
		visited[at] = true;
		System.out.print(" -> " + at);
		ArrayList<Integer> neighbours = adj.get(at);
		for(Integer next : neighbours) {
			dfs(next);
		}
	}
}
