package br.edu.pdm.tccfreak.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Classe que representa um Aluno.
 *
 * @since 26/09/2016
 */
@DatabaseTable(tableName = "aluno")
public class Aluno {
    @DatabaseField(generatedId = true)
    private Integer codalu;
    @DatabaseField(canBeNull = false)
    private String nomalu;
    @DatabaseField(canBeNull = false)
    private String nomcur;
    @DatabaseField
    private byte[] fotalu;


    public Integer getCodalu() {
        return codalu;
    }

    public void setCodalu(Integer codalu) {
        this.codalu = codalu;
    }

    public String getNomalu() {
        return nomalu;
    }

    public void setNomalu(String nomalu) {
        this.nomalu = nomalu;
    }

    public String getNomcur() {
        return nomcur;
    }

    public void setNomcur(String nomcur) {
        this.nomcur = nomcur;
    }

    public byte[] getFotalu() {
        return fotalu;
    }

    public void setFotalu(byte[] fotalu) {
        this.fotalu = fotalu;
    }
}