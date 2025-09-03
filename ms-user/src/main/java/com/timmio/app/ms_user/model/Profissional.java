package com.timmio.app.ms_user.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@Table(name = "TBL_PROFISSIONAIS")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Profissional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idProfissional;

    @Column
    private String nomeProfissional;

    @Column
    private String cpfProfissional;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column
    @CreatedDate
    private LocalDate dataCadastro;

    @Column
    @LastModifiedDate
    private LocalDate ultimaAtualizacao;
}
