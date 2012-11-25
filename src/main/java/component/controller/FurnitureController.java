package component.controller;

import component.service.FurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
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

        return "catalogDisplayAll";
    }

    @RequestMapping(value = "/{itemId}", method = RequestMethod.GET)
    public String getFurnitureItem(@PathVariable String itemId, Map<String, Object> model) {
        model.put("furnitureItem", furnitureService.getById(itemId));

        return "catalogDisplayItem";
    }

}
