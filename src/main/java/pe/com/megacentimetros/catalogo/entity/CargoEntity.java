package pe.com.megacentimetros.catalogo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "CargoEntity")
@Table(name = "cargo")
public class CargoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codcarg")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nomcarg", length = 50, nullable = false, unique = true)
    private String nombre;

    @Column(name = "descarg", length = 300)
    private String descripcion;

    @Column(name = "estcarg", nullable = false)
    private Boolean estado;

    @Column(name = "codtiemp", nullable = false)
    private Long codigoTipoEmpleado;

    @Column(name = "usucre", length = 50, nullable = false)
    private String usuarioCreacion;

    @Column(name = "feccre", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "usuact", length = 50)
    private String usuarioActualizacion;

    @Column(name = "fecact")
    private LocalDateTime fechaActualizacion;
}
