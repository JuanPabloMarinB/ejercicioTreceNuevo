package Servicios;

import Entidades.Curso;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CursoServicios {

    DecimalFormat decimales = new DecimalFormat("###,###,###.##");

    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    int i;
    String[] arregloAlumnos = new String[5];
    Curso c1 = new Curso();

    public void cargarAlumnos() {

        for (i = 0; i < arregloAlumnos.length; i++) {
            System.out.println("Ingresa el nombre del alumno n° " + (i + 1));
            arregloAlumnos[i] = sc.next();
        }

        c1.setAlumnos(arregloAlumnos);

    }

    public Curso crearCurso() {

        cargarAlumnos();

        System.out.println("Ingresa el nombre del curso");
        c1.setNombreCurso(sc.next());

        System.out.println("Ingresa la cantidad de horas por día");
        c1.setCantidadHorasPorDia(sc.nextInt());

        System.out.println("Ingresa la cantidad de días por semana");
        c1.setCantidadDiasPorSemana(sc.nextInt());

        System.out.println("Ingresa el turno (Mañana o tarde)");
        c1.setTurno(sc.next());

        while (!c1.getTurno().equalsIgnoreCase("mañana")
                && !c1.getTurno().equalsIgnoreCase("tarde")) {
            System.out.println("El turno que ingresaste es incorrecto");
            System.out.println("Ingresa el turno nuevamente");
            c1.setTurno(sc.next());
        }

        System.out.println("Ingresa el precio por hora");
        c1.setPrecioPorHora(sc.nextDouble());

        return c1;

    }

    public void calcularGananciaSemanal() {

        double ganancia = c1.getCantidadHorasPorDia() * c1.getPrecioPorHora()
                * c1.getAlumnos().length * c1.getCantidadDiasPorSemana();

        System.out.println("El total de ganancia por el curso "
                + c1.getNombreCurso() + " es $" + decimales.format(ganancia));

    }

}
