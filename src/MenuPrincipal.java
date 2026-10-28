import java.util.Scanner;

public class MenuPrincipal {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        Agenda agenda = new Agenda();
        int opcion = 0;

        while (opcion != 10) {
            System.out.println("\n--- AGENDA DE CONTACTOS ---");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Listar contactos");
            System.out.println("5. Ver historial");
            System.out.println("6. Crear grupo");
            System.out.println("7. Agregar contacto a un grupo");
            System.out.println("8. Listar grupos");
            System.out.println("9. Ver contactos de un grupo");
            System.out.println("10. Salir");
            System.out.print("Seleccione una opcion: ");

            if (teclado.hasNextInt()) {
                opcion = teclado.nextInt();
                teclado.nextLine();
            } else {
                System.out.println("Ingrese un numero valido.");
                teclado.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = teclado.nextLine();

                    System.out.print("Telefono: ");
                    String telefono = teclado.nextLine();

                    System.out.print("Email: ");
                    String email = teclado.nextLine();

                    Contacto contacto = new Contacto(nombre, telefono, email);
                    agenda.agregarContacto(contacto);
                    break;

                case 2:
                    System.out.print("Nombre del contacto: ");
                    nombre = teclado.nextLine();

                    contacto = agenda.buscarContacto(nombre);

                    if (contacto != null) {
                        System.out.println(contacto);
                    } else {
                        System.out.println("El contacto no existe.");
                    }
                    break;

                case 3:
                    System.out.print("Nombre del contacto: ");
                    nombre = teclado.nextLine();

                    agenda.eliminarContacto(nombre);
                    break;

                case 4:
                    agenda.listarContactos();
                    break;

                case 5:
                    agenda.listarHistorial();
                    break;

                case 6:
                    System.out.print("Nombre del grupo: ");
                    String nombreGrupo = teclado.nextLine();

                    agenda.agregarGrupo(nombreGrupo);
                    break;

                case 7:
                    System.out.print("Nombre del contacto: ");
                    nombre = teclado.nextLine();

                    System.out.print("Nombre del grupo: ");
                    nombreGrupo = teclado.nextLine();

                    agenda.agregarContactoAGrupo(nombre, nombreGrupo);
                    break;

                case 8:
                    agenda.listarGrupos();
                    break;

                case 9:
                    System.out.print("Nombre del grupo: ");
                    nombreGrupo = teclado.nextLine();

                    agenda.mostrarContactosPorGrupo(nombreGrupo);
                    break;

                case 10:
                    System.out.println("Saliendo de la agenda...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }
        }

        teclado.close();
    }
}
