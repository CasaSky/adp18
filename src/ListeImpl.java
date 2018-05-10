import java.lang.reflect.Array;

/**
 * Created by michelbrueger on 23.04.18.
 */
public class ListeImpl<T> implements ListeInterface<T> {

    private T[] arrayListe;
    private int size = 0;
    private int maxSize;

    public ListeImpl(int maxSize) {
        this.maxSize = maxSize;
        arrayListe = (T[])new Object[maxSize];
    }

//    @Override
//    public int size() {
//        return 88;
//    }

    public void arrayListeIncrease(){
        T[] copyArray = (T[]) new Object[maxSize *2];
        for(int i=0; i<this.size; i++){
            copyArray[i] = arrayListe[i];
        }
    }


    public void arrayListeDecrease(){
        T[] copyArray = (T[]) new Object[maxSize / 2];
        for(int i=0; i<this.size; i++){
            copyArray[i] = arrayListe[i];
        }
    }



    @Override
    public void insert(T element, int position) {
        if (element == null) {
            throw new IllegalArgumentException("Element must be not null.");
        }
        if (position < 0 || position > getSize()) {
            throw new IllegalArgumentException("Position must be greater than 0 and lower or equal than size of liste");
        }
        if (position>maxSize) {
            throw new IllegalArgumentException("The list is full and can not store more elements");  // IllegalArgumentException wird nicht geworfen, sondern ArrayIndexOutOfBoundsException
        }
        arrayListe[position] = element;
        if (position == size) {
            size++;
        }
    }

    @Override
    public void delete(int position) {
        T[] copyArrayListe = (T[])new Object[maxSize];

        if (position < 0 || position >= getSize()) {
            throw new IllegalArgumentException("Position must be higher 0 and lower liste size");
        }
        for (int i = 0; i<position; i++) {
             copyArrayListe[i] = arrayListe[i];
        }
        for (int i = position+1; i<size; i++) {
            copyArrayListe[i-1] = arrayListe[i];
        }
        arrayListe = copyArrayListe;
        size--;
    }

    @Override
    public T get(int position) {
        if (position < 0 || position >= getSize()) {
            throw new IllegalArgumentException("Position must be higher 0 and lower liste size");
        }
        return arrayListe[position];
    }

    @Override
    public void clear() {
        arrayListe = (T[])new Object[maxSize];
        this.size = 0;
    }

//    @Override
//    public ListeInterface<T> concat(ListeInterface<T> anotherListe) {
//        if(getSize()==0) {
//            this.arrayListe = anotherListe.getArrayListe();
//        } else {
//            //TODO
//        }
//       // return arrayListe;
//        return null;
//    }
//
//    @Override
//    public ListeInterface<T> sublist(int startPosition, int endPosition) {
//        return null;
//    }

    @Override
    public ListeInterface<T> concat(ListeInterface<T> anotherListe) {
        if(this.getSize() + anotherListe.getSize() > this.maxSize){
            throw new IllegalArgumentException("Internal Array too small!");
        }
        if(this.getSize() == 0) {
            this.arrayListe = anotherListe.getArrayListe();
            this.size = anotherListe.getSize();
        } else {
            for(int i = 0; i < anotherListe.getSize(); ++i) {
                this.insert(anotherListe.get(i), this.getSize());  // statt this.getSize() mit Variable und hochzählen arbeiten, dann muss nicht jedes Mal über die Liste iteriert werden
            }
        }
        return this;
    }

    @Override
    public ListeInterface<T> sublist(int startPosition, int endPosition) {
        ListeImpl resultListe = new ListeImpl(endPosition + 1 - startPosition);
        int resultListeIndex = 0;

        for(int i = startPosition; i <= endPosition; ++i) {
            resultListe.insert(this.get(i), resultListeIndex);
            ++resultListeIndex;
        }

        return resultListe;
    }

    @Override
    public String toString() {
        String resultString = "";

        for(int i = 0; i < this.getSize(); ++i) {
            resultString = resultString + this.get(i).toString() + ", ";
        }

        return resultString;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public T[] getArrayListe() {
        return arrayListe;
    }

//    @Override
    public boolean equals(ListeInterface<T> anotherListe) {
        if (anotherListe.getSize() != this.getSize()) { return false;   }
        for(int i=0; i<this.getSize(); i++) {
            if (this.get(i) != anotherListe.get(i)) {   return false;   }
        }
        return true;
    }
}
