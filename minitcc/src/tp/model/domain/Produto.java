package tp.model.domain;

public class Produto {
    private Long id;
    private String nome;
    private Double preco;
    private String descricao;
    private Long categoria_id;
    private Long fornecedor_id;

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCategoria_id(Long categoria_id) {
        this.categoria_id = categoria_id;
    }

    public void setFornecedor_id(Long fornecedor_id) {
        this.fornecedor_id = fornecedor_id;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public Long getCategoria_id() {
        return categoria_id;
    }

    public Long getFornecedor_id() {
        return fornecedor_id;
    }
}