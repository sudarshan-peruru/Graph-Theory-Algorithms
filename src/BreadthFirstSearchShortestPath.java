import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearchShortestPath {
	int R,C;
	char[][] m = {{'S','.','.','#','.','.','.'},{'.','#','.','.','.','#','.'},
			{'.','#','.','.','.','.','.'},{'.','.','#','#','.','.','.'},
			{'#','.','#','E','.','#','.'}};
	int sr,sc;
	Queue<Integer> rq = new LinkedList<>();
	Queue<Integer> cq = new LinkedList<>();
	int moveCount = 0;
	int nodesLeftInLayer = 1;
	int nodesInNextLayer = 0;
	boolean reachedEnd = false;
	boolean[][] visited;
	int[] dr = { -1, 1, 0, 0};
	int[] dc = {0, 0, 1, -1};
	
	BreadthFirstSearchShortestPath(int R, int C, int sr, int sc){
		this.R = R;
		this.C = C;
		this.sr = sr;
		this.sc = sc;
		visited = new boolean[R][C];
	}
	
	int shortestPath() {
			rq.add(sr);
			cq.add(sc);
			visited[sr][sc] = true;
			while (rq.size() > 0 || cq.size() > 0) {
				int r = rq.poll();
				int c = cq.poll();
				if(m[r][c] == 'E') {
					reachedEnd = true;
					break;
				}
				exploreNeighbours(r, c);
				nodesLeftInLayer--;
				if(nodesLeftInLayer == 0) {
					nodesLeftInLayer = nodesInNextLayer;
					nodesInNextLayer = 0;
					moveCount++;
				}
			}
			if(reachedEnd) {
				return moveCount;
			}
			return -1;
		}
	
	void exploreNeighbours(int r, int c) {
		int rr=-1,cc=-1;
		for(int i=0;i<4;i++) {
			rr = r + dr[i];
			cc = c + dc[i];
			if(rr < 0 || cc < 0) {
				continue;
			}
			if (rr >= R || cc >= C) {
				continue;
			}
			if (visited[rr][cc]) {
				continue;
			}
			if(m[rr][cc] == '#') {
				continue;
			}
			
			rq.add(rr);
			cq.add(cc);
			visited[rr][cc] = true;
			nodesInNextLayer++;
		}
		
	}
	
	public static void main(String[] args) {
		BreadthFirstSearchShortestPath bfs = new BreadthFirstSearchShortestPath(5, 7, 0, 0);
		System.out.println("Shortest Path is: " + bfs.shortestPath());
	}

}
