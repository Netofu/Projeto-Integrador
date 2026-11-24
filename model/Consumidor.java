package br.com.arthub.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "consumidores")
public class Consumidor extends Usuario {

    @OneToMany(mappedBy = "consumidor", cascade = CascadeType.ALL)
    private List<Follow> seguindo = new ArrayList<>();

    @OneToMany(mappedBy = "consumidor", cascade = CascadeType.ALL)
    private List<Favorito> favoritos = new ArrayList<>();

    @OneToMany(mappedBy = "consumidor", cascade = CascadeType.ALL)
    private List<Comissao> comissoes = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "consumidor_comunidades",
        joinColumns = @JoinColumn(name = "consumidor_id"),
        inverseJoinColumns = @JoinColumn(name = "comunidade_id")
    )
    private List<Comunidade> comunidades = new ArrayList<>();

    // Getters e Setters
    public List<Follow> getSeguindo() { return seguindo; }
    public void setSeguindo(List<Follow> seguindo) { this.seguindo = seguindo; }

    public List<Favorito> getFavoritos() { return favoritos; }
    public void setFavoritos(List<Favorito> favoritos) { this.favoritos = favoritos; }

    public List<Comissao> getComissoes() { return comissoes; }
    public void setComissoes(List<Comissao> comissoes) { this.comissoes = comissoes; }

    public List<Comunidade> getComunidades() { return comunidades; }
    public void setComunidades(List<Comunidade> comunidades) { this.comunidades = comunidades; }
}