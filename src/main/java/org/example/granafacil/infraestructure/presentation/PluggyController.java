package org.example.granafacil.infraestructure.presentation;

import org.example.granafacil.infraestructure.integrations.pluggy.PluggyService;
import org.example.granafacil.infraestructure.integrations.pluggy.dto.AcessTokenResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/open-finance")
@RestController
public class PluggyController {
    private final PluggyService pluggyService;
    public PluggyController(PluggyService pluggyService) {
        this.pluggyService = pluggyService;
    }

    @GetMapping
    public ResponseEntity<AcessTokenResponse> getAcessToken () {
        AcessTokenResponse acessTokenResponse = pluggyService.getConnectToken();
        return ResponseEntity.ok(acessTokenResponse);
    }

//    @PostMapping("/item")
//    public ResponseEntity<Void> receberItem(@RequestBody ItemRequest request) {
//        //pluggyService.processarNovoItem(request.itemId());
//        return ResponseEntity.ok().build();
//    }

}
