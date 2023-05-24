package MenuDeLibreria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Libreria {
    private List<Libro> libros;

    public Libreria() {
        libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void mostrarMenu() {
        int opcion;

        do {
            System.out.println("==== MENÚ DE LA BIBLIOTECA ====");
            System.out.println("1. Registrar libro");
            System.out.println("2. Prestar libro");
            System.out.println("3. Buscar libro");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = obtenerOpcionUsuario();

            switch (opcion) {
                case 1:
                    registrarLibro();
                    break;
                case 2:
                    prestarLibro();
                    break;
                case 3:
                    buscarLibro();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione nuevamente.");
                    break;
            }
        } while (opcion != 5);
    }

    private int obtenerOpcionUsuario() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private void registrarLibro() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el autor del libro: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese la editorial del libro: ");
        String editorial = scanner.nextLine();
        System.out.print("Ingrese el año del libro: ");
        int año = scanner.nextInt();

        Libro libro = new Libro(titulo, autor, editorial, año);
        agregarLibro(libro);
        System.out.println("Libro registrado correctamente.");
    }
    

    private void prestarLibro() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados en la biblioteca.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Lista de libros disponibles:");

        for (int i = 0; i < libros.size(); i++) {
            Libro libro = libros.get(i);
            System.out.println((i + 1) + ". " + libro.getTitulo() + " - " + libro.getAutor());
        }
    }
        private void buscarLibro() {
            if (libros.isEmpty()) {
                System.out.println("No hay libros registrados en la biblioteca.");
                return;
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el título o autor del libro a buscar: ");
            String busqueda = scanner.nextLine();

            List<Libro> resultados = new ArrayList<>();

            for (Libro libro : libros) {
                if (libro.getTitulo().equalsIgnoreCase(busqueda) || libro.getAutor().equalsIgnoreCase(busqueda)) {
                    resultados.add(libro);
                }
            }

            if (resultados.isEmpty()) {
                System.out.println("No se encontraron resultados para la búsqueda.");
            } else {
                System.out.println("Resultados de la búsqueda:");
                for (Libro libro : resultados) {
                    System.out.println("- " + libro.getTitulo() + " - " + libro.getAutor() + " - " + libro.getAño() + " - " + libro.getEditorial()+ " - ");
               }
          }
     }
}