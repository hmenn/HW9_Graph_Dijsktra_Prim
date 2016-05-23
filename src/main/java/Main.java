/**
 * Created by Hasan MEN on 22.05.2016.
 */
public class Main {

    private static long start;
    private static long end;

    public static void main(String... args) {

        try {

            // read edges from file
            System.out.println("\n######### CREATE LIST GRAPHS  #########\n");
            int pred[] = new int[1000];
            double dist[] = new double[1000];

            System.out.println("READING ALL GRAPH FROM FILES ...");
            System.out.println("Creating ListGraph...");
            start = System.currentTimeMillis();
            ListGraph lg1000_02 = ListGraph.createFromFile("Graphs/1000-0.2.xml");
            ListGraph lg1000_05 = ListGraph.createFromFile("Graphs/1000-0.5.xml");
            ListGraph lg1000_075 = ListGraph.createFromFile("Graphs/1000-0.75.xml");
            ListGraph lg1000_08 = ListGraph.createFromFile("Graphs/1000-0.8.xml");
            ListGraph lg500_02 = ListGraph.createFromFile("Graphs/500-0.2.xml");
            ListGraph lg500_05 = ListGraph.createFromFile("Graphs/500-0.5.xml");
            ListGraph lg500_075 = ListGraph.createFromFile("Graphs/500-0.75.xml");
            ListGraph lg500_08 = ListGraph.createFromFile("Graphs/500-0.8.xml");
            ListGraph lg100_02 = ListGraph.createFromFile("Graphs/100-0.2.xml");
            ListGraph lg100_05 = ListGraph.createFromFile("Graphs/100-0.5.xml");
            ListGraph lg100_075 = ListGraph.createFromFile("Graphs/100-0.75.xml");
            ListGraph lg100_08 = ListGraph.createFromFile("Graphs/100-0.8.xml");
            ListGraph lg50_02 = ListGraph.createFromFile("Graphs/50-0.2.xml");
            ListGraph lg50_05 = ListGraph.createFromFile("Graphs/50-0.5.xml");
            ListGraph lg50_075 = ListGraph.createFromFile("Graphs/50-0.75.xml");
            ListGraph lg50_08 = ListGraph.createFromFile("Graphs/50-0.8.xml");
            end = System.currentTimeMillis();
            System.out.println("\n->>Created all ListedGraph in " + (end - start) + " (ms)");

            System.out.println("\n######### CREATE MATRIX GRAPHS  #########\n");
            System.out.println("READING ALL GRAPH FROM FILES ...");
            System.out.println("Creating Matrix...");
            start = System.currentTimeMillis();
            MatrixGraph mg1000_02 = MatrixGraph.createFromFile("Graphs/1000-0.2.xml");
            MatrixGraph mg1000_05 = MatrixGraph.createFromFile("Graphs/1000-0.5.xml");
            MatrixGraph mg1000_075 = MatrixGraph.createFromFile("Graphs/1000-0.75.xml");
            MatrixGraph mg1000_08 = MatrixGraph.createFromFile("Graphs/1000-0.8.xml");
            MatrixGraph mg500_02 = MatrixGraph.createFromFile("Graphs/500-0.2.xml");
            MatrixGraph mg500_05 = MatrixGraph.createFromFile("Graphs/500-0.5.xml");
            MatrixGraph mg500_075 = MatrixGraph.createFromFile("Graphs/500-0.75.xml");
            MatrixGraph mg500_08 = MatrixGraph.createFromFile("Graphs/500-0.8.xml");
            MatrixGraph mg100_02 = MatrixGraph.createFromFile("Graphs/100-0.2.xml");
            MatrixGraph mg100_05 = MatrixGraph.createFromFile("Graphs/100-0.5.xml");
            MatrixGraph mg100_075 = MatrixGraph.createFromFile("Graphs/100-0.75.xml");
            MatrixGraph mg100_08 = MatrixGraph.createFromFile("Graphs/100-0.8.xml");
            MatrixGraph mg50_02 = MatrixGraph.createFromFile("Graphs/50-0.2.xml");
            MatrixGraph mg50_05 = MatrixGraph.createFromFile("Graphs/50-0.5.xml");
            MatrixGraph mg50_075 = MatrixGraph.createFromFile("Graphs/50-0.75.xml");
            MatrixGraph mg50_08 = MatrixGraph.createFromFile("Graphs/50-0.8.xml");
            end = System.currentTimeMillis();
            System.out.println("\n->>Created all Matrix in " + (end - start) + " (ms)");

            System.out.println("\n### DIJSKTRA AND PRIM TEST ###\n");
            start = System.currentTimeMillis();
            DijkstrasAlgorithm.dijkstrasAlgorithm(lg1000_02, 0, pred, dist);
            end = System.currentTimeMillis();
            System.out.println("List 1000-02 Dijsktra : " + (end - start) + "(ms)");

            // start test
            System.out.println("\n##########################");
            System.out.println("List Graph Prim Tests : \n");
            primTest(lg50_02, "lg50_02", 0);
            primTest(lg50_05, "lg50_05", 0);
            primTest(lg50_075, "lg50_075", 0);
            primTest(lg50_08, "lg50_08", 0);
            primTest(lg100_02, "lg100_02", 0);
            primTest(lg100_05, "lg100_05", 0);
            primTest(lg100_075, "lg100_075", 0);
            primTest(lg100_08, "lg100_08", 0);
            primTest(lg500_02, "lg500_02", 0);
            primTest(lg500_05, "lg500_05", 0);
            primTest(lg500_075, "lg500_075", 0);
            primTest(lg500_08, "lg500_08", 0);
            primTest(lg1000_02, "lg1000_02", 0);
            primTest(lg1000_05, "lg1000_05", 0);
            primTest(lg1000_075, "lg1000_075", 0);
            primTest(lg1000_08, "lg1000_08", 0);

            System.out.println("\n###########################");
            System.out.println("List Graph Dijsktra Test :\n");
            djTest(lg50_02, "lg50_02", 0,50);
            djTest(lg50_05, "lg50_05", 0,50);
            djTest(lg50_075, "lg50_075", 0,50);
            djTest(lg50_08, "lg50_08", 0,50);
            djTest(lg100_02, "lg100_02", 0,100);
            djTest(lg100_05, "lg100_05", 0,100);
            djTest(lg100_075, "lg100_075", 0,100);
            djTest(lg100_08, "lg100_08", 0,100);
            djTest(lg500_02, "lg500_02", 0,500);
            djTest(lg500_05, "lg500_05", 0,500);
            djTest(lg500_075, "lg500_075", 0,500);
            djTest(lg500_08, "lg500_08", 0,500);
            djTest(lg1000_02, "lg1000_02", 0,1000);
            djTest(lg1000_05, "lg1000_05", 0,1000);
            djTest(lg1000_075, "lg1000_075", 0,1000);
            djTest(lg1000_08, "lg1000_08", 0,1000);

            System.out.println("\n##########################");
            System.out.println("Matrix Graph Prim Tests : \n");
            primTest(mg50_02, "mg50_02", 0);
            primTest(mg50_05, "mg50_05", 0);
            primTest(mg50_075, "mg50_075", 0);
            primTest(mg50_08, "mg50_08", 0);
            primTest(mg100_02, "mg100_02", 0);
            primTest(mg100_05, "mg100_05", 0);
            primTest(mg100_075, "mg100_075", 0);
            primTest(mg100_08, "mg100_08", 0);
            primTest(mg500_02, "mg500_02", 0);
            primTest(mg500_05, "mg500_05", 0);
            primTest(mg500_075, "mg500_075", 0);
            primTest(mg500_08, "mg500_08", 0);
            primTest(mg1000_02, "mg1000_02", 0);
            primTest(mg1000_05, "mg1000_05", 0);
            primTest(mg1000_075, "mg1000_075", 0);
            primTest(mg1000_08, "mg1000_08", 0);

            System.out.println("\n###########################");
            System.out.println("Matirx Graph Dijsktra Test :\n");
            djTest(mg50_02, "mg50_02", 0,50);
            djTest(mg50_05, "mg50_05", 0,50);
            djTest(mg50_075, "mg50_075", 0,50);
            djTest(mg50_08, "mg50_08", 0,50);
            djTest(mg100_02, "mg100_02", 0,100);
            djTest(mg100_05, "mg100_05", 0,100);
            djTest(mg100_075, "mg100_075", 0,100);
            djTest(mg100_08, "mg100_08", 0,100);
            djTest(mg500_02, "mg500_02", 0,500);
            djTest(mg500_05, "mg500_05", 0,500);
            djTest(mg500_075, "mg500_075", 0,500);
            djTest(mg500_08, "mg500_08", 0,500);
            djTest(mg1000_02, "mg1000_02", 0,1000);
            djTest(mg1000_05, "mg1000_05", 0,1000);
            djTest(mg1000_075, "mg1000_075", 0,1000);
            djTest(mg1000_08, "mg1000_08", 0,1000);


        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


    }

    /**
     * This method will test prim algorithm on graphs and return run time
     * @param graph list or matrix graph
     * @param name name of graph
     * @param startVertex start vertex
     * @return run time
     */
    public static long primTest(Graph graph, String name, int startVertex) {
        long startTime = System.currentTimeMillis();
        PrimsAlgorithm.primsAlgorithm(graph, startVertex);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(name + " Prim : " + totalTime + "(ms)");
        return totalTime;
    }

    /**
     * This method will test dijsktra algorithm on graphs and return run time
     * @param graph list or matrix graph
     * @param name name of graph
     * @param startVertex start vertex
     * @param size number of vertices
     * @return run time
     */
    public static long djTest(Graph graph, String name, int startVertex, int size) {
        int pred[] = new int[size];
        double dist[] = new double[size];
        long startTime = System.currentTimeMillis();
        DijkstrasAlgorithm.dijkstrasAlgorithm(graph, startVertex,pred,dist);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(name + " Dijsktra : " + totalTime + "(ms)");
        return totalTime;
    }


}
