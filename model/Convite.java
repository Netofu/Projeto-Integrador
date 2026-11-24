package br.com.arthub.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "convites")
public class Convite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "comunidade_id", nullable = false)
    private Comunidade comunidade;

    @ManyToOne
    @JoinColumn(name = "convidado_id", nullable = false)
    private Usuario convidado;

    @ManyToOne
    @JoinColumn(name = "convidante_id", nullable = false)
    private Artista convidante;

    @Enumerated(EnumType.STRING)
    private StatusConvite status;

    @Column(name = "data_convite")
    private LocalDateTime dataConvite;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Comunidade getComunidade() { return comunidade; }
    public void setComunidade(Comunidade comunidade) { this.comunidade = comunidade; }

    public Usuario getConvidado() { return convidado; }
    public void setConvidado(Usuario convidado) { this.convidado = convidado; }

    public Artista getConvidante() { return convidante; }
    public void setConvidante(Artista convidante) { this.convidante = convidante; }

    public StatusConvite getStatus() { return status; }
    public void setStatus(StatusConvite status) { this.status = status; }

    public LocalDateTime getDataConvite() { return dataConvite; }
    public void setDataConvite(LocalDateTime dataConvite) { this.dataConvite = dataConvite; }
}

enum StatusConvite { PENDENTE, ACEITO, RECUSADO }