package component.controller;

import component.service.FurnitureService;
import entity.FurnitureitemsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping("/catalog")
public class FurnitureController {

    @Autowired
    FurnitureService furnitureService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllItems(Map<String, Object> model) {

        model.put("agd", furnitureService.getByCategory("agd"));
        model.put("beds", furnitureService.getByCategory("beds"));
        model.put("cabinet", furnitureService.getByCategory("cabinet"));
        model.put("chairs", furnitureService.getByCategory("chairs"));
        model.put("dresser", furnitureService.getByCategory("dresser"));
        model.put("sofas", furnitureService.getByCategory("sofas"));
        model.put("tables", furnitureService.getByCategory("tables"));
        model.put("wardrobes", furnitureService.getByCategory("wardrobes"));

        model.put("pageHeading", "Katalog mebli");
        model.put("pageLead", "Wyselekcjonowany katalog mebli z najlepszych sklepów meblowych w Polsce");

        return "catalogDisplayAll";
    }

    @RequestMapping(value = "/{itemId}", method = RequestMethod.GET)
    public String getFurnitureItem(@PathVariable String itemId, Map<String, Object> model) {
        FurnitureitemsEntity furniture = furnitureService.getById(itemId);
        if(furniture!=null) {
            model.put("furnitureItem", furniture);
            model.put("pageHeading", "Katalog mebli");
            model.put("pageLead", "Widok szczegółowy");

            return "catalogDisplayItem";
        }
        else {
            model.put("error", "Nie odnaleziono w bazie danych mebla o podanym id.");
            return "errorPage";
        }

    }

    @PreAuthorize(("hasRole('ROLE_ADMIN')"))
    @RequestMapping(value = "/delete/{itemId}", method = RequestMethod.GET)
    public String deleteItem(@PathVariable String itemId, Map<String, Object> model) {
        furnitureService.removeItem(itemId);

        return "redirect:/catalog";
    }

}
