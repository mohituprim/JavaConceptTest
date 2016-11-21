package DataStructure;
import java.util.*;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.lang.*;

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

		int HeightOfBinaryTree(TreeNode root)
		{
			if(root==null)
				return 0;
			else
				return 1+Math.max(HeightOfBinaryTree(root.Left), HeightOfBinaryTree(root.Right));
		}
		
		//Time Complexity = o(n2)
		void LevelOrderTraversalWithoutQueue(TreeNode root)
		{
			
			for(int h=1;h<=HeightOfBinaryTree(root);h++)
			{
				
			}
		}
		
		void printNodeAtLevel(TreeNode root, int level)
		{
			if(root==null)
				return;
			if(level==1)
				System.out.println(root.key);
			else if(level>1)
			{
				printNodeAtLevel(root.Left, level-1);
				printNodeAtLevel(root.Right, level-1);
			}
				
		}
		
		//Time Complexity = o(n2) and space complexity=width of tree
		void LevelOrderTraversal()
		{
			if(this.root==null)
				return;
			Queue<TreeNode> queue =null;

			queue.add(root);
			
			while(!queue.isEmpty())
			{
				TreeNode tn = queue.remove();
				System.out.println(tn.key+",");
				if(tn.Left!=null)
					queue.add(tn.Left);
				if(tn.Right!=null)
					queue.add(tn.Right);	
			}
		}
		
		void InorderTraversalWithOutRecursion()
		{
			if(this.root==null)
				return;
			TreeNode temp=this.root;
			Stack<TreeNode> stack = null;
			while(temp!=null)
			{
				stack.push(temp);
				temp=temp.Left;
			}
			
			while(stack.size()>0)
			{
				temp=stack.pop();
				System.out.println(temp.key+",");
				if(temp.Right!=null)
				{
					temp=temp.Right;
					while(temp!=null)
					{
						stack.push(temp);
						temp=temp.Left;
					}
				}
			}
		}
		
		int preIndex=0;
		TreeNode ConstructTreeFromInOrderAndPreOrder(ArrayList<Integer> inorder,  ArrayList<Integer> preorder, int inStrt, int inEnd)
		{

			if(inStrt>inEnd)
				return null;
			//Take Item from preorder
			TreeNode tNode = new TreeNode(preorder.get(preIndex++));
			//No children left for this node
			if(inStrt==inEnd)
				return tNode;
			int inIndex= inorder.indexOf(tNode.key);
			
			tNode.Left=ConstructTreeFromInOrderAndPreOrder(inorder, preorder, inStrt, inIndex-1);
			tNode.Right=ConstructTreeFromInOrderAndPreOrder(inorder, preorder, inIndex+1, inEnd);
			return tNode;
		}
		
		HashMap<Integer, ArrayList<Integer>> hashMap =  new HashMap<>();
		void getVerticalOrederUsingHash(TreeNode root, int hashDistance)
		{
			if(root==null)
				return;

			try
			{
				hashMap.get(hashDistance).add(root.key);
				hashMap.put(hashDistance, hashMap.get(hashDistance));
			}
			catch(NullPointerException ex){
				ArrayList<Integer> node = new ArrayList<>();
				node.add(root.key);
				hashMap.put(hashDistance, node);
;				
			}
			
			getVerticalOrederUsingHash(root.Left, hashDistance-1);
			getVerticalOrederUsingHash(root.Right, hashDistance+1);	
		}
		
		void printVerticalOrder()
		{
			for (Map.Entry<Integer, ArrayList<Integer>> element : hashMap.entrySet()) {
				System.out.println(element.getKey());
				Iterator entries = element.getValue().iterator();
				while(entries.hasNext())
				{
					System.out.println(entries.toString());
				}
			}
		}
	}
	
	class BinarySearchTree
	{
		
		//root of binary  search tree 
		TreeNode root;
		public BinarySearchTree(int key) {
			// TODO Auto-generated constructor stub
			root =  new TreeNode(key);
		}
		
		public BinarySearchTree()
		{
			root=null;
		}
		
	    /* A recursive function to insert a new key in BST */
		public TreeNode insertRecursive(TreeNode root, int key) {
	 
	        /* If the tree is empty, return a new node */
	        if (root == null) {
	            root = new TreeNode(key);
	            return root;
	        }
	 
	        /* Otherwise, recur down the tree */
	        if (key < root.key)
	            root.Left = insertRecursive(root.Left, key);
	        else if (key > root.key)
	            root.Right = insertRecursive(root.Right, key);
	 
	        /* return the (unchanged) node pointer */
	        return root;
	    }
		
		// A utility function to search a given key in BST
		public TreeNode search(TreeNode root, int key)
		{
		    // Base Cases: root is null or key is present at root
		    if (root==null || root.key==key)
		        return root;
		 
		    // val is greater than root's key
		    if (root.key > key)
		        return search(root.Left, key);
		 
		    // val is less than root's key
		    return search(root.Right, key);
		}
		
		//LeftMost Node
		public TreeNode FindMin(TreeNode root)
		{
			TreeNode temp=root;
			while(temp.Left!=null)
			{
				temp=temp.Left;
			}
			
			return temp;
		}
		
		
		
		public TreeNode  GetSuccessor(TreeNode root, int data)
		{
			//search in tree
			TreeNode currentNode=search(root, data);
			//There is no node with given data
			if(currentNode==null)
				return null;
			if(currentNode.Right!=null)//Case 1 Node has right subtree
			{
				return FindMin(currentNode.Right);
			}
			else//case 2 no right subtree
			{
				TreeNode succ=null;
				TreeNode ancestor =root;
				while(ancestor!=currentNode)
				{
					if(currentNode.key<ancestor.key)
					{
						succ=ancestor; //so far this is the deepest node for which current node is in left
						ancestor =ancestor.Left;
					}
					else
						ancestor =ancestor.Right;
				}
				return succ;
			}
		}
		
		//RightMost Node
		public TreeNode FindMax(TreeNode root)
		{
			TreeNode temp=root;
			while(temp.Right!=null)
			{
				temp=temp.Right;
			}
			
			return temp;
		}
		public TreeNode GetPredecessor(TreeNode root, int data)
		{
			//
			TreeNode currentNode = search(root, data);
			if(currentNode==null)
				return null;
			if(currentNode.Left!=null)
				return FindMax(currentNode.Left);
			else
			{
				//parent node(deepest node) for which current node is in right
				TreeNode pred=null;
				TreeNode ancestor =root;
				while(ancestor!=currentNode)
				{
					if(currentNode.key>ancestor.key)
					{
						pred=ancestor;
						ancestor=ancestor.Right;
					}
					else
						ancestor = ancestor.Left;
				}
				
				return pred;
			}
			
		}
		
		public void DeleteNodeFromBST(TreeNode node)
		{
			if(node==null)
				return;
			else if(node.Left==null&&node.Right==null)
				return;
			else if(node.Left!=null)
			{
				node.key=(node.Left).key;
				node.Left=null;
			}
			else if(node.Right!=null)
			{
				node.key=(node.Right).key;
				node.Right=null;
			}
			else
			{
				TreeNode inorderSuceesor = GetSuccessor(root, node.key);
				int temp=node.key;
				node.key=inorderSuceesor.key;
				inorderSuceesor.key=temp;
				DeleteNodeFromBST(inorderSuceesor);
			}
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
