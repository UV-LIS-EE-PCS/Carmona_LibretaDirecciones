/**
 * La clase principal que inicia la aplicación de la libreta de direcciones.
 */
public class AddressBookApplication {
    /**
     * El punto de entrada principal para la aplicación.
     * 
     * @param args Los argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        // Crea una nueva instancia de AddressBook.
        AddressBook addressBook = new AddressBook();
        
        // Crea una nueva instancia de Menu, pasando la libreta de direcciones.
        Menu menu = new Menu(addressBook);
        
        // Muestra el menú para la interacción del usuario.
        menu.displayMenu();
    }
}
