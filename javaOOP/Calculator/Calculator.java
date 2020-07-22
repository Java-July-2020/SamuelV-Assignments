public class Calculator {
    
    // I) Attributes of the Class
    private double operandOne;
    private double operandTwo;
    private String operation; 

    // II) Constructor of the Class
    public Calculator(){
    }

    // III) Customized Methods
    public double performOperation(){
        double result = 0;
        if (operation == "+"){
            result = this.operandOne + this.operandTwo;
        }
        else if (operation == "-"){
            result = this.operandOne - this.operandTwo;
        }
        return result;
    }

    public void getResults(){
        System.out.println("The result of the operation is: " + Double.toString(this.performOperation()));
    }

    // IV) Getters and Setters
    public double getOperandOne() {
        return operandOne;
    }

    public void setOperandOne(double operandOne) {
        this.operandOne = operandOne;
    }

    public double getOperandTwo() {
        return operandTwo;
    }

    public void setOperandTwo(double operandTwo) {
        this.operandTwo = operandTwo;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }


}