package com.flow.flowbackend.controller;

import com.flow.flowbackend.entity.CustomExtension;
import com.flow.flowbackend.entity.FixedExtension;
import com.flow.flowbackend.dto.CustomExtensionDto;
import com.flow.flowbackend.dto.ExtensionSortBy;
import com.flow.flowbackend.dto.ExtensionSortOrder;
import com.flow.flowbackend.dto.FixedExtensionDto;
import com.flow.flowbackend.service.ExtensionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/extension")
@CrossOrigin(origins = "${cors_allowed}")
@Validated
public class ExtensionController {
    private final ExtensionService extensionService;

    @GetMapping("/fixed")
    public ResponseEntity<List<FixedExtension>> getFixedExtensionList() {
        List<FixedExtension> result = extensionService.getFixedExtensionList();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/custom")
    public ResponseEntity<CustomExtensionDto> getCustomExtensionList(
            @RequestParam(defaultValue = "name", required = false) ExtensionSortBy sortBy,
            @RequestParam(defaultValue = "asc", required = false) ExtensionSortOrder sortOrder
    ) {
        List<CustomExtension> result = extensionService.getCustomExtensionList(sortBy, sortOrder);
        return ResponseEntity.ok(new CustomExtensionDto(result, result.size()));
    }

    @PatchMapping("/fixed")
    public void changeFixedExtension(@RequestBody @Valid FixedExtensionDto fixedExtensionDto) {
        extensionService.changeFixedExtension(fixedExtensionDto.getName(), fixedExtensionDto.getIsBlocked());
    }

    @PostMapping("/custom/{name}")
    public void addCustomExtension(@PathVariable @Size(max = 20) String name) {
        extensionService.addCustomExtension(name);
    }

    @DeleteMapping("/custom/{name}")
    public void deleteCustomExtension(@PathVariable @Size(max = 20) String name) {
        extensionService.deleteCustomExtension(name);
    }
}
