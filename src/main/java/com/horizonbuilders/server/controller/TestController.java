package com.horizonbuilders.server.controller;

import com.horizonbuilders.server.repository.GlobalTypeRepository;
import com.horizonbuilders.server.repository.projections.GlobalTypeListView;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    GlobalTypeRepository globalTypeRepository;

    @GetMapping("/test")
    @SecurityRequirements
    public List<String> getSampleString() {
        return List.of("Bekzhan", "Nazima", "Zhoomart", "Aigul");
    }

    @GetMapping("/test/global-types")
    @SecurityRequirements
    Page<GlobalTypeListView> getAllGlobalsListView(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "3") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        return globalTypeRepository.findAllProjectedBy(pageable);
    }
}
