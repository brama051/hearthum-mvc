package com.vabram.hearthum.controller;

import com.vabram.hearthum.mapper.InventoryItemMapper;
import com.vabram.hearthum.model.InventoryItem;
import com.vabram.hearthum.model.form.InventoryItemForm;
import com.vabram.hearthum.service.CategoryService;
import com.vabram.hearthum.service.InventoryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by brama051 on 1.3.2017..
 */
@Controller
@RequestMapping("/draft")
public class DraftController {

    // --- VIEW NAMES ---------------------------------------------------------
    private static final String ITEM_LIST_VIEW_NAME = "item_list";
    private static final String ITEM_FORM_VIEW_NAME = "item_form";
    private static final String ITEM_LIST_REDIRECT_NAME = "redirect:/draft/item-list";

    // --- REDIRECT ATTRIBUTES ------------------------------------------------
    private static final String FORM_SUBMIT = "formSubmit";

    @Autowired
    private InventoryItemService inventoryItemService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private InventoryItemMapper inventoryItemMapper;

    @RequestMapping("/item-list")
    public String itemList(Model model) {
        model.addAttribute("itemList", inventoryItemService.findAll());
        return ITEM_LIST_VIEW_NAME;
    }

    @RequestMapping(value = "/item-new", method = RequestMethod.GET)
    public String itemForm(Model model) {
        InventoryItemForm form = new InventoryItemForm();
        form.setCategories(categoryService.findAll());
        model.addAttribute("inventoryItemForm", form);
        return ITEM_FORM_VIEW_NAME;
    }

    @RequestMapping(value = "/item-new", method = RequestMethod.POST)
    public String itemFormSubmit(@Valid@ModelAttribute("inventoryItemForm") InventoryItemForm inventoryItemForm, BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {
        inventoryItemForm.setCategory(categoryService.findById(inventoryItemForm.getCategory().getId()));
        if (bindingResult.hasErrors()){
            return ITEM_FORM_VIEW_NAME;
        }

        InventoryItem inventoryItem = inventoryItemMapper.formToInventoryItem(inventoryItemForm);

        inventoryItemService.save(inventoryItem);


        redirectAttributes.addFlashAttribute(FORM_SUBMIT, true);
        return ITEM_LIST_REDIRECT_NAME;
    }
}
