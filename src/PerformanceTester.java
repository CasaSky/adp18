/**
 * Created by michelbrueger on 11.05.18.
 */
public class PerformanceTester {

    public PerformanceTester(){

    }

//    public ListeInterface testListeImplInsertedAt0{
//        for(int k=0; k<2; k++){
//            for(int j=0; j<3; j++){
//                for (int i=0; i<10; i++){
//                    long startTime = System.currentTimeMillis();
//                    ListeInterface listeImplInsertedAt0 = RandomListGenerator.generateRandomList(40000,0,100000,j,0);
//                    long endTime = System.currentTimeMillis() - startTime;
//                }
//            }
//
//        }
//
//    }

    public static ListeInterface testPerformanceOfList(int listSize, int numbersFromInclusive, int numbersUpToExclusive, int insertAt, int listType){
        ListeInterface resultList = new Liste2ChainImpl();
        for(int i=0; i<10; i++){
            long startTime = System.currentTimeMillis();
            ListeInterface generatedList = RandomListGenerator.generateRandomList(listSize, numbersFromInclusive, numbersUpToExclusive, insertAt, listType);
            long endTime = System.currentTimeMillis()-startTime;
            resultList.insert(endTime,0);
        }
        return resultList;
    }

    public static ListeInterface testPerformanceOfAllInsertionPositions(int listSize, int numbersFromInclusive, int numbersUpToExclusive, int listType){
        ListeInterface resultList = new Liste2ChainImpl();
        for(int i=0; i<3; i++){
            ListeInterface tempResultList = testPerformanceOfList(listSize, numbersFromInclusive, numbersUpToExclusive, i, listType);
            resultList.insert(tempResultList,0);
        }
        return resultList;
    }

    public static ListeInterface completePerformanceTest(int listSize, int numbersFromInclusive, int numbersUpToExclusive){
        ListeInterface resultList = new Liste2ChainImpl();
        for(int i=0; i<2; i++){
            ListeInterface tempResultList = testPerformanceOfAllInsertionPositions(listSize,numbersFromInclusive, numbersUpToExclusive,i);
            resultList.insert(tempResultList,0);
        }
        return resultList;
    }

}
