import java.util.ArrayList;

public class Calculator implements java.io.Serializable{
    
    // I) Attributes of the Class
    private ArrayList<Double> myOperands;
    private ArrayList<String> myOperators;
    private double result;

    // II) Constructor of the Class
    public Calculator(){
        this.myOperands = new ArrayList<Double>();
        this.myOperators  = new ArrayList<String>();
        this.result = 0;
    }


    // III) Customized Methods

    public void performOperation(double operand){
        this.myOperands.add(operand);
    }

    public void performOperation(String operator){
        
        // A) If sign "=" is not the "operator" variable, then add operators in myOperators array
        if (operator != "="){
            this.myOperators.add(operator);
        }

        // B) Else, if the "operator" variable is "=", then proceed to calculate the entire Operation:
        else {

            // b.1) First execute multiplication/division operations and save results on "result" variable:
            int index = 0;
            double aux = 0;

            while(myOperators.contains("*")){
                index = myOperators.indexOf("*");
                aux = this.myOperands.get(index)*this.myOperands.get(index+1);
                this.myOperators.remove(index);
                this.myOperands.set(index, aux);
                this.myOperands.remove(index+1);
            }

            while(myOperators.contains("/")){
                index = myOperators.indexOf("/");
                aux = this.myOperands.get(index)/this.myOperands.get(index+1);
                this.myOperators.remove(index);
                this.myOperands.set(index, aux);
                this.myOperands.remove(index+1);
            }

            //b.2) Second, execute addition/substraction operations and save results on "result" variable:

            this.result = this.myOperands.get(0);
            for (int i = 0; i < this.myOperators.size(); i++){
                
                if(this.myOperators.get(i) == "+"){
                    this.result += this.myOperands.get(i+1); 
                }
                else if(this.myOperators.get(i) == "-"){
                    this.result -= this.myOperands.get(i+1); 
                }
            }

            //b.3) After getting the results we clear myOperands and myOperators ArrayLists
            this.myOperands.clear();
            this.myOperators.clear();

        }
        
    }

    public void getResults(){
        System.out.println("The result of the operation is: " + Double.toString(this.result));
    }

    //IV) Getters and Setters 
}