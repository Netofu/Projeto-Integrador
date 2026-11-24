package br.com.arthub.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "reportado_id", nullable = false)
    private Usuario reportado;

    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoReport tipo;

    @Column(nullable = false, length = 2000)
    private String descricao;

    @Column(name = "data_reporte")
    private LocalDateTime dataReporte;

    @Enumerated(EnumType.STRING)
    private StatusReport status;

    @Column(name = "evidencia_apagada")
    private Boolean evidenciaApagada = false;

    @Column(name = "historico_apagado")
    private Boolean historicoApagado = false;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Usuario getAutor() { return autor; }
    public void setAutor(Usuario autor) { this.autor = autor; }

    public Usuario getReportado() { return reportado; }
    public void setReportado(Usuario reportado) { this.reportado = reportado; }

    public Chat getChat() { return chat; }
    public void setChat(Chat chat) { this.chat = chat; }

    public TipoReport getTipo() { return tipo; }
    public void setTipo(TipoReport tipo) { this.tipo = tipo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public LocalDateTime getDataReporte() { return dataReporte; }
    public void setDataReporte(LocalDateTime dataReporte) { this.dataReporte = dataReporte; }

    public StatusReport getStatus() { return status; }
    public void setStatus(StatusReport status) { this.status = status; }

    public Boolean getEvidenciaApagada() { return evidenciaApagada; }
    public void setEvidenciaApagada(Boolean evidenciaApagada) { this.evidenciaApagada = evidenciaApagada; }

    public Boolean getHistoricoApagado() { return historicoApagado; }
    public void setHistoricoApagado(Boolean historicoApagado) { this.historicoApagado = historicoApagado; }
}