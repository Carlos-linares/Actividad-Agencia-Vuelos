package fligtht.Booking.Controller;

import fligtht.Booking.dto.VuelosDto;
import fligtht.Booking.Services.VuelosService;
import fligtht.Booking.dto.VuelostoSalve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/vuelos")
public class VuelosController {

    private final VuelosService vuelosService;

    @Autowired
    public VuelosController(VuelosService vuelosService) {
        this.vuelosService = vuelosService;
    }

    @PostMapping("/save")
    public ResponseEntity<VuelosDto> saveVuelo(@RequestBody VuelostoSalve vuelosToSaveDto) {
        return ResponseEntity.ok(vuelosService.saveVuelo(vuelosToSaveDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VuelosDto> getVueloById(@PathVariable UUID id) {
        return ResponseEntity.ok(vuelosService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VuelosDto> updateVuelo(@PathVariable UUID id, @RequestBody VuelostoSalve vuelosToSaveDto) {
        return ResponseEntity.ok(vuelosService.updateVueloById(id, vuelosToSaveDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<VuelosDto> updatePatchVuelo(@PathVariable UUID id, @RequestBody VuelostoSalve vuelosToSaveDto) {
        return ResponseEntity.ok(vuelosService.updateVueloById(id, vuelosToSaveDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVueloById(@PathVariable UUID id) {
        vuelosService.deleteVueloById(id);
        return ResponseEntity.noContent().build();
    }
}
