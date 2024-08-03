package dsa.Admin_Panel;

public class DijkstraPair implements Comparable<DijkstraPair>{
    String stationName;
    String psf; //psf : path so far
    int cost;

    @Override
    public int compareTo(DijkstraPair dp){
        return dp.cost - this.cost;
    }
}
