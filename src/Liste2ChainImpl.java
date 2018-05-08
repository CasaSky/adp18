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
//            nodeToInsert.setPosition(position);
        }
        if (position == 0) {
            this.head.setPredecessor(nodeToInsert);
            nodeToInsert.setSuccessor(this.head);
            this.head = nodeToInsert;
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
        if (position<0 || position>=this.size){
            throw new IllegalArgumentException("Position must be greater than or equal 0 and lower than size of list!");
        }
        if (position == 0){
            Node successorOfHead = this.head.getSuccessor();
            successorOfHead.setPredecessor(null);
            this.head = successorOfHead;
        }
        if(this.size == 1){
            this.head = null;
            this.tail = null;
        } else {
            Node actualNode = this.head;
            for (int i=0; i<= position; i++){
                if (i == position-1){
                    Node successorOfSuccessor = actualNode.getSuccessor().getSuccessor();
                    actualNode.setSuccessor(successorOfSuccessor);
                    successorOfSuccessor.setPredecessor(actualNode);
                }
            }
        }
        this.size--;
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
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public ListeInterface<T> concat(ListeInterface<T> anotherListe) {
        Liste2ChainImpl another2ChainListe;
        another2ChainListe = (Liste2ChainImpl) anotherListe;
        if(this.size==0){
            this.head = another2ChainListe.getHead();
            this.tail = another2ChainListe.getTail();
            this.size = anotherListe.getSize();
            return this;
        }
        if(anotherListe.getSize() == 0) {
            return this;
        }
        another2ChainListe.getHead().setPredecessor(this.getTail());
        this.tail.setSuccessor(another2ChainListe.getHead());
        this.tail = another2ChainListe.getTail();
        this.size = this.size + anotherListe.getSize();
        return this;
    }

    @Override
    public ListeInterface<T> sublist(int startPosition, int endPosition) {
        if(startPosition<0 || startPosition >= this.size) {
            throw new IllegalArgumentException("startPosition must be in Range of List-Element-Indexes!");
        }
        if(endPosition<0 || endPosition >= this.size) {
            throw new IllegalArgumentException("endPosition must be in range of List-Element-Indexes!");
        }
        if (endPosition < startPosition) {
            throw new IllegalArgumentException("endPosition must be greater than or equal to startPosition!");
        }
        Liste2ChainImpl<T> resultList = new Liste2ChainImpl<T>();
        for(int i=endPosition; i>=startPosition; i--){
            resultList.insert(this.get(i),0);
        }
        return resultList;


    }

    @Override
    public T[] getArrayListe() {
        return null;
    }

    //@Override
    public boolean equals(Liste2ChainImpl<T> anotherListe) {
        if(this.getSize() != anotherListe.getSize()){
            return false;
        }
        if(this.getSize()==0 && anotherListe.getSize()==0){
            return true;
        }
        if (!(this.getHead().equals(anotherListe.getHead()))
                || !(this.getTail().equals(anotherListe.getTail()))){
            return false;
        }
        for(int i=0; i<this.size; i++){
            if(!this.get(i).equals(anotherListe.get(i))){
                return false;
            }
        }
        return true;
    }


    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return this.tail;
    }


}
