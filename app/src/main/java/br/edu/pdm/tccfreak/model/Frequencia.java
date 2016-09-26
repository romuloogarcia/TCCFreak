package br.edu.pdm.tccfreak.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Classe que representa a frequência de um aluno.
 *
 * @since 26/09/2016
 */
@DatabaseTable(tableName = "frequencia")
public class Frequencia {
    @DatabaseField(generatedId = true)
    private Integer codfrq;
    @DatabaseField(canBeNull = false)
    private Date datfrq;
    @DatabaseField(canBeNull = false)
    private Integer codtra;
}