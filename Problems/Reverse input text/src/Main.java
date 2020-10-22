import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here
        char[] ret = new char[50];
        int charsRead = reader.read(ret, 0, 50);

        if (charsRead != -1) {
            for (int i = ret.length - 1; i >= 0; i--)
                if (ret[i] != '\u0000') System.out.print(ret[i]);
        }

        reader.close();
    }
}