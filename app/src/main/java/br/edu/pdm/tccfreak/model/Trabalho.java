package br.edu.pdm.tccfreak.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Classe que representa a frequência de um aluno.
 *
 * @since 26/09/2016
 */
@DatabaseTable(tableName = "trabalho")
public class Trabalho {
    @DatabaseField(generatedId = true)
    private Integer codtra;
    @DatabaseField(canBeNull = false)
    private String tittra;
    @DatabaseField(canBeNull = false)
    private String nomcur;
}
