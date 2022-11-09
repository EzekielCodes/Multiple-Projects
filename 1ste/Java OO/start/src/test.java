public class test {
    static int i = 0;

    public static void main(String[] args) {


        String word1 = "word";
        String word2 = "word";

        if(word1.substring(4) == null){
            System.out.println("Leeg");
        }
        else
            System.out.println("niet leeg");


        //equalWords("word","word");



    }
    public static  boolean equalWords(String word1, String word2) { //controlleer elk karakter van beide wooden
        //CharAt(n) == CharqAt(n) --> n++ --> =! return false, no character --> return true
        // word1.la

        char j = word1.charAt(i);
        char k = word2.charAt(i);


        if (j == ' ' && k == ' '){
            i = 0;
            return true;
        }
        else if(j == k){
            i++;
            System.out.println(i);
            if ((String.valueOf(word1.charAt(i + 1)) == null) || String.valueOf(word2.charAt(i + 1)) == null){
                i = 0;
            }
            equalWords(word1,word2);
            System.out.println(i);

            return true;
        }
        else

            return false;
    }
}

