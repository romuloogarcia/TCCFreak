package br.edu.pdm.tccfreak.model;

import com.j256.ormlite.table.DatabaseTable;

/**
 * Classe que representa um Usuário.
 *
 * @since 24/09/2016
 */
@DatabaseTable(tableName = "usuario")
public class Usuario {
    private Integer codigo;
    private String nome;
    private String login;
    private String senha;
    private String email;
    private byte[] foto;

    public Usuario() {

    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}
