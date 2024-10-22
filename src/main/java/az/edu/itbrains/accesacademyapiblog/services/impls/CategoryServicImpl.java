package az.edu.itbrains.accesacademyapiblog.services.impls;

import az.edu.itbrains.accesacademyapiblog.dtos.CategoryAddDto;
import az.edu.itbrains.accesacademyapiblog.dtos.CategoryDto;
import az.edu.itbrains.accesacademyapiblog.dtos.CategoryUpdateDto;
import az.edu.itbrains.accesacademyapiblog.models.Category;
import az.edu.itbrains.accesacademyapiblog.payloads.ApiPayload;
import az.edu.itbrains.accesacademyapiblog.payloads.ApiResponse;
import az.edu.itbrains.accesacademyapiblog.repositories.CategoryRepository;
import az.edu.itbrains.accesacademyapiblog.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServicImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServicImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse createCategory(CategoryAddDto categoryAddDto) {
        try {
            Category findCategory = categoryRepository.findByName(categoryAddDto.getName());
            if (findCategory != null) {
                return new ApiResponse(false, HttpStatus.METHOD_NOT_ALLOWED, "Category alredy exist");
            }
            Category category = new Category();
            category.setName(categoryAddDto.getName());
            categoryRepository.save(category);
            return new ApiResponse(true, HttpStatus.CREATED, "Category created");

        } catch (Exception e) {
            return new ApiResponse(false, HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @Override
    public ApiPayload<CategoryDto> getCategories() {
        try {
            List<Category> data = categoryRepository.findAll();
            List<CategoryDto> result = data.stream().map(x -> modelMapper.map(x, CategoryDto.class)).toList();
            return new ApiPayload<>(true, result, HttpStatus.OK);

        } catch (Exception e) {
            return new ApiPayload<>(false, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ApiResponse deleteCategory(Long id) {
        try {
            Category findCategory = categoryRepository.findById(id).orElseThrow();
            if (findCategory == null) {
                return new ApiResponse(false, HttpStatus.EXPECTATION_FAILED, "Category not found");
            }
            categoryRepository.delete(findCategory);
            return new ApiResponse(true, HttpStatus.OK, "Category removed");
        } catch (Exception e) {
            return new ApiResponse(false, HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @Override
    public ApiResponse updateCategory(Long id, CategoryUpdateDto categoryUpdateDto) {
        try {
            Category findCategory=categoryRepository.findById(id).orElseThrow();
            if (findCategory==null){
                return new ApiResponse(false,HttpStatus.METHOD_NOT_ALLOWED,"not found");
            }
            findCategory.setName(categoryUpdateDto.getName());
            categoryRepository.save(findCategory);
            return new ApiResponse(true,HttpStatus.OK,"category updated");

        }catch (Exception e){
          return new ApiResponse(false,HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @Override
    public CategoryDto findUpdateCategory(Long id) {
        try {
            Category findCategory=categoryRepository.findById(id).orElseThrow();
            if (findCategory==null){
                return null;
            }
            CategoryDto data=modelMapper.map(findCategory,CategoryDto.class);
            return data;

        }catch (Exception e){
            return null;
        }
    }
}
