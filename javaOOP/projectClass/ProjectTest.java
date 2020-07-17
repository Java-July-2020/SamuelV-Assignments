import java.util.*;

public class ProjectTest {
    public static void main(String[] args) {
    
        Project Project_1 = new Project("Hoover Dam", 15000, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." );
        Project Project_2 = new Project("Arizona Nuclear Power Station", 25000, "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat." );
        Project Project_3 = new Project("Washington Distribution Grid", 20000, "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur." );

        // TESTING MAIN REQUIREMENTS

        // I) Get Elevator Pitch from project 1
        System.out.println("\nI) The Elevator Pitch of Project 1 is:");
        System.out.println(Project_1.elevatorPitch());
        
        // II) Get initialCost from project 2
        System.out.println("\nII) The initial Cost of Project 2 is:");
        System.out.println(Project_2.getInitialCost());

        // III) Get name, cost and description from project 3, separetly
        System.out.println("\nIII) The details about name, cost and description of project 3 are:");
        System.out.println("Name of the Project " + Project_3.getName());
        System.out.println("Cost of the Project " + Project_3.getInitialCost());
        System.out.println("Description of the project: " + Project_3.getDescription());
        
        // TESTING OPTIONAL REQUIREMENTS

        ArrayList<Project> myProjects = new ArrayList<Project>(Arrays.asList(Project_1,Project_2,Project_3));

        Portfolio myPortfolio = new Portfolio(myProjects);

        // IV) Get total cost of Portfolio
        System.out.println("\nIV) The total cost of the projects in the Portfolio is: ");
        System.out.println(myPortfolio.getPortfolioCost());

        // V) Print Elevator Pitchs for all projects in Portfolio
        System.out.println("\nV) The elevator Pitchs of all projeccts in the portfolio are:");
        myPortfolio.showPortfolio();
    
    }
}