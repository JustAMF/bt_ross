package hw1.rest;

import hw1.domain.RunningInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import hw1.service.InfoAnalysis;

import java.util.List;

@RestController
public class RunningInfoAnalysisRestController {

    @Autowired
    private InfoAnalysis infoAnalysis;

    @RequestMapping(value = "/running", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<RunningInformation> RunningInformations){
        this.infoAnalysis.saveRunningLocations(RunningInformations);
    }

    @RequestMapping(value = "/purge", method = RequestMethod.DELETE)
    public void deleteAll(){
        this.infoAnalysis.deleteAll();
    }

    @RequestMapping(value = "/running/all", method = RequestMethod.GET)
    public Page<RunningInformation> findAllByHeartRateDesc(@RequestParam(name = "page") int page){
        return this.infoAnalysis.findAllByOrderByHeartRateDesc(new PageRequest(page, 2));
    }

    @RequestMapping(value = "/running/all/{healthWarningLevel}", method = RequestMethod.GET)
    public Page<RunningInformation> findAllByHeartRateDesc(@PathVariable RunningInformation.HealthWarningLevel healthWarningLevel, @RequestParam(name = "page") int page){
        return this.infoAnalysis.findByHealthWarningLevel(healthWarningLevel, new PageRequest(page, 2));
    }

}
