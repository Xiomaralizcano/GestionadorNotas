import java.util.Scanner;
public class GestinadorDeNotas {
    public static void main(String[] args) {
        final int NUM_ESTUDIANTES = 5;
        final int NUM_ASIGNATURAS = 3;
        final double LIMITE_APROBACION = 3.0;
        String[] nombres = new String[NUM_ESTUDIANTES];
        int[] identificaciones = new int[NUM_ESTUDIANTES];
        double[][] notas = new double[NUM_ESTUDIANTES][NUM_ASIGNATURAS];
        double[] promedios = new double[NUM_ESTUDIANTES];
        boolean[] aprobados = new boolean[NUM_ESTUDIANTES];
        String[]carrera = new String[NUM_ESTUDIANTES];
        int []semestre = new int[NUM_ESTUDIANTES];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            System.out.print("Ingrese el nombre del estudiante " + (i + 1) + ": ");
            nombres[i] = scanner.nextLine();
            System.out.println("Ingrese la carrera del estudiante");
            carrera[i] = scanner.nextLine();
            System.out.println("Que semestre cursa?");
            semestre[i] = scanner.nextInt();
            while (semestre[i] < 12 ) {
                System.out.println("El maximo de semestres es 12");
                semestre[i] = scanner.nextInt();
                break;
            }
            System.out.print("Ingrese el codigo del estudiante " + (i + 1) + ": ");
            identificaciones[i] = scanner.nextInt();
            int numero = identificaciones[i];
            int longitudCodigo = String.valueOf(numero).length();

            while (longitudCodigo != 6) {
                System.out.print("El codigo debe tener 6 caracteres (OBLIGATORIO). ");
                identificaciones[i] = scanner.nextInt();
                break;
                
            }

            for (int j = 0; j < NUM_ASIGNATURAS; j++) {
                System.out.print("Ingrese la nota de la asignatura " + (j + 1) + " para " + nombres[i] +" de la carrera " + carrera[i] + ": ");
                notas[i][j] = scanner.nextDouble();
                while (notas[i][j] < 0) {
                    System.out.print("Ingrese una nota valida ");
                    notas[i][j] = scanner.nextDouble();
                    
                }
                scanner.nextLine();
            }
        }

        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            double sumaNotas = 0;
            for (int j = 0; j < NUM_ASIGNATURAS; j++) {
                sumaNotas += notas[i][j];
            }
            promedios[i] = sumaNotas / NUM_ASIGNATURAS;
            aprobados[i] = promedios[i] >= LIMITE_APROBACION;
        }

        System.out.println("\nReporte final:");
        System.out.println("Estudiantes aprobados:");
        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            if (aprobados[i]) {
                System.out.println("Identificación: " + identificaciones[i] + ", Nombre: " + nombres[i] +", de la carrera: " +carrera[i] +" y semestre: " +semestre[i] + " (Promedio: " + promedios[i] + ")");
            }
        }
        System.out.println("Estudiantes reprobados:");
        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            if (!aprobados[i]) {
                System.out.println("Identificación: " + identificaciones[i] + ", Nombre: " + nombres[i] +", de la carrera:" +carrera[i]  +" y semestre: " +semestre[i] + " (Promedio: " + promedios[i] + ")");
            }
        }
        scanner.close();
    }
}