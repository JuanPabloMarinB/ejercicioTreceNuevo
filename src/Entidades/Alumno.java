package Entidades;

import java.util.ArrayList;
import java.util.function.IntFunction;
import java.util.stream.Stream;

public class Alumno extends ArrayList<Alumno> {

    private String nombre;

    public Alumno() {
    }

    public Alumno(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre(String next) {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return super.toArray(generator);
    }

    @Override
    public Stream<Alumno> stream() {
        return super.stream();
    }

    @Override
    public Stream<Alumno> parallelStream() {
        return super.parallelStream();
    }

}
