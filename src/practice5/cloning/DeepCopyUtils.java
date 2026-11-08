package practice5.cloning;
import java.util.Date;
public final class DeepCopyUtils {
    private DeepCopyUtils() {
    }
    @SuppressWarnings("unchecked")
    public static <T> T copy(T value) {
        if (value == null || isImmutable(value.getClass())) {
            return value;
        }
        if (value instanceof DeepCopyable<?>) {
            return (T) ((DeepCopyable<?>) value).deepCopy();
        }
        if (value instanceof Date) {
            return (T) new Date(((Date) value).getTime());
        }
        if (value.getClass().isArray()) {
            return (T) copyArray(value);
        }
        throw new IllegalArgumentException(
                "Нельзя глубоко скопировать тип " + value.getClass().getName()
                + ". Реализуйте DeepCopyable<T> для этого класса.");
    }
    private static boolean isImmutable(Class<?> type) {
        return type == String.class
                || type == Boolean.class
                || type == Byte.class
                || type == Short.class
                || type == Integer.class
                || type == Long.class
                || type == Float.class
                || type == Double.class
                || type == Character.class
                || type.isEnum();
    }
    private static Object copyArray(Object source) {
        int length = java.lang.reflect.Array.getLength(source);
        Class<?> componentType = source.getClass().getComponentType();
        Object target = java.lang.reflect.Array.newInstance(componentType, length);
        for (int i = 0; i < length; i++) {
            Object item = java.lang.reflect.Array.get(source, i);
            Object copied = componentType.isPrimitive() ? item : copy(item);
            java.lang.reflect.Array.set(target, i, copied);
        }
        return target;
    }
}