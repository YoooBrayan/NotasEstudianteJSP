package dto;

/**
 *
 * @author YO
 */
public class Estudiante_DTO {
    
    private int codigo;
    private String nombre;
    private String apellido;
    private String correo;
    private String clave;
    private int cc;

    public Estudiante_DTO(int codigo, String nombre, String apellido, String correo, String clave, int cc) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.clave = clave;
        this.cc = cc;
    }
    
    public Estudiante_DTO() {
        this.codigo = 0;
        this.nombre = "";
        this.apellido = "";
        this.correo = "";
        this.clave = "";
        this.cc = 0;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }
    
    
    
    
    
    
}
