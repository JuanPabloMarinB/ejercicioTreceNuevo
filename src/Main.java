import Servicios.CursoServicios;

public class Main {
    public static void main(String[] args) {

        CursoServicios cs = new CursoServicios();
        cs.crearCurso();
        cs.calcularGananciaSemanal();

    }
}