public class IPToCode {
    public static void main(String args[]) {
       //String[] possibleHolder = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String totalistic = convertUp( 	5782034831345L,11);
        System.out.print(totalistic);
        /*int slatt = 69;
        slatt /= 69;
        System.out.print(slatt);*/
    }

    public static long convertDown(String numberToConvert,int currentBase) {
        String[] possibleHolder = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String[] seperateDigits = numberToConvert.split("");
        long totalValueInTen = 0;
        for (int x = seperateDigits.length - 1; x >= 0; x--) {
            double timeThis = Math.pow(currentBase, seperateDigits.length - 1 - x);
            long decimalValue = 0;
            for (int y = 0; y < possibleHolder.length; y++) {
                if (seperateDigits[x].equals(possibleHolder[y])) {
                    decimalValue = y;
                }
            }
            double tempvalue = decimalValue * timeThis;
            totalValueInTen += tempvalue;
        }
        return totalValueInTen;
    }

    private static String convertUp(long numberToConvert,int finalBase) {
        String[] possibleHolder = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String finalThing = "";
        boolean keepRunning = true;
        int whichDigit = 15;
        while (keepRunning) {
            long mulitplyBy = (long) Math.pow(finalBase, whichDigit);
            long numOfThem = numberToConvert / mulitplyBy;
            finalThing += possibleHolder[(int) numOfThem];
            if (numberToConvert >= mulitplyBy) {
                numberToConvert = numberToConvert- numOfThem*mulitplyBy;
            }
            whichDigit--;
            if (whichDigit < 0 || numberToConvert < 1) {
                keepRunning = false;
            }
        }
        finalThing = finalThing.replaceFirst("^0+(?!$)", "");
        return finalThing;
    }
}
