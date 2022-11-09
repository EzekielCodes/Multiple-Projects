package data;
import data.connectie;
import logica.Connectie;
import logica.ENUM.Kleur;
import logica.Spellen;
import logica.Steden;
import logica.Rollen;
import java.awt.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import  logica.*;
public class test {


    public static void main(String[] args) throws SQLException {
        connectie dataLayer = new connectie("pandemie", false);
        List<Steden> stedenList = dataLayer.selectSteden();
//        List<Rollen> rollenList = dataLayer.selectRollen();
//        List<Spellen> spellenList = dataLayer.selectSpellen();
//        List<Connectie> connectieList = dataLayer.getConnectie();
          //dataLayer.insertSpeler(7, Kleur.valueOf("BLAUW"),"Medic","Ezekiel");
       //LocalDateTime start = LocalDateTime.of(2021, Month.MAY,25,21,30,05).withNano(0);
//        ArrayList<String> stad = new ArrayList();
//       stad =  dataLayer.selectStad(stad);
        stedenList.get(1).setZiekteStenen(1);

        stedenList.get(1).setZiekteStenen(-1);

//        int id = dataLayer.selectId();
//        ArrayList<String> names = new ArrayList<>();
//        dataLayer.selectNamen(names,id);
//       String rol =  dataLayer.selectRol(id,names.get(0));
//        System.out.println(names);
//        System.out.println(rol);
       // List<stadOne> stadOneList = dataLayer.selectStadOne();
        //System.out.println(stadOneList);
//        List<Stad> staList = dataLayer.selectStad("Milaan");
//        System.out.println(staList.get(0).getX());
//        System.out.println(staList.get(0).getY());
//        dataLayer.selectSteden();
//        System.out.println(dataLayer.selectSteden());
//        System.out.println(dataLayer.getSteden());


//        for (int x  = 0  ; x< stadOneList.size() ; x++){
//            System.out.println(stadOneList.get(x).getX() +  " "  +  stadOneList.get(x).getY()) ;
//
//        }

//        ArrayList<Integer> list = new ArrayList<>();
//        ArrayList<String> naam = new ArrayList<>();
//        list = dataLayer.selectListConnnected(1);
//        System.out.println(list);
//        for (int x = 0; x < list.size(); x++){
//
//            int t = list.get(x);
//           // System.out.println(t);
//            String n = dataLayer.selectNaamStad(list.get(x));
//            System.out.println(n);
//
//        }
//        System.out.println(naam);


     //   LocalDateTime start = LocalDateTime.now().withNano(0);
  //      dataLayer.insertSpellen(start);
//        //2021-05-25 20:24:37;
//
//
//        System.out.println(LocalDateTime.now().withNano(0));
//        String test = String.valueOf(start).replace("T"," ");
//        String control = String.valueOf(start);
//
 //       System.out.println(start);
//        System.out.println(test);
    //    int id  = dataLayer.spellenID(start);
//        System.out.println(control);
   //     System.out.println(id);
//        List<stadOne> stadOneList = dataLayer.selectStadOne();
//        List<stadTwo> stadTwoList = dataLayer.selectStadTwo();
//
 //      dataLayer.insertSpeler(id, Kleur.valueOf("BLAUW"),"Medic","test22");
//
//        for (Steden s : stedenList) {
//            System.out.println("\t" + s.getName() + " " + s.getX() + " " + s.getY() + " " + s.getColor());
//        }
//        for (Rollen s : rollenList) {
//            System.out.println("\t" + s.getId() + " " + s.getNaam() + " " + s.getBeschrijving());
//        }
//
//        for (Connectie s : connectieList) {
//            System.out.println("\t" + s.getStadOne() + " " + s.getStadTwo());
//        }
//        for (int x = 0; x < stadOneList.size(); x++) {
//            System.out.println(stadOneList.get(x).getX() + " " + stadOneList.get(x).getY() + " "+ stadTwoList.get(x).getX() + " " + stadTwoList.get(x).getY());
//
//        }

//        String list = "Ezekiel;Akindele;Broer";
//        String copie = list;
//        String namen[];
//        Scanner input = new Scanner(list);
//        Scanner reach = new Scanner(copie);
//        input.useDelimiter(";");
//        reach.useDelimiter(";");
//        int teller = 0;
//        while (input.hasNext()){
//            System.out.println("ben");
//            input.next();
//            teller++;
//
//        }
//        input.close();
//        namen = new String[teller];
//
//        for (int i = 0; i < namen.length;i++){
//            namen[i] = reach.next();
//        }
//
//        for (int i = 0; i < 1;i++){
//            System.out.println(namen[i]);
//
//            if (5 ==5){
//                System.out.println("here");
//                System.out.println(namen[i]);
//                i = i +1;
//            }
//            else if (6 == 3){
//                i = i + 1;
//                System.out.println(namen[i]);
//            }
//            else if ( 7 == 7){
//                System.out.println("bye");
//
//                System.out.println(namen[i]);
//            }
//        }




    }
}