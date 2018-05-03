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
        if (element == null){
            throw new IllegalArgumentException("Element must not be null!");
        }
        if (position<0 || position > this.size) {
            throw new IllegalArgumentException("Position must be greater than 0 and lower or equal than size of list!");
        }
        Node nodeToInsert = new Node(element);
        if(this.size == 0){
            this.head = nodeToInsert;
            this.tail = nodeToInsert;
            nodeToInsert.setPosition(position);
        }
        if (position == this.size) {
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
        this.size++;
    }

    @Override
    public void delete(int position) {

    }

    @Override
    public T get(int position) {
        if (position < 0 || position >= getSize()){
            throw new IllegalArgumentException("Position must be greater than 0 and lower than size of list!");
            }
        if(position==0) return (T) this.head.getData();
        if(position==this.size-1) return (T) this.tail.getData();
        else {
            Node actualNode = this.head;
            for (int i=0; i<=position; i++){
                if(i==position) return (T) actualNode.getData();
                actualNode = actualNode.getSuccessor();
            }
        }
        return (T) head.getData();
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
