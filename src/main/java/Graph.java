import java.util.Iterator;

/**
 * GRAPH INTERFACE
 * Created by Hasan MEN on 21.05.2016.
 */
public interface Graph {

    /**
     * Get number of vertices
     * @return number of vertices
     */
    int getNumV();

    /**
     * Check graph is directed
     * @return status of directed
     */
    boolean isDirected();

    /**
     * This method adds new element to graph
     * @param edge new edge to add
     */
    void insert(Edge edge);

    /**
     * This method control edges
     * @param source start vertex
     * @param dest end vertex
     * @return if edge return true otherwise return false
     */
    boolean isEdge(int source, int dest);

    /**
     * This method check edges, if has edge returns edge
     * @param sooruce edge source - start vertex
     * @param dest edge destination - end index
     * @return edge
     */
    Edge getEdge(int sooruce, int dest);

    /**
     * This method return a graph iterator
     * @param source iterator index
     * @return graph iterator
     */
    Iterator<Edge> edgeIterator(int source);
}
