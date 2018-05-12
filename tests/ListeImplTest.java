import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by michelbrueger on 25.04.18.
 */
public class ListeImplTest {
    ListeImpl<Integer> liste0;
    ListeImpl<Integer> liste1;
    ListeImpl<Integer> liste2;
    ListeImpl<Integer> liste3;
    ListeImpl<String> listeString2;
    ListeImpl<String> listeString3;
    ListeImpl<String> listeString10;
    Integer[] internalArrayListe0;
    Integer[] internalArrayListe1;
    Integer[] internalArrayListe2;
    String[] internalArrayListeString2;
    String[] internalArrayListeString3;
    String[] internalArrayListeString10;
    @Before
    public void setUp() throws Exception {
        liste0 = new ListeImpl<>(10);
//        liste1 = new ListeImpl(11);
        liste1 = new ListeImpl<>();
        liste1.insert(10,0);
        liste2 = new ListeImpl<>(12);
        liste2.insert(20,0);
        liste2.insert(21,1);
        listeString2 = new ListeImpl<>(2);
        listeString2.insert("Zero",0);
        listeString2.insert("One",1);
        listeString3 = new ListeImpl<>(21);
        listeString3.insert("Null", 0);
        listeString3.insert("Eins", 1);
        listeString3.insert("Zwei", 2);
        listeString10 = new ListeImpl<>(10);
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
        internalArrayListe0 = new Integer[10];
        internalArrayListe1 = new Integer[4];
        internalArrayListe1[0] = 10;
        internalArrayListe2 = new Integer[12];
        internalArrayListe2[0] = 20;
        internalArrayListe2[1] = 21;
        internalArrayListeString2 = new String[2];
        internalArrayListeString2[0] = "Zero";
        internalArrayListeString2[1] = "One";
        internalArrayListeString3 = new String[21];
        internalArrayListeString3[0] = "Null";
        internalArrayListeString3[1] = "Eins";
        internalArrayListeString3[2] = "Zwei";
        internalArrayListeString10 = new String[10];
        internalArrayListeString10[0] = "Null";
        internalArrayListeString10[1] = "Eins";
        internalArrayListeString10[2] = "Zwei";
        internalArrayListeString10[3] = "Drei";
        internalArrayListeString10[4] = "Vier";
        internalArrayListeString10[5] = "Fuenf";
        internalArrayListeString10[6] = "Sechs";
        internalArrayListeString10[7] = "Sieben";
        internalArrayListeString10[8] = "Acht";
        internalArrayListeString10[9] = "Neun";
        liste3 = new ListeImpl<>();
        for(int i=0; i<3333; i++){
            liste3.insert(i,i);
        }
    }

//    @Test
//    public void sizeTest() throws Exception {
//
//    }

    @Test
    public void insertTest() throws Exception {
        assertTrue(0 == liste0.getSize());
        assertTrue(1 == liste1.getSize());
        assertTrue(2 == liste2.getSize());
        assertTrue(3 == listeString3.getSize());
        assertTrue(10 == liste1.get(0));
        assertTrue(20 == liste2.get(0));
        assertTrue(21 == liste2.get(1));
        assertTrue("Null" == listeString3.get(0));
        assertTrue("Eins" == listeString3.get(1));
        assertTrue("Zwei" == listeString3.get(2));
        liste0.insert(10,0);
        liste0.insert(11,0);
        liste0.insert(12,0);
        liste0.insert(13,1);
        assertTrue(4 == liste0.getSize());
        assertTrue(12 == liste0.get(0));
        assertTrue(13 == liste0.get(1));
        assertTrue(11 == liste0.get(2));
        assertTrue(10 == liste0.get(3));
        listeString3.insert("Null2", 0);
        listeString3.insert("Eins2", 1);
        listeString3.insert("Zwei2",2);
        assertTrue(6 == listeString3.getSize());
        assertTrue("Null2" == listeString3.get(0));
        assertTrue("Eins2" == listeString3.get(1));
        assertTrue("Zwei2" == listeString3.get(2));
        assertTrue("Null" == listeString3.get(3));
        assertTrue("Eins" == listeString3.get(4));
        assertTrue("Zwei" == listeString3.get(5));
        listeString3.insert("Sechs",6);
        assertTrue("Sechs" == listeString3.get(6));
        assertTrue(3333 == liste3.getSize());
//        assertEquals(12800, liste3.getMaxSize());
    }

