package logica;

import java.util.Objects;

public class Bankrekening {
    private String nummer = "";
    private double saldo;
    private String houder = "";

    public Bankrekening(String naamHouder,String inputNummer){
        if (naamHouder.isEmpty()){
            throw new IllegalArgumentException("Geef de naam van de houder in");
        }
        if (inputNummer.isEmpty()){
            throw new IllegalArgumentException("Geef een rekening nummer in ");
        }
        this.houder = naamHouder;
        this.nummer = inputNummer;

    }

    public Bankrekening(String naamHouder, String inputNummer, double inputSaldo){
        if(inputSaldo < 0){
            throw new IllegalArgumentException("Saldo kan niet kleine zijn dan 0");
        }
        if (naamHouder.isEmpty()){
            throw new IllegalArgumentException("Geef de naam van de houder in");
        }
        if (inputNummer.isEmpty()){
            throw new IllegalArgumentException("Geef een rekening nummer in ");
        }
        this.houder = naamHouder;
        this.nummer = inputNummer;
        this.saldo = inputSaldo;

    }

    public String getHouder() {
        return houder;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if(saldo < 0){
            throw new IllegalArgumentException("Saldo kan niet kleine zijn dan 0");
        }
        this.saldo = saldo;
    }

    public void setHouder(String houder) {
        if (houder.isEmpty()){
            throw new IllegalArgumentException("Geef de naam van de houder in");
        }
        this.houder = houder;
    }

    public String getNummer() {
        return controleRekening(this.nummer);
    }

    public void setNummer(String nummer) {
        if (nummer.isEmpty()){
            throw new IllegalArgumentException("Geef een rekening nummer in ");
        }
        this.nummer = nummer;
    }

    public boolean haalBedragAf(double bedragAfhalen){

        if(bedragAfhalen > this.saldo){
            return false;
        }
        if (bedragAfhalen < 0){
           throw new IllegalArgumentException("Je kan geen negatief getal afhalen");
        }

        double balance = this.saldo - bedragAfhalen;
        this.saldo = balance;


        return true;
    }
    public void stortBedrag(double bedragStorten){
        if (bedragStorten < 0){
            throw new IllegalArgumentException("Je kan Geen negatief bedrag storten");
        }

        double balance = this.saldo + bedragStorten;
        this.saldo = balance;
    }

    @Override
    public String toString() {
        return "Bankrekening{" +
                "nummer='" + controleRekening(nummer) + '\'' +
                ", saldo=" + this.saldo +
                ", houder='" + this.houder + '\'' +
                '}';
    }


    //    @Override
//    public boolean equals(Object randomObject) {
//        Bankrekening s = (Bankrekening) randomObject;
//        if (randomObject instanceof Bankrekening){
//            if (this.nummer.equals(s.getNummer())){
//
//                return false;
//            }
//
//        }
//
//        return true;
//    }


    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bankrekening that = (Bankrekening) o;
        if (this.nummer.equals(that.getNummer())){
            return  false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nummer);
    }

    public String controleRekening(String inputRekening){
        String correct = "";
        if(inputRekening.contains("IBAN")){
            String spatie = inputRekening.replaceAll("\\s+","");
            correct = spatie.substring(4,spatie.length());
        }
        else if(inputRekening.contains("BE")){
            String spatie = inputRekening.replaceAll("\\s+","");
            correct = spatie;
        }



        return correct;
    }


}
