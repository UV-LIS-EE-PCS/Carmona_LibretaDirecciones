import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Clase que representa una libreta de direcciones.
 */
public class AddressBook {
    private List<AddressEntry> entries;

    /**
     * Constructor para crear una nueva libreta de direcciones vacía.
     */
    public AddressBook() {
        entries = new ArrayList<>();
    }

    /**
     * Agrega una nueva entrada a la libreta de direcciones.
     * @param entry La entrada a agregar.
     */
    public void addAddress(AddressEntry entry) {
        if (!entryExists(entry)) {
            entries.add(entry);
            Collections.sort(entries, Comparator.comparing(AddressEntry::getApellido));
            System.out.println("Contacto agregado: " + entry);
        } else {
            System.out.println("El contacto ya existe: " + entry);
        }
    }

    /**
     * Elimina una entrada de la libreta de direcciones.
     * @param entry La entrada a eliminar.
     */
    public void removeAddress(AddressEntry entry) {
        if (entries.remove(entry)) {
            System.out.println("Contacto eliminado: " + entry);
        } else {
            System.out.println("El contacto no existe: " + entry);
        }
    }

    /**
     * Busca entradas en la libreta de direcciones por apellido.
     * @param apellido El apellido a buscar.
     * @return Una lista de entradas que coinciden con el apellido proporcionado.
     */
    public List<AddressEntry> findApellido(String apellido) {
        List<AddressEntry> result = new ArrayList<>();
        for (AddressEntry entry : entries) {
            if (entry.getApellido().toLowerCase().startsWith(apellido.toLowerCase())) {
                result.add(entry);
            }
        }
        return result;
    }

    /**
     * Obtiene todas las entradas de la libreta de direcciones.
     * @return Una lista de todas las entradas en la libreta de direcciones.
     */
    public List<AddressEntry> getAllEntries() {
        return new ArrayList<>(entries);
    }

    /**
     * Carga las entradas de un archivo en la libreta de direcciones.
     * @param fileName El nombre del archivo desde el cual cargar las entradas.
     */
    public void loadFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(" ");
                if (data.length == 8) {
                    AddressEntry newEntry = new AddressEntry(
                            data[0], // Nombre
                            data[1], // Apellido
                            data[2], // Calle
                            data[3], // Ciudad
                            data[4], // Estado
                            data[5], // CodigoPostal
                            data[6], // Email
                            data[7]  // Telefono
                    );
                    if (!entryExists(newEntry)) {
                        addAddress(newEntry);
                    } else {
                        System.out.println("El contacto " + newEntry + " ya existe y no se agregará nuevamente.");
                    }
                } else {
                    System.out.println("Línea mal formada: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    /**
     * Verifica si una entrada ya existe en la libreta de direcciones.
     * @param newEntry La nueva entrada a verificar.
     * @return true si la entrada ya existe, false en caso contrario.
     */
    private boolean entryExists(AddressEntry newEntry) {
        return entries.stream().anyMatch(entry -> entry.equals(newEntry));
    }
}
