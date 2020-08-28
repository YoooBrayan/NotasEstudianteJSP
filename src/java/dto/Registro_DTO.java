package dto;

/**
 *
 * @author YO
 */
public class Registro_DTO {
    
    private int id;
    private String fecha;
    private Estudiante_DTO estudianteDTO;
    private Curso_DTO cursoDTO;

    public Registro_DTO(int id, String fecha, Estudiante_DTO estudianteDTO, Curso_DTO cursoDTO) {
        this.id = id;
        this.fecha = fecha;
        this.estudianteDTO = estudianteDTO;
        this.cursoDTO = cursoDTO;
    }
    
    public Registro_DTO() {
        this.id = 0;
        this.fecha = "";
        this.estudianteDTO = new Estudiante_DTO();
        this.cursoDTO = new Curso_DTO();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Estudiante_DTO getEstudianteDTO() {
        return estudianteDTO;
    }

    public void setEstudianteDTO(Estudiante_DTO estudianteDTO) {
        this.estudianteDTO = estudianteDTO;
    }

    public Curso_DTO getCursoDTO() {
        return cursoDTO;
    }

    public void setCursoDTO(Curso_DTO cursoDTO) {
        this.cursoDTO = cursoDTO;
    }
    
    
    
    
}
