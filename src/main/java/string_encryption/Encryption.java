package string_encryption;

public class Encryption {
    public static String Encrypt(String str) {
        StringBuilder X=new StringBuilder();
        for (int i=0;i<str.length();i++) {
            if (i == str.length() - 1) {
                int a = str.charAt(0);
                int b = str.charAt(str.length() - 1);
                char c = (char) (a + b);
                X.append(c);
            } else {
                int a = str.charAt(i);
                int b = str.charAt(i + 1);
                char c = (char) (b + a);
                X.append(c);
            }
        }
        if (str.length() %2==0){
            String m=String.valueOf(str.charAt(0));
            String n=String.valueOf(str.charAt(str.length() -1));
            String o=X.substring(0,str.length() -1);
            X=new StringBuilder(o + n + m);
        }
        return X.toString();
    }

    public static String Decrypt(String str) {
        StringBuilder out = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < str.length(); i+=2) {
            if (i == str.length()-1) sum += (int) str.charAt(i) - (int) str.charAt(0);
            else sum += (int) str.charAt(i) - (int) str.charAt(i+1);
        }
        char first = (char) ((sum + str.charAt(0))/2);
        for (int i = 0; i < str.length(); i++) {
            if (first != 0) out.append(first);
            first = (char) (str.charAt(i) - first);
        }
        return out.toString();
    }
}
