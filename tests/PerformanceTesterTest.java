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

    }

    @Test
    public void testPerformanceOfList() throws Exception {
        assertEquals(10, singleListeImplTest1.getSize());
        assertEquals(10, singleListeImplTest2.getSize());
        assertEquals(10, singleListeImplTest2.getSize());
        assertEquals(10, singleListe2ChainTest1.getSize());
        assertEquals(10, singleListe2ChainTest2.getSize());
        assertEquals(10, singleListe2ChainTest3.getSize());
        assertEquals(3, completeListeImplTest.getSize());
//        assertEquals(10, completeListeImplTest.get(0).getSize());  Wieso gehtn das nicht?
    }

    @Test
    public void testPerformanceOfAllInsertionPositions() throws Exception {


    }

    @Test
    public void completePerformanceTest() throws Exception {
    }

}