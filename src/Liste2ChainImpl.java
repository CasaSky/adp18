public class Liste2ChainImpl<T> implements ListeInterface<T> {
    private Node head;
    private Node tail;
    private int size;

    public Liste2ChainImpl(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void insert(T element, int position) {
        Node nodeToInsert = new Node(element);
        if(position == 0){
            this.head = nodeToInsert;
            this.tail = nodeToInsert;
            nodeToInsert.setPosition(position);
        } if (position == this.size) {
            this.tail.setSuccessor(nodeToInsert);
            nodeToInsert.setPredecessor(this.tail);
            this.tail = nodeToInsert;
        } else {
            Node actualNode = this.head;
            for (int i=0; i<=position; i++){
                if(i==position-1){
                    nodeToInsert.setSuccessor(actualNode.getSuccessor());
                    nodeToInsert.setPredecessor(actualNode);
                    actualNode.setSuccessor(nodeToInsert);
                }
                actualNode = actualNode.getSuccessor();
            }
        }

    }

    @Override
    public void delete(int position) {

    }

    @Override
    public T get(int position) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public ListeInterface<T> concat(ListeInterface<T> anotherListe) {
        return null;
    }

    @Override
    public ListeImpl<T> sublist(int startPosition, int endPosition) {
        return null;
    }

    @Override
    public T[] getArrayListe() {
        return null;
    }

    @Override
    public boolean equals(ListeImpl<T> anotherListe) {
        return false;
    }
}
