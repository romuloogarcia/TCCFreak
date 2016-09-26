package br.edu.pdm.tccfreak.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Classe que representa a frequência de um aluno.
 *
 * @since 26/09/2016
 */
@DatabaseTable(tableName = "frequencia_aluno")
public class Frequencia_Aluno {
    @DatabaseField(generatedId = true)
    private Integer codfrqalu;
    @DatabaseField(canBeNull = false)
    private Integer codfrq;
    @DatabaseField(canBeNull = false)
    private Integer codalu;
    @DatabaseField(canBeNull = false)
    private char sitalu;
    @DatabaseField(canBeNull = false)
    private String assalu;


    public Integer getCodfrqalu() {
        return codfrqalu;
    }

    public void setCodfrqalu(Integer codfrqalu) {
        this.codfrqalu = codfrqalu;
    }

    public Integer getCodfrq() {
        return codfrq;
    }

    public void setCodfrq(Integer codfrq) {
        this.codfrq = codfrq;
    }

    public Integer getCodalu() {
        return codalu;
    }

    public void setCodalu(Integer codalu) {
        this.codalu = codalu;
    }

    public char getSitalu() {
        return sitalu;
    }

    public void setSitalu(char sitalu) {
        this.sitalu = sitalu;
    }

    public String getAssalu() {
        return assalu;
    }

    public void setAssalu(String assalu) {
        this.assalu = assalu;
    }
}
