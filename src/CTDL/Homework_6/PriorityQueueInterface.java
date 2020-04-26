/* NomNom created on 4/26/2020 inside the package - CTDL.Homework_6 */

package CTDL.Homework_6;

public interface PriorityQueueInterface <K, E> {
    /**
     *
     * @return size of priority queue
     */
    public int size();

    /**
     *
     * @return is priority queue is empty or not
     */
    public boolean isEmpty();

    public void insert(Entry<K, E> entry);
    public void insert(K k, E e);
    public Entry<K, E> removeMin();
    public Entry<K, E> min();
}
