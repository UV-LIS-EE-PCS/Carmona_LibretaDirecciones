/**
 * Clase que representa una entrada en la libreta de direcciones.
 */
public class AddressEntry {
    private String nombre;
    private String apellido;
    private String calle;
    private String ciudad;
    private String estado;
    private String codigoPostal;
    private String email;
    private String telefono;

    /**
     * Constructor para crear una nueva entrada de dirección.
     *
     * @param nombre       El nombre del contacto.
     * @param apellido     El apellido del contacto.
     * @param calle        La calle del contacto.
     * @param ciudad       La ciudad del contacto.
     * @param estado       El estado del contacto.
     * @param codigoPostal El código postal del contacto.
     * @param email        El correo electrónico del contacto.
     * @param telefono     El número de teléfono del contacto.
     */
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

    /**
     * Retorna una representación en cadena de la entrada de dirección.
     *
     * @return Una cadena que representa la entrada de dirección.
     */
    @Override
    public String toString() {
        return nombre + " " + apellido + " " + calle + " " + ciudad + " " + estado + " " + codigoPostal + " " + email + " " + telefono;
    }

    /**
     * Obtiene el nombre del contacto.
     *
     * @return El nombre del contacto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del contacto.
     *
     * @param nombre El nuevo nombre del contacto.
     */
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.isEmpty()) {
            this.nombre = nombre;
        } else {
            System.out.println("Nombre inválido.");
        }
    }

    /**
     * Obtiene el apellido del contacto.
     *
     * @return El apellido del contacto.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del contacto.
     *
     * @param apellido El nuevo apellido del contacto.
     */
    public void setApellido(String apellido) {
        if (apellido != null && !apellido.isEmpty()) {
            this.apellido = apellido;
        } else {
            System.out.println("Apellido inválido.");
        }
    }

    /**
     * Obtiene la calle del contacto.
     *
     * @return La calle del contacto.
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Establece la calle del contacto.
     *
     * @param calle La nueva calle del contacto.
     */
    public void setCalle(String calle) {
        if (calle != null && !calle.isEmpty()) {
            this.calle = calle;
        } else {
            System.out.println("Calle inválida.");
        }
    }

    /**
     * Obtiene la ciudad del contacto.
     *
     * @return La ciudad del contacto.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece la ciudad del contacto.
     *
     * @param ciudad La nueva ciudad del contacto.
     */
    public void setCiudad(String ciudad) {
        if (ciudad != null && !ciudad.isEmpty()) {
            this.ciudad = ciudad;
        } else {
            System.out.println("Ciudad inválida.");
        }
    }

    /**
     * Obtiene el estado del contacto.
     *
     * @return El estado del contacto.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado del contacto.
     *
     * @param estado El nuevo estado del contacto.
     */
    public void setEstado(String estado) {
        if (estado != null && !estado.isEmpty()) {
            this.estado = estado;
        } else {
            System.out.println("Estado inválido.");
        }
    }

    /**
     * Obtiene el código postal del contacto.
     *
     * @return El código postal del contacto.
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Establece el código postal del contacto.
     *
     * @param codigoPostal El nuevo código postal del contacto.
     */
    public void setCodigoPostal(String codigoPostal) {
        if (codigoPostal != null && !codigoPostal.isEmpty()) {
            this.codigoPostal = codigoPostal;
        } else {
            System.out.println("Código postal inválido.");
        }
    }

    /**
     * Obtiene el correo electrónico del contacto.
     *
     * @return El correo electrónico del contacto.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del contacto.
     *
     * @param email El nuevo correo electrónico del contacto.
     */
    public void setEmail(String email) {
        if (isValidEmail(email)) {
            this.email = email;
            System.out.println("Correo electrónico enviado.");
        } else {
            System.out.println("Correo electrónico invalido");
        }
    }

    /**
     * Obtiene el número de teléfono del contacto.
     *
     * @return El número de teléfono del contacto.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del contacto.
     *
     * @param telefono El nuevo número de teléfono del contacto.
     */
    public void setTelefono(String telefono) {
        if (isValidPhoneNumber(telefono)) {
            this.telefono = telefono;
        } else {
            System.out.println("Número de teléfono inválido.");
        }
    }

    /**
     * Valida si un correo electrónico es válido.
     *
     * @param email El correo electrónico a validar.
     * @return true si el correo electrónico es válido, false en caso contrario.
     */
    private boolean isValidEmail(String email) {
        return email != null && !email.isEmpty() && email.contains("@") && email.indexOf(".") > email.indexOf("@");
    }

    /**
     * Valida si un número de teléfono es válido.
     *
     * @param phoneNumber El número de teléfono a validar.
     * @return true si el número de teléfono es válido, false en caso contrario.
     */
    private boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber != null && !phoneNumber.isEmpty() && phoneNumber.matches("\\d+");
    }
}


