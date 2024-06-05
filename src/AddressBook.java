import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AddressBook {
    private List<AddressEntry> entries;

    public AddressBook() {
        entries = new ArrayList<>();
    }

    public void addAddress(AddressEntry entry) {
        if (!entryExists(entry)) {
            entries.add(entry);
            Collections.sort(entries, Comparator.comparing(AddressEntry::getApellido));
            System.out.println("Contacto agregado: " + entry);
        } else {
            System.out.println("El contacto ya existe: " + entry);
        }
    }

    public void removeAddress(AddressEntry entry) {
        if (entries.remove(entry)) {
            System.out.println("Contacto eliminado: " + entry);
        } else {
            System.out.println("El contacto no existe: " + entry);
        }
    }

    public List<AddressEntry> findApellido(String apellido) {
        List<AddressEntry> result = new ArrayList<>();
        for (AddressEntry entry : entries) {
            if (entry.getApellido().toLowerCase().startsWith(apellido.toLowerCase())) {
                result.add(entry);
            }
        }
        return result;
    }

    public List<AddressEntry> getAllEntries() {
        return new ArrayList<>(entries);
    }

    public void loadFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(" ");
                if (data.length == 8) {
                    AddressEntry newEntry = new AddressEntry(
                            data[0], //Nombre
                            data[1], //Apellido
                            data[2], //Calle
                            data[3], //Ciudad
                            data[4], //Estado
                            data[5], //CodigoPostal
                            data[6], //Email
                            data[7]  //Telefonoadd
                    );
                    if (!entryExists(newEntry)) {
                        addAddress(newEntry);
                    } else {
                        System.out.println("El contacto " + newEntry + " ya existe y no se agregara nuevamente.");
                    }
                } else {
                    System.out.println("Linea mal formada: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private boolean entryExists(AddressEntry newEntry) {
        for (AddressEntry entry : entries) {
            if (entry.equals(newEntry)) {
                return true;
            }
        }
        return false;
    }
}
