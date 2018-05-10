import java.util.Random;

public class Main {

    public static void main(String[] args) {
//        Liste2ChainImpl<Integer> liste0 = new Liste2ChainImpl<>();
//        liste0.insert(10,0);
//        System.out.println(liste0.get(0));
//        liste0.insert(100,0);
//        System.out.println(liste0.get(0));
//        System.out.println(liste0.get(1));
//        liste0.insert(20,2);
//        System.out.println("-------------------------------------");
//        liste0.insert(200,0);
//        System.out.println(liste0.get(0));
//        liste0.insert(300,0);
//        System.out.println(liste0.get(0));
//        System.out.println(liste0.get(1));
//        System.out.println(liste0.get(2));
//        System.out.println(liste0.get(3));
//        System.out.println(liste0.get(4));
//        System.out.println(liste0.get(2));
//        System.out.println(liste0.get(2));
//        Liste2ChainImpl<Integer> liste1 = new Liste2ChainImpl<>();
//        liste1.insert(10, 0);
//        System.out.println("---------------------------------------------");
//        System.out.println(liste0.getClass());
//        System.out.println("-----------------------------------------------");
//        liste0.concat(liste1);
//        System.out.println(liste0.getHead() + " liste0.getHead()");
//        System.out.println(liste1.getHead() + " liste1.getHead()");
//        System.out.println(liste1);
//        System.out.println(liste1.getSize());
//        System.out.println(liste0.getSize());
//        System.out.println(liste0.equals(liste1));
//        System.out.println(liste0.concat(liste1).equals(liste1));
//        System.out.println(liste0.concat(liste1));
//        System.out.println(liste1);
//        Random random = new Random();
//        int randomNumber = random.ints(1,0,2).findFirst().getAsInt();
//        System.out.println(randomNumber);

        RandomListGenerator rlg = new RandomListGenerator();

        ListeInterface testListe = rlg.generateRandomList(40000,0,40001,1,1);
        System.out.println(testListe);
        System.out.println(rlg.getRandomNumbersArray());
        System.out.println(rlg.getSizeOfRandomNumbersArray());
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println(rlg.getRandomNumbersArray()[0]);
        System.out.println(rlg.getRandomNumbersArray()[1]);
        System.out.println(rlg.getRandomNumbersArray()[2]);
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println(testListe.getSize() + " = liste.getSize()");
        for(int i=0; i<testListe.getSize(); i++){
            System.out.println(testListe.get(i));
        }
        System.out.println("Teständerung");
    }
}
