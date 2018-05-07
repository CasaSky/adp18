import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class NodeTest {
    Node node1;
    Node node2;
    Node node3;
    Node newNode1;
    Node newNode2;
    Node newNode3;
    Node stringNode1;
    Node stringNode2;
    Node stringNode3;
    Node newStringNode1;
    Node newStringNode2;
    Node newStringNode3;
    @Before
    public void setUp() throws Exception {
        node1 = new Node<Integer>(10);
        node2 = new Node<Integer>(20);
        node3 = new Node<Integer>(30);
        newNode1 = new Node<Integer>(10);
        newNode2 = new Node<Integer>(20);
        newNode3 = new Node<Integer>(30);
        stringNode1 = new Node<String>("Eins");
        stringNode2 = new Node<String>("Zwei");
        stringNode3 = new Node<String>("Drei");
        newStringNode1 = new Node<String>("Eins");
        newStringNode2 = new Node<String>("Zwei");
        newStringNode3 = new Node<String>("Drei");

        node1.setSuccessor(node2);
        node2.setPredecessor(node1);
        node2.setSuccessor(node3);
        node3.setPredecessor(node2);
        newNode1.setSuccessor(newNode2);
        newNode2.setPredecessor(newNode1);
        newNode2.setSuccessor(newNode3);
        newNode3.setPredecessor(newNode2);
    }

    @Test
    public void equalsTest() {
        assertTrue(null == null);
        assertTrue(node1.equals(newNode1));
    }


}