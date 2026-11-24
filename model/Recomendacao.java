package br.com.arthub.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "recomendacoes")
public class Recomendacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "comunidade_id", nullable = false)
    private Comunidade comunidade;

    @ManyToOne
    @JoinColumn(name = "artista_id", nullable = false)
    private Artista artista;

    @Column(name = "quantidade_comissoes")
    private Integer quantidadeComissoes;

    @Column(name = "ultima_atualizacao")
    private LocalDateTime ultimaAtualizacao;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Comunidade getComunidade() { return comunidade; }
    public void setComunidade(Comunidade comunidade) { this.comunidade = comunidade; }

    public Artista getArtista() { return artista; }
    public void setArtista(Artista artista) { this.artista = artista; }

    public Integer getQuantidadeComissoes() { return quantidadeComissoes; }
    public void setQuantidadeComissoes(Integer quantidadeComissoes) { this.quantidadeComissoes = quantidadeComissoes; }

    public LocalDateTime getUltimaAtualizacao() { return ultimaAtualizacao; }
    public void setUltimaAtualizacao(LocalDateTime ultimaAtualizacao) { this.ultimaAtualizacao = ultimaAtualizacao; }
}