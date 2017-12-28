import java.util.ArrayList;
import java.util.Arrays;

public class SearchRunner {

    public static void main(String args[]) {

        //Create our nodes
        Node NYC = new Node("New York City", null);
        Node CHI = new Node("Chicago", null);
        Node DEN = new Node("Denver", null);
        Node MIA = new Node("Miami", null);
        Node DAL = new Node("Dallas", null);
        Node SD = new Node("San Diego", null);
        Node LA = new Node("Los Angeles", null);
        Node SF = new Node("San Francisco", null);

        //Add edges between appropriate cities
        NYC.setChildren(new ArrayList<Node>(Arrays.asList(CHI, DEN, MIA, DAL)), new ArrayList<Integer>(Arrays.asList(75, 100, 90, 125)));
        CHI.setChildren(new ArrayList<Node>(Arrays.asList(NYC, SF, DEN)), new ArrayList<Integer>(Arrays.asList(75, 20, 25)));
        DEN.setChildren(new ArrayList<Node>(Arrays.asList(CHI, NYC, LA, SF)), new ArrayList<Integer>(Arrays.asList(100, 20, 100, 75)));
        MIA.setChildren(new ArrayList<Node>(Arrays.asList(NYC, DAL)), new ArrayList<Integer>(Arrays.asList(90, 50)));
        DAL.setChildren(new ArrayList<Node>(Arrays.asList(NYC, SD, MIA, LA)), new ArrayList<Integer>(Arrays.asList(125, 50, 90, 80)));
        SD.setChildren(new ArrayList<Node>(Arrays.asList(LA, DAL)), new ArrayList<Integer>(Arrays.asList(80, 45)));
        LA.setChildren(new ArrayList<Node>(Arrays.asList(SD, SF, DEN, DAL)), new ArrayList<Integer>(Arrays.asList(100, 80, 45, 45)));
        SF.setChildren(new ArrayList<Node>(Arrays.asList(LA, DEN, CHI)), new ArrayList<Integer>(Arrays.asList(25, 75, 45)));


        //The Edges between cities. So adjMat[0][1] represents the distance between NYC and CHI.
//        int[][] adjMat = new int[][]{
//        	{0,75,100,90,125,0,0,0},
//        	{75,0,20,0,0,0,0,25},
//        	{100,20,0,0,0,0,100,75},
//        	{90,0,0,0,50,0,0,0},
//        	{125,0,0,50,0,90,80,0},
//        	{0,0,0,0,80,45,0,0},
//        	{0,0,100,0,80,45,0,45},
//        	{0,25,75,0,0,0,45,0}};

        //Test our Search Methods
        AbstractSearch bfs = new BreadthFirstSearch(NYC, SD);
        AbstractSearch dfs = new DepthFirstSearch(NYC, SD);
        AbstractSearch dijkstra = new DijkstraSearch(NYC, SD);

        if (bfs.search())
            System.out.println("Breadth First Path Found!");
        else {
            System.out.println("No Path Found");
        }
        if (dfs.search()) {
            System.out.println("Depth First Path Found!");
        } else {
            System.out.println("No DFS Path");
        }
        //dijkstra prints it's own path after finding the goal node
        dijkstra.search();
    }
}