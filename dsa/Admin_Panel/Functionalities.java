package dsa.Admin_Panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Functionalities {
    public static HashMap<String, Vertex> stations;

    public Edges e;
    public Vertex v;

    public Functionalities(){
			stations = new HashMap<>();
            v = new Vertex();
            e = new Edges();
		}

    //checking of the path 
    public boolean hasPath(String stationNm1, String stationNm2, HashMap<String, Boolean> processed) 
		{
			// DIR EDGE
			if (e.containsEdge(stationNm1, stationNm2)) {
				return true;
			}

			//MARK AS DONE
			processed.put(stationNm1, true);

			Vertex vtx = stations.get(stationNm1);
			ArrayList<String> adjVertex = new ArrayList<>(vtx.adjVertex.keySet());

			//TRAVERSE THE adjVertex OF THE VERTEX
			for (String nbr : adjVertex) 
			{

				if (!processed.containsKey(nbr))
					if (hasPath(nbr, stationNm2, processed))
						return true;
			}

			return false;
		}


        public int dijkstra(String source,String destination,boolean flag){
        //flag : is false -> calculate minimum Time 
        //flag : is true -> calculate minimum time
        boolean calTime=false;
        if(flag){
            calTime=true;
        }

        int val=0; //returns min Time or min time

        ArrayList<String> ans = new ArrayList<>(); //track the path from source -> destination
        HashMap<String,DijkstraPair> map = new HashMap<>(); //to store Dijkstra's Pair object for each vertex

        PriorityQueue<DijkstraPair> pq = new PriorityQueue<DijkstraPair>((x,y)-> x.cost - y.cost); //arranging Dijkstra's Pair objects according to the cost where minimum cost is given priority.

        //traversing all the stations
        //and initializing there cost to Integer.MAX_VALUE;
        //for source its cost is 0
        for(String key : stations.keySet()){
            DijkstraPair np = new DijkstraPair();
            np.stationName=key;
            np.cost=Integer.MAX_VALUE;

            if(key.equals(source)){
                np.cost=0;
                np.psf=key;
            }
            pq.add(np);
            map.put(key, np);
        }

        //keep removing the pairs while priority queue is not empty
        while(!pq.isEmpty()){
            DijkstraPair rp = pq.poll();
            if(rp.stationName.equals(destination)){
                val = rp.cost;
                break;
            }

            map.remove(rp.stationName);
            ans.add(rp.stationName);

            Vertex vtx = stations.get(rp.stationName);
            for(String nbr : vtx.adjVertex.keySet()){
                if(map.containsKey(vtx)){
                    int oldCost = map.get(nbr).cost;
                    Vertex k = stations.get(rp.stationName);
                    int newCost;

                    if(calTime==true){
                        newCost=rp.cost+(k.adjVertex.get(nbr)/60);
                    }else{
                        newCost=rp.cost+k.adjVertex.get(nbr);
                    }

                    if(newCost<oldCost){
                        DijkstraPair gp = map.get(nbr);
                        gp.psf=rp.psf+nbr;
                        gp.cost=newCost;

                        pq.add(gp);
                    }
                }
            }
        }
        return val;
    }

    //minimum distance 
    public String getMinDistance(String source,String destination,int flag){
        int min = Integer.MAX_VALUE;
        String ans="";
        HashMap<String,Boolean> processed = new HashMap<>();
        LinkedList<Pair> l = new LinkedList<>();

        //create a new Pair
        Pair p = new Pair();
        p.stationName=source;
        p.psf=source+" ";
        p.minTime=0;
        p.minTime=0;


        //put the new pair in linkedList
        l.addFirst(p);

        while(!l.isEmpty()){
            //remove from the linkedList
            Pair rp = l.removeFirst();
            if(processed.containsKey(rp.stationName)){
                continue;
            }

            processed.put(rp.stationName,true);

            //if there exists direct edge between removed pair and destination vertex
            if(rp.stationName.equals(destination)){
                int temp=rp.minDistance;
                if(temp<min){
                    ans=rp.psf;
                    min=temp;
                }
                continue;
            }
            Vertex rpvtx = stations.get(rp.stationName);
            ArrayList<String> nbrs = new ArrayList<>(rpvtx.adjVertex.keySet());
            
            for(String nbr: nbrs){
                //process only unprocessed neighbours
                if(!(processed.containsKey(nbr))){
                    //make new pair of nbr and put in queue
                    Pair p1 = new Pair();
                    p1.stationName=nbr;
                    p1.psf=rp.psf+nbr+" ";
                    p1.minDistance=rp.minDistance+rpvtx.adjVertex.get(nbr);
                    l.addFirst(p1);

                }
            }
        }
        if(flag==0){
            ans = Integer.toString(min);
            return ans;
        }
        ans = ans + Integer.toString(min);
		return ans;
        
    }

    //minimum time
    public String getMinTime(String source,String destination,int flag){
        int min = Integer.MAX_VALUE;
        String ans="";
        HashMap<String,Boolean> processed = new HashMap<>();
        LinkedList<Pair> l = new LinkedList<>();

        //create a new Pair
        Pair p = new Pair();
        p.stationName=source;
        p.psf=source+" ";
        p.minTime=0;
        p.minTime=0;

        
        //put the new pair in linkedList
        l.addFirst(p);

        while(!l.isEmpty()){
            //remove from the linkedList
            Pair rp = l.removeFirst();
            if(processed.containsKey(rp.stationName)){
                continue;
            }

            processed.put(rp.stationName,true);

            //if there exists direct edge between removed pair and destination vertex
            if(rp.stationName.equals(destination)){
                int temp=rp.minTime;
                if(temp<min){
                    ans=rp.psf;
                    min=temp;
                }
                continue;
            }
            Vertex rpvtx = stations.get(rp.stationName);
            ArrayList<String> nbrs = new ArrayList<>(rpvtx.adjVertex.keySet());
            
            for(String nbr: nbrs){
                //process only unprocessed neighbours
                if(!(processed.containsKey(nbr))){
                    //make new pair of nbr and put in queue
                    Pair p1 = new Pair();
                    p1.stationName=nbr;
                    p1.psf=rp.psf+nbr+" ";
                    p1.minTime=rp.minTime+(rpvtx.adjVertex.get(nbr)*60/80);
                    l.addFirst(p1);
                }
            }
        }
        if(flag==0){
            String str=" ";
            ans = str+min;
            return ans;
        }
        ans=ans+min;
        return ans;
        
    }


    //get interchanges
    public ArrayList<String> getInterChanges(String path){ 
        ArrayList<String> arr = new ArrayList<>();
			String res[] = path.split("  ");
			arr.add(res[0]);
			int count = 0;
			for(int i=1;i<res.length-1;i++)
			{
				int index = res[i].indexOf('~');
				String s = res[i].substring(index+1);
				
				if(s.length()==2)
				{
					String prev = res[i-1].substring(res[i-1].indexOf('~')+1);
					String next = res[i+1].substring(res[i+1].indexOf('~')+1);
					
					if(prev.equals(next)) 
					{
						arr.add(res[i]);
					}
					else
					{
						arr.add(res[i]+" ==> "+res[i+1]);
						i++;
						count++;
					}
				}
				else
				{
					arr.add(res[i]);
				}
			}
			arr.add(Integer.toString(count));
			arr.add(res[res.length-1]);
			return arr;
    }	
}
