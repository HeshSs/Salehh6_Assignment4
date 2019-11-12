/**
 * The BadCommandException class adds an Exception to Runtime Exceptions so it's available globally
 */
class BadCommandException extends RuntimeException {
    BadCommandException(String message) { super(message); }
}
