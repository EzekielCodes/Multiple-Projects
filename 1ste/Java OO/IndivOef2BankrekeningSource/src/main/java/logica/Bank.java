package logica;

import java.util.ArrayList;
import logica.Bankrekening;

public class Bank {
    private String naamBank = "";
    private ArrayList<Bankrekening> bankLijst = new ArrayList<>();

    public Bank(String inputBankName){
        this.naamBank = inputBankName;
    }

    public ArrayList<Bankrekening> getRekeningen() {
        return bankLijst;
    }

    public void voegBankrekeningToe(Bankrekening s) {

           for (int i = 0; i <bankLijst.size();i++){
               if (bankLijst.get(i).getNummer().equals(s.getNummer())){
                   throw new IllegalArgumentException("Bestaat al");
               }
           }

        bankLijst.add(s);



    }

    public  double geefTotaalSaldoVanHouder(String naamHouder){

        double saldo = 0;
        for(int i = 0; i < bankLijst.size(); i++){
                if (bankLijst.get(i).getHouder().equals(naamHouder)){
                    saldo += bankLijst.get(i).getSaldo();
                }
        }
        return saldo;

    }







}
