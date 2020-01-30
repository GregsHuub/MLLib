package functionalInterfaces;

@FunctionalInterface
public interface Checker<T> {

    boolean checkIsNull(T object);

}
