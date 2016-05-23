import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Hasan MEN on 21.05.2016.
 */
public abstract class AbstractGraph implements Graph{
    private boolean directed;
    private int numV;

    /**
     * Constructor
     * @param numV number of vertices
     * @param directed graph is directed
     */
    public AbstractGraph(int numV,boolean directed){
        this.numV=numV;
        this.directed=directed;
    }

    /**
     * Get number of vertices
     * @return number of vertices
     */
    public int getNumV(){
        return this.numV;
    }

    /**
     * Control is graph directed
     * @return status of graph
     */
    public boolean isDirected(){
        return directed;
    }

    /**
     * This method will be use to create graph with reading input file
     * @param filename file name which include vertives and edges
     * @return grapgh
     * @throws IOException may be filenane not valid
     */
    public static AbstractGraph createFromFile(String filename) throws IOException{
        return null;
    }

}
