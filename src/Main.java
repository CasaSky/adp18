public class Main {

    public static void main(String[] args) {
        Liste2ChainImpl<Integer> liste0 = new Liste2ChainImpl<>();
        liste0.insert(10,0);
        System.out.println(liste0.get(0));
        liste0.insert(100,0);
        System.out.println(liste0.get(0));
        System.out.println(liste0.get(1));
        liste0.insert(20,2);
        System.out.println("-------------------------------------");
        liste0.insert(200,0);
        System.out.println(liste0.get(0));
        liste0.insert(300,0);
        System.out.println(liste0.get(0));
        System.out.println(liste0.get(1));
        System.out.println(liste0.get(2));
        System.out.println(liste0.get(3));
        System.out.println(liste0.get(4));
//        System.out.println(liste0.get(2));
        System.out.println(liste0.get(5));
//        System.out.println(liste0.get(2));
        Liste2ChainImpl<Integer> liste1 = new Liste2ChainImpl<>();
//        liste1.insert()

    }
}
