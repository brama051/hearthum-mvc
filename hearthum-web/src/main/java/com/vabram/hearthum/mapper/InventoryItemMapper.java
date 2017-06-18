package com.vabram.hearthum.mapper;

import com.vabram.hearthum.model.InventoryItem;
import com.vabram.hearthum.model.form.InventoryItemForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by brama051 on 2.3.2017..
 */
@Mapper(componentModel = "spring")
public interface InventoryItemMapper {

    InventoryItemMapper INSTANCE = Mappers.getMapper(InventoryItemMapper.class);

    @Mapping(source = "manufacturerNumber", target = "manufacturerNumber")
    InventoryItem formToInventoryItem(InventoryItemForm form);

    //CategoryServiceImpl categoryService = new CategoryServiceImpl();

    default List<String> LabelsToList (String labelsString){
        List<String> labels = new ArrayList<>(Arrays.asList(labelsString.split(",")));
        return labels;

    }

    /*default Category idToCategory(Long id){
        return categoryService.findById(id);
    }*/
}
