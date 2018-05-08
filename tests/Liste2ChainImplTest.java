import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Liste2ChainImplTest {
    Liste2ChainImpl<Integer> liste0;
    Liste2ChainImpl<Integer> liste1;
    Liste2ChainImpl<Integer> liste2;
    Liste2ChainImpl<String> listeString2;
    Liste2ChainImpl<String> listeString3;
    Liste2ChainImpl<String> listeString10;
    Liste2ChainImpl<Integer> liste321;

    @Before
    public void setUp() throws Exception {
        liste0 = new Liste2ChainImpl<>();
        liste1 = new Liste2ChainImpl<>();
        liste1.insert(10,0);
        liste2 = new Liste2ChainImpl<>();
        liste2.insert(20,0);
        liste2.insert(21,1);
        listeString2 = new Liste2ChainImpl<>();
        listeString2.insert("Zero",0);
        listeString2.insert("One",1);
        listeString3 = new Liste2ChainImpl<>();
        listeString3.insert("Null", 0);
        listeString3.insert("Eins", 1);
        listeString3.insert("Zwei", 2);
        listeString10 = new Liste2ChainImpl<>();
        listeString10.insert("Null",0);
        listeString10.insert("Eins",1);
        listeString10.insert("Zwei",2);
        listeString10.insert("Drei",3);
        listeString10.insert("Vier",4);
        listeString10.insert("Fuenf",5);
        listeString10.insert("Sechs",6);
        listeString10.insert("Sieben",7);
        listeString10.insert("Acht",8);
        listeString10.insert("Neun",9);
        liste321 = new Liste2ChainImpl<>();
        liste321.insert(1,0);
        liste321.insert(2,0);
        liste321.insert(3,0);
    }


    @Test
    public void insertTest() throws Exception {
        assertTrue(0 == liste0.getSize());
        assertNull(liste0.getHead());
        assertNull(liste0.getTail());
        assertTrue(1 == liste1.getSize());
        assertNotNull(liste1.getHead());
        assertNotNull(liste1.getTail());
        assertEquals(10, liste1.getHead().getData());
        assertEquals(10, liste1.getTail().getData());
        liste1.insert(9,0);
        assertEquals(9, liste1.getHead().getData());
        assertEquals(10, liste1.getTail().getData());
        assertTrue(2 == liste2.getSize());
        assertEquals(20, liste2.getHead().getData());
        assertEquals(21, liste2.getTail().getData());
        assertTrue(3 == listeString3.getSize());
        assertEquals("Null", listeString3.getHead().getData());
        assertEquals("Zwei", listeString3.getTail().getData());
        assertTrue(9 == liste1.get(0));
        assertTrue(20 == liste2.get(0));
        assertTrue(21 == liste2.get(1));
        assertTrue("Null" == listeString3.get(0));
        assertTrue("Eins" == listeString3.get(1));
        assertTrue("Zwei" == listeString3.get(2));
        assertTrue(3 == liste321.get(0));
        assertTrue(2 == liste321.get(1));
        assertTrue(1 == liste321.get(2));
        assertEquals(3, liste321.getHead().getData());
        assertEquals(1, liste321.getTail().getData());
    }

    @Test
    public void insertNonDestructiveTest() throws Exception {
        liste1.insert(100,0);
        assertTrue(100 == liste1.get(0));
        assertTrue(10 == liste1.get(1));
        assertTrue(2 == liste1.getSize());
        liste2.insert(200,0);
        liste2.insert(201,1);
        assertTrue(200 == liste2.get(0));
        assertTrue(201 == liste2.get(1));
        assertTrue(20 == liste2.get(2));
        assertTrue(21 == liste2.get(3));
        assertTrue(4 == liste2.getSize());
        liste2.insert(202,2);
        assertTrue(5 == liste2.getSize());
    }

    @Test (expected = IllegalArgumentException.class)
    public void insertNullExceptionTest() throws Exception {
        liste0.insert(null,0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void insertNegativePositionExceptionTest() throws Exception {
        liste0.insert(-111,-1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void insertAtPositionGreaterThanSizeTest() throws Exception {
        liste0.insert(2,1);
    }

    @Test
    public void deleteTest() throws Exception {
        liste1.delete(0);
        assertEquals(0, liste1.getSize());
        assertNull(liste1.getHead());
        assertNull(liste1.getTail());
        liste2.delete(0);
        assertEquals(1, liste2.getSize());
        assertTrue(21 == liste2.get(0));
        assertEquals(21, liste2.getHead().getData());
        assertEquals(21, liste2.getTail().getData());
    }

    @Test (expected = IllegalArgumentException.class)
    public void deleteNegativePositionTest() throws Exception {
        liste1.delete(-1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void deletePositionGreaterThanOrEqualSize() throws Exception {
        listeString3.delete(3);
    }

    @Test
    public void getTest() throws Exception {
        assertTrue(10 == liste1.get(0));
        assertTrue("Null" == listeString3.get(0));
        assertTrue("Zwei" == listeString3.get(2));
    }

    @Test (expected = IllegalArgumentException.class)
    public void getNegativePositionTest() throws Exception {
        liste1.get(-1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void getPositionGreaterThanOrEqualSize() throws Exception {
        liste1.get(1);
    }

    @Test
    public void clearTest() throws Exception {
        liste0.clear();
        assertTrue(0 == liste0.getSize());
        assertTrue(null == liste0.getHead());
        assertTrue(null == liste0.getTail());
        liste1.clear();
        assertTrue(0 == liste1.getSize());
        assertTrue(null == liste1.getHead());
        assertTrue(null == liste1.getTail());
        liste2.clear();
        assertTrue(0 == liste2.getSize());
        assertTrue(null == liste2.getHead());
        assertTrue(null == liste2.getTail());
        listeString2.clear();
        assertTrue(0 == listeString2.getSize());
        assertTrue(null == listeString2.getHead());
        assertTrue(null == listeString2.getTail());
        listeString3.clear();
        assertTrue(0 ==listeString3.getSize());
        assertTrue(null == listeString3.getHead());
        assertTrue(null == listeString3.getTail());

        assertTrue(0 == liste0.getSize()
                && 0 == liste1.getSize()
                && 0 == liste2.getSize()
                && 0 == listeString2.getSize()
                && 0 == listeString3.getSize());
    }

    @Test
    public void concatTest() throws Exception {
//        assertTrue(liste1.equals(liste0.concat(liste1)));
//        assertTrue(liste0.concat(liste1).equals(liste1));
        liste0.concat(liste1);
        assertTrue(1 == liste0.getSize());
        assertTrue(10 == liste0.get(0));
        assertTrue(1 == liste1.getSize());
        assertTrue(10 == liste1.get(0));
        assertTrue(liste0.equals(liste1));
        assertFalse(liste0.equals(liste2));
        listeString3.concat(listeString2);
        assertTrue(5 == listeString3.getSize());
        assertTrue("Null" == listeString3.get(0));
        assertTrue("Zwei" == listeString3.get(2));
        assertTrue("Zero" == listeString3.get(3));
        assertTrue("One" == listeString3.get(4));
        assertEquals("Null", listeString3.get(0));
    }

    @Test
    public void sublistTest() throws Exception {
        Liste2ChainImpl resultListe;
        resultListe = (Liste2ChainImpl) listeString10.sublist(0,2);
        assertTrue(listeString3.equals(resultListe));
//        listeString10.sublist(0,2);
//        assertTrue(listeString3.equals(listeString10.sublist(0,2)));
        assertTrue(3 == listeString10.sublist(0,2).getSize());
        assertTrue("Null" == listeString10.sublist(0,2).get(0));
        assertTrue("Eins" == listeString10.sublist(0,2).get(1));
        assertTrue("Zwei" == listeString10.sublist(0,2).get(2));
        assertTrue(1 == liste1.sublist(0,0).getSize());
    }

    @Test (expected = IllegalArgumentException.class)
    public void sublistEmptyListTest() throws Exception {
        liste0.sublist(0,0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void sublistStartPositionTooLowTest() throws Exception {
        liste1.sublist(-1,0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void sublistEndPositionTooGreatTest() throws Exception {
        liste2.sublist(1,2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void sublistEndPositionSmallerThanStartPosition() throws Exception {
        liste2.sublist(1,0);
    }

//    @Test
//    public void toStringTest() throws Exception {
//        assertEquals("10, ", liste1.toString());
//        assertEquals("20, 21, ", liste2.toString());
//        assertEquals("", liste0.toString());
//        assertEquals("Null, Eins, Zwei, ", listeString3.toString());
//    }

    @Test
    public void getSizeTest() throws Exception {
        assertEquals(0, liste0.getSize());
        assertEquals(1, liste1.getSize());
        assertEquals(2, liste2.getSize());
        assertEquals(3, listeString3.getSize());

    }

    @Test
    public void getArrayListeTest() throws Exception {
//        assertArrayEquals(internalArrayListe0, liste0.getArrayListe());
//        assertArrayEquals(internalArrayListe1, liste1.getArrayListe());
//        assertArrayEquals(internalArrayListe2, liste2.getArrayListe());
//        assertArrayEquals(internalArrayListeString2, listeString2.getArrayListe());
//        assertArrayEquals(internalArrayListeString3, listeString3.getArrayListe());
//        assertArrayEquals(internalArrayListeString10, listeString10.getArrayListe());
    }


    @Test
    public void equalsTest() {
        Liste2ChainImpl newListe0 = new Liste2ChainImpl();
        assertTrue(liste0.equals(newListe0));
        Liste2ChainImpl newListeString3 = new Liste2ChainImpl();
        newListeString3.insert("Null", 0);
        newListeString3.insert("Eins", 1);
        assertFalse(listeString3.equals(newListeString3));
        newListeString3.insert("Zwei", 2);
        assertTrue(listeString3.equals(newListeString3));
        Liste2ChainImpl newListeString3a = new Liste2ChainImpl();
        newListeString3a.insert("Zwei", 0);
        newListeString3a.insert("Eins",0);
        newListeString3a.insert("NUL",0);
        assertFalse(newListeString3a.equals(listeString3));
        Liste2ChainImpl newListeString3b = new Liste2ChainImpl();
        newListeString3b.insert("Zwai",0);
        newListeString3b.insert("Eins",0);
        newListeString3b.insert("Null",0);
        assertFalse(listeString3.equals(newListeString3b));
        Liste2ChainImpl newListeString3c = new Liste2ChainImpl();
        newListeString3c.insert("Zwei",0);
        newListeString3c.insert("Eins",0);
        newListeString3c.insert("Null",0);
        assertTrue(listeString3.equals(newListeString3c));
    }
}