import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by michelbrueger on 25.04.18.
 */
public class ListeImplTest {
    ListeImpl<Integer> Liste0;
    ListeImpl<Integer> Liste1;
    ListeImpl<Integer> Liste2;
    ListeImpl<String> ListeString2;
    ListeImpl<String> ListeString3;
    @Before
    public void setUp() throws Exception {
        Liste0 = new ListeImpl<>(10);
        Liste1 = new ListeImpl(11);
        Liste1.insert(10,0);
        Liste2 = new ListeImpl<>(12);
        Liste2.insert(20,0);
        Liste2.insert(21,1);
        ListeString2 = new ListeImpl<>(2);
        ListeString2.insert("Zero",0);
        ListeString2.insert("One",1);
        ListeString3 = new ListeImpl<>(21);
        ListeString3.insert("Null", 0);
        ListeString3.insert("Eins", 1);
        ListeString3.insert("Zwei", 2);
    }

//    @Test
//    public void sizeTest() throws Exception {
//
//    }

    @Test
    public void insertTest() throws Exception {
        assertTrue(0 == Liste0.getSize());
        assertTrue(1 == Liste1.getSize());
        assertTrue(2 == Liste2.getSize());
        assertTrue(3 == ListeString3.getSize());
        assertTrue(10 == Liste1.get(0));
        assertTrue(20 == Liste2.get(0));
        assertTrue(21 == Liste2.get(1));
        assertTrue("Null" == ListeString3.get(0));
        assertTrue("Eins" == ListeString3.get(1));
        assertTrue("Zwei" == ListeString3.get(2));
    }

    @Test
    public void insertDestructiveTest() throws Exception {
        Liste1.insert(100,0);
        assertTrue(100 == Liste1.get(0));
        assertTrue(1 == Liste1.getSize());
        Liste2.insert(200,0);
        Liste2.insert(201,1);
        assertTrue(200 == Liste2.get(0));
        assertTrue(201 == Liste2.get(1));
        assertTrue(2 == Liste2.getSize());
        Liste2.insert(202,2);
        assertTrue(3 == Liste2.getSize());
    }

    @Test (expected = IllegalArgumentException.class)
    public void insertNullExceptionTest() throws Exception {
        Liste0.insert(null,1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void insertNegativePositionExceptionTest() throws Exception {
        Liste0.insert(-111,-1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void insertAtPositionGreaterThanSizeTest() throws Exception {
        Liste0.insert(2,2);
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)  // IllegalArgumentexception wird gar nicht erst gworfen.
    public void insertAtPositionGreaterThanInternalArraySizeTest() throws Exception {
            ListeString2.insert("Two",2);
    }

    @Test
    public void deleteTest() throws Exception {
        Liste1.delete(0);
        assertEquals(0,Liste1.getSize());
        Liste2.delete(0);
        assertEquals(1,Liste2.getSize());
        assertTrue(21 == Liste2.get(0));
    }

    @Test (expected = IllegalArgumentException.class)
    public void deleteNegativePositionTest() throws Exception {
        Liste1.delete(-1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void deletePositionGreaterThanOrEqualSize() throws Exception {
        ListeString3.delete(3);
    }

    @Test
    public void getTest() throws Exception {
        assertTrue(10 == Liste1.get(0));
        assertTrue("Null" == ListeString3.get(0));
        assertTrue("Zwei" == ListeString3.get(2));
    }

    @Test (expected = IllegalArgumentException.class)
    public void getNegativePositionTest() throws Exception {
        Liste1.get(-1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void getPositionGreaterThanOrEqualSize() throws Exception {
        Liste1.get(1);
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
        assertEquals(0, Liste0.getSize());
        assertEquals(1, Liste1.getSize());
        assertEquals(2, Liste2.getSize());
        assertEquals(3, ListeString3.getSize());

    }

    @Test
    public void getArrayListeTest() throws Exception {
    }

}