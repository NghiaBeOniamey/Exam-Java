package com.oniamey.exam.service;

import com.oniamey.exam.entity.BaiHat;
import com.oniamey.exam.model.BaiHatRequest;
import com.oniamey.exam.model.FindBaiHatRequest;
import com.oniamey.exam.model.BaiHatResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface BaiHatService {

    Page<BaiHatResponse> getBaiHatsByNameAndPrice(FindBaiHatRequest request);

    BaiHat addBaiHat(BaiHatRequest request);

    BaiHat updateBaiHat(Integer id, BaiHatRequest request);

    BaiHat deleteBaiHat(Integer id);

}
