class CustomCheckedException extends Exception {
    public CustomCheckedException(String message) {
        super(message);
    }
}
class CustomUncheckedException extends RuntimeException {
    public CustomUncheckedException(String message) {
        super(message);
    }
}
class DataProcessor {
    public void processData(String data) throws CustomCheckedException {

        if (data == null) {
            throw new CustomCheckedException("Data cannot be null.");
        }
    }
}

public class CheckedAndUnchecked {
    public static void main(String[] args) {
        DataProcessor dataProcessor = new DataProcessor();
        String inputData = null;
        try {
            dataProcessor.processData(inputData);
        } catch (CustomCheckedException e) {
            System.err.println("Checked exception occurred: " + e.getMessage());
        } catch (CustomUncheckedException e) {
            System.err.println("Unchecked exception occurred: " + e.getMessage());
        }
    }
}
