/**
 * Created by michelbrueger on 23.04.18.
 */
public interface ListeInterface<T> {

    /**
     * Computes the amount of elements contained in the list
     * @return amount of elements as int, 0 if List is empty
     */
   int size();

   /**
    * Inserts an element at a given position into the list.
    * @param element element to be inserted, element must not be NULL
    * @param position 0 <= position <= Liste.size()
    */
   void insert(T element, int position);

   /**
    * Deletes the element of the list at given position
    * @param position 0 <= position <= Liste.size()-1, index of element that has to be deleted
    */
   void delete(int position);

   /**
    * Computes element at given position
    * @param position 0 <= position <= Liste.size()-1, index of position of element that is to return
    * @return element of list at position, element must not be NULL
    */
   T get(int position);

   /**
    * Clears all elements of the list
    */
   void clear();

   /**
    * Inserts elements of argument list at the end of list on which method is called upon
    * @param list must not be NULL, must contain elements of same type,
    * @return must not be NULL, size must be sum of sizes of both lists
    */
   ListeInterface<T> concat(ListeInterface<T> list);

   /**
    * Computes sublist of elements of receiver list
    * @param startPosition 0 <= startPosition <= liste.size()-1, index of element of receiver list that becomes first element in result list
    * @param endPosition 0 <= endPosition <= liste.size()-1, index of element of receiver list that becomes last element in result list
    * @return list of elements of receiver list, must not be NULL
    */
   ListeInterface<T> sublist(int startPosition, int endPosition);
}
