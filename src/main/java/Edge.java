/**
 * This class will store edge informations
 * Created by Hasan MEN on 21.05.2016.
 */
public class Edge {

    private int dest; // destination
    private int source;
    private double weight;

    /**
     * Edge consturctor
     * @param source start vertex
     * @param dest destination vertex
     */
    public Edge(int source, int dest){
        this.dest=dest;
        this.source=source;
        this.weight=0.0;
    }

    /**
     * Edge constructor
     * @param source start vertex
     * @param dest destination vertex
     * @param weight weight of edge for weighted graps
     */
    public Edge(int source, int dest, double weight){
        this.source=source;
        this.dest=dest;
        this.weight=weight;
    }

    /**
     * This method compares two edges accoriding to their source and destination
     * @param  o other vertex
     * @return value of equality
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        if (dest != edge.dest) return false;
        return source == edge.source;

    }

    /**
     * Creates an hash value
     * @return hash code
     */
    @Override
    public int hashCode() {
        int result = dest;
        result = 31 * result + source;
        return result;
    }

    /**
     * Get destination
     * @return destination
     */
    public int getDest() {
        return dest;
    }

    /**
     * Get source
     * @return source
     */
    public int getSource() {
        return source;
    }

    /**
     * Get weight
     * @return weight of edge
     */
    public double getWeight() {
        return weight;
    }

    /**
     * To string method
     * @return edge string
     */
    @Override
    public String toString() {
        return "Edge{" +
                "dest=" + dest +
                ", source=" + source +
                ", weight=" + weight +
                '}';
    }
}
