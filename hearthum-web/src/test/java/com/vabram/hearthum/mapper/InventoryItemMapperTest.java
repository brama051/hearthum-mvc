package com.vabram.hearthum.mapper;

import com.vabram.hearthum.model.Category;
import com.vabram.hearthum.model.InventoryItem;
import com.vabram.hearthum.model.form.InventoryItemForm;
import org.fest.assertions.Assertions;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.fest.assertions.Assertions.assertThat;
/**
 * Created by brama051 on 2.3.2017..
 */
public class InventoryItemMapperTest {
    private final static String NAME = "name";
    private final static String DESCRIPTION = "description";
    private final static String QTY_UNIT = "qtyUnit";
    private final static Long CATEGORY_ID = 1L;
    private final static String CATEGORY_NAME = "category";
    private final static String MANUFACTURER_NUMBER = "manufacturerNumber";
    private final static String WARRANTY_NUMBER = "warrantyNumber";
    private final static Date PURCHASE_DATE = new Date(2016, 2, 10);
    private final static BigDecimal PRICE = new BigDecimal("1000");
    private final static String CURRENCY = "KN";
    private final static String LABELS = "label1,label2,label3";
    private final static Long INVENTORY_NUMBER = 1000250L;

    @Test
    public void formToInventoryItem(){
        InventoryItemForm form = constructForm();

        InventoryItem inventoryItem = InventoryItemMapper.INSTANCE.formToInventoryItem(form);

        assertThat(inventoryItem.getName()).isEqualTo(NAME);
        assertThat(inventoryItem.getDescription()).isEqualTo(DESCRIPTION);
        assertThat(inventoryItem.getQtyUnit()).isEqualTo(QTY_UNIT);
        Assertions.assertThat(inventoryItem.getCategory()).isNotNull();
        assertThat(inventoryItem.getCategory().getId()).isEqualTo(CATEGORY_ID);
        assertThat(inventoryItem.getCategory().getName()).isEqualTo(CATEGORY_NAME);
        assertThat(inventoryItem.getManufacturerNumber()).isEqualTo(MANUFACTURER_NUMBER);
        assertThat(inventoryItem.getWarrantyNumber()).isEqualTo(WARRANTY_NUMBER);
        assertThat(inventoryItem.getPurchaseDate()).isEqualTo(PURCHASE_DATE);
        assertThat(inventoryItem.getPrice()).isEqualTo(PRICE);
        assertThat(inventoryItem.getCurrency()).isEqualTo(CURRENCY);
        assertThat(inventoryItem.getLabels()).isNotNull().isNotEmpty();
        assertThat(inventoryItem.getLabels().get(0)).isEqualTo("label1");
        assertThat(inventoryItem.getLabels().get(1)).isEqualTo("label2");
        assertThat(inventoryItem.getLabels().get(2)).isEqualTo("label3");
        assertThat(inventoryItem.getInventoryNumber()).isEqualTo(INVENTORY_NUMBER);



    }

    private InventoryItemForm constructForm() {
        InventoryItemForm form = new InventoryItemForm();

        form.setName(NAME);
        form.setDescription(DESCRIPTION);
        form.setQtyUnit(QTY_UNIT);
        Category category = new Category();
        category.setId(CATEGORY_ID);
        category.setName(CATEGORY_NAME);
        form.setCategory(category);
        form.setManufacturerNumber(MANUFACTURER_NUMBER);
        form.setWarrantyNumber(WARRANTY_NUMBER);
        form.setPurchaseDate(PURCHASE_DATE);
        form.setPrice(PRICE);
        form.setCurrency(CURRENCY);
        form.setLabels(LABELS);
        form.setInventoryNumber(INVENTORY_NUMBER);

        return form;
    }
}
