import java.util.List;
import java.util.Scanner;

/**
 * Clase que representa el menú interactivo para la libreta de direcciones.
 */
public class Menu {
    private AddressBook addressBook;
    private Scanner scanner;

    /**
     * Constructor para la clase Menu.
     * @param addressBook La libreta de direcciones.
     */
    public Menu(AddressBook addressBook) {
        this.addressBook = addressBook;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Muestra el menú principal y maneja la interacción con el usuario.
     */
    public void displayMenu() {
        while (true) {
            System.out.println("====================================");
            System.out.println("Elige una opcion del menu");
            System.out.println("a) Cargar de archivo");
            System.out.println("b) Agregar");
            System.out.println("c) Eliminar");
            System.out.println("d) Buscar");
            System.out.println("e) Mostrar");
            System.out.println("f) Salir");
            System.out.println("====================================");
            String opcion = scanner.nextLine().trim().toLowerCase();

            switch(opcion) {
                case "a":
                    loadFromFile();
                    break;
                case "b":
                    addEntry();
                    break;
                case "c":
                    removeEntry();
                    break;
                case "d":
                    findEntry();
                    break;
                case "e":
                    showEntry();
                    break;
                case "f":
                    scanner.close();
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }

    /**
     * Añade una nueva entrada a la libreta de direcciones.
     */
    private void addEntry() {
        System.out.println("Agregando un nuevo contacto: ");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine().trim();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine().trim();
        System.out.print("Calle: ");
        String calle = scanner.nextLine().trim();
        System.out.print("Ciudad: ");
        String ciudad = scanner.nextLine().trim();
        System.out.print("Estado: ");
        String estado = scanner.nextLine().trim();
        System.out.print("CP: ");
        String cp = scanner.nextLine().trim();
        System.out.print("Email: ");
        String email = scanner.nextLine().trim();
        System.out.print("Telefono: ");
        String telefono = scanner.nextLine().trim();

        AddressEntry newEntry = new AddressEntry(nombre, apellido, calle, ciudad, estado, cp, email, telefono);
        addressBook.addAddress(newEntry);

        System.out.println("El contacto se ha agregado correctamente.");
    }

    /**
     * Elimina una entrada de la libreta de direcciones.
     */
    private void removeEntry() {
        System.out.println("Eliminando un contacto:");
        System.out.print("Ingrese las primeras letras del apellido del contacto a eliminar: ");
        String apellidoInicio = scanner.nextLine().trim();

        List<AddressEntry> contactsToRemove = addressBook.findApellido(apellidoInicio);

        if (contactsToRemove.isEmpty()) {
            System.out.println("No se encontraron contactos con ese inicio de apellido.");
        } else {
            System.out.println("Contactos encontrados:");
            for (int i = 0; i < contactsToRemove.size(); i++) {
                System.out.println((i + 1) + ". " + contactsToRemove.get(i));
            }

            int seleccion = getValidIntegerInput("Ingrese el numero del contacto que desea eliminar o '0' para cancelar: ", 0, contactsToRemove.size());

            if (seleccion == 0) {
                System.out.println("Operacion de eliminacion cancelada.");
            } else {
                AddressEntry selectedContact = contactsToRemove.get(seleccion - 1);
                System.out.println("Esta seguro de que desea eliminar el siguiente contacto?");
                System.out.println(selectedContact);
                System.out.print("(Y/N): ");
                String confirmacion = scanner.nextLine().trim().toUpperCase();
                if (confirmacion.equals("Y")) {
                    addressBook.removeAddress(selectedContact);
                    System.out.println("Contacto eliminado correctamente.");
                } else {
                    System.out.println("Operacion de eliminacion cancelada.");
                }
            }
        }
        System.out.println("Regresando al menu principal.");
    }

    /**
     * Busca y muestra entradas por apellido.
     */
    private void findEntry() {
        System.out.println("Buscando un contacto por apellido:");
        System.out.print("Ingrese el apellido o sus primeras letras: ");
        String apellidoInicio = scanner.nextLine().trim();

        List<AddressEntry> contactsFound = addressBook.findApellido(apellidoInicio);

        if (contactsFound.isEmpty()) {
            System.out.println("No se encontraron contactos con ese apellido.");
        } else {
            System.out.println("Contactos encontrados:");
            for (AddressEntry entry : contactsFound) {
                System.out.println(entry);
            }
        }
    }

    /**
     * Muestra todas las entradas en la libreta de direcciones.
     */
    private void showEntry() {
        for (AddressEntry entry : addressBook.getAllEntries()) {
            System.out.println(entry);
        }
    }

    /**
     * Carga entradas desde un archivo.
     */
    private void loadFromFile() {
        System.out.print("Ingrese el nombre del archivo: ");
        String fileName = scanner.nextLine().trim();

        addressBook.loadFromFile(fileName);

        System.out.println("Carga de archivo completada.");
    }

    /**
     * Obtiene una entrada de entero válida del usuario.
     *
     * @param prompt El mensaje para el usuario.
     * @param min    El valor mínimo aceptable.
     * @param max    El valor máximo aceptable.
     * @return Un entero válido dentro del rango especificado.
     */
    private int getValidIntegerInput(String prompt, int min, int max) {
        int input = -1;
        while (true) {
            System.out.print(prompt);
            try {
                input = Integer.parseInt(scanner.nextLine().trim());
                if (input >= min && input <= max) {
                    break;
                } else {
                    System.out.println("Entrada fuera de rango. Por favor, ingrese un número entre " + min + " y " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
            }
        }
        return input;
    }
}
