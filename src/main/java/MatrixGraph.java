import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

/**
 * This class will use create matrix graph
 * Created by Hasan MEN on 21.05.2016.
 */
public class MatrixGraph extends AbstractGraph {
    private double[][] edges; // two-dimensional matrix

    /**
     * Matrix graph constructor
     * @param numV number of vertices
     * @param directed is graph direct
     */
    public MatrixGraph(int numV, boolean directed) {
        super(numV, directed);
        edges = new double[numV][];
        for (int i = 0; i < numV; ++i) {
            edges[i] = new double[numV];
            for (int j = 0; j < numV; ++j) {
                edges[i][j] = Double.POSITIVE_INFINITY; // fill graph with infinite value
            }
        }

    }

    /**
     * This method will return matrix graph iterator
     * @param source iterator index
     * @return matrix iterator
     */
    public Iterator<Edge> edgeIterator(int source) {
        if (source < 0 || source >= getNumV()){
            throw new IllegalArgumentException("Iterator index INVALID : "+ source);
        }
        return new MGIter(source);
    }

    /**
     * This method returns edges between two vertices
     * @param source start vertex
     * @param dest edge destination - end index
     * @return if edge there returns edge, otherwise returns infinite edge
     */
    public Edge getEdge(int source, int dest) {
        return isEdge(source,dest)==false ? new Edge(source, dest, Double.POSITIVE_INFINITY) : new Edge(source, dest, edges[source][dest]);
    }

    /**
     * This method control is there edge between two vertices
     * @param source start vertex
     * @param dest end vertex
     * @return is there edge
     */
    public boolean isEdge(int source, int dest) {
        if (source < 0 || source >= getNumV() || dest < 0 || dest >= getNumV())
            throw new IndexOutOfBoundsException("invalid source : " + source);

        return edges[source][dest] == Double.POSITIVE_INFINITY ? false : true;
    }

    /**
     * This method inserts new edge to matrix graph
     * @param edge new edge to add
     */
    public void insert(Edge edge) {
        if (edge == null)
            throw new NullPointerException("Null parameter");
        if (edge.getSource() < 0 || edge.getSource() >= getNumV() || edge.getDest() < 0 || edge.getDest() >= getNumV())
            throw new IllegalArgumentException("Edge source/dest out of bounds");

        edges[edge.getSource()][edge.getDest()] = edge.getWeight();

        if (!isDirected())
            edges[edge.getDest()][edge.getSource()] = edge.getWeight();
    }

    /**
     * This method reads file and parse file
     * then adds edges to graph and returns this graph
     * @param filename filename
     * @return linked list graph
     * @throws IOException if file no exist
     */
    public static MatrixGraph createFromFile(String filename) throws IOException {

        File file = new File(filename);

        if (!file.exists())
            throw new FileNotFoundException("File not found : " + filename);

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.startsWith("  <"))
                break;
        }
        int i = 0;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.startsWith("  </"))
                break;
            ++i;
        }

        MatrixGraph graph = new MatrixGraph(i, false);
        System.out.println("Found " + i + " vertices in " + filename);

        bufferedReader.readLine();

        String edgeName;
        int vertexSource;
        int vertexDest;
        double edgeWeight;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.startsWith("  </"))
                break;

            StringTokenizer tokenizer = new StringTokenizer(line, "\"");

            tokenizer.nextToken();
            edgeName = tokenizer.nextToken();
            tokenizer.nextToken();
            vertexSource = Integer.valueOf(tokenizer.nextToken().substring(1));
            tokenizer.nextToken();
            vertexDest = Integer.valueOf(tokenizer.nextToken().substring(1));
            tokenizer.nextToken();
            edgeWeight = Double.valueOf(tokenizer.nextToken());

            //System.out.println(edgeName+" S:"+vertexSource+" D:"+vertexDest+" W:"+edgeWeight);
            graph.insert(new Edge(vertexSource - 1, vertexDest - 1, edgeWeight));
        }

        bufferedReader.close();
        return graph;
    }

    // Iter class
    /** An iterator to the edges.  An Edge iterator is
     *  similar to an Iterator except that its
     *  next method will always return an edge
     */
    private class MGIter implements Iterator < Edge > {
        // Data fields
        /** The source vertix for this iterator */
        private int source;

        /** The current index for this iterator */
        private int index;

        // Constructor
        /** Construct an EdgeIterator for a given vertix
         *  @param source - The source vertix
         */
        public MGIter(int source) {
            this.source = source;
            index = -1;
            advanceIndex();
        }

        /** Return true if there are more edges
         *  @return true if there are more edges
         */
        public boolean hasNext() {
            return index != getNumV();
        }

        /** Return the next edge if there is one
         *  @throws NoSuchElementException - there are no
         *  more edges
         *  @return the next Edge in the iteration
         */
        public Edge next() {
            if (index == getNumV()) {
                throw new java.util.NoSuchElementException();
            }
            Edge returnValue = new Edge(source, index,edges[source][index]);
            advanceIndex();
            return returnValue;
        }

        /** Remove is not implememted
         *  @throws UnsupportedOperationExeption if called
         */
        @SuppressWarnings("JavadocReference")
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /** Advance the index to the next edge */
        private void advanceIndex() {
            do {
                index++;
            }
            while (index != getNumV() && Double.POSITIVE_INFINITY == edges[source][index]);
        }
    }


}

