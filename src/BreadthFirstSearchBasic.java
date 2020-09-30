import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class BreadthFirstSearchBasic {

	int V;
	ArrayList<ArrayList<Integer>> adj;
	
	BreadthFirstSearchBasic(int V){
		this.V = V;
		adj = new ArrayList<ArrayList<Integer>>(V);
		for(int i=0;i<V;i++) {
			adj.add(new ArrayList<Integer>());
		}
	}
	
	void addEdge(ArrayList<ArrayList<Integer>> adj,int v, int e) {
		System.out.println(v +" "+e);
		adj.get(v).add(e);
		adj.get(e).add(v);
	}
	
	ArrayList<Integer> bfs(int root) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[V];
		visited[root] = true;
		q.add(root);
		ArrayList<Integer> prev = new ArrayList<>();
		int node;
		while (q.size() != 0) {
			node = q.poll();
			prev.add(node);
			ArrayList<Integer> neighbours = adj.get(node);
			
			for(Integer i : neighbours) {
				if(visited[i] == false) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
		
		return prev;
	}
	
	public static void main(String[] args) {
		BreadthFirstSearchBasic basic = new BreadthFirstSearchBasic(13);
		basic.addEdge(basic.adj,0, 9);
		basic.addEdge(basic.adj,0, 7);
		basic.addEdge(basic.adj,0, 11);
		basic.addEdge(basic.adj,9, 10);
		basic.addEdge(basic.adj,9, 8);
		basic.addEdge(basic.adj,10, 1);
		basic.addEdge(basic.adj,8, 1);
		basic.addEdge(basic.adj,8, 12);
		basic.addEdge(basic.adj,12, 2);
		basic.addEdge(basic.adj,2, 3);
		basic.addEdge(basic.adj,3, 4);
		basic.addEdge(basic.adj,3, 7);
		basic.addEdge(basic.adj,7, 11);
		basic.addEdge(basic.adj,7, 6);
		basic.addEdge(basic.adj,6, 5);
		ArrayList<Integer> prev = basic.bfs(0);
		System.out.println("Bfs Traversal: ");
		for(Integer k : prev) {
			System.out.print(k+" ");
		}
	}

}
