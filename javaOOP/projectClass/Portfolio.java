import java.util.*;

public class Portfolio {
    
    // Object Attributes
    private ArrayList<Project> projects;
    
    // Constructor Methods
    public Portfolio(ArrayList<Project> projects){
        this.projects = new ArrayList<Project>();
        for (Project aProject : projects) {
            this.projects.add(aProject);
        }
    }

    // Customized Methods
    public double getPortfolioCost(){
        double portfolioCost = 0;
        for (Project aProject : this.projects)
            portfolioCost += aProject.getInitialCost();
        return portfolioCost;
    }

    public void showPortfolio(){
        for (Project aProject : this.projects){
            System.out.println(aProject.elevatorPitch());
        }
    }


    // Getter and Setter Methods
    public ArrayList<Project> getProjects() {
        ArrayList<Project> portfolioReturn = new ArrayList<Project>();
        for (Project aProject : this.projects) {
            portfolioReturn.add((Project) aProject.clone());
        }
        return portfolioReturn;
    }

    public void setProjetcs(ArrayList<Project> projects) {
        for (Project aProject : projects) {
            this.projects.add((Project) aProject.clone());
        }
    }

    

}