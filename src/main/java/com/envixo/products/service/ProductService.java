package com.envixo.products.service;

import com.envixo.products.dto.ProductDto;
import com.envixo.products.enums.Status;
import com.envixo.products.model.Product;
import com.envixo.products.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService extends GenericService<ProductDto, Product> {

    public ProductService(ProductRepository repository) {
        super(repository);
    }

    @Override
    Class<ProductDto> getDtoClass() {
        return ProductDto.class;
    }

    @Override
    Class<Product> getModelClass() {
        return Product.class;
    }

    public List<ProductDto> get(String status) {
        List<ProductDto> dtos = null;
        if(!Objects.isNull(status)) {
            final Status status1 = Status.valueOf(status);
            if(!Objects.isNull(status1)) {
                dtos = map(getRepository().findByStatus(status1));
            }
        }

        if(Objects.isNull(dtos))
            dtos = super.get();

        getImages(dtos);

        return dtos;
    }

    @Override
    public ProductDto get(Long id) {
        final ProductDto dto = super.get(id);
        getImages(dto);
        return dto;
    }

    @Override
    protected void postSave(ProductDto dto, Product model) {
        //simulação do registro das imagens no servidor de arquivos
        saveImages(model.getId(), dto.getImagesBase64());
    }

    private void saveImages(Long id, List<String> imagesBase64) {
        Optional.ofNullable(imagesBase64).ifPresent(images -> {
            //...
            //...
            //...
        });
    }

    private void getImages(List<ProductDto> dtos) {
        dtos.forEach(this::getImages);
    }

    private void getImages(ProductDto dto) {
        //simulação da recuperação das imagens no servidor de arquivos
        dto.setImagesBase64(new ArrayList<>());
    }

    private ProductRepository getRepository() {
        return (ProductRepository) this.repository;
    }
}
