package haivo.us.crypto.mechanoid.net;

public interface JsonEntityReaderProvider {
    <T, R extends JsonEntityReader<T>> R get(Class<T> cls);
}
