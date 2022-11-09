package logica;

public class WPS {
    private  String pincode = "";

    public WPS(){
        for (int i = 0 ; i < 7; i++){
            this.pincode += (int) (Math.random() * 10);
        }

        addLastNumber();
    }

    public WPS(String pincodeInput){
        setPincode(pincodeInput);
    }

    public  WPS(WPS copy){
        this.pincode = copy.pincode;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincodeInput) {
        controleerPincode(pincodeInput);
        this.pincode = pincodeInput;
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

    private boolean codeChecker(String pincode){
        int laatsteCijfer = lastNumberGenerator(pincode);
        if (laatsteCijfer == Integer.parseInt(pincode.substring((pincode.length()-1)))){
            return true;
        }
        return false;
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

    @Override
    public String toString() {
        return pincode;
    }
    @Override
    public boolean equals(Object controle){


        boolean state = false;
        WPS controleObject = (WPS) controle;

        if(this.pincode.equals(controleObject.pincode)){
            state = true;
        }
        return state;
    }
    private void addLastNumber(){
        String pin = pincode;
        int addLast = lastNumberGenerator(pin);
        pincode += addLast;
    }

    private int lastNumberGenerator(String pincode){
        int lengte = 7;
        int oneven = 0;
        int even = 0;
        int lastNumber = 0;
        for (int i = 0; i < lengte; i+= 2){
            oneven += Character.getNumericValue(pincode.charAt(i));
        }
        for (int i = 1; i < lengte; i+= 2){
            even += Character.getNumericValue(pincode.charAt(i));
        }

        int multiplyOneven = (oneven * 3);
        int addEven = (even + multiplyOneven) % 10;

        if (addEven != 0){
            lastNumber = 10 - addEven;
        }

        return lastNumber;

    }
}