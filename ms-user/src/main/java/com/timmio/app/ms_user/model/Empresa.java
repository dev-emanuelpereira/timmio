package com.timmio.app.ms_user.model;

import io.hypersistence.utils.hibernate.type.array.ListArrayType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@Table(name = "TBL_EMPRESAS")
@EntityListeners(AuditingEntityListener.class)
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idEmpresa;

    @Column
    private String nomeEmpresa;

    @Column
    private RamoEmpresa ramoEmpresa;

    @Column
    private String descricaoEmpresa;

    @Type(ListArrayType.class)
    @Column(name = "servicos", columnDefinition = "varchar[]")
    private List<String> servicos;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column
    private LocalTime horarioInicio;

    @Column
    private LocalTime horarioTermino;

    @Column
    @CreatedDate
    private LocalDate dataCadastro;

    @Column
    @LastModifiedDate
    private LocalDate ultimaAtualizacao;


}
