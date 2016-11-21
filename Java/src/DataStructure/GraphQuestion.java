package DataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.LinkedList;
import java.util.Stack;

public class GraphQuestion {
	
	//Using array list only

/*	class Graph {
		Integer Vertex;
		ArrayList<List<Integer>> adjList;
		
		public Graph(Integer Vertex) {
			// TODO Auto-generated constructor stub
			this.Vertex = Vertex;
			this.adjList = new ArrayList<>(this.Vertex);
	        for (int i = 0 ; i < this.Vertex ; i++)
	        {
	        	this.adjList.add(new ArrayList<Integer>());
	        }
		}
		
		public void addEdge(Integer src, Integer dest) {
			// Add an edge from src to dest.
			this.adjList.get(src).add(dest);
			
			// Since graph is undirected, add an edge from dest to src also
			this.adjList.get(dest).add(src);
		}
	}*/
	
	class Graph {
	    /* Makes use of Map collection to store the adjacency list for each vertex.*/
	    private  Map<Integer, List<Integer>> Adjacency_List;
	    private int vertex;
	    /*
	     * Initializes the map to with size equal to number of vertices in a graph
	     * Maps each vertex to a given List Object
	     */
	    public Graph(int number_of_vertices)
	    {
	        Adjacency_List = new HashMap<Integer, List<Integer>>();
	        this.vertex = number_of_vertices;
	        for (int i = 1 ; i <= number_of_vertices ; i++)
	        {
	            Adjacency_List.put(i, new LinkedList<Integer>());
	        }
	    }


	    /* Adds nodes in the Adjacency list for the corresponding vertex */
	    public void setEdge(int source , int destination)
	    {
	        if (source > Adjacency_List.size() || destination > Adjacency_List.size())
	        {
	            System.out.println("the vertex entered in not present ");
	            return;
	        }
	        List<Integer> slist = Adjacency_List.get(source);
	        slist.add(destination);
	        List<Integer> dlist = Adjacency_List.get(destination);
	        dlist.add(source);
	    }

	    /* Returns the List containing the vertex joining the source vertex */
	    public List<Integer> getEdge(int source)
	    {
	        if (source > Adjacency_List.size())
	        {
	            System.out.println("the vertex entered is not present");
	            return null;
	        }
	        return Adjacency_List.get(source);
	    }
	    
	    public void printAdjacencyList(int number_of_vertices)
	    {
	    	 /* Prints the adjacency List representing the graph.*/
            System.out.println ("the given Adjacency List for the graph \n");
            for (int i = 1 ; i <= number_of_vertices ; i++)
            {
                System.out.print(i+"->");
                List<Integer> edgeList = this.getEdge(i);
                for (int j = 1 ; ; j++ )
                {
                    if (j != edgeList.size())
                    {
                        System.out.print(edgeList.get(j - 1 )+"->");
                    }else
                    {
                        System.out.print(edgeList.get(j - 1 ));
                        break;
                    }
                }
                System.out.println();
            }
	    }
	    
	    public void BreadthFirstTraversalForAGraph(Integer start)
	    {
	    	boolean visited[] = new boolean[this.vertex];
	    	
	    	LinkedList< Integer> queue = new LinkedList<Integer>();
	    	
	    	visited[start] =true;
	    	queue.add(start);
	    	while(queue.size()!=0)
	    	{
	    		 start=queue.poll();
	    		 System.out.println(start + " ");
	    		 Iterator<Integer> i  = (Iterator<Integer>) this.Adjacency_List.get(start);
	    		 
	    		 while(i.hasNext())
	    		 {
	    			 int n= i.next();
	    			 if(!visited[n])
	    			 {
	    				 visited[n]=true;
	    				 queue.add(n);
	    			 }
	    		 }
	    	}
	    	
	    }
	    
	    //Note that the above code traverses only the vertices reachable from a given source vertex.
	    //All the vertices may not be reachable from a given vertex (example Disconnected graph). To do complete DFS traversal of such graphs, we must call DFSUtil() for every vertex. 
	    public void DfsUtil(int start, boolean[] visited)
	    {
	    	visited[start]=true;
	    	
	    	System.out.println(start + " ");
	    	
	    	Iterator<Integer> i  = (Iterator<Integer>) this.Adjacency_List.get(start);
   		 
	   		 while(i.hasNext())
	   		 {
	   			 int n= i.next();
	   			 if(!visited[n])
	   			 {
	   				 DfsUtil(n, visited);
	   			 }
	   		 }
	    	
	    }
	    public void DepthFirstTraversalForAGraph(int start)
	    {
	    	boolean visited[] = new boolean[this.vertex];
	    	
	    	//Will cover only vertex reachabel form start
	    	DfsUtil(start, visited);
	    	
	        // Call the recursive helper function to print DFS traversal
	        // starting from all vertices one by one
	        for (int i=0; i<this.vertex; ++i)
	            if (visited[i] == false)
	            	DfsUtil(i, visited);
	    }
	    
