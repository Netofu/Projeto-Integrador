package br.com.arthub.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "trades")
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "artista_solicitante_id", nullable = false)
    private Artista artistaSolicitante;

    @ManyToOne
    @JoinColumn(name = "artista_destino_id", nullable = false)
    private Artista artistaDestino;

    @Column(nullable = false, length = 2000)
    private String descricao;

    @Enumerated(EnumType.STRING)
    private StatusTrade status;

    @Column(name = "data_solicitacao")
    private LocalDateTime dataSolicitacao;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Artista getArtistaSolicitante() { return artistaSolicitante; }
    public void setArtistaSolicitante(Artista artistaSolicitante) { this.artistaSolicitante = artistaSolicitante; }

    public Artista getArtistaDestino() { return artistaDestino; }
    public void setArtistaDestino(Artista artistaDestino) { this.artistaDestino = artistaDestino; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public StatusTrade getStatus() { return status; }
    public void setStatus(StatusTrade status) { this.status = status; }

    public LocalDateTime getDataSolicitacao() { return dataSolicitacao; }
    public void setDataSolicitacao(LocalDateTime dataSolicitacao) { this.dataSolicitacao = dataSolicitacao; }
}

enum StatusTrade { PENDENTE, ACEITO, RECUSADO, CONCLUIDO }