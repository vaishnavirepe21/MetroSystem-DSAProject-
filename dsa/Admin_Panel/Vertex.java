package dsa.Admin_Panel;

import java.util.ArrayList;
import java.util.HashMap;

public class Vertex {
    public HashMap<String,Integer> adjVertex = new HashMap<>();
    
    //getting number of stations 
    public int numberOfVertices(){
        return Functionalities.stations.size();
    }

    //checking if the station exists or not : 
    public boolean containsVertex(String stationName){
        return Functionalities.stations.containsKey(stationName);
    }

    //adding new stations : 
    public void addVertex(String stationName){
        Vertex v = new Vertex();
        Functionalities.stations.put(stationName,v); //value of node is stationName
    }

    //removing the station :
    public void removeVertex(String stationName){
        //getting node to delete
        Vertex vertexToRemove = Functionalities.stations.get(stationName);

        //storing adjacent nodes of the current node in order to delete them from there adjacent nodes 
        //as well
        ArrayList<String> keys = new ArrayList<>(vertexToRemove.adjVertex.keySet());


        //iterating through the adjacent nodes and deleting the current node from there
        for(String key : keys){
            Vertex nbrVertex = Functionalities.stations.get(key);
            nbrVertex.adjVertex.remove(stationName);
        }

        //removing the actaul node 
        Functionalities.stations.remove(stationName);
    }
}
