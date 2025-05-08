package edu.icet.controller.pubicAPI;

import edu.icet.dto.FeaturedEvent;
import edu.icet.dto.supplier.Location;
import edu.icet.dto.supplier.Supplier;
import edu.icet.util.EventType;
import edu.icet.util.SupplierCategoryType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/public/featured-event")
public class FeaturedEventsController {

    @GetMapping("/get-all")
    public List<FeaturedEvent> getAll(){

        // Create mock suppliers
        Supplier supplier1 = new Supplier();
        supplier1.setId(1L);
        supplier1.setBusinessName("Golden Catering");
        supplier1.setBusinessContactNumber("0771234567");
        supplier1.setBusinessEmail("catering@golden.com");
        supplier1.setDescription("Best in town catering services.");
        supplier1.setAvailability(true);
        supplier1.setCategory(SupplierCategoryType.CATERING);
        supplier1.setLocation(new Location(1L, "Colombo", "Bambalapitiya"));

        Supplier supplier2 = new Supplier();
        supplier2.setId(2L);
        supplier2.setBusinessName("Crystal Music");
        supplier2.setBusinessContactNumber("0777654321");
        supplier2.setBusinessEmail("music@crystal.com");
        supplier2.setDescription("Live music band for weddings and events.");
        supplier2.setAvailability(true);
        supplier2.setCategory(SupplierCategoryType.MUSIC);
        supplier2.setLocation(new Location(2L, "Kandy", "Peradeniya"));

        Supplier supplier3 = new Supplier();
        supplier3.setId(3L);
        supplier3.setBusinessName("Royal Venue Services");
        supplier3.setBusinessContactNumber("0769998888");
        supplier3.setBusinessEmail("venue@royal.com");
        supplier3.setDescription("Luxury venues for any kind of event.");
        supplier3.setAvailability(true);
        supplier3.setCategory(SupplierCategoryType.VENUE);
        supplier3.setLocation(new Location(3L, "Galle", "Fort"));

        // Create featured events and assign suppliers
        List<FeaturedEvent> featuredEvents = new ArrayList<>();

        featuredEvents.add(new FeaturedEvent(
                1, // eventId or title (your DTO uses Integer title)
                EventType.WEDDING,
                "John & Jane",
                150000.00,
                "A romantic beach wedding.",
                Arrays.asList(supplier1, supplier3)
        ));

        featuredEvents.add(new FeaturedEvent(
                2,
                EventType.CONCERT,
                "Colombo Live Music Fest",
                200000.00,
                "An electrifying music night in Colombo.",
                Arrays.asList(supplier2)
        ));

        featuredEvents.add(new FeaturedEvent(
                3,
                EventType.CORPORATE,
                "Tech Leaders Summit",
                300000.00,
                "Annual gathering of tech leaders and innovators.",
                Arrays.asList(supplier1, supplier2, supplier3)
        ));

        // Print out all featured events
        featuredEvents.forEach(System.out::println);

        return featuredEvents;
    }
}
