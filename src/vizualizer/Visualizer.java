package vizualizer;

import javax.swing.JFrame;
import org.apache.commons.collections15.Transformer;
import edu.uci.ics.jung.algorithms.layout.TreeLayout;
import edu.uci.ics.jung.graph.DelegateForest;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import graph.Edge;
import graph.Graph;
import graph.Vertex;

public class Visualizer {
	
	private Graph graph;
	private DelegateForest<Vertex,Edge> forest = new DelegateForest<>();
	private JFrame visualizerFrame = new JFrame();
	private TreeLayout<Vertex,Edge> layout;
	private BasicVisualizationServer<Vertex,Edge> server;
	
	public Visualizer(Graph graph){
		this.graph = graph;
		convertGraph();
	}
	private void convertGraph(){
		for(int i = 0; i < graph.getVertexList().size(); i++){
			forest.addVertex(graph.getVertexList().get(i));			
		}
		for(int j = 0; j < graph.getEdgeList().size(); j++){
			forest.addEdge(graph.getEdgeList().get(j), graph.getEdgeList().get(j).getVertex1(),graph.getEdgeList().get(j).getVertex2());
		}
	}
	
	public void makeGUI(){
		layout = new TreeLayout<>(forest);
		server = new BasicVisualizationServer<>(layout);
		visualizerFrame.add(server);
		visualizerFrame.setBounds(100,100, 300, 300);
		visualizerFrame.setVisible(true);
	}
	
	public void showValues(){
		Transformer<Vertex, String> valueTransformer = new Transformer<Vertex, String>(){
			@Override
			public String transform(Vertex vertex) {
				return vertex.getValue() + "";
			}
		};
		server.getRenderContext().setVertexLabelTransformer(valueTransformer);			
	}
}
