package Sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
	int val;
	TreeNode left, right;
	
	TreeNode(int x){
		this.val = x;
	}
}
public class Basic_bfs01 {
	//1, 3,2 4,5 출력이 나와야됨 트리를 지그재그로 출력
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		System.out.println(solve(root));
	}
	
	public static List<List<Integer>> solve(TreeNode root){
		
		//1.data structure
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		boolean check = true;  // 지그재그로 출력하기 귀함
		
		//2. 
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			List<Integer> list = new LinkedList<>();
			
			for(int i=0; i<size; i++){
				TreeNode node = queue.poll();
				if(check) {
					list.add(node.val);
				}else {
					list.add(0,node.val);
				}
				
				if(node.left != null) {
					queue.offer(node.left);
				}
				if(node.right != null) {
					queue.offer(node.right);
				}
			}
			check = !check;
			result.add(list);	
		}
		return result;
	}

}
