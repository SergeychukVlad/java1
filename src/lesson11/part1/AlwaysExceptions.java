package lesson11.part1;

import java.io.IOException;

public class AlwaysExceptions implements AutoCloseable {
    int id;

    public AlwaysExceptions(int id) {
        this.id = id;
    }

    public void method() throws IOException {
        throw new IOException(this + ": исключение в method()");
    }

    @Override
    public void close() throws IOException {
        throw new IOException(this + ": исключение в close()");
    }

    @Override
    public String toString() {
        return "AlwaysExceptions (" + id + ")";
    }
}
