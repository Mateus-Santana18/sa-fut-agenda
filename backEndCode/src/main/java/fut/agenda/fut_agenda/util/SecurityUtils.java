package fut.agenda.fut_agenda.util;

import fut.agenda.fut_agenda.entities.UsuarioEntity;
import java.util.Optional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {

  public static Long getCurrentId() {
    if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UsuarioEntity) {
      Optional<Authentication> authentication = Optional.ofNullable(
          SecurityContextHolder.getContext().getAuthentication());
      if (authentication.isPresent()) {
        return ((UsuarioEntity) authentication.get().getPrincipal()).getId();
      }
    }
    throw new RuntimeException("User not found");
  }

  public static UsuarioEntity getCurrentUser() {
    if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UsuarioEntity) {
      Optional<Authentication> authentication = Optional.ofNullable(
          SecurityContextHolder.getContext().getAuthentication());
      if (authentication.isPresent()) {
        return ((UsuarioEntity) authentication.get().getPrincipal());
      }
    }
    throw new RuntimeException("User not found");
  }
}
