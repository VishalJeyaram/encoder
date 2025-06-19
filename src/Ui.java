import java.util.Scanner;

public class Ui {
    protected Scanner in;

    public Ui() {
        this.in = new Scanner(System.in);
    }

    public String sendInput() {
        return in.nextLine();
    }

    public static final String ENCODE = "encode";

    public static final String DECODE = "decode";

    public static final String EXIT = "exit";

    public static final String USER_PROMPT_MESSAGE = """
            Please state if you want me to Encode or Decode a text by typing out either "encode" or "decode", \
            followed by a single space, and\s
            then the text itself IN CAPS! Alternatively, you may exit by typing "exit".
            """;

    public static final String USER_PROMPT_MESSAGE_OFFSET = """
            Please enter an offset character only from the values provided
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
            'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '(', ')', '*', '+', ',', '-', '.', '/'
            """;

    public static final String GREETINGS =  "Hello there! I am the Encoder!\n" + USER_PROMPT_MESSAGE;

    public static final String INCORRECT_INPUT = "That is not a valid input.\n" + USER_PROMPT_MESSAGE;

    public static final String INCORRECT_OFFSET_ENCODER = "Invalid offset character! We will restart.\n" + USER_PROMPT_MESSAGE;

    public static final String INCORRECT_OFFSET_DECODER = "Invalid message to decode! We will restart.\n" + USER_PROMPT_MESSAGE;

    public static final String EXIT_MESSAGE = "Thanks for using the Encoder!\n";

    public static final String USER_INPUT_ARGUMENTS = "Please enter: ";

    public static final String USER_INPUT_OFFSET = "Please enter your offset character: ";

    /** To prompt the user to key in a command */
    public static void greetUser() {
        System.out.println(GREETINGS);
    }

    public static void promptUserInput() {
        System.out.print(USER_INPUT_ARGUMENTS);
    }

    public static void printIncorrectInput() {
        System.out.println(INCORRECT_INPUT);
    }

    public static void printIncorrectOffset(boolean isEncode) {
        if (isEncode) {
            System.out.println(INCORRECT_OFFSET_ENCODER);
        } else {
            System.out.println(INCORRECT_OFFSET_DECODER);
        }
    }

    public static void printEndingMessage() {
        System.out.println(EXIT_MESSAGE);
    }

    public static void askForOffset() {
        System.out.println(USER_PROMPT_MESSAGE_OFFSET);
        System.out.print(USER_INPUT_OFFSET);
    }

    public static void printEncodedMessage(String originalMessage, String encodedMessage) {
        System.out.println("The encoded message for " + originalMessage + " is " + encodedMessage);
        System.out.println("Let's go again!");
        System.out.println(USER_PROMPT_MESSAGE);
    }

    public static void printDecodedMessage(String originalMessage, String encodedMessage) {
        System.out.println("The decoded message for " + originalMessage + " is " + encodedMessage);
        System.out.println("Let's go again!");
        System.out.println(USER_PROMPT_MESSAGE);
    }


}
