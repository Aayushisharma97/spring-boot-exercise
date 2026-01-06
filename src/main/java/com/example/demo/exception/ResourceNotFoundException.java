package com.example.demo.exception;

/**
 * Exception thrown when a requested resource (e.g., User, Order) is not found.
 *
 * <p>
 * This is a runtime exception, so it does not require explicit catching.
 * Typically handled globally via a {@link org.springframework.web.bind.annotation.ControllerAdvice}.
 * </p>
 */
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Constructs a new ResourceNotFoundException with a custom message.
     *
     * @param message the detail message explaining which resource was not found
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructs a new ResourceNotFoundException with a message and a cause.
     *
     * @param message the detail message explaining which resource was not found
     * @param cause   the underlying cause of the exception
     */
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
