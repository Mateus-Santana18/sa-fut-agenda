package fut.agenda.fut_agenda.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "reserva")
public class ReservaEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "horario")
  private String horario;
  @ManyToOne
  @JoinColumn(name = "id_quadra")
  private QuadraEntity quadraEntity;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_organizador")
  private OrganizadorEntity organizadorEntity;
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_reserva")
  private Set<ReservaUsuarioEntity> reservaUsuarioEntitySet;
}
