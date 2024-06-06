import junit.framework.TestCase;
import java.util.List;

/**
 * Clase de prueba para la clase AddressBook.
 */
public class AddressBookTest extends TestCase {
    private AddressBook addressBook;

    /**
     * Configura el estado inicial para cada prueba.
     */
    protected void setUp() {
        addressBook = new AddressBook();
    }

    /**
     * Prueba para verificar si se agrega una entrada correctamente.
     */
    public void testAddAddress() {
        // Prueba de agregar una entrada
        AddressEntry entry1 = new AddressEntry("John", "Doe", "123 Main St", "City", "State", "12345", "john@example.com", "123-456-7890");
        addressBook.addAddress(entry1);

        List<AddressEntry> entries = addressBook.getAllEntries();
        assertTrue(entries.contains(entry1));

        // Prueba de agregar otra entrada diferente
        AddressEntry entry2 = new AddressEntry("Jane", "Smith", "456 Elm St", "City", "State", "54321", "jane@example.com", "987-654-3210");
        addressBook.addAddress(entry2);

        entries = addressBook.getAllEntries();
        assertTrue(entries.contains(entry2));
    }

    /**
     * Prueba para verificar si se elimina una entrada correctamente.
     */
    public void testRemoveAddress() {
        // Agregar una entrada y luego eliminarla
        AddressEntry entry = new AddressEntry("Jane", "Smith", "456 Elm St", "City", "State", "54321", "jane@example.com", "987-654-3210");
        addressBook.addAddress(entry);

        addressBook.removeAddress(entry);
        List<AddressEntry> entries = addressBook.getAllEntries();
        assertFalse(entries.contains(entry));

        // Agregar otra entrada y eliminarla
        AddressEntry entry2 = new AddressEntry("John", "Doe", "123 Main St", "City", "State", "12345", "john@example.com", "123-456-7890");
        addressBook.addAddress(entry2);

        addressBook.removeAddress(entry2);
        entries = addressBook.getAllEntries();
        assertFalse(entries.contains(entry2));
    }

    /**
     * Prueba para verificar si se encuentran las entradas correctamente por apellido.
     */
    public void testFindApellido() {
        // Agregar varias entradas con apellidos similares
        AddressEntry entry1 = new AddressEntry("Alice", "Johnson", "789 Oak St", "City", "State", "67890", "alice@example.com", "567-890-1234");
        AddressEntry entry2 = new AddressEntry("Bob", "Johnson", "789 Oak St", "City", "State", "67890", "bob@example.com", "567-890-1234");
        AddressEntry entry3 = new AddressEntry("Charlie", "Smith", "789 Oak St", "City", "State", "67890", "charlie@example.com", "567-890-1234");

        addressBook.addAddress(entry1);
        addressBook.addAddress(entry2);
        addressBook.addAddress(entry3);

        // Buscar las entradas por apellido
        List<AddressEntry> foundEntries = addressBook.findApellido("Jo");
        assertEquals(2, foundEntries.size());

        // Agregar una entrada con apellido diferente y buscarla
        AddressEntry entry4 = new AddressEntry("David", "Lee", "789 Oak St", "City", "State", "67890", "david@example.com", "567-890-1234");
        addressBook.addAddress(entry4);

        foundEntries = addressBook.findApellido("Le");
        assertEquals(1, foundEntries.size());
    }
}
