import java.io.IOException;

public class Encoder {

    private final Ui ui;
    private final Parser parser;

    public Encoder() {
        this.ui = new Ui();
        this.parser = new Parser();
    }
    public void checkMessage() {
        String line;
        Ui.greetUser();
        boolean isEncode = true;
        while (true) {
            try {
                Ui.promptUserInput();
                line = ui.sendInput();
                String message = parser.checkCommand(line);
                isEncode = parser.isEncode;
                if (isEncode) {
                    Ui.printEncodedMessage(message, encode(message));
                } else {
                    Ui.printDecodedMessage(message, decode(message));
                }
            } catch (IOException | EncoderException e) {
                Ui.printIncorrectInput();
            } catch (StringIndexOutOfBoundsException | IllegalArgumentException e) {
                Ui.printIncorrectOffset(isEncode);
            } catch (ExitCodeException e) {
                break;
            }
        }
        Ui.printEndingMessage();
    }

    public String encode(String plainText) {
        Ui.askForOffset();
        String line = ui.sendInput();
        return EncodeDecode.encodeMessage(plainText, line);
    }

    public String decode(String encodedText) {
        return EncodeDecode.decodeMessage(encodedText);
    }

    public static void main(String[] args) {
        new Encoder().checkMessage();
    }
}