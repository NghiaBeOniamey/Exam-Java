package com.oniamey.exam.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BaiHatRequest {

    private String tenBaiHat;

    private String tenTacGia;

    private Integer thoiLuong;

    private Date ngaySanXuat;

    private Double gia;

    private Integer caSiId;

}
