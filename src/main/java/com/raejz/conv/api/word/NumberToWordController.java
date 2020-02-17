package com.raejz.conv.api.word;

import com.raejz.conv.kafka.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;


@RestController
@RequestMapping(value = "/num_to_english")
public class NumberToWordController {
    @Autowired
    private NumberToWordService numberToWordService;

    @Autowired
    private ProducerService producerService;

    @GetMapping(value = "/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DeferredResult<ResponseEntity<?>> getNumWords(@PathVariable String number) {
        DeferredResult<ResponseEntity<?>> deferredResult = new DeferredResult<>();

        NumberInWord result = numberToWordService.toWords(number);
        producerService.sendMessage(result);
        deferredResult.setResult(ResponseEntity.ok(result));

        return deferredResult;
    }
}
