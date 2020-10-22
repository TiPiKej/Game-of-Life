import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here

        char[] ret = new char[100];
        int charsRead = reader.read(ret, 0, 100);

        int count = 0;

        if (charsRead != -1) {
            for (int i = 0; i < ret.length; i++) {
                if (ret[i] == '\u0000') continue;

                if (ret[i] != 32 && ret[i] != 13 && ret[i] != 10 && count == 0) count++;

                if (i == 0) continue;
                if (ret[i] == ' ' && ret[i - 1] != ' ') count++;
            }
        }

        reader.close();
        System.out.println(count);
    }
}