import java.io.IOException;

public class Parser {

    protected boolean isEncode;

    public Parser() {
        this.isEncode = true;
    }

    public String checkCommand(String line) throws EncoderException, IOException {
        String[] input = line.split(" ",2);
        String firstWord = input[0];
        String message = "";
        if (input.length == 1) {
            checkSingleCommand(firstWord);
        } else {
            message = checkMultiCommand(input);
        }
        return message;
    }

    public boolean isMessageValid(String message) throws EncoderException {
        if (message.isEmpty()) {
            return false;
        } else return message.charAt(0) != ' ';
    }

    public void checkSingleCommand(String firstWord) throws EncoderException {
        if (firstWord.equals(Ui.EXIT)) {
            throw new ExitCodeException();
        } else {
            throw new EncoderException();
        }
    }

    public String checkMultiCommand(String[] input) throws EncoderException {
        String firstWord = input[0];
        String secondWord = input[1];
        if (!isMessageValid(secondWord)){
            throw new EncoderException();
        } else if (firstWord.equals(Ui.ENCODE)) {
            isEncode = true;
        } else if (firstWord.equals(Ui.DECODE)) {
            isEncode = false;
        } else {
            throw new EncoderException();
        }
        return secondWord;
    }
}
