package az.edu.itbrains.accesacademyapiblog.controllers;

import az.edu.itbrains.accesacademyapiblog.dtos.CategoryAddDto;
import az.edu.itbrains.accesacademyapiblog.dtos.CategoryDto;
import az.edu.itbrains.accesacademyapiblog.dtos.CategoryUpdateDto;
import az.edu.itbrains.accesacademyapiblog.payloads.ApiPayload;
import az.edu.itbrains.accesacademyapiblog.payloads.ApiResponse;
import az.edu.itbrains.accesacademyapiblog.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService categoryService;


    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createCategory(@RequestBody  CategoryAddDto categoryAddDto){
        ApiResponse data = categoryService.createCategory(categoryAddDto);
        return new ResponseEntity<>(data,data.getHttpStatus());
    }
    @GetMapping("/getAll")
    public ResponseEntity<ApiPayload<CategoryDto>> getCategories(){
        ApiPayload<CategoryDto> data=categoryService.getCategories();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<ApiResponse> removeCategory(@PathVariable Long id){
        ApiResponse data=categoryService.deleteCategory(id);
        return new ResponseEntity<>(data,data.getHttpStatus());
    }
    @PutMapping("/update/{id}")
    public  ResponseEntity<ApiResponse> updateCategory(@PathVariable Long id, @RequestBody CategoryUpdateDto categoryUpdateDto){
        ApiResponse data=categoryService.updateCategory(id,categoryUpdateDto);
        return new ResponseEntity<>(data,data.getHttpStatus());
    }
    @GetMapping("/update/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable Long id){
        CategoryDto data =categoryService.findUpdateCategory(id);
        return new ResponseEntity<>(data,HttpStatus.OK);
    }

}
