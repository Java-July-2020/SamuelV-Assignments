public class Project {
    
    // Object Attributes
    private String name;
    private String description;
    private double initialCost;
    
    // Constructor Methods (Overloading is used)
    public Project(){
        this("",0,"");
    }
    public Project(String name){
        this(name,0,"");
    }
    public Project(String name, double initialCost, String description){
        this.name = name;
        this.initialCost = initialCost;
        this.description = description;
       
    }

    // Customized Methods
    public String elevatorPitch(){
        String elevatorPitch = "- " + this.name + " ($" + this.initialCost + "): " + this.description;
        return elevatorPitch;
    }

    // Getter and Setter Methods
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public double getInitialCost(){
        return this.initialCost;
    }
    public void setInitialCost(double initialCost){
        this.initialCost = initialCost;
    }

    // Clone Method (used for creating getter and setter methods for an ArrayList).
    // The clone method here is an overrided method from the clone method of the class "ArrayList"

    public Object clone() {
        Project aClone = new Project(this.name, this.initialCost, this.description);
        return aClone;
    }


}