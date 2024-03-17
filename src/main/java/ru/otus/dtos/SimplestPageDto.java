package ru.otus.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SimplestPageDto<T> {
    private List<T> content;
}