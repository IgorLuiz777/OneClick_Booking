package br.com.oneclick.booking.api.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    // TODO: ERRO PERSONALIZADO

    @PostMapping
    public Property postProperty(@RequestBody Property property) {
        return propertyService.createProperty(property);
    }

    @GetMapping
    public List<Property> getAllProperties() {
        return propertyService.listAllProperties();
    }

    @GetMapping("/{id}")
    public Optional<Property> getPropertyById(@PathVariable Long id) {
        return propertyService.getPropertyById(id);
    }

    @PutMapping
    public Property updateProperty(@RequestBody Property property, @PathVariable Long id) {
        return propertyService.updateProperty(id, property);
    }

    @DeleteMapping("/{id}")
    public void deletPropertyById(@PathVariable Long id) {
        propertyService.deleteProperty(id);
    }

}
