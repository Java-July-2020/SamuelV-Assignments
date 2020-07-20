public class ListTester {
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        
        // TESTING MAIN REQUIREMENTS
        // Methods add(), remove() and printValues() are tested

        System.out.println("\nI) TESTING MAIN REQUIREMENTS");

        sll.add(3);
        sll.add(4);
        sll.add(10);
        sll.add(5);
        sll.add(15);
        sll.add(2);
        sll.remove();
        sll.remove();
        sll.printValues();

        // TESTING OPTIONAL REQUIREMENTS


        System.out.println("\nII) TESTING OPTIONAL REQUIREMENTS");

        System.out.println("\na)Testing find method\n");
        Node foundNode = sll.find(3); // Should return first Node
        Node foundNode_2 = sll.find(10); // Should return third Node
        Node foundNode_3 = sll.find(5); // Should return last Node
        Node foundNode_4 = sll.find(2); // Should return no node (null node)

        System.out.println("\nb)Testing removeAt method");
        SinglyLinkedList sll_2 = new SinglyLinkedList();
        sll_2.add(1);
        sll_2.add(2);
        sll_2.add(3);
        sll_2.add(4);
        sll_2.add(5);
        sll_2.add(6);
        sll_2.add(7);
        System.out.println("\nThis is the list that will be tested");
        sll_2.printValues();

        System.out.println("\nNode at index 0 is removed"); // Head is removed
        sll_2.removeAt(0);
        sll_2.printValues();

        System.out.println("\nNode at index 3 is removed"); // Node 4 is removed
        sll_2.removeAt(3);
        sll_2.printValues();

        System.out.println("\nNode at index 4 is removed (last node)"); // Node 5 is removed
        sll_2.removeAt(4);
        sll_2.printValues();

        System.out.println("\nNode at index 10 is removed?"); // No node is removed. There is no index with the value looked at the SSL
        sll_2.removeAt(10);
        sll_2.printValues();


        
        

    }
}