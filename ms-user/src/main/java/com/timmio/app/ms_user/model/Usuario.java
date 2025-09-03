package com.timmio.app.ms_user.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "TBL_USUARIOS")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer idUsuario;

    @Column
    private String nomeUsuario;

    @Column
    private String cpfCliente;

    @Column
    private String dddCliente;

    @Column
    @OneToMany(mappedBy = "usuario")
    private List<Profissional> profissionais;

    @Column
    private String telefoneCliente;

    @Column
    @CreatedDate
    private LocalDate dataCadastro;

    @Column
    @LastModifiedDate
    private LocalDate ultimaAtualizacao;


}
