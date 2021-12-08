package queue_ex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left, right;
	TreeNode(int x){
		this.val = x;
	}
}

public class Zigzag {
	
	public static void main(String[] args) {
		// 트리1  2 3 4 5 가 있을 때  [[1],[3,2],[4,5]] 로 출력시키기
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		System.out.println(solve(root));
	}
	
	public static List<List<Integer>> solve (TreeNode root){
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		boolean zigzag = false;
		
		queue.offer(root);
		
		while(!queue.isEmpty()) {	
			List<Integer> list = new ArrayList<>();
			int size = queue.size();
			for(int i=0; i<size;i++) {
				TreeNode node = queue.poll();
				if(zigzag) {
					list.add(0,node.val);
				}else {
					list.add(node.val);
				}
				if(node.left != null) {
					queue.offer(node.left);
				}
				if(node.right != null) {
					queue.offer(node.right);
				}
			}	
			zigzag = !zigzag;
			result.add(list);
		}
		return result;
	}
}
