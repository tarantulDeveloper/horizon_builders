package com.horizonbuilders.server.service.impl;

import com.horizonbuilders.server.exception.AlreadyExistException;
import com.horizonbuilders.server.exception.BadRequestException;
import com.horizonbuilders.server.exception.ResourceNotFoundException;
import com.horizonbuilders.server.model.Position;
import com.horizonbuilders.server.repository.PositionRepository;
import com.horizonbuilders.server.service.PositionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PositionServiceImpl implements PositionService {
    final PositionRepository positionRepository;

    @Override
    public Page<Position> getAllPositions(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        return positionRepository.findAll(pageable);
    }

    @Override
    public Position addPosition(String name, double salary) {
        if (positionRepository.existsByName(name)) {
            throw new AlreadyExistException("This position is already exist!");
        }
        if (salary < 0) {
            throw new BadRequestException("Salary can be only more or equal to 0!");
        }
        Position position = Position.builder()
                .name(name)
                .salary(salary)
                .build();
        return positionRepository.save(position);
    }

    @Override
    public void deletePositionById(int positionId) {
        Position position = positionRepository.findById(positionId)
                .orElseThrow(() -> new ResourceNotFoundException("Position not found!"));
        positionRepository.deleteById(positionId);
    }

    @Override
    public Position updatePosition(String name, double salary, int positionId) {
        Position updatingPosition = positionRepository.findById(positionId)
                .orElseThrow(() -> new ResourceNotFoundException("Position not found"));
        if (salary < 0) {
            throw new BadRequestException("Salary can be only more or equal to 0!");
        }
        if (positionRepository.existsByName(name)) {
            throw new AlreadyExistException("This position is already exist!");
        }
        updatingPosition.setName(name);
        updatingPosition.setSalary(salary);
        return positionRepository.save(updatingPosition);
    }


    @Override
    public Position getPositionById(int positionId) {
        return positionRepository.findById(positionId).orElseThrow(() -> new ResourceNotFoundException("Position not found!"));
    }

}
