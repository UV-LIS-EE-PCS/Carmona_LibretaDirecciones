import junit.framework.TestCase;

/**
 * Clase de prueba para la clase AddressEntry.
 */
public class AddressEntryTest extends TestCase {

    /**
     * Prueba para verificar si se crea una entrada correctamente.
     */
    public void testAddressEntryCreation() {
        // Crear una entrada con valores válidos
        AddressEntry entry1 = new AddressEntry("John", "Doe", "123 Main St", "City", "State", "12345", "john@example.com", "123-456-7890");

        assertEquals("John", entry1.getNombre());
        assertEquals("Doe", entry1.getApellido());
        assertEquals("123 Main St", entry1.getCalle());
        assertEquals("City", entry1.getCiudad());
        assertEquals("State", entry1.getEstado());
        assertEquals("12345", entry1.getCodigoPostal());
        assertEquals("john@example.com", entry1.getEmail());
        assertEquals("123-456-7890", entry1.getTelefono());

        // Crear otra entrada con valores diferentes
        AddressEntry entry2 = new AddressEntry("Jane", "Smith", "456 Elm St", "City", "State", "54321", "jane@example.com", "987-654-3210");

        assertEquals("Jane", entry2.getNombre());
        assertEquals("Smith", entry2.getApellido());
        assertEquals("456 Elm St", entry2.getCalle());
        assertEquals("City", entry2.getCiudad());
        assertEquals("State", entry2.getEstado());
        assertEquals("54321", entry2.getCodigoPostal());
        assertEquals("jane@example.com", entry2.getEmail());
        assertEquals("987-654-3210", entry2.getTelefono());
    }

    /**
     * Prueba para verificar si se establecen correctamente los valores nulos o vacíos.
     */
    public void testSettersWithNullValues() {
        // Crear una entrada con valores válidos
        AddressEntry entry = new AddressEntry("John", "Doe", "123 Main St", "City", "State", "12345", "john@example.com", "123-456-7890");

        // Probar establecer el nombre a nulo
        entry.setNombre(null);
        assertNull(entry.getNombre());

        // Probar establecer el apellido a nulo
        entry.setApellido(null);
        assertNull(entry.getApellido());

        // Probar establecer la calle a nulo
        entry.setCalle(null);
        assertNull(entry.getCalle());

        // Probar establecer la ciudad a nulo
        entry.setCiudad(null);
        assertNull(entry.getCiudad());

        // Probar establecer el estado a nulo
        entry.setEstado(null);
        assertNull(entry.getEstado());

        // Probar establecer el código postal a nulo
        entry.setCodigoPostal(null);
        assertNull(entry.getCodigoPostal());

        // Probar establecer el email a nulo
        entry.setEmail(null);
        assertNull(entry.getEmail());

        // Probar establecer el teléfono a nulo
        entry.setTelefono(null);
        assertNull(entry.getTelefono());
    }

    /**
     * Prueba para verificar si se establecen correctamente los valores inválidos.
     */
    public void testSettersWithInvalidValues() {
        // Crear una entrada con valores válidos
        AddressEntry entry = new AddressEntry("John", "Doe", "123 Main St", "City", "State", "12345", "john@example.com", "123-456-7890");

        // Probar establecer el nombre a vacío
        entry.setNombre("");
        assertEquals("John", entry.getNombre());

        // Probar establecer el apellido a vacío
        entry.setApellido("");
        assertEquals("Doe", entry.getApellido());

        // Probar establecer el email a un formato inválido
        entry.setEmail("invalidemail.com");
        assertEquals("john@example.com", entry.getEmail());

        // Probar establecer el teléfono a un formato inválido
        entry.setTelefono("123-abc-456");
        assertEquals("123-456-7890", entry.getTelefono());
    }
}
