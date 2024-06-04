public class AddressEntry {
    private String nombre;
    private String apellido;
    private String calle;
    private String ciudad;
    private String estado;
    private String codigoPostal;
    private String email;
    private String telefono;

    public AddressEntry(String nombre, String apellido, String calle, String ciudad, String estado, String codigoPostal, String email, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.calle = calle;
        this.ciudad = ciudad;
        this.estado = estado;
        this.codigoPostal = codigoPostal;
        this.email = email;
        this.telefono = telefono;
    }
    @Override
    public String toString() {
        return nombre + " " + apellido + " " + calle + " " + ciudad + " " + estado + " " + codigoPostal + " " + email + " " + telefono;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getCalle() {
        return calle;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getCodigoPostal() {
        return codigoPostal;
    }
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
