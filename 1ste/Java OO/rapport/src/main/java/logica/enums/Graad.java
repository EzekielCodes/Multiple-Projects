package logica.enums;

public enum Graad {
    NIET_GESLAAGD{
        @Override
        public String toString() {
            return "NIET GESLAAGD";
        }
    },
    VOLDOENING{
        @Override
        public String toString() {
            return "VOLDOENING";
        }
    },
    ONDERSCHEIDING{
        @Override
        public String toString() {
            return "ONDERSCHEIDING";
        }
    },
    GROTE_ONDERSCHEIDING{
        @Override
        public String toString() {
            return "GROTE ONDERSCHEIDING";
        }
    },
    GROOTSTE_ONDERSCHEIDING{
        @Override
        public String toString(){
            return "GROOTSTE ONDERSCHEIDING";
        }
    },

    ALLE{
        @Override
        public String toString(){
            return "ALLE";
        }
    }


}
