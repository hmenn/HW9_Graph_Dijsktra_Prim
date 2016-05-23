import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * This class store linked list graph
 * Created by Hasan MEN on 21.05.2016.
 */
public class ListGraph extends AbstractGraph {

    private List<Edge>[] edges; // array of linked lists

    /**
     * Contructor
     * @param numV number of vertices
     * @param directed graph direct
     */
    public ListGraph(int numV,boolean directed){
        super(numV,directed);

        edges = new List[getNumV()]; // create array of list

        for(int i=0;i<this.getNumV();++i){
            edges[i]=new LinkedList<>();
        }
    }

    /**
     * This method returns graph iterator
     * I will use linked list iterator
     * @param source iterator index
     * @return linked-list graph iterator
     */
    public Iterator<Edge> edgeIterator(int source){
        if(source<0 || source >getNumV())
            throw new IndexOutOfBoundsException("LList invalid index :"+source);
        return edges[source].listIterator();
    }

    /**
     * Get edge
     * @param source edge start index
     * @param dest edge destination - end index
     * @return edge
     */
    public Edge getEdge(int source, int dest){
        if(source <0 || source>=getNumV())
            throw new IndexOutOfBoundsException("invalid source : "+source);

        int index = edges[source].indexOf(new Edge(source,dest));

        return index != -1 ? edges[source].get(index) : new Edge(source,dest,Double.POSITIVE_INFINITY);
    }

    /**
     * Checks edges
     * @param source start vertex
     * @param dest end vertex
     * @return edge status
     */
    public boolean isEdge(int source,int dest){
        if(source<0 ||source>=getNumV())
            throw new IndexOutOfBoundsException("Source index out of bounds : "+source);
        return edges[source].contains(new Edge(source,dest));
    }

    /**
     * This method inserts new edge to graph
     * @param edge new edge to add
     */
    public void insert(Edge edge){
        if(edge == null)
            throw new NullPointerException("Null parameter");
        if(edge.getSource()<0 || edge.getSource()>=getNumV() || edge.getDest()<0 || edge.getDest()>=getNumV())
            throw new IllegalArgumentException("Edge source/dest out of bounds");

        edges[edge.getSource()].add(new Edge(edge.getSource(),edge.getDest(),edge.getWeight()));

        if(!isDirected())
            edges[edge.getDest()].add(new Edge(edge.getDest(),edge.getSource(),edge.getWeight()));
    }

    /**
     * This method reads file and parse file
     * then adds edges to graph and returns this graph
     * @param filename filename
     * @return linked list graph
     * @throws IOException if file no exist
     */
    public static ListGraph  createFromFile(String filename) throws IOException {

        File file = new File(filename);

        if(!file.exists())
            throw new FileNotFoundException("File not found : "+filename);

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while((line = bufferedReader.readLine())!=null){
            if(line.startsWith("  <"))
                break;
        }
        int i=0;
        while((line = bufferedReader.readLine())!=null){
            if(line.startsWith("  </"))
                break;
            ++i;
        }

        ListGraph graph = new ListGraph(i,false);
        System.out.println("Found "+i+" vertices in "+filename);

        bufferedReader.readLine();

        String edgeName;
        int vertexSource;
        int vertexDest;
        double edgeWeight;
        while((line = bufferedReader.readLine())!=null){

            if(line.startsWith("  </"))
                break;

            StringTokenizer tokenizer = new StringTokenizer(line,"\"");

                tokenizer.nextToken();
                edgeName=tokenizer.nextToken();
                tokenizer.nextToken();
                vertexSource = Integer.valueOf(tokenizer.nextToken().substring(1));
                tokenizer.nextToken();
                vertexDest = Integer.valueOf(tokenizer.nextToken().substring(1));
                tokenizer.nextToken();
                edgeWeight = Double.valueOf(tokenizer.nextToken());

            //System.out.println(edgeName+" S:"+vertexSource+" D:"+vertexDest+" W:"+edgeWeight);
            graph.insert(new Edge(vertexSource-1,vertexDest-1,edgeWeight));
        }

        bufferedReader.close();
        return graph;
    }

}
