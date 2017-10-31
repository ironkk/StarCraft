package herenciap01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import modelo.Escuadron;
import modelo.Protoss;
import modelo.Terran;
import modelo.Zerg;

public class Main {

    static List<Escuadron> misEscuadrones;

    public static void main(String[] args) throws IOException {
        misEscuadrones = new ArrayList<>();
        inicio();

    }

    public static void inicio() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = null;
        do {
            try {
                String linea = br.readLine();
                parts = linea.split(" ");
                if (parts[0].equalsIgnoreCase("a")) {
                    altaEscuadrones(parts);
                } else if (parts[0].equalsIgnoreCase("r")) {
                    registrarBatalla(parts);

                } else if (parts[0].equalsIgnoreCase("m")) {
                    mejorarEscuadron(parts);

                } else if (parts[0].equalsIgnoreCase("c")) {
                    mostrarClasificacion();

                } else if (parts[0].equalsIgnoreCase("s")) {
                    System.exit(0);
                } else {
                    System.out.println("< ERROR 003: Letra incorrecta > ");
                }
            } catch (IOException ex) {

            }

        } while (!parts[0].equalsIgnoreCase("s"));

    }

    public static void altaEscuadrones(String parts[]) {
        if (parts.length != 7) {
            System.out.println("< ERROR 001: Nº de argumentos inválido > ");

        } else {
            int nivelAtaque,nivelDefensa,habilidadUno,habilidadDos;
            String nombre = parts[2];
            int victoria = 0;
            if (isNumeric(parts[3]) && isNumeric(parts[4]) && isNumeric(parts[5]) && isNumeric(parts[6])) {
                nivelAtaque = Integer.parseInt(parts[3]);
                nivelDefensa = Integer.parseInt(parts[4]);
                habilidadUno = Integer.parseInt(parts[5]);
                habilidadDos = Integer.parseInt(parts[6]);

                if (parts[1].equalsIgnoreCase("terran")) {
                    Terran t = new Terran(habilidadUno, habilidadDos, nombre, victoria, nivelAtaque, nivelDefensa);
                    misEscuadrones.add(t);
                    System.out.println("< OK: Escuadrón registrado >");
                } else if (parts[1].equalsIgnoreCase("zerg")) {
                    Zerg z = new Zerg(habilidadUno, habilidadDos, nombre, victoria, nivelAtaque, nivelDefensa);
                    misEscuadrones.add(z);
                    System.out.println("< OK: Escuadrón registrado >");
                } else if (parts[1].equalsIgnoreCase("protoss")) {
                    Protoss p = new Protoss(habilidadUno, nombre, victoria, nivelAtaque, nivelDefensa);
                    misEscuadrones.add(p);
                    System.out.println("< OK: Escuadrón registrado >");
                } else {
                    System.out.println("< ERROR 002: Especie incorrecta >");
                }

            } else {
                System.out.println("< ERROR 003: Dato incorrecto >");
            }
        }

    }

    private static void registrarBatalla(String[] parts) {
        if (parts.length != 3) {
            System.out.println("ERROR 001: Nº DE ARGUMENTOS INVÁLIDO");

        }
        String nombreEscuadron1 = parts[1];
        String nombreEscuadron2 = parts[2];
        Escuadron e1 = buscarEscuadron(nombreEscuadron1);
        Escuadron e2 = buscarEscuadron(nombreEscuadron1);
        int contadorj1 = 0;
        int contadorj2 = 0;
        int aleatorio = (int) (Math.random() * 9 + 0);
        int aleatorio2 = (int) (Math.random() * 9 + 0);
        if (e1 != null && e2 != null) {
            for (int asaltos = 5; asaltos != 0; asaltos--) {

                double j1 = aleatorio + e1.calcularAtaque() - e2.calcularDefensa();
                double j2 = aleatorio2 + e2.calcularAtaque() - e1.calcularDefensa();
                String gana = "";
                if (j1 > j2) {
                    gana = nombreEscuadron1;
                    contadorj1++;
                } else if (j1 == j2) {
                    System.out.println("<OK: La batalla ha acabado en empate>");
                } else {
                    gana = nombreEscuadron2;
                    contadorj2++;
                }
                System.out.println("<Inicio batalla...>");
                System.out.println("Asalto nº: " + asaltos);
                System.out.println(" ");
                System.out.println("Ataca: -" + nombreEscuadron1 +""+ "Nº Aleatorio: -" + aleatorio +" "+ "Valor de su ataque: " + j1);
                System.out.println("Ataca: -" + nombreEscuadron2 + "Nº Aleatorio: -" + aleatorio2 + "Valor de su ataque: " + j2);
                System.out.println(" ");
                System.out.println("Ganador del asalto: " + gana);

            }
            System.out.println("<Fin batalla...>");
            if (contadorj1 > contadorj2) {
                e1.setNumvictorias(e1.getNumvictorias() + 1);
                System.out.println("<OK: La batalla la ha ganado el escuadron" + nombreEscuadron1 + " " + "con" + " " + contadorj1 +" " + "asaltos>: ");
            } else if (contadorj2 > contadorj1) {
                e2.setNumvictorias(e2.getNumvictorias() + 1);
                System.out.println("<OK: La batalla la ha ganado el escuadron:" + " " + nombreEscuadron2 + " " + "con" + " " +contadorj2 +" " + "asaltos>: ");
            } else {
                System.out.println("<OK: La batalla ha acabado en empate>");
            }

        } else {
            System.out.println("< ERROR 005: No existe especie con ese nombre >");
        }
    }

    private static void mejorarEscuadron(String[] parts) {
        if (parts.length != 4) {
            System.out.println("< ERROR 001: Nº de argumentos inválido >");

        }if (isNumeric(parts[3])) {
        String nombreEscuadron = parts[1];
        String PropiedadAMejorar = parts[2];
        String Nuevo = parts[3];
        int NuevoDato = 0;
        NuevoDato = Integer.parseInt(Nuevo);
        if (NuevoDato < 1) {
            System.out.println("< ERROR 003: Dato incorrecto >");
        } else if (existeEscuadron(nombreEscuadron)) {

            Escuadron e = cogerEscuadron(nombreEscuadron);

            if (e instanceof Terran) {
                Terran t = (Terran) e;

                if (PropiedadAMejorar.equalsIgnoreCase("edificio")) {
                    t.setNumedificio(NuevoDato);
                    System.out.println("<OK: Propiedad mejorada>");

                } else if (PropiedadAMejorar.equalsIgnoreCase("tecnologia")) {
                    t.setTecnologia(NuevoDato);
                    System.out.println("<OK: Propiedad mejorada>");
                } else {
                    System.out.println("< ERROR 006: Propiedad incorrecta>");
                }
            }

            if (e instanceof Zerg) {
                Zerg z = (Zerg) e;

                if (PropiedadAMejorar.equalsIgnoreCase("esbirros")) {
                    z.setCantidadEsbirros(NuevoDato);
                    System.out.println("<OK: Propiedad mejorada >");

                } else if (PropiedadAMejorar.equalsIgnoreCase("overlords")) {
                    z.setOverlords(NuevoDato);
                    System.out.println("<OK: Propiedad mejorada >");

                } else {
                    System.out.println("< ERROR 006: Propiedad incorrecta >");
                }
            }

            if (e instanceof Protoss) {
                Protoss p = (Protoss) e;

                if (PropiedadAMejorar.equalsIgnoreCase("pilones")) {

                    p.setPilon(NuevoDato);
                    System.out.println("<OK: Propiedad mejorada>");

                } else {
                    System.out.println("< ERROR 006: Propiedad incorrecta >");
                }

            }

        } else {
            System.out.println("ERROR 005: No existe especie con ese nombre");
        }
    }else{
           System.out.println("< ERROR 003: Dato incorrecto >"); 
        }
    }

    public static boolean existeEscuadron(String nombre) {
        for (Escuadron e : misEscuadrones) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    public static Escuadron buscarEscuadron(String nombre) {
        for (Escuadron e : misEscuadrones) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                return e;
            }
        }
        return null;
    }

    public static Escuadron cogerEscuadron(String nombre) {
        for (Escuadron e : misEscuadrones) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                return e;
            }
        }
        return null;
    }

    private static void mostrarClasificacion() {

        List<Integer> victorias = new ArrayList<>();

        for (Escuadron e : misEscuadrones) {
            victorias.add(e.getNumvictorias());
        }
        if (victorias.size() < 1) {
            System.out.println("< ERROR 004: Operación incorrecta >");
        }
        Collections.sort(victorias);

        for (int i = victorias.size() - 1; i >= 0; i--) {
            for (int e = 0; e < misEscuadrones.size(); e++) {
                if (victorias.get(i) == misEscuadrones.get(e).getNumvictorias()) {
                    System.out.println(misEscuadrones.get(e).getNombre() + " - " + misEscuadrones.get(e).getNumvictorias());
                }
            }
        }
    }

    private static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
