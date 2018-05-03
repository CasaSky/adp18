public class Main {

    public static void main(String[] args) {
        Liste2ChainImpl<Integer> liste0 = new Liste2ChainImpl<>();
        liste0.insert(10,0);
        System.out.println(liste0.get(0));
        liste0.insert(100,0);
        System.out.println(liste0.get(0));
        System.out.println(liste0.get(1));
//        System.out.println(liste0.get(2));
        System.out.println("-------------------------------------");
        Liste2ChainImpl<Integer> liste1 = new Liste2ChainImpl<>();
//        liste1.insert()

    }
}
