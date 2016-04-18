package DataStructure;

public class TreeDs {

	
	class TreeNode
	{
		int key;
		TreeNode Left, Right;
		
		TreeNode(int item)
		{
			this.key =  item;
			this.Left = null;
			this.Right = null;
		}
		
	}
	
	class BinaryTree
	{
		//root of binary tree 
		TreeNode root;
		public BinaryTree(int key) {
			// TODO Auto-generated constructor stub
			root =  new TreeNode(key);
		}
		public BinaryTree()
		{
			root=null;
		}
		
		public void UseBinaryTree() {
			BinaryTree bt =  new  BinaryTree(10);
		}
	}
	
	public void UseBinaryTree() {
		BinaryTree bt =  new  BinaryTree();
		bt.root = new TreeNode(10);
		bt.root.Left =  new TreeNode(30);
		bt.root.Right = new TreeNode(40);	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//TreeDs t = new TreeDs();
		//this is also one way to use the binary tree
		//BinaryTree bt =  t.new  BinaryTree(10);
		//t.UseBinaryTree();
	}
	
	

}
