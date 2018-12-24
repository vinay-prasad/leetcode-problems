package org.handsoncoder.leetcode.amazon;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath {
	private static int findShortestPathBFS(char arr[][], int startX, int startY) {
		if (arr[startX][startY] == 'E')
			return 0;
		int moveX[] = new int[] { 0, 0, 1, -1 };
		int moveY[] = new int[] { 1, -1, 0, 0 };
		boolean visited[][] = new boolean[arr.length][arr[0].length];
		Queue<QNode> qNodes = new LinkedList<>();
		qNodes.add(new QNode(startX, startY, 0));
		while (!qNodes.isEmpty()) {
			QNode currNode = qNodes.remove();
			int currX = currNode.x;
			int currY = currNode.y;
			int currDistance = currNode.distance;
			visited[currX][currY] = true;
			// System.out.println(arr[currX][currY]);
			if (arr[currX][currY] == 'E')
				return currDistance;

			for (int i = 0; i < moveX.length; i++) {
				int newX = currX + moveX[i];
				int newY = currY + moveY[i];

				if (newX >= 0 && newX < arr.length && newY >= 0 && newY < arr[0].length && !visited[newX][newY]
						&& arr[newX][newY] != 'X') {
					qNodes.add(new QNode(newX, newY, currDistance + 1));
				}
			}

		}

		return -1;
	}

	private static class QNode {
		int x;
		int y;
		int distance;

		QNode(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}

	}

	public static void main(String[] args) {
		char[][] arr = new char[][] { 
			{ 'S', '1', '1', '1', '1' }, 
			{ '1', '1', 'X', '1', '1' },
			{ '1', '1', '1', '1', '1' }, 
			{ 'X', '1', '1', 'E', '1' }, 
			{ '1', '1', '1', '1', 'X' } };
		System.out.println(ShortestPath.findShortestPathBFS(arr, 0, 0));
		arr = new char[][] { 
			{ '1', '1', '1', '1' }, 
			{ 'X', '1', '1', '1' },
			{ 'X', '1', 'E', 'X' }, 
			{ '1', '1', '1', '1'}, 
			{ 'X', 'X', '1', '1'} };
		System.out.println(ShortestPath.findShortestPathBFS(arr, 0, 0));

	}
}
