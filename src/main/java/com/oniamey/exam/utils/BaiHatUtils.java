package com.oniamey.exam.utils;

import com.oniamey.exam.entity.BaiHat;
import com.oniamey.exam.model.BaiHatResponse;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class BaiHatUtils {

    public static Optional<BaiHatResponse> findSongWithHighestPrice(List<BaiHatResponse> baiHatList) {
        return baiHatList.stream()
                .max(Comparator.comparingDouble(BaiHatResponse::getGia));
    }

    public static Optional<BaiHatResponse> findSongWithLongestDuration(List<BaiHatResponse> baiHatList) {
        return baiHatList.stream()
                .max(Comparator.comparingInt(BaiHatResponse::getThoiLuong));
    }

    public static Map<String, Integer> groupSongsBySingerAndCalculateTotalDuration(List<BaiHatResponse> baiHatList) {
        return baiHatList.stream()
                .collect(Collectors.groupingBy(
                        BaiHatResponse::getTenCaSi,
                        Collectors.summingInt(BaiHatResponse::getThoiLuong)
                ));
    }
}
