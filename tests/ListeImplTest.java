import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by michelbrueger on 25.04.18.
 */
public class ListeImplTest {
    @Before
    public void setUp() throws Exception {
        ListeImpl<Integer> Liste1 = new ListeImpl(10);
        Liste1.insert(10,0);
        Liste1.insert(11,1);
        ListeImpl<Integer> Liste2 = new ListeImpl(10);
        Liste2.insert(20,0);
        Liste2.insert(21,1);
    }

    @Test
    public void sizeTest() throws Exception {
        ListeImpl<Integer> Liste1 = new ListeImpl(10);
        Liste1.insert(10,0);
        Liste1.insert(11,1);
        ListeImpl<Integer> Liste2 = new ListeImpl(10);
        Liste2.insert(20,0);
        Liste2.insert(21,1);
        assertEquals(2, Liste1.size());

    }

    @Test
    public void insertTest() throws Exception {
    }

    @Test
    public void deleteTest() throws Exception {
    }

    @Test
    public void getTest() throws Exception {
    }

    @Test
    public void clearTest() throws Exception {
    }

    @Test
    public void concatTest() throws Exception {
    }

    @Test
    public void sublistTest() throws Exception {
    }

    @Test
    public void toStringTest() throws Exception {
    }

    @Test
    public void getSizeTest() throws Exception {
    }

    @Test
    public void getArrayListeTest() throws Exception {
    }

}