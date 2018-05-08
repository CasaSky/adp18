public class Node<T> {
    public T data;
    public Node successor;
    public Node predecessor;

    public Node(T data) {
        this.data = data;
        this.successor = null;
        this.predecessor = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getSuccessor() {
        return successor;
    }

    public void setSuccessor(Node successor) {
        this.successor = successor;
    }

    public Node getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Node predecessor) {
        this.predecessor = predecessor;
    }

    public boolean equals(Node anotherNode){
//        if ((this.getData().equals(anotherNode.getData())
//                && (this.getSuccessor().equals(anotherNode.getSuccessor()) || (this.getSuccessor() == null && anotherNode.getSuccessor() == null) )
//                && (this.getPredecessor().equals(anotherNode.getPredecessor()) || (this.getPredecessor() == null && anotherNode.getPredecessor() == null)))){
//            return true;
//        }
//        return false;
        if (this.getData() == anotherNode.getData()){
            return true;
        }
        return false;
    }
}

