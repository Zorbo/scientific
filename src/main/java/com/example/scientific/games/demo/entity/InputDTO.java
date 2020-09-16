package com.example.scientific.games.demo.entity;

import lombok.Data;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


@Data
@Root(name = "root")
public class InputDTO {

    @Element(name = "panels")
    private int panels;

    @Element(name = "random_numbers")
    private int randomNumbers;

    @Element(name = "number_range")
    private int numberRangeTo;

}
