package dto;

/**
 *
 * @author YO
 */
public class Curso_DTO {
    
    private int id;
    private String nombre;

    public Curso_DTO(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public Curso_DTO() {
        this.id = 0;
        this.nombre = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    
    
    
}
