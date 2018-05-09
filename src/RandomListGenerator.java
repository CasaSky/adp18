import java.util.Random;

public class RandomListGenerator {
    private static int[] randomNumbersArray;

    public RandomListGenerator(){
    }

    public static ListeInterface generateRandomList(int listSize, int numbersFromInclusive, int numbersUpToExclusive, int insertAt, int listType){
        Random random1 = new Random();
        randomNumbersArray = random1.ints(listSize, numbersFromInclusive, numbersUpToExclusive).toArray();
        ListeInterface resultList;

        switch (listType) {
            case 0:  resultList = new ListeImpl(40000);
                    break;
            case 1:  resultList = new Liste2ChainImpl();
                    break;
            default: throw new IllegalArgumentException("Please insert correct value for \"listType\", 0 for ListeImpl, 1 for Liste2ChainImpl");
        }

//        for (int elem : randomNumbersArray){
//        for(int i=0; i<randomNumbersArray.length; i++){
            switch (insertAt) {
                case 0: for (int elem : randomNumbersArray){
                            resultList.insert(elem,0);
                }
                        break;
                case 1: for (int elem : randomNumbersArray){
                            resultList.insert(elem, computeRandomPosition(resultList));
                }
                        break;
                case 2: for (int elem : randomNumbersArray){
                            resultList.insert(elem, resultList.getSize());
                }
                        break;
                default: throw new IllegalArgumentException("Please insert correct value for \"insertAt\", 0 for insertion at beginning of list, 1 for insertion at random position, 2 for insertion at end of list ");
//                        break;
            }
//        }
        return resultList;
    }

    private static int computeRandomPosition(ListeInterface list) {
        Random random2 = new Random();
        int randomPosition = random2.ints(1,0,list.getSize()+1).findFirst().getAsInt();
        return randomPosition;
    }

    public int[] getRandomNumbersArray(){
        return randomNumbersArray;
    }

    public int getSizeOfRandomNumbersArray(){
        return randomNumbersArray.length;
    }


}
