import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private AddressBook addressBook;
    private Scanner scanner;

    public Menu(AddressBook addressBook) {
        this.addressBook = addressBook;
        this.scanner = new Scanner(System.in);
    }

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
            String opcion = scanner.nextLine();

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
                    return;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }

    private void addEntry() {
        System.out.println("Agregando un nuevo contacto: ");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Calle: ");
        String calle = scanner.nextLine();
        System.out.print("Ciudad: ");
        String ciudad = scanner.nextLine();
        System.out.print("Estado: ");
        String estado = scanner.nextLine();
        System.out.print("CP: ");
        String cp = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Telefono: ");
        String telefono = scanner.nextLine();

        AddressEntry newEntry = new AddressEntry(nombre, apellido, calle, ciudad, estado, cp, email, telefono);

        addressBook.addAddress(newEntry);

        System.out.println("El contacto se ha agregado correctamente.");
    }

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

            System.out.println("Ingrese el numero del contacto que desea eliminar o '0' para cancelar: ");
            int seleccion = scanner.nextInt();
            scanner.nextLine();

            if (seleccion >= 1 && seleccion <= contactsToRemove.size()) {
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
            } else if (seleccion == 0) {
                System.out.println("Operacion de eliminacion cancelada.");
            } else {
                System.out.println("Seleccion no valida. Por favor, ingrese un numero de contacto valido.");
            }
        }
        System.out.println("Regresando al menu principal.");
    }

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

    private void showEntry() {
        for (AddressEntry entry : addressBook.getAllEntries()) {
            System.out.println(entry);
        }
    }

    private void loadFromFile() {
        System.out.print("Ingrese el nombre del archivo: ");
        String fileName = scanner.nextLine().trim();

        addressBook.loadFromFile(fileName);

        System.out.println("Carga de archivo completada.");
    }
}
