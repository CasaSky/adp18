import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by michelbrueger on 11.05.18.
 */
public class PerformanceTesterTest {
    ListeInterface singleListeImplTest1;
    ListeInterface singleListeImplTest2;
    ListeInterface singleListeImplTest3;
    ListeInterface singleListe2ChainTest1;
    ListeInterface singleListe2ChainTest2;
    ListeInterface singleListe2ChainTest3;
    ListeInterface completeListeImplTest;
    ListeInterface completeListe2ChainTest;
    ListeInterface completeTest;

    @Before
    public void setUp() throws Exception {
        singleListeImplTest1 = PerformanceTester.testPerformanceOfList(1000,0,10,0,0);
        singleListeImplTest2 = PerformanceTester.testPerformanceOfList(1000,0,10,1,0);
        singleListeImplTest3 = PerformanceTester.testPerformanceOfList(1000,0,10,2,0);
        singleListe2ChainTest1 = PerformanceTester.testPerformanceOfList(1000,0,10,0,1);
        singleListe2ChainTest2 = PerformanceTester.testPerformanceOfList(1000,0,10,1,1);
        singleListe2ChainTest3 = PerformanceTester.testPerformanceOfList(1000,0,10,2,1);
        completeListeImplTest = PerformanceTester.testPerformanceOfAllInsertionPositions(1000,0,10,0);
        completeListe2ChainTest = PerformanceTester.testPerformanceOfAllInsertionPositions(1000, 0, 10, 1);
        completeTest = PerformanceTester.completePerformanceTest(1000,0,10);
    }

    @Test
    public void testPerformanceOfList() throws Exception {
        assertEquals(10, singleListeImplTest1.getSize());
        assertEquals(10, singleListeImplTest2.getSize());
        assertEquals(10, singleListeImplTest2.getSize());
        assertEquals(10, singleListe2ChainTest1.getSize());
        assertEquals(10, singleListe2ChainTest2.getSize());
        assertEquals(10, singleListe2ChainTest3.getSize());

    }

    @Test
    public void testPerformanceOfAllInsertionPositions() throws Exception {
        assertEquals(3, completeListeImplTest.getSize());
//        assertEquals(10, completeListeImplTest.get(0));  // Wieso gehtn das nicht?
        ListeInterface completeListeImplTest0 = (ListeInterface) completeListeImplTest.get(0);
        ListeInterface completeListeImplTest1 = (ListeInterface) completeListeImplTest.get(1);
        ListeInterface completeListeImplTest2 = (ListeInterface) completeListeImplTest.get(2);
        assertEquals(10, completeListeImplTest0.getSize());
        assertEquals(10, completeListeImplTest1.getSize());
        assertEquals(10, completeListeImplTest2.getSize());
        assertTrue(completeListeImplTest.get(0) == completeListeImplTest0);
        assertTrue(completeListeImplTest.get(1) == completeListeImplTest1);
        assertTrue(completeListeImplTest.get(2) == completeListeImplTest2);

        assertEquals(3, completeListe2ChainTest.getSize());
        ListeInterface completeListe2ChainTest0 = (ListeInterface) completeListe2ChainTest.get(0);
        ListeInterface completeListe2ChainTest1 = (ListeInterface) completeListe2ChainTest.get(1);
        ListeInterface completeListe2ChainTest2 = (ListeInterface) completeListe2ChainTest.get(2);
        assertEquals(10, completeListe2ChainTest0.getSize());
        assertEquals(10, completeListe2ChainTest1.getSize());
        assertEquals(10, completeListe2ChainTest2.getSize());
        assertTrue(completeListe2ChainTest.get(0) == completeListe2ChainTest0);
        assertTrue(completeListe2ChainTest.get(1) == completeListe2ChainTest1);
        assertTrue(completeListe2ChainTest.get(2) == completeListe2ChainTest2);
    }

    @Test
    public void completePerformanceTest() throws Exception {
        assertEquals(2, completeTest.getSize());
        ListeInterface completeTest0 = (ListeInterface) completeTest.get(0);
        ListeInterface completeTest1 = (ListeInterface) completeTest.get(1);
        assertEquals(3, completeTest0.getSize());
        assertEquals(3,completeTest1.getSize());
        assertEquals(completeTest.get(0), completeTest0);
        assertEquals(completeTest.get(1), completeTest1);
        ListeInterface completeTest00 = (ListeInterface) completeTest0.get(0);
        ListeInterface completeTest01 = (ListeInterface) completeTest0.get(1);
        ListeInterface completeTest02 = (ListeInterface) completeTest0.get(2);
        assertEquals(10, completeTest00.getSize());
        assertEquals(10, completeTest01.getSize());
        assertEquals(10, completeTest02.getSize());
        assertEquals(completeTest0.get(0), completeTest00);
        assertEquals(completeTest0.get(1), completeTest01);
        assertEquals(completeTest0.get(2), completeTest02);

    }

}
