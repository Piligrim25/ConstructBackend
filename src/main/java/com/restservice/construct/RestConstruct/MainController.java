package com.restservice.construct.RestConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private ImageRepository imageRepository;

    @GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody String addNewImage (@RequestParam Integer type_id
            , @RequestParam String url) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Image img = new Image();
        img.setType_id(type_id);
        img.setUrl(url);
        imageRepository.save(img);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Image> getAllImages() {
        // This returns a JSON or XML with the users
        return imageRepository.findAll();
    }

    private Iterable<Image> getAllImages(ImageType imageType) {
        // This returns a JSON or XML with the users
        ArrayList<Image> result = new ArrayList<>();
        imageRepository.findAll().forEach(image -> {
            if(image.getType_id() == imageType.getType_id()) {
                result.add(image);
            }
        });
        return result;
    }

    @GetMapping(path="/allwheels")
    @CrossOrigin
    public @ResponseBody Iterable<Image> getAllWheels() {
        return getAllImages(ImageType.WHEEL);
    }

    @GetMapping(path="/allcars")
    @CrossOrigin
    public @ResponseBody Iterable<Image> getAllCars() {
        return getAllImages(ImageType.CAR);
    }

    @GetMapping(path="/allstickers")
    @CrossOrigin
    public @ResponseBody Iterable<Image> getAllStickers() {
        return getAllImages(ImageType.STICKER);
    }
}