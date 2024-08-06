package com.oniamey.exam.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FindBaiHatRequest {

    private String ten;

    private Double min;

    private Double max;

    private int page;

}
