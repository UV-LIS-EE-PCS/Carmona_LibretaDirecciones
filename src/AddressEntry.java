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
        if (nombre != null && !nombre.isEmpty()) {
            this.nombre = nombre;
        } else {
            System.out.println("Nombre inválido.");
        }
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if (apellido != null && !apellido.isEmpty()) {
            this.apellido = apellido;
        } else {
            System.out.println("Apellido inválido.");
        }
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        if (calle != null && !calle.isEmpty()) {
            this.calle = calle;
        } else {
            System.out.println("Calle inválida.");
        }
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        if (ciudad != null && !ciudad.isEmpty()) {
            this.ciudad = ciudad;
        } else {
            System.out.println("Ciudad inválida.");
        }
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        if (estado != null && !estado.isEmpty()) {
            this.estado = estado;
        } else {
            System.out.println("Estado inválido.");
        }
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        if (codigoPostal != null && !codigoPostal.isEmpty()) {
            this.codigoPostal = codigoPostal;
        } else {
            System.out.println("Código postal inválido.");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (isValidEmail(email)) {
            this.email = email;
        } else {
            System.out.println("Correo electrónico inválido.");
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (isValidPhoneNumber(telefono)) {
            this.telefono = telefono;
        } else {
            System.out.println("Número de teléfono inválido.");
        }
    }

    private boolean isValidEmail(String email) {
        return email != null && !email.isEmpty() && email.contains("@") && email.indexOf(".") > email.indexOf("@");
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber != null && !phoneNumber.isEmpty() && phoneNumber.matches("\\d+");
    }
}
