package com.flow.flowbackend.service;

import com.flow.flowbackend.entity.CustomExtension;
import com.flow.flowbackend.entity.FixedExtension;
import com.flow.flowbackend.dto.ExtensionSortBy;
import com.flow.flowbackend.dto.ExtensionSortOrder;
import com.flow.flowbackend.exception.*;
import com.flow.flowbackend.repository.CustomExtensionRepository;
import com.flow.flowbackend.repository.FixedExtensionRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExtensionService {
    private final FixedExtensionRepository fixedExtensionRepository;
    private final CustomExtensionRepository customExtensionRepository;
    private Logger logger = LoggerFactory.getLogger(ExtensionService.class);
    @Transactional
    public List<FixedExtension> getFixedExtensionList() {
        return fixedExtensionRepository.findAll();
    }

    @Transactional
    public List<CustomExtension> getCustomExtensionList(ExtensionSortBy sortBy, ExtensionSortOrder sortOrder) {
        Sort sort = Sort.by(sortOrder.toDirection(), sortBy.value);
        System.out.println(sortBy.value);
        return customExtensionRepository.findAllByEnabled( true, sort);
    }

    @Transactional
    public void changeFixedExtension(String name, boolean isBlocked) {
        FixedExtension fixedExtension = fixedExtensionRepository.findById(name)
                .orElseGet(() -> {
                    throw new NotAFixedExtensionException();
                });

        if (fixedExtension.isBlocked() == isBlocked) {
            throw new NothingChangedException();
        }

        fixedExtension.setBlocked(isBlocked);

        fixedExtensionRepository.saveAndFlush(fixedExtension);
    }

    @Transactional
    public void addCustomExtension(String name) {
        // 중복 체크
        if(customExtensionRepository.findByNameAndEnabled(name, true).isPresent()) throw new AlreadyExistException();
        else if(fixedExtensionRepository.findById(name).isPresent()) throw new AlreadyExistException();

        // 데이터 200개 초과 방지
        long cnt = customExtensionRepository.countByEnabled();
        if (cnt >= 200) {
            throw new CustomExtensionExceedException();
        }
        try {
            customExtensionRepository.saveAndFlush(new CustomExtension(name,true,LocalDateTime.now()));
        } catch(InvalidDataAccessApiUsageException e) {
            System.out.println(e);
            if(customExtensionRepository.count()>=200) throw new CustomExtensionExceedException();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Transactional
    public void deleteCustomExtension(String name) {
        CustomExtension customExtension = customExtensionRepository.findById(name)
                .orElseGet(() -> {
                    throw new NotExistCustomExtensionException();
                });
        customExtension.setEnabled(false);
        customExtensionRepository.saveAndFlush(customExtension);
    }
}
