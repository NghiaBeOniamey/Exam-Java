package com.oniamey.exam.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.util.Date;

@Entity
@Table(name = "bai_hat")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaiHat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Nationalized
    @Column(name = "ten_bai_hat")
    private String tenBaiHat;

    @Nationalized
    @Column(name = "ten_tac_gia")
    private String tenTacGia;

    @Column(name = "thoi_luong")
    private Integer thoiLuong;

    @Column(name = "ngay_san_xuat")
    private Date ngaySanXuat;

    @Column(name = "gia")
    private Double gia;

    @Column(name = "ca_si_id")
    private Integer caSiId;

}
