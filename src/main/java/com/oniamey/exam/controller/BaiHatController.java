package com.oniamey.exam.controller;

import com.oniamey.exam.entity.BaiHat;
import com.oniamey.exam.model.BaiHatRequest;
import com.oniamey.exam.model.BaiHatResponse;
import com.oniamey.exam.model.FindBaiHatRequest;
import com.oniamey.exam.service.BaiHatService;
import com.oniamey.exam.utils.BaiHatUtils;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController()
@RequestMapping("/api/bai-hat")
public class BaiHatController {

    private final BaiHatService baiHatService;

    public BaiHatController(BaiHatService baiHatService) {
        this.baiHatService = baiHatService;
    }

    @GetMapping()
    public Page<BaiHatResponse> getBaiHatsByNameAndPrice(final FindBaiHatRequest request) {
        return baiHatService.getBaiHatsByNameAndPrice(request);
    }

    @PostMapping()
    public BaiHat createBaiHat(@RequestBody BaiHatRequest request) {
        return baiHatService.addBaiHat(request);
    }

    @PutMapping("/{id}")
    public BaiHat updateBaiHat(@PathVariable Integer id, @RequestBody BaiHatRequest request) {
        return baiHatService.updateBaiHat(id, request);
    }

    @DeleteMapping("/{id}")
    public BaiHat deleteBaiHat(@PathVariable Integer id) {
        return baiHatService.deleteBaiHat(id);
    }

}
