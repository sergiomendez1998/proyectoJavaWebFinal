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
public class TitleAkasDTO {

    @CsvBindByName
    private String titleId;

    @CsvBindByName
    private String ordering;

    @CsvBindByName
    private String title;

    @CsvBindByName
    private String region;

    @CsvBindByName
    private String language;

    @CsvBindByName
    private String types;

    @CsvBindByName
    private String attributes;

    @CsvBindByName
    private String isOriginalTitle;

}