	    public boolean isCyclicDirectedGraphUtil(int start, boolean[] visited, boolean[] recStack)
	    {
	    	visited[start]=true;
	    	recStack[start]=true;
	    	
	    	Iterator<Integer> i  = (Iterator<Integer>) this.Adjacency_List.get(start);
	   		 
	   		 while(i.hasNext())
	   		 {
	   			 int n= i.next();
	   			 if(!visited[n]&&isCyclicDirectedGraphUtil(n, visited, recStack))
	   			 {
	   				 return true;
	   			 }
	   			 else if(recStack[n])
	   				 return true;
	   		 }
	    	recStack[start] =false;
	    	return false;
	    }
//	    DFS to detect cycle in an directed graph in O(V+E) time
	    public boolean isCyclicDirectedGraph()
	    {
	    	boolean[] visited = new boolean[this.vertex];
	    	boolean[] recStack = new boolean[this.vertex];
	    	
	    	for(int i=0;i<this.vertex;i++)
	    	{
	    		if(isCyclicDirectedGraphUtil(i, visited, recStack))
	    			return true;
	    	}
	    	
	    	return false;
	    }
	    
	    public boolean isCyclicUnDirectedGraphUtil(int start, boolean[] visited, int parent)
	    {
	    	visited[start]=true;
	    	
	    	Iterator<Integer> i  = (Iterator<Integer>) this.Adjacency_List.get(start);
	   		 
	   		 while(i.hasNext())
	   		 {
	   			 int n= i.next();
	   			 if(!visited[n]&&isCyclicUnDirectedGraphUtil(n, visited, start))
	   			 {
	   				 return true;
	   			 }
	   			 
	   	        // If an adjacent is visited and not parent of current vertex,
	   	        // then there is a cycle.
	   	        else if (start != parent)
	   	           return true;

	   		 }
	    	return false;
	    }
	    
//	    DFS to detect cycle in an undirected graph in O(V+E) time. The assumption of this approach is that there are no parallel edges between any two vertices.
	    public boolean isCyclicUnDirectedGraph()
	    {
	    	boolean[] visited = new boolean[this.vertex];
	    	
	    	for(int i=0;i<this.vertex;i++)
	    	{
	    		if(isCyclicUnDirectedGraphUtil(i, visited, -1))
	    			return true;
	    	}
	    	
	    	return false;
	    }
	    
//	    we use a temporary stack. We don’t print the vertex immediately, we first recursively call topological sorting for all its adjacent vertices, then push it to a stack. Finally, print contents of stack
	    public void topologicalSortingUtil(int vertex, boolean[] visited, Stack stack)
	    {
	    	visited[vertex]=true;
	    	
	    	Iterator<Integer> i  = (Iterator<Integer>) this.Adjacency_List.get(vertex);
	   		 
	   		 while(i.hasNext())
	   		 {
	   			 int n= i.next();
	   			 if(!visited[n])
	   				topologicalSortingUtil(n, visited, stack);

	   		 }
	   		 
	   		 // Push current vertex to stack which stores result
	         stack.push(new Integer(vertex));
	    }
//	    O(V+E).
	    public void topologicalSorting()
	    {
	    	boolean[] visited = new boolean[this.vertex];
	    	
	    	Stack stack = new Stack();
	    	
	    	for(int i=0;i<this.vertex;i++)
	    	{
	    		if(!visited[i])
	    			topologicalSortingUtil(i, visited, stack);
	    	}
	    	
	    	
	        // Print contents of stack
	        while (stack.empty()==false)
	            System.out.print(stack.pop() + " ");
	    }
	    
	    public void longestPathInDirectedAcyclicGraph(int source)
	    {
	    	boolean[] visited = new boolean[this.vertex];
	    	
	    	int[] dist = new int[this.vertex];
	    	
	    	Stack stack = new Stack();
	    	
	    	for(int i=0;i<this.vertex;i++)
	    	{
	    		if(!visited[i])
	    			topologicalSortingUtil(i, visited, stack);
	    	}
	    	
	        // Initialize distances to all vertices as infinite and distance
	        // to source as 0
	        for (int i = 0; i < this.vertex; i++)
	            dist[i] = Integer.MIN_VALUE;
	        dist[source] = 0;
	        
	     // Process vertices in topological order
	        while (stack.empty()==false)
	        {
	        	// Get the next vertex from topological order
	            int u = (int) stack.peek();
	            stack.pop();
	            
	         // Update distances of all adjacent vertices
	            Iterator<Integer> i  = (Iterator<Integer>) this.Adjacency_List.get(vertex);
	            if (dist[u] != Integer.MIN_VALUE)
	            {
/*	              while(i.hasNext())
	                 if (dist[i] < dist[u] + i->getWeight())
	                    dist[i->getV()] = dist[u] + i->getWeight();*/
	            }
	        }
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Graph g = new GraphQuestion().new Graph(3);
		g.setEdge(1, 2);
		g.setEdge(2, 3);
		g.printAdjacencyList(3);
	}

}
