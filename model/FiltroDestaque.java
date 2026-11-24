package br.com.arthub.model;

import jakarta.persistence.*;

@Entity
@Table(name = "filtros_destaque")
public class FiltroDestaque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(name = "tipo_filtro", nullable = false)
    private String tipoFiltro; // "ESTILO" ou "NICHO"

    @Column(nullable = false)
    private Integer peso; // peso na ordenação de resultados

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTipoFiltro() { return tipoFiltro; }
    public void setTipoFiltro(String tipoFiltro) { this.tipoFiltro = tipoFiltro; }

    public Integer getPeso() { return peso; }
    public void setPeso(Integer peso) { this.peso = peso; }
}