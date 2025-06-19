import java.util.Arrays;
import java.util.List;

public class EncodeDecode {

    private static final List<Character> characterMap = Arrays.asList(
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
            'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '(', ')', '*', '+', ',', '-', '.', '/'
    );

    private static final int size = characterMap.size();

    public static String encodeMessage(String input, String offsetInput) {
        if (offsetInput.length() != 1) {
            throw new IllegalArgumentException();
        }
        char offsetChar = offsetInput.charAt(0); // Gets the first character 'H'
        int offset = characterMap.indexOf(offsetChar);
        if (offset == -1) {
            throw new IllegalArgumentException();
        }
        StringBuilder encoded = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (characterMap.contains(c)) {
                int originalIndex = characterMap.indexOf(c);
                int newIndex = (originalIndex - offset + size) % size;
                encoded.append(characterMap.get(newIndex));
            } else {
                encoded.append(c);
            }
        }
        return offsetChar + encoded.toString();
    }

    public static String decodeMessage(String input) {
        char offsetChar = input.charAt(0);
        int offset = characterMap.indexOf(offsetChar);
        if (offset == -1) {
            throw new IllegalArgumentException();
        }
        StringBuilder decoded = new StringBuilder();
        for (int i = 1; i < input.length(); i++) {  // Start from index 1
            char c = input.charAt(i);
            if (characterMap.contains(c)) {
                int originalIndex = characterMap.indexOf(c);
                int newIndex = (originalIndex + offset) % size;
                decoded.append(characterMap.get(newIndex));
            } else {
                decoded.append(c);
            }
        }
        return decoded.toString();
    }
}
