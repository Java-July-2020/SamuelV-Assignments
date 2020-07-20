public class SinglyLinkedList {
    
    // I) Class attributes
    public Node head;

    // II) Constructor Method
    public SinglyLinkedList() {
        this.head = null;
    }
    
    // III) SLL methods. 
    
    // 3.1) Add Method
    public void add(int value) {
        
        // New node is instanciated
        Node newNode = new Node(value);
        // If the SLL is empty, then the new node is assigned as the head
        if(head == null) {
            head = newNode;
        }
        // Else if the SSL is not empty, we traverse the list until the last node and then we add the new node
        else {
            Node runner = head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }

    // 3.2) Remove Method
    public void remove() {
        // If the SLL is empty, there is no need to remove a node. A print statement is shown at the console
        if(head == null) {
            System.out.println("There is no node to remove on the SLL");
        }
        
        // Else if the SLL is not empty, then
        else {
            // If the SSL has only one node (the head), then we remove that node:
            if (head.next == null){
                head = null;
            }
            // Else if the SSL has more than one node, then we traverse list until the second to last node. We reaching that node, we define its next node as null
            else{
                Node runner = head;
                while(runner.next.next != null) {
                    runner = runner.next;
                }
                runner.next = null;
            }
        }
    }

    // 3.3) Print Values
    public void printValues() {
        // If the SLL is empty, there is no need to ptint values. A print statement is shown at the console
        if(head == null) {
            System.out.println("The SSL list is empty. There is node values to print");
        } 
        // Else if the SSL is not empty, we traverse the list printing each value
        else {
            Node runner = head;
            int counter = 1; 
            while(runner.next != null) {
                if (counter == 1){
                    System.out.println("Node 1 (Head) -> Value: " + runner.value);
                }
                else{
                    System.out.println("Node " + counter + " -> Value: " + runner.value);
                }
                runner = runner.next;
                counter++;
            }
            // Last Value is printed
            System.out.println("Node " + counter + " -> Value: " + runner.value);
        }
    }

    // 3.3) Find value
    public Node find(int value) {
        // If the SLL is empty, there is no need to find a value. A print statement is shown at the console and we return null
        if(head == null) {
            System.out.println("The SSL list is empty. There is no value no look for");
            return null;
        } 
        // Else if the SLL is not empty, then
        else{    
            
            // We traverse the list until the second to last node looking for the first node with the value
            Node runner = head;
            int counter = 1;
            while(runner.next != null) {
                if (runner.value == value){
                    System.out.println("The first node founded with the value " + value + " is: Node " + counter);
                    return runner;
                }
                counter++;
                runner = runner.next;
            }
            
            // If the value is not finded we check the last node
            if (runner.value == value){
                System.out.println("The first node founded with the value " + value + " is the last Node: Node " + counter);
                return runner;
            }
            // Else if the value is not founded in the entire list, then we return null
            else{
                System.out.println("No node was founded with the value " + value);
                return null;
            }
        }
    }

    // 3.4) Remove Node
    public void removeAt(int index) {
        // If the SLL is empty, there is no need to remove a node. A print statement is shown at the console
        if(head == null) {
            System.out.println("There is no node to remove on the SLL");
        } 
        
        // Else, if the SSL is not empty, then

        else{
            // If the node to be removed is the first node, then we set as head the second node
            if (index == 0){
                head = head.next;
                return;
            }
            // Else, we traverse until the second-to-last node looking for a node with the index wanted. I the index is found, we eliminate that node
            else{
                Node runner = head;
                int counter = 1;
                while(runner.next != null) {
                    if (counter == index){
                        runner.next = runner.next.next;
                        return;
                    }
                    counter++;
                    runner = runner.next;
                }
                // If when traversing the list until the second-to-last node does not show any results, then we check the last node matchs with the index looked.
                if(counter == index){
                    runner = null;
                    return;
                }
            }
            
            // If the index is not found in the SLL we print statement at the console
            
            System.out.println("No node was founded with the index " + index);
            return;
            
        }
    }
}