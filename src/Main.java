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

//        String[] array = new String[5];
//        array[0]="Null";
//        array[1]="Eins";
//        for(String elem : array){
//            System.out.println(elem);
//        }
//        array[2].concat("ululuuu");
//        int[] array = new int[5];
//        array[0] = 10;
//        array[1] = 11;
//        for(int elem : array){
//            System.out.println(elem);
//        }
//        System.out.println(array[1] + 5); // fcksht
//        System.out.println(array[2] + 5);

//        ListeImpl liste = new ListeImpl(22);
//        liste.insert(10,0);
//        liste.insert(11,0);
//        liste.insert(12,1);
//        liste.insert(11,3);
//        System.out.println(liste);

        ListeInterface listeImpl = new ListeImpl();
        listeImpl.insert("Null", 0);
        System.out.println(listeImpl.getClass());




    }

}