    @Test
    public void maxSizeIncreaseTest() throws Exception {
        ListeImpl<Integer> liste4 = new ListeImpl<>();
        assertEquals(2, liste4.getMaxSize());
        liste4.insert(0,0);
        assertEquals(1,liste4.getSize());
        assertEquals(4, liste4.getMaxSize());
        liste4.insert(1,1);
        assertEquals(8, liste4.getMaxSize());
        liste4.insert(2,2);
        assertEquals(8, liste4.getMaxSize());
        liste4.insert(3,3);
        assertEquals(16, liste4.getMaxSize());
        liste4.insert(4,4);
        assertEquals(16,liste4.getMaxSize());
        ListeImpl<Integer> liste5 = new ListeImpl<>();
        for(int i=0; i<40; i++){
            liste5.insert(i,i);
        }
        assertEquals(128, liste5.getMaxSize());
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
        liste0.insert(null,1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void insertNegativePositionExceptionTest() throws Exception {
        liste0.insert(-111,-1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void insertAtPositionGreaterThanSizeTest() throws Exception {
        liste0.insert(2,2);
    }

    @Test
    public void deleteTest() throws Exception {
        liste1.delete(0);
        assertEquals(0, liste1.getSize());
        liste2.delete(0);
        assertEquals(1, liste2.getSize());
        assertTrue(21 == liste2.get(0));
        for(int i=0; i<3000; i++){
            liste3.delete(3332-i);
        }
        assertTrue(333 == liste3.getSize());
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
        liste1.clear();
        liste2.clear();
        listeString2.clear();
        listeString3.clear();
        assertTrue(0 == liste0.getSize()
                && 0 == liste1.getSize()
                && 0 == liste2.getSize()
                && 0 == listeString2.getSize()
                && 0 == listeString3.getSize());
    }

    @Test
    public void concatTest() throws Exception {
        liste1.concat(liste0);
        assertTrue(1 == liste1.getSize());
        assertTrue(0 == liste0.getSize());
        assertTrue(10 == liste1.get(0));
        liste0.concat(liste1);
        assertTrue(1 == liste0.getSize());
        assertTrue(10 == liste0.get(0));
        assertTrue(1 == liste1.getSize());
        assertTrue(10 == liste1.get(0));
//        assertEquals(10, liste0.get(0));
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
        listeString10.sublist(0,2);
        assertTrue(listeString3.equals(listeString10.sublist(0,2)));
//        assertEquals(listeString3, listeString10.sublist(0,2));
    }

    @Test
    public void toStringTest() throws Exception {
        assertEquals("10, ", liste1.toString());
        assertEquals("20, 21, ", liste2.toString());
        assertEquals("", liste0.toString());
        assertEquals("Null, Eins, Zwei, ", listeString3.toString());
    }

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
        assertArrayEquals(internalArrayListe1, liste1.getArrayListe());
//        assertArrayEquals(internalArrayListe2, liste2.getArrayListe());
//        assertArrayEquals(internalArrayListeString2, listeString2.getArrayListe());
//        assertArrayEquals(internalArrayListeString3, listeString3.getArrayListe());
//        assertArrayEquals(internalArrayListeString10, listeString10.getArrayListe());
    }

    @Test
    public void equalsTest() {
        ListeImpl newListe0 = new ListeImpl(5);
        assertTrue(liste0.equals(newListe0));
        ListeImpl newListeString3 = new ListeImpl(222);
        newListeString3.insert("Null",0);
        newListeString3.insert("Eins", 1);
        newListeString3.insert("Zwei", 2);
        assertTrue(listeString3.equals(newListeString3));
        assertFalse(liste0.equals(newListeString3));
    }
}