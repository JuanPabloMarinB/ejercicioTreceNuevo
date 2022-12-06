package Servicios;

import Entidades.Alumno;
import Entidades.Curso;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class CursoServicios {

    DecimalFormat decimales = new DecimalFormat("###,###,###.##");

    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    Alumno a1 = new Alumno();
    Curso c1 = new Curso();
    ArrayList<Alumno> arregloAlumnos = new ArrayList<>();

    public void cargarAlumnos() {


        String continuar;
        boolean salir = false;

        do {
            System.out.println("Ingresa el nombre del alumno ");
            a1.getNombre(sc.next());
            arregloAlumnos.add(a1);
            System.out.println("¿Deseas continuar añadiendo alumnos? S/N");
            continuar = sc.next();
            while (!continuar.equalsIgnoreCase("s") && !continuar.equalsIgnoreCase("n")) {
                System.out.println("Respuesta incorrecta");
                System.out.println("¿Deseas continuar añadiendo alumnos? S/N");
                continuar = sc.next();
            }
            if (continuar.equalsIgnoreCase("n")) {
                salir = true;
            }
        } while (!salir);

        System.out.println("La cantidad de alumnos agregados es " + arregloAlumnos.size());

        for (int i = 0; i < arregloAlumnos.size(); i++) {
            c1.setAlumnos(arregloAlumnos);
        }


    }

    public Curso crearCurso() {


//        cargarAlumnos();


        for (int i = 0; i < arregloAlumnos.size(); i++) {
            c1.setAlumnos(arregloAlumnos);
        }

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

        double ganancia;

        if (c1.getAlumnos() == null) {
            ganancia = 0;
            System.out.println("Al no haber alumnos añadidos, el total de ganancias es $" + ganancia);
        } else {
            ganancia = c1.getCantidadHorasPorDia() * c1.getPrecioPorHora()
                    * c1.getAlumnos().size() * c1.getCantidadDiasPorSemana();
            System.out.println("El total de ganancia por el curso "
                    + c1.getNombreCurso() + " es $" + decimales.format(ganancia));
        }

    }

    public void menu() {

        boolean salir = false;

        do {

            System.out.println("¿Qué deseas hacer?");
            System.out.println("1. Añadir alumnos");
            System.out.println("2. Añadir curso");
            System.out.println("3. Calcular las ganancias");
            System.out.println("4. Salir");

            int opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> cargarAlumnos();
                case 2 -> crearCurso();
                case 3 -> calcularGananciaSemanal();
                case 4 -> salir = true;
                default -> System.out.println("Opción incorrecta");
            }

        } while (!salir);

        System.out.println("Nos vemos pronto");


    }

}
