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
public class NameBasicsDTO {
    @CsvBindByName
    private String nconst;
    
    @CsvBindByName
    private String primaryName;
    
    @CsvBindByName
    private String birthYear;
    
    @CsvBindByName
    private String deathYear;
    
    @CsvBindByName
    private String primaryProfession;
    
    @CsvBindByName
    private String knownForTitles;
    
    
}
