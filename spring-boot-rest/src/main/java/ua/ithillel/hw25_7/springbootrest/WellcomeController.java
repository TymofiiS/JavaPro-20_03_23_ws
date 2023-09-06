package ua.ithillel.hw25_7.springbootrest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WellcomeController {

	@GetMapping("/wellcome")
	public String wellcome() {
		return "Wellcome to the boot rest api";
	}
}
