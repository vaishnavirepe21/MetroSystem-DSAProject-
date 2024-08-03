package dsa.User_Panel;

import java.util.ArrayList;
import java.util.StringTokenizer;

import dsa.Admin_Panel.*;

public class UserFunctionalities {
    //printing the stations code list : 
    public String[] printStationCodeList(){
        System.out.println("\n================================================================================\n");
        System.out.println("\n\t**** List of station along with their codes ****\n");
        ArrayList<String> keys =new ArrayList<>(Functionalities.stations.keySet());

        int i=1;
        int j=0;
        int m=1;
        StringTokenizer stationName;
        
        String temp="";
        String[] codes = new String[keys.size()];
        char c;
        for(String key:keys){
            stationName=new StringTokenizer(key);

            codes[i-1]="";
            j=0;

            while(stationName.hasMoreTokens()){
                temp=stationName.nextToken();
                c=temp.charAt(0);
                while(c>47 && c<58){     //c is 0-9 numbers 
                    codes[i-1]=codes[i-1]+c;
                    j++;
                    c =temp.charAt(j);
                }//while close

                if ((c<48 || c>57) && c<123)
                codes[i-1]= codes[i-1]+c;
            }//outter while close 

            if (codes[i-1].length() < 2)
					codes[i-1]=codes[i-1]+Character.toUpperCase(temp.charAt(1));
				            
			System.out.print("\t\t"+i + ". " + key + "\t");
			if (key.length()<(22-m))
                    System.out.print("\t");
			if (key.length()<(14-m))
                    System.out.print("\t");
            if (key.length()<(6-m))
                    System.out.print("\t");
            System.out.println(codes[i-1]);
			i++;
			if (i == (int)Math.pow(10,m))
				    m++;
        }//for loop close 
        return codes;
    }

    //displaying metro stations
    public void displayMetroMap(){

        System.out.println("\n\t ******* Pune Metro Map *******"+"\n");
        ArrayList<String> keys = new ArrayList<>(Functionalities.stations.keySet());

        int i=1;
        for (String key : keys) {
            String str = i+". "+key + " --> ";
            Vertex vtx = Functionalities.stations.get(key);
            ArrayList<String> vtxnbrs = new ArrayList<>(vtx.adjVertex.keySet());

            for (String nbr : vtxnbrs) {
                str = str + nbr + " ";
                // Add distance if required
                // str = str + "(" + vtx.adjVertex.get(nbr) + ")";
                str = str + " --> ";  // Separator between neighbors
            }

            // Remove the last comma and space
            if (str.endsWith(" --> ")) {
                str = str.substring(0, str.length() - 5);
            }
            i++;

            System.out.println("\t"+str);
        }
        System.out.println("\n================================================================================\n");
    }

        

    //displaying metro stations: 
    public void displayMetroStations(){
        //System.out.println("\n================================================================================\n");
			ArrayList<String> keys = new ArrayList<>(Functionalities.stations.keySet());
			int i=1;
			for(String key : keys) 
			{
				System.out.println("\t\t"+i + ". " + key +" station.");
				i++;
			}
			System.out.println("\n================================================================================\n");
    }
}
