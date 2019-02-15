package com.hjdong.dsc.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class TestGraph {

	public static void main(String[] args) {
		TestGraph tg = new TestGraph();
		Graph g1 = tg.new Graph(8);
		g1.addEdge(0, 1);
		g1.addEdge(0, 3);
		g1.addEdge(1, 2);
		g1.addEdge(1, 4);
		g1.addEdge(2, 5);
		g1.addEdge(3, 4);
		g1.addEdge(4, 5);
		g1.addEdge(4, 6);
		g1.addEdge(5, 7);
		g1.addEdge(6, 7);
		/**
		 * 0-1-2
		 * | | |
		 * 3-4-5
		 *   | |
		 *   6-7
		 */
		
		//�������
		bfs(g1);
		//�������
		dfs(g1);
		
		System.out.println(dfs_search(g1, 0, 9));
	}
	
	
	private static List<Integer> dfs_search(Graph g1, int p, int q) {
		// TODO Auto-generated method stub
		if (g1.adj == null && g1.adj.length == 0) {
			return null;
		}
		
		List<Integer> path = new ArrayList<Integer>();
		int[] visit = new int[g1.v];
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(p);
		int dfsnodeIndex;
		boolean find = false;
		while(!stack.isEmpty()) {
			dfsnodeIndex = stack.pop();
			if (visit[dfsnodeIndex] != 1) {
				path.add(dfsnodeIndex);
				System.out.println("visit:" + dfsnodeIndex);
				visit[dfsnodeIndex] = 1;
				for (int ncnodeIndex : g1.adj[dfsnodeIndex]) {
					stack.push(ncnodeIndex);
				}
			}
			
			if (dfsnodeIndex == q) {
				find = true;
				System.out.println("find:" + q);
				break;
			}
			
		}
		if (find) {
			return path;
		} else {
			System.out.println("not find:" + q);
			return null;
		}
	}

	private static void bfs_search(Graph g1, int start, int end) {
		if (g1.adj == null && g1.adj.length == 0) {
			return;
		}
		
		int[] visit = new int[g1.v];
		int hasVisitNode = 0;
		ArrayBlockingQueue<Integer> bfsqueue = new ArrayBlockingQueue<Integer>(g1.v);
		bfsqueue.add(0);
		int bfsnodeIndex;
		while (!bfsqueue.isEmpty()) {
			if (hasVisitNode == g1.v) {
				System.out.println("finish");
				break;
			}
			
			bfsnodeIndex = bfsqueue.poll();
			if (visit[bfsnodeIndex] != 1) {
				System.out.println("visit:" + bfsnodeIndex);
				visit[bfsnodeIndex] = 1;
				hasVisitNode ++;
				for (int ncnodeIndex : g1.adj[bfsnodeIndex]) {
					bfsqueue.offer(ncnodeIndex);
				}
			}
			
		}
		
		
	}

	private static void dfs(Graph g1) {
		// TODO Auto-generated method stub
		if (g1.adj == null && g1.adj.length == 0) {
			return;
		}
		
		int[] visit = new int[g1.v];
		int hasVisitNode = 0;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		int dfsnodeIndex;
		
		while(true) {
			if (hasVisitNode == g1.v) {
				System.out.println("finish");
				break;
			}
			
			dfsnodeIndex = stack.pop();
			if (visit[dfsnodeIndex] != 1) {
				System.out.println("visit:" + dfsnodeIndex);
				visit[dfsnodeIndex] = 1;
				hasVisitNode ++;
				for (int ncnodeIndex : g1.adj[dfsnodeIndex]) {
					stack.push(ncnodeIndex);
				}
			}
			
		}
	}

	private static void bfs(Graph g1) {
		if (g1.adj == null && g1.adj.length == 0) {
			return;
		}
		
		int[] visit = new int[g1.v];
		int hasVisitNode = 0;
		ArrayBlockingQueue<Integer> bfsqueue = new ArrayBlockingQueue<Integer>(g1.v);
		bfsqueue.add(0);
		int bfsnodeIndex;
		while (!bfsqueue.isEmpty()) {
			if (hasVisitNode == g1.v) {
				System.out.println("finish");
				break;
			}
			
			bfsnodeIndex = bfsqueue.poll();
			if (visit[bfsnodeIndex] != 1) {
				System.out.println("visit:" + bfsnodeIndex);
				visit[bfsnodeIndex] = 1;
				hasVisitNode ++;
				for (int ncnodeIndex : g1.adj[bfsnodeIndex]) {
					bfsqueue.offer(ncnodeIndex);
				}
			}
			
		}
		
		
	}

	class Graph { // ����ͼ

		private int v; // ����ĸ���

		private LinkedList<Integer> adj[]; // �ڽӱ�

		public Graph(int v) {
			this.v = v;
			adj = new LinkedList[v];
			for (int i = 0; i < v; ++i) {
				adj[i] = new LinkedList<>();
			}
		}

		public void addEdge(int s, int t) { // ����ͼһ���ߴ�����
			adj[s].add(t);
			adj[t].add(s);
		}

	}

}
