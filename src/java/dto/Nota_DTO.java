package dto;

/**
 *
 * @author YO
 */
public class Nota_DTO {
    
    private int id;
    private Registro_DTO registroDTO;
    private float nota;
    private float acumulado;
    private float cuantoNecesito;
    private int porcentaje;

    public Nota_DTO(int id, Registro_DTO registroDTO, float nota, float acumulado, float cuantoNecesito, int porcentaje) {
        this.id = id;
        this.registroDTO = registroDTO;
        this.nota = nota;
        this.acumulado = acumulado;
        this.cuantoNecesito = cuantoNecesito;
        this.porcentaje = porcentaje;
    }

    public Nota_DTO() {
        this.id = 0;
        this.registroDTO = new Registro_DTO();
        this.nota = 0;
        this.acumulado = 0;
        this.cuantoNecesito = 0;
        this.porcentaje = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Registro_DTO getRegistroDTO() {
        return registroDTO;
    }

    public void setRegistroDTO(Registro_DTO registroDTO) {
        this.registroDTO = registroDTO;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public float getAcumulado() {
        return acumulado;
    }

    public void setAcumulado(float acumulado) {
        this.acumulado = acumulado;
    }

    public float getCuantoNecesito() {
        return cuantoNecesito;
    }

    public void setCuantoNecesito(float cuantoNecesito) {
        this.cuantoNecesito = cuantoNecesito;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    
}
