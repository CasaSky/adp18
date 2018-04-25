/**
 * Created by michelbrueger on 23.04.18.
 */
public interface ListeInterface<T> {

   /**
    * Computes the amount of elements contained in the list
    * @return amount of elements as int, 0 if List is empty
    */
   int getSize();

   /**
    * Inserts an element at a given position into the list.
    * @param element element to be inserted, element must not be NULL
    * @param position 0 <= position <= Liste.size()
    */
   void insert(T element, int position);

   /**
    * Deletes the element of the list at given position
    * @param position 0 <= position < Liste.size(), index of element that has to be deleted
    */
   void delete(int position);

   /**
    * Computes element at given position
    * @param position 0 <= position < Liste.size(), index of position of element that is to return
    * @return element of list at position, element != null
    */
   T get(int position);

   /**
    * Clears all elements of the list
    */
   void clear();

   /**
    * Inserts elements of otherList at the end of this list.
    * @param otherList != null
    * @return this list. must not be NULL, size must be sum of sizes of both lists
    */
//   ListeInterface<T> concat(ListeInterface<T> otherList);
   ListeInterface<T> concat(ListeInterface<T> anotherListe);
   /**
    * Computes sublist of elements of this list
    * @param startPosition 0 <= startPosition < liste.size(), index of element of receiver list that becomes first element in result list
    * @param endPosition 0 <= endPosition < liste.size(), index of element of receiver list that becomes last element in result list
    * @return subliste.size >= 1
    */
//   ListeInterface<T> sublist(int startPosition, int endPosition);
   ListeImpl<T> sublist(int startPosition, int endPosition);


   T[] getArrayListe();


   boolean equals(ListeImpl<T> anotherListe);
}
