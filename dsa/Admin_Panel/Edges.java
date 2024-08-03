package dsa.Admin_Panel;

import java.util.ArrayList;

public class Edges {
    //getting number of edges
    public int numberOfEdges(){
        ArrayList<String> keys = new ArrayList<>(Functionalities.stations.keySet());
        int count=0;

        for(String key : keys){
            Vertex vtx = Functionalities.stations.get(key);
            count = count + vtx.adjVertex.size();
        }
        return (count/2); //as if pune -> mumbai the mumbai -> pune count this as one only.
    }

    //checking if path exists or not
    public boolean containsEdge(String stationNm1,String stationNm2){
        Vertex station1 = Functionalities.stations.get(stationNm1);
        Vertex station2 = Functionalities.stations.get(stationNm2);



        if(station1==null || station2==null || !(station1.adjVertex.containsKey(stationNm2))){
            return false; //path does not exists between station1 and station2
        }
        return true; //path exists between the station1 and station2
    }

    //connecting stations so that path exists:
    public void addEdge(String stationNm1,String stationNm2,int distance){
        Vertex station1 = Functionalities.stations.get(stationNm1);
        Vertex station2 = Functionalities.stations.get(stationNm2);

        if(station1==null || station2==null || (station1.adjVertex.containsKey(stationNm2))){
            return;
        }

        //add the path between two stations
        station1.adjVertex.put(stationNm2,distance);
        station2.adjVertex.put(stationNm1, distance);
    }

    //removing the path : 
    public void removeEdge(String stationNm1,String stationNm2){
        Vertex station1 = Functionalities.stations.get(stationNm1);
        Vertex station2 = Functionalities.stations.get(stationNm2);

        //check if station exists or the path between these stations exists or not
        if(station1==null || station2==null || !(station1.adjVertex.containsKey(stationNm2))){
            return;
        }

        station1.adjVertex.remove(stationNm2);
        station2.adjVertex.remove(stationNm1);
    }
}
