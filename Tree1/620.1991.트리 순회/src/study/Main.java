package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * https://minhamina.tistory.com/78
 * 트리 구현과 순회 방법 구현(공부해두기)
 */

public class Main {
	public static Tree tree;

	public static int N;

	// 전위 순회: 루트 노드 -> 왼쪽 차일드 노드 -> 오른쪽 차일드 노드
	public static void preorder(Node root) {
		System.out.print(root.data);

		if (root.left != null)
			preorder(root.left);

		if (root.right != null)
			preorder(root.right);
	}

	// 중위 순회: 왼쪽 차일드 노드 -> 루트 노드 -> 오른쪽 차일드 노드
	public static void inorder(Node root) {
		if (root.left != null)
			inorder(root.left);

		System.out.print(root.data);

		if (root.right != null)
			inorder(root.right);
	}

	// 후위 순회: 왼쪽 차일드 노드 -> 오른쪽 차일드 노드 -> 루트 노드
	public static void postorder(Node root) {
		if (root.left != null)
			postorder(root.left);

		if (root.right != null)
			postorder(root.right);

		System.out.print(root.data);
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		tree = new Tree();

		for (int i = 0; i < N; i++) {
			char[] data;
			data = br.readLine().replaceAll(" ", "").toCharArray();

			tree.createNode(data[0], data[1], data[2]);
		}

		preorder(tree.root);
		System.out.println();

		inorder(tree.root);
		System.out.println();

		postorder(tree.root);
		System.out.println();
	}

}

// 트리 구현하는 방법!!!
class Node {
	public char data;
	public Node left;
	public Node right;

	Node(char data) {
		this.data = data;
	}
}

class Tree {
	Node root;

	public void createNode(char data, char left, char right) {
		if (root == null) {
			root = new Node(data);

			if (left != '.') {
				root.left = new Node(left);
			}

			if (right != '.') {
				root.right = new Node(right);
			}
		} else {
			searchNode(root, data, left, right);
		}
	}

	public void searchNode(Node root, char data, char leftData, char rightData) {
		if (root == null) {
			return;
		} else if (root.data == data) {
			if (leftData != '.')
				root.left = new Node(leftData);

			if (rightData != '.')
				root.right = new Node(rightData);
		} else {
			searchNode(root.left, data, leftData, rightData);
			searchNode(root.right, data, leftData, rightData);
		}
	}
}