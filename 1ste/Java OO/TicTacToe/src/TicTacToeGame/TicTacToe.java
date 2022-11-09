package TicTacToeGame;

public class TicTacToe {
    String s = "";

    public boolean delenDrie(int x , int value){
        String output = "";
        int teller = 0;

        if(x % value == 0){
            teller++;
        }
        while(x > 0)
        {
            System.out.println(x);
            if(x % 10 == value)
                teller++;
                //return true;
            x= x / 10;
        }

        if(teller > 0) {
            for (int y = 0; y < teller; y++) {

                output += "Tic ";
                s += "Tic ";

            }
            System.out.println(output);
            return true;
        }
        System.out.println(output);
        return false;
    }

    public boolean delenVijf(int x, int value){
        String output = "";
        int teller = 0;
        if(x % value == 0){
            teller++;
        }
        while(x > 0)
        {
            System.out.println(x);
            if(x % 10 == value)
                teller++;
            //return true;
            x= x / 10;
        }
        if(teller > 0) {
            for (int y = 0; y < teller; y++) {
                output += "Tac ";
                s += "Tac ";

            }
            System.out.println(output);
            return true;
        }
        System.out.println(output);
        return false;
    }

    public boolean delenSeven(int x, int value){
        String output = "";
        int teller = 0;
        if(x % value == 0){
            teller++;
        }
        while(x > 0)
        {
            System.out.println(x);
            if(x % 10 == value)
                teller++;
            //return true;
            x= x / 10;
        }
        if(teller > 0) {
            for (int y = 0; y < teller; y++) {
                output += "Toe ";
                s += "Toe ";

            }
            System.out.println(output);
            return true;
        }
        System.out.println(output);
        return false;
    }



    public String replace(int getal){
        s = "";
        delenDrie(getal,3);
        delenVijf(getal,5);
        delenSeven(getal,7);
        return s;
    }

    public boolean deelbaar(int beginWaarde, int eindWaarde, int[]getal, String[]woord) {
        int waarde = beginWaarde;
        while (waarde < eindWaarde) {
            int tempWaarde=waarde;
            String output = " ";
            for (int i = 0; i < getal.length; i++) {
                if (waarde % getal[i] == 0) {
                    output += woord[i];
                }
            }
            while (tempWaarde > 0) {
                for (int i = 0; i < getal.length; i++) {
                    if (waarde % 10 == getal[i]) {
                        output += woord[i];
                    }
                }
                tempWaarde/= 10;
            }
            if(output==""){
                System.out.print(waarde +", ");
            } else {
                System.out.print(output +", ");
            }
            waarde++;
        }
        return true;
    }


}
