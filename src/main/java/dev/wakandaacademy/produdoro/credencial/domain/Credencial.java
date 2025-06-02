package dev.wakandaacademy.produdoro.credencial.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Document(collection = "credencial")
public class Credencial {
    @MongoId(targetType = FieldType.STRING)
    @Getter
    private String usuario;
    private String senha;

    public Credencial(String senha, String usuario) {
        this.senha = new BCryptPasswordEncoder().encode(senha);
        this.usuario = usuario;
    }
    public String getPassword() {
        return senha;
    }
}
