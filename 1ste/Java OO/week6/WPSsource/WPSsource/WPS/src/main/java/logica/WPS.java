package logica;

/**
 * @author Van de Voorde Siebe
 * @Version 24/03/2021
 */

public class WPS {
    private String pincode = "";

    public WPS(){
        for (int i = 0; i < 7; i++){
            this.pincode += (int)(Math.random() * 10);
        }
        voegLaatsteCijferToe();
    }

    public WPS (String pincode){
        setPincode(pincode);
    }

    public WPS(WPS wps){
        this.pincode = wps.pincode;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode){
        controleerPincode(pincode);
        this.pincode = pincode;
    }

    private void voegLaatsteCijferToe(){
        String code = pincode;
        int laatsteCijfer = laatsteCijferGen(code);
        pincode += laatsteCijfer;
    }

    private void controleerPincode(String pincode){
        if (pincode.length() != 8){
            throw new IllegalArgumentException("ongeldig aantal tekens");
        }
        if (!isNumber(pincode)){
            throw new NumberFormatException("ongeldige tekenreeks");
        }
        if (!codeChecker(pincode)) {
            throw new IllegalArgumentException("ongeldige code");
        }
    }

    private boolean isNumber(String pincode){
        try {
            Integer.parseInt(pincode);
        }
        catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    private boolean codeChecker(String pincode){
        int laatsteCijfer = laatsteCijferGen(pincode);
        if (laatsteCijfer == Integer.parseInt(pincode.substring((pincode.length()-1)))){
            return true;
        }
        return false;
    }

    private int laatsteCijferGen(String pincode){
        int BeginPinLengte = 7;
        int opgeteldOneven = 0;
        int opgeteldEven = 0;
        int laatsteCijfer = 0;
        for (int i = 0; i < (BeginPinLengte); i += 2){
            opgeteldOneven += Character.getNumericValue(pincode.charAt(i));
        }
        for (int i = 1; i < (BeginPinLengte); i += 2){
            opgeteldEven += Character.getNumericValue(pincode.charAt(i));
        }
        int vermenigvuldigdOneven = (opgeteldOneven * 3);
        int modulo = (vermenigvuldigdOneven + opgeteldEven) % 10;
        if (modulo != 0){
            laatsteCijfer = 10 - modulo;
        }
        return  laatsteCijfer;
    }

    @Override
    public String toString(){
        return pincode;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        WPS wps = (WPS)obj;
        if (this.pincode.equals(wps.pincode)){
            return true;
        }
        return false;
    }
}
