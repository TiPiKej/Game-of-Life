import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Converter {
    public static char[] convert(String[] words) throws IOException {
        List<Character> tempArr = new ArrayList<>();

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                tempArr.add(ch);
            }
        }

        char[] ret = new char[tempArr.size()];
        for (int i = 0; i < tempArr.size(); i++) {
            ret[i] = tempArr.get(i);
        }

        return ret;
    }
}