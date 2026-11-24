package br.com.arthub.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "comunidades")
public class Comunidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoComunidade tipo;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "somente_convite")
    private Boolean somenteConvite = false;

    @ManyToMany(mappedBy = "comunidades")
    private List<Artista> artistas = new ArrayList<>();

    @ManyToMany(mappedBy = "comunidades")
    private List<Consumidor> consumidores = new ArrayList<>();

    @OneToMany(mappedBy = "comunidade", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "comunidade", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Convite> convites = new ArrayList<>();

    @OneToMany(mappedBy = "comunidade", cascade = CascadeType.ALL)
    private List<Recomendacao> recomendacoes = new ArrayList<>();

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public TipoComunidade getTipo() { return tipo; }
    public void setTipo(TipoComunidade tipo) { this.tipo = tipo; }

    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDateTime dataCriacao) { this.dataCriacao = dataCriacao; }

    public Boolean getSomenteConvite() { return somenteConvite; }
    public void setSomenteConvite(Boolean somenteConvite) { this.somenteConvite = somenteConvite; }

    public List<Artista> getArtistas() { return artistas; }
    public void setArtistas(List<Artista> artistas) { this.artistas = artistas; }

    public List<Consumidor> getConsumidores() { return consumidores; }
    public void setConsumidores(List<Consumidor> consumidores) { this.consumidores = consumidores; }

    public List<Post> getPosts() { return posts; }
    public void setPosts(List<Post> posts) { this.posts = posts; }

    public List<Convite> getConvites() { return convites; }
    public void setConvites(List<Convite> convites) { this.convites = convites; }

    public List<Recomendacao> getRecomendacoes() { return recomendacoes; }
    public void setRecomendacoes(List<Recomendacao> recomendacoes) { this.recomendacoes = recomendacoes; }
}