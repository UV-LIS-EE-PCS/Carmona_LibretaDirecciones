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
            System.out.println("Elige una opción del menu");
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
                    //Falta implementar lo de cargar archivo pronto lo hare 00:20 27 de mayo
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
                    System.out.println("Opcion no valida. ");
            }
        }
    }
    private void addEntry() {
        System.out.println("Agregando una nueva entrada: ");
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

        System.out.println("La entrada se ha agregado correctamente.");
    }
    private void removeEntry() {
        System.out.println("Eliminando una nueva entrada: ");
        System.out.println("Ingrese el apellido del contacto a eliminar: ");
        String apellido = scanner.nextLine().trim();

        List<AddressEntry> entriesToRemove = addressBook.findApellido(apellido);
        if(entriesToRemove.isEmpty()) {
            System.out.println("No se encontró el apellido.");
        }
        else {
            System.out.println("El siguiente contacto fue encontrado: ");
            for(AddressEntry entry : entriesToRemove) {
                System.out.println(entry);
            }
        }

        System.out.println("Ingrese 'y' para eliminar o 'n' para regresar al menú");
        String confirmacion = scanner.nextLine().trim().toLowerCase();
        if(confirmacion.equals("y")) {
            for(AddressEntry entry : entriesToRemove) {
                addressBook.removeAddress(entry);
            }
            System.out.println("Se eliminaron correctamente todas las entradas.");
        }
        else {
            System.out.println("Regresando al menú.");
            displayMenu();
        }
    }
    private void findEntry() {

    }
    private void showEntry() {
        for (AddressEntry entry : addressBook.getAllEntries()) {
            System.out.println(entry);
        }
    }
}