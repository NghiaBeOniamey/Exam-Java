package com.oniamey.exam.repository;

import com.oniamey.exam.entity.BaiHat;
import com.oniamey.exam.model.FindBaiHatRequest;
import com.oniamey.exam.model.BaiHatResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BaiHatRepository extends JpaRepository<BaiHat, Integer> {

    @Query(value = """
        SELECT
            bh.id AS id,
            bh.ten_bai_hat AS tenBaiHat,
            bh.ten_tac_gia AS tenTacGia,
            bh.thoi_luong AS thoiLuong,
            bh.ngay_san_xuat AS ngaySanXuat,
            bh.gia AS gia,
            cs.ten_ca_si AS tenCaSi,
            cs.que_quan AS queQuan
        FROM bai_hat bh
        LEFT JOIN dbo.ca_si cs on cs.id = bh.ca_si_id
        WHERE
           ( :#{#request.ten} IS NULL OR :#{#request.ten} LIKE '' OR cs.ten_ca_si LIKE CONCAT('%', :#{#request.ten}, '%') )
        AND
           ( :#{#request.min} IS NULL OR :#{#request.min} LIKE '' OR :#{#request.max} IS NULL OR :#{#request.max} LIKE ''
            OR bh.gia BETWEEN :#{#request.min} AND :#{#request.max} )
    """, nativeQuery = true)
    Page<BaiHatResponse> getBaiHatsByNameAndPrice(Pageable pageable, FindBaiHatRequest request);



}
