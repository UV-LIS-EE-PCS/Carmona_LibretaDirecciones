import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Una libreta de direcciones que almacena y gestiona contactos.
 */
public class AddressBook {
    private List<AddressEntry> entries;

    /**
     * Crea una nueva libreta de direcciones vacía.
     */
    public AddressBook() {
        entries = new ArrayList<>();
    }

    /**
     * Agrega un nuevo contacto a la libreta de direcciones.
     * @param entry El contacto a agregar.
     */
    public void addAddress(AddressEntry entry) {
        if (!entryExists(entry)) {
            entries.add(entry);
            Collections.sort(entries, Comparator.comparing(AddressEntry::getApellido));
            notify("Contacto agregado: " + entry);
        } else {
            notify("El contacto ya existe: " + entry);
        }
    }

    /**
     * Elimina un contacto de la libreta de direcciones.
     * @param entry El contacto a eliminar.
     */
    public void removeAddress(AddressEntry entry) {
        if (entries.remove(entry)) {
            notify("Contacto eliminado: " + entry);
        } else {
            notify("El contacto no existe: " + entry);
        }
    }

    /**
     * Busca contactos por apellido.
     * @param apellido El apellido o sus primeras letras.
     * @return Una lista de contactos que coinciden con el apellido dado.
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
     * Obtiene todos los contactos de la libreta de direcciones.
     * @return Una lista de todos los contactos.
     */
    public List<AddressEntry> getAllEntries() {
        return new ArrayList<>(entries);
    }

    /**
     * Carga contactos desde un archivo de texto.
     * @param fileName El nombre del archivo de texto.
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
                        notify("El contacto " + newEntry + " ya existe y no se agregará nuevamente.");
                    }
                } else {
                    notify("Línea mal formada: " + line);
                }
            }
        } catch (IOException e) {
            notify("Error al leer el archivo: " + e.getMessage());
        }
    }

    /**
     * Verifica si un contacto ya existe en la libreta de direcciones.
     * @param newEntry El contacto a verificar.
     * @return true si el contacto ya existe, false de lo contrario.
     */
    private boolean entryExists(AddressEntry newEntry) {
        return entries.stream().anyMatch(entry -> entry.equals(newEntry));
    }

    /**
     * Muestra un mensaje en la consola.
     * @param message El mensaje a mostrar.
     */
    private void notify(String message) {
        System.out.println(message);
    }
}
