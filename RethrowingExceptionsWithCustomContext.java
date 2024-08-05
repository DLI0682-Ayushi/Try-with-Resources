class TransactionProcessingException extends Exception {
    public TransactionProcessingException(String message) {
        super(message);
    }

    public TransactionProcessingException(String message, RuntimeException e) {
        message = "oops..error!!!!";

    }
}

class TransactionProcessor {
    public void processTransaction(String transactionData) throws TransactionProcessingException {
        try {
            throw new RuntimeException("Database connection error");
        } catch (RuntimeException e) {
            throw new TransactionProcessingException("Error processing transaction: " + transactionData, e);
        }
    }
}

public class RethrowingExceptionsWithCustomContext {
    public static void main(String[] args) {
        TransactionProcessor transactionProcessor = new TransactionProcessor();
        String transactionData = "User: Alice, Amount: $100";

        try {
            transactionProcessor.processTransaction(transactionData);
        } catch (TransactionProcessingException e) {
            System.err.println("Transaction processing failed: " + e.getMessage());

        }
    }
}
