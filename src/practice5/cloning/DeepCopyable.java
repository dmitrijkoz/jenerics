package practice5.cloning;

/** Контракт для объектов, умеющих создавать собственную глубокую копию. */
public interface DeepCopyable<T> {
    T deepCopy();
}
