package stream.exception.handling;

// @FunctionalInterface it is not mandatory, since it only have one method java will consider this as functional interface
@FunctionalInterface
public interface CheckedExceptionHandlerConsumer<T, ExceptionObj extends Exception> {
    // i give the same name as consumer i could change the name since is my own function and i throw exception generated
    void accept(T value) throws ExceptionObj;
}
