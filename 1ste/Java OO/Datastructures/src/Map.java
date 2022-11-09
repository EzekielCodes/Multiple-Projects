import java.util.HashMap;

public class Map {
    public static void main(String[] args) {

        HashMap<String,Integer> hash = new HashMap<String , Integer>();
        hash.put("a",10);
        hash.put("b",20);
        hash.put("c",30);
        hash.get("a");


                //key  value
        HashMap<String,String> login = new HashMap<String , String>();
        login.put("Ezekiel","Azerty123");
        login.put("Akindele","Ezekiel123");
        login.put("Akin","Ezekiel123");
        login.put("skin","Ezekiel123");

//        for (java.util.Map.Entry<String, String> entry : login.entrySet()) {
//            if (entry.getValue().equals("Ezekiel123")) {
//                System.out.println(entry.getKey());
//            }
//        }
//
//       // login.remove("Ezekiel");
//        login.containsValue("Azerty123");


        System.out.println(login.values());
        //System.out.println(login.);
    }
}
