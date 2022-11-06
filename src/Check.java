import java.util.Arrays;

class Check {
    String[] array = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    int index;

    int checkIt(String string) {
        index = Arrays.binarySearch(array, string);
        return index;
    }

}
