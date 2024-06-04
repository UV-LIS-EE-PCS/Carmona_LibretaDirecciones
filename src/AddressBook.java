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
        entries.add(entry);
        Collections.sort(entries, Comparator.comparing(AddressEntry::getApellido));
    }

    public void removeAddress(AddressEntry entry) {
        entries.remove(entry);
    }

    public List<AddressEntry> findApellido(String apellido) {
        List<AddressEntry> result = new ArrayList<>();
        for (AddressEntry entry : entries) {
            if (entry.getApellido().equals(apellido)) {
                result.add(entry);
            }
        }
        return result;
    }
    public List<AddressEntry> getAllEntries() {
        return new ArrayList<>(entries);
    }
}
