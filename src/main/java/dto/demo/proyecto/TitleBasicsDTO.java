/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.demo.proyecto;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Sergio_Mendez_G
 */
@Getter
@Setter
@ToString
public class TitleBasicsDTO {

    @CsvBindByName
    private String tconst;

    @CsvBindByName
    private String titleType;

    @CsvBindByName
    private String primaryTitle;

    @CsvBindByName
    private String originalTitle;

    @CsvBindByName
    private String isAdult;

    @CsvBindByName
    private String startYear;

    @CsvBindByName
    private String endYear;

    @CsvBindByName
    private String runtimeMinutes;

    @CsvBindByName
    private String genres;
}
