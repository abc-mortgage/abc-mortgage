/*

package com.abc.bank.mortgage.controller;

import com.abc.bank.mortgage.config.MessageUtil;
        import com.abc.bank.mortgage.model.Mortgage;
        import com.abc.bank.mortgage.service.MortgageService;
        import io.swagger.annotations.ApiParam;
        import io.swagger.v3.oas.annotations.Operation;
        import lombok.RequiredArgsConstructor;
        import org.apache.commons.lang3.StringUtils;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.validation.annotation.Validated;
        import org.springframework.web.bind.annotation.*;

        import java.util.Objects;
        import java.util.Optional;
        import java.util.UUID;

        import static com.abc.bank.mortgage.constant.MAContants.*;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping(DEFAULT_URI)
public class CustomerController {

    //private final CustomerService customerService;
    private final MessageUtil messageUtil;




    @Operation(summary = "Create customer", description = "Create customer")
    @PostMapping("/customer")
    public ResponseEntity<Mortgage> createMortgage(@RequestBody Customer customer) throws Exception {

        return new ResponseEntity<>(mortgageService.createMortgage(mortgage), HttpStatus.OK);
    }


}

*/
