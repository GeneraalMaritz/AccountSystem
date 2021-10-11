package za.ac.nwu.ac.logic.config.flow.impl;

import za.ac.nwu.ac.logic.config.flow.CreateAccountTypeFlow;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("CreateAccountTypeFlowName")
class CreateAccountTypeFLowImpl implements CreateAccountTypeFlow {
    @Override
    public AccountTypeDto create(AccountTypeDto accountType) {
        if(null == accountType.getCreationDate()){
            accountType.setCreationDate(LocalDate.now());
        }
        return accountTypeTranslator.create(accountType);
    }

    private final AccountTypeTranslator accountTypeTranslator;

    private CreateAccountTypeFLowImpl(AccountTypeTranslator accountTypeTranslator){
        this.accountTypeTranslator = accountTypeTranslator;
    }


}
