package br.com.arthub.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artistas")
public class Artista extends Usuario {

    @Column(name = "nome_artistico")
    private String nomeArtistico;

    @Column(name = "esta_disponivel")
    private Boolean estaDisponivel = true;

    @Column(name = "em_hiatus")
    private Boolean emHiatus = false;

    @Column(name = "motivo_hiatus")
    private String motivoHiatus;

    @ElementCollection
    @CollectionTable(name = "artista_estilos", joinColumns = @JoinColumn(name = "artista_id"))
    @Column(name = "estilo")
    private List<String> estilos = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "artista_nichos", joinColumns = @JoinColumn(name = "artista_id"))
    @Column(name = "nicho")
    private List<String> nichos = new ArrayList<>();

    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL)
    private List<Portfolio> portfolio = new ArrayList<>();

    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL)
    private List<Servico> servicos = new ArrayList<>();

    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL)
    private List<Follow> seguidores = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "artista_comunidades",
        joinColumns = @JoinColumn(name = "artista_id"),
        inverseJoinColumns = @JoinColumn(name = "comunidade_id")
    )
    private List<Comunidade> comunidades = new ArrayList<>();

    // Getters e Setters
    public String getNomeArtistico() { return nomeArtistico; }
    public void setNomeArtistico(String nomeArtistico) { this.nomeArtistico = nomeArtistico; }

    public Boolean getEstaDisponivel() { return estaDisponivel; }
    public void setEstaDisponivel(Boolean estaDisponivel) { this.estaDisponivel = estaDisponivel; }

    public Boolean getEmHiatus() { return emHiatus; }
    public void setEmHiatus(Boolean emHiatus) { this.emHiatus = emHiatus; }

    public String getMotivoHiatus() { return motivoHiatus; }
    public void setMotivoHiatus(String motivoHiatus) { this.motivoHiatus = motivoHiatus; }

    public List<String> getEstilos() { return estilos; }
    public void setEstilos(List<String> estilos) { this.estilos = estilos; }

    public List<String> getNichos() { return nichos; }
    public void setNichos(List<String> nichos) { this.nichos = nichos; }

    public List<Portfolio> getPortfolio() { return portfolio; }
    public void setPortfolio(List<Portfolio> portfolio) { this.portfolio = portfolio; }

    public List<Servico> getServicos() { return servicos; }
    public void setServicos(List<Servico> servicos) { this.servicos = servicos; }

    public List<Follow> getSeguidores() { return seguidores; }
    public void setSeguidores(List<Follow> seguidores) { this.seguidores = seguidores; }

    public List<Comunidade> getComunidades() { return comunidades; }
    public void setComunidades(List<Comunidade> comunidades) { this.comunidades = comunidades; }
}