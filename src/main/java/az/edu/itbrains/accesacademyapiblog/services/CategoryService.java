package az.edu.itbrains.accesacademyapiblog.services;

import az.edu.itbrains.accesacademyapiblog.dtos.CategoryAddDto;
import az.edu.itbrains.accesacademyapiblog.dtos.CategoryDto;
import az.edu.itbrains.accesacademyapiblog.dtos.CategoryUpdateDto;
import az.edu.itbrains.accesacademyapiblog.payloads.ApiPayload;
import az.edu.itbrains.accesacademyapiblog.payloads.ApiResponse;

public interface CategoryService {
    ApiResponse createCategory(CategoryAddDto categoryAddDto);
    ApiPayload<CategoryDto>  getCategories();
    ApiResponse deleteCategory(Long id);
    ApiResponse updateCategory(Long id, CategoryUpdateDto categoryUpdateDto);
    CategoryDto findUpdateCategory(Long id);
}
