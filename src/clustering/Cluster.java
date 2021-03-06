package clustering;

import io.testio.Printable;

import java.util.ArrayList;

/**
 * 
 * @author colonelmo
 * cluster representation
 */
public class Cluster {
	private int size;
	private EdgeList edgeContainer ;
	private NodeList nodeContainer ;
	private boolean printUtilityFlag ;
	
	int clusterId;
	
	public Cluster(int id){
		printUtilityFlag = false ;
		size = 0 ;
		edgeContainer = new EdgeList() ;
		nodeContainer = new NodeList() ;
		clusterId = id; 
	}
	
	public Cluster recordAddition(Node node){
		nodeContainer.add(node);
		return this ;
	}
	
	public Cluster addEdge(Node a , Node b , Edge e){
		edgeContainer.add(e);
		nodeContainer.add(a);
		nodeContainer.add(b);
		return this ;
	}
	
	public boolean hasEdge(Edge e){
		return edgeContainer.hasEdge(e);
	}
	
	public int getClusterNodeSize(){
		return nodeContainer.size() ;
	}

	public boolean overSized() {
		return getClusterNodeSize() > help.Constants.Parameters.CLUSTER_SIZE ;
	}

	public Edge getOldestEdge() {
		return edgeContainer.getOldestEdge() ;
	}

	public void reset() {
		edgeContainer.reset() ;
		nodeContainer.reset() ;	
	}

	public ArrayList<Edge> allEdges() {
		return edgeContainer.getAll();
	}

	public ArrayList<Node> allNodes() {
		return nodeContainer.getAll() ;
	}
	
	public void setPrintUtilityFlag(boolean b){
		printUtilityFlag = b; 
	}
	
	public boolean getPrintUtilityFlag(){
		return printUtilityFlag;
	}
	
//	public ClusterGraph getGraph(){
//		return new ClusterGraph(edgeContainer, nodeContainer);
//	}
	
	public int getClusterId(){
		return clusterId;
	}

	public GenericClusterRepresentation<Integer> getRepresentation() {
		GenericClusterRepresentation<Integer> ret = new GenericClusterRepresentation<>(clusterId) ;
//		System.out.println("cluster: " + clusterId);
		for(Node n : allNodes()){
//			System.out.println(n.getId());
			ret.addNode(n.getId());
		}
		for(Edge e : allEdges()){
//			System.out.println(e.getA() + " " + e.getB());
			ret.addEdge(e.getA(), e.getB());
		}
//		System.out.println();
		return ret; 
	}

	public int getClusterEdgeSize() {
		return edgeContainer.num() ;
	}
}
