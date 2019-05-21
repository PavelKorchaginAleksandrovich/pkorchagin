package collect;



import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Password {
    int maxSize = 20;
    int minSize = 4;
    Character[] numbers = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
    Character[] specSymbols = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')'};

    public void checkPassword(String password) {

        char[] chars = password.toCharArray();
        Set<Character> setPassword = new HashSet<>();
        for (char c : chars) {
            setPassword.add(c);
        }

        setPassword.addAll(Arrays.asList());
        if (checkCase(password) && checkLength(password) && checkNumber(setPassword) && checkSpec(setPassword)) {
            System.out.println("правильный");
        } else {
            System.out.println("неправильный");
        }
    }
    boolean checkCase(String password) {
        String lowerCasePassword = password.toLowerCase();
        return !password.equals(lowerCasePassword);
    }

    boolean checkLength(String password) {
        char[] charArray = password.toCharArray();
        return charArray.length >= minSize && charArray.length <= maxSize;
    }

    boolean checkNumber(Set<Character> setPassword) {
        Set<Character> setNumbers = new HashSet();
        setNumbers.addAll(Arrays.asList(numbers));
        int oldSize = setPassword.size() + setNumbers.size();
        setNumbers.addAll(setPassword);
        int newSize = setNumbers.size();
        return !(oldSize == newSize);
    }

    boolean checkSpec(Set<Character> setPassword) {
        Set<Character> setSpac = new HashSet();
        setSpac.addAll(Arrays.asList(specSymbols));
        int oldSize = setPassword.size() + setSpac.size();
        setSpac.addAll(setPassword);
        int newSize = setSpac.size();
        return !(oldSize == newSize);
    }

}
