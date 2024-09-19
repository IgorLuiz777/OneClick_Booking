package br.com.oneclick.booking.api.property;

import jakarta.el.PropertyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    public Property createProperty(Property property) {
        return propertyRepository.save(property);
    }

    public List<Property> listAllProperties() {
        return propertyRepository.findAll();
    }

    public Optional<Property> getPropertyById(Long id) {
        if (!propertyRepository.existsById(id)) throw new PropertyNotFoundException("Property not found, id: " + id);
        return propertyRepository.findById(id);
    }

    public Property updateProperty(Long id, Property property) {
        if (!propertyRepository.findById(id).isPresent()) throw new PropertyNotFoundException("Property not found, id: id");
        return propertyRepository.save(property);
    }

    public void deleteProperty(Long id) {
        if (!propertyRepository.findById(id).isPresent()) throw new PropertyNotFoundException("Property not found, id: id");
        propertyRepository.deleteById(id);
    }

}
