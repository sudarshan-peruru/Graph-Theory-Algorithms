import java.util.ArrayList;
public class DepthFirstSearchAlgoConnectedComp {
	static int noOfNodes = 18,count = 0;
	static boolean[] visited = new boolean[noOfNodes];
	static int[] components = new int[noOfNodes];
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(noOfNodes);
	public static void main(String[] args) {
		for (int k = 0; k < noOfNodes; k++) {
			visited[k] = false;
		}
		
		for(int i=0;i<noOfNodes;i++) {
			adj.add(new ArrayList<Integer>());
		}
		addEdge(adj,0,4);
		addEdge(adj,0,8);
		addEdge(adj,0,14);
		addEdge(adj,0,13);
		addEdge(adj,1,5);
		addEdge(adj,2,15);
		addEdge(adj,2,9);
		addEdge(adj,3,9);
		addEdge(adj,4,8);
		addEdge(adj,5,16);
		addEdge(adj,5,17);
		addEdge(adj,6,11);
		addEdge(adj,6,7);
		addEdge(adj,7,11);
		addEdge(adj,8,14);
		addEdge(adj,9,15);
		addEdge(adj,10,15);
		addEdge(adj,13,14);
		
		System.out.println();
		findComponents();
	}
	
	static void addEdge(ArrayList<ArrayList<Integer>> adj,int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	
	static void findComponents() {
		for (int i = 0; i < noOfNodes; i++) {
			if (!visited[i]) {
				count++;
				System.out.println("Component-" + count + ":");
				dfs(i);
				System.out.println();
			}
		}
	}
	
	static void dfs(int at) {
		if(visited[at]) {
			return;
		}
		visited[at] = true;
		components[at] = count;
		System.out.print(" -> " + at);
		ArrayList<Integer> neighbours = adj.get(at);
		for(Integer next : neighbours) {
			if(!visited[next]) {
				dfs(next);
			}
		}
	}
}
