package io.github.achadoseperdidos.dto.response;

import io.github.achadoseperdidos.model.Usuario;

import java.util.UUID;

public record UsuarioResponse(
        UUID usuarioId,
        String nome,
        String email
) {

    public static UsuarioResponse fronEntity(Usuario usuario){
        return new UsuarioResponse(
                usuario.getUsuarioId(),
                usuario.getNome(),
                usuario.getEmail()
        );
    }

}
