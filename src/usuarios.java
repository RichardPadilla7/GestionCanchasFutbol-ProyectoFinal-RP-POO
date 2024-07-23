public class usuarios {
    String nombre;
    String email;
    String contrasenia;
    String cedula;
    String modo;

    public usuarios(String nombre, String email, String contrasenia, String cedula, String modo) {
        this.nombre = nombre;
        this.email = email;
        this.contrasenia = contrasenia;
        this.cedula = cedula;
        this.modo = modo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }
}
