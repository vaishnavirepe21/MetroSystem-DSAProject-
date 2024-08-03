package dsa.ControlSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import dsa.Admin_Panel.Functionalities;
import dsa.User_Panel.UserFunctionalities;

public class ControlPanel {
    public static Functionalities func;
    public static UserFunctionalities userFunc;
    
    public static void main(String[] args) throws IOException{

        func = new Functionalities();
        userFunc = new UserFunctionalities();

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try{

                System.out.println("\n\n------------------------------------------------------------------------------------------------------------\n");
                System.out.println("\n\t\t\t****** Metro System Menu ******");
                System.out.println("\n\t\t\t\t1. Admin Panel");
                System.out.println("\n\t\t\t\t2. User Panel");
                System.out.println("\n\t\t\t\t3. Exit");
                System.out.println("\n------------------------------------------------------------------------------------------------------------\n");
                System.out.print("Select option: ");
            
                int option = Integer.parseInt(input.readLine());

                switch (option) {
                    case 1:
                        System.out.println("\n================================================================================\n");
                        System.out.println("\n\t\t****** WELCOME TO PUNE METRO SYSTEM (Admin Panel) ******\n");
                        String adminPassword="adminPune@2023";
                        // System.out.print("\t\tEnter password : ");
                        // String password = input.readLine();
                        String password = PasswordField.readPassword("\t\tEnter password :");
                        if(password.equals(adminPassword)){ 
                            showAdminPanel();
                        }else{
                            String reason="Entered password doesn't match";
                            System.out.println("\n\t\t!!! Please enter valid credentials.\n\t\tProblem : "+reason);
                            System.out.println("\n================================================================================\n");
                        }
                        break;
                    case 2:
                        showUserPanel();
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        System.out.println("\n------------------------------------------------------------------------------------\n");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option. Try again.");
                        System.out.println("\n------------------------------------------------------------------------------------\n");
                } //switch end
            }catch (IOException e) {
                System.out.println("Error reading input. Please try again.");
            }  
        }//while end
    }


    private static void showAdminPanel() {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                System.out.println("\n\t\t ******* Admin Panel Menu *******"); 
                System.out.println("\n\t\t1. Create Metro Map : ");
                System.out.println("\t\t\t1. Add Station");
                System.out.println("\t\t\t2. Add Path");
                System.out.println("\t\t2. Remove : ");
                System.out.println("\t\t\t1. Station");
                System.out.println("\t\t\t2. Path");
                System.out.println("\t\t3. Metro Stations");
                System.out.println("\t\t4. Metro Maps");
                System.out.println("\t\t5. Metro Station Code List");
                System.out.println("\t\t6. Return to Main Menu");
                System.out.println("\n================================================================================\n");
                System.out.print("Select option: ");

                int option = Integer.parseInt(input.readLine());

                switch (option) {
                    case 1:
                        System.out.println("\n------------------------------------------------------------------------------------\n");
                        System.out.print("Enter your choice : ");
                        int choice = Integer.parseInt(input.readLine());
                        System.out.println();
                        if(choice==1){
                            System.out.print("Enter station-1 name : ");
                            String stNm1 = input.readLine();
                            
                            func.v.addVertex(stNm1);
                            
                            System.out.println("Station added Sucessfully !!!");
                            System.out.println("\n------------------------------------------------------------------------------------");
                        }else{
                            System.out.print("\nEnter station-1 name : ");
                            String stNm1 = input.readLine();
                            System.out.print("Enter station-2 name : ");
                            String stNm2 = input.readLine();
                            System.out.print("Enter Distance(in km) : ");
                            int distance = Integer.parseInt(input.readLine());
                            System.out.println();

                            HashMap<String, Boolean> processed = new HashMap<>();

                            boolean find = func.hasPath(stNm1, stNm2, processed);

                            if(find==false){
                                func.e.addEdge(stNm1, stNm2,distance);
                                System.out.println("New Path added Successfully !!!");
                            }else{
                                System.out.println("Path ALREADY exists...");
                            }
                            System.out.println("------------------------------------------------------------------------------------\n");
                        }
                        break;
                    case 2:
                        System.out.println("------------------------------------------------------------------------------------\n");
                        System.out.print("Enter your choice : ");
                        int ch = Integer.parseInt(input.readLine());
                        System.out.println();
                        if(ch==1){
                            System.out.print("Enter station name to remove : ");
                            String stNm1 = input.readLine();
                            func.v.removeVertex(stNm1);
                            System.out.println("Station was REMOVED Successuflly !!!");
                            System.out.println("\n------------------------------------------------------------------------------------\n");
                        }else{
                            System.out.print("Enter station-1 name : ");
                            String stNm1 = input.readLine();
                            System.out.print("Enter station-2 name :");
                            String stNm2 = input.readLine();
                            func.e.removeEdge(stNm1, stNm2);
                            System.out.println("\nPath was REMOVED Successfully!!!");
                            
                            System.out.println("\n------------------------------------------------------------------------------------\n");
                        }
                        break;
                    case 3:
                            System.out.println("------------------------------------------------------------------------------------\n");
                            System.out.println("\n\t\t******* Metro Station List ******* \n");
                            userFunc.displayMetroStations();
                            System.out.println();
                            System.out.println("------------------------------------------------------------------------------------\n");
                        break;
                    case 4:
                            System.out.println("------------------------------------------------------------------------------------\n");
                            userFunc.displayMetroMap();
                            System.out.println();
                            System.out.println("------------------------------------------------------------------------------------\n");
                            
                        break;
                    case 5:
                            System.out.println("------------------------------------------------------------------------------------\n");
                            userFunc.printStationCodeList();
                            System.out.println("------------------------------------------------------------------------------------\n");
                            break;
                    case 6:
                        return;
                    default:
                        System.out.println("Invalid option. Try again.");
                        System.out.println("\n------------------------------------------------------------------------------------\n");
                }
            } catch (IOException ie) {
                System.out.println("Error reading input. Please try again.");
            }
        }
    }

    

    private static void showUserPanel() {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.println("------------------------------------------------------------------------------------------------------------");
                System.out.println("\n\n\t\t\t\t ****** WELCOME TO PUNE METRO SYSTEM ******");
                System.out.println("\n\t\tGet Access to ");
                System.out.println("\n\t\t1. Metro Stations");
                System.out.println("\t\t2. Metro Map");
                System.out.println("\t\t3. Station Code List");
                System.out.println("\t\t4. Minimum Distance (to reach from source->destination)");
                System.out.println("\t\t5. Minimum Time (to reach from source->destination)");
                System.out.println("\t\t6. Path ( to reach from source->destination)");
                System.out.println("\t\t7. Return to Main Menu\n\n");
                System.out.println("------------------------------------------------------------------------------------------------------------");
                
                System.out.print("\n\tSelect option: ");

                int option = Integer.parseInt(input.readLine());

                switch (option) {
                    case 1:
                        System.out.println("\n================================================================================\n");
                        System.out.println("\n\t\t******* Metro Station List ******* \n");
                        userFunc.displayMetroStations();
                        System.out.println();
                        break;
                    case 2:
                        userFunc.displayMetroMap();
                        System.out.println();
                        break;
                    case 3:
                        userFunc.printStationCodeList();
                        System.out.println("\n================================================================================\n");
                        System.out.println();
                        break;
                    case 4:
                        System.out.println("\n================================================================================\n");
                        System.out.print("Enter start station : ");
                        String srcStation = input.readLine();
                        System.out.print("Enter destination station : ");
                        String desStation = input.readLine();
                        String res = func.getMinDistance(srcStation, desStation,0);
                        System.out.println("\nSHORTEST DISTANCE FROM : ");
                        System.out.print(srcStation + " ---> "+desStation + " = " + res+ " km\n\n");
                        System.out.println("\n================================================================================\n");
                        break;
                    case 5:
                    System.out.println("\n================================================================================\n");
                        System.out.print("Enter start station : ");
                        String station1 = input.readLine();
                        System.out.print("Enter destination station : ");
                        String station2 = input.readLine();
				
                        String result = func.getMinTime(station1, station2,0);				
					    System.out.println("\nSHORTEST TIME FROM : ");
                        System.out.print(station1 + " ---> "+station2 + " (approximately) =" + result+ " minutes\n\n");
                        System.out.println("\n================================================================================\n");
                        break;
                    case 6:
                        System.out.println("\n================================================================================\n");
                        System.out.print("Enter start station : ");
                        String st1 = input.readLine();
                        System.out.print("Enter destination station : ");
                        String st2 = input.readLine();
				
					HashMap<String, Boolean> processed2 = new HashMap<>();
					if(!func.v.containsVertex(st1) || !func.v.containsVertex(st2) || !func.hasPath(st1, st2, processed2))
						System.out.println("THE INPUTS ARE INVALID");
					else {
						ArrayList<String> str = func.getInterChanges(func.getMinDistance(st1, st2,1));
						int len = str.size();
                        System.out.println();
						System.out.println("SOURCE STATION : " + st1);
						System.out.println("DESTINATION STATION : " + st2);
						System.out.println("DISTANCE : " + str.get(len-1));
						System.out.println("NUMBER OF INTERCHANGES : " + str.get(len-2));
						System.out.println();
					}
                    System.out.println("================================================================================\n");
                        break;
                    case 7: 
                        return;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            } catch (IOException ie) {
                System.out.println("Error reading input. Please try again.");
            }
        }
    }
}
