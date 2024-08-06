package com.oniamey.exam.service.impl;

import com.oniamey.exam.entity.BaiHat;
import com.oniamey.exam.model.BaiHatRequest;
import com.oniamey.exam.model.BaiHatResponse;
import com.oniamey.exam.model.FindBaiHatRequest;
import com.oniamey.exam.repository.BaiHatRepository;
import com.oniamey.exam.service.BaiHatService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BaiHatServiceImpl implements BaiHatService {

    private final BaiHatRepository baiHatRepository;

    public BaiHatServiceImpl(BaiHatRepository baiHatRepository) {
        this.baiHatRepository = baiHatRepository;
    }

    @Override
    public Page<BaiHatResponse> getBaiHatsByNameAndPrice(FindBaiHatRequest request) {
        return baiHatRepository.getBaiHatsByNameAndPrice(PageRequest.of(request.getPage() - 1, 5), request);
    }

    @Override
    public BaiHat addBaiHat(BaiHatRequest request) {
        BaiHat baiHat = new BaiHat();
        return getBaiHat(request, baiHat);
    }

    @Override
    public BaiHat updateBaiHat(Integer id, BaiHatRequest request) {
        Optional<BaiHat> baiHatOptional = baiHatRepository.findById(id);
        if (baiHatOptional.isPresent()) {
            BaiHat baiHat = baiHatOptional.get();
            return getBaiHat(request, baiHat);
        }
        return null;
    }

    private BaiHat getBaiHat(BaiHatRequest request, BaiHat baiHat) {
        baiHat.setTenBaiHat(request.getTenBaiHat());
        baiHat.setGia(request.getGia());
        baiHat.setThoiLuong(request.getThoiLuong());
        baiHat.setNgaySanXuat(request.getNgaySanXuat());
        baiHat.setTenTacGia(request.getTenTacGia());
        baiHat.setCaSiId(request.getCaSiId());
        return baiHatRepository.save(baiHat);
    }

    @Override
    public BaiHat deleteBaiHat(Integer id) {
        Optional<BaiHat> baiHatOptional = baiHatRepository.findById(id);
        if (baiHatOptional.isPresent()) {
            BaiHat baiHat = baiHatOptional.get();
            baiHatRepository.delete(baiHat);
            return baiHat;
        }
        return null;
    }


}
