package dto;

/**
 *
 * @author YO
 */
public class Certificado_DTO {
    
    private int id;
    private Estudiante_DTO estudianteDTO;
    private Curso_DTO cursoDTO;
    private Nota_DTO notaDTO;

    public Certificado_DTO(int id, Estudiante_DTO estudianteDTO, Curso_DTO cursoDTO, Nota_DTO notaDTO) {
        this.id = id;
        this.estudianteDTO = estudianteDTO;
        this.cursoDTO = cursoDTO;
        this.notaDTO = notaDTO;
    }
    
    public Certificado_DTO() {
        this.id = 0;
        this.estudianteDTO = new Estudiante_DTO();
        this.cursoDTO = new Curso_DTO();
        this.notaDTO = new Nota_DTO();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Nota_DTO getNotaDTO() {
        return notaDTO;
    }

    public void setNotaDTO(Nota_DTO notaDTO) {
        this.notaDTO = notaDTO;
    }
    
    
    
    
}
