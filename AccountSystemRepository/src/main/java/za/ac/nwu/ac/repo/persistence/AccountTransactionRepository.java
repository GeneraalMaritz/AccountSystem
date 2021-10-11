package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;


@Repository
public interface AccountTransactionRepository extends JpaRepository <AccountTransaction, Long> {

    @Query(value = "SELECT " +
            "       ACCOUNT_TX_ID" +
            "       MEMBER_ID" +
            "       TX_DATE" +
            "       AMOUNT" +
            "   FROM" +
            "       ACCOUNT_SYSTEM.ACCOUNT_TX" +
            "   WHERE ACCOUNT_TYPE_ID = :accountTypeId ", nativeQuery = true)
    AccountType getTransactionIdNativeQuery(Long accountTypeId);

    @Query(value = "SELECT" +
            "       t" +
            "   FROM" +
            "       AccountTransaction t" +
            "   WHERE t.accountTypeId = :accountTypeId")
    AccountType getAccountTypeByMnemonic(Long accountTypeId);

    @Query(value = "SELECT new za.ac.nwu.domain.dto.AccountTypeDto(" +
            "       t.memberId" +
            "       t.amount" +
            "       t.transactionDate)" +
            "   FROM" +
            "       AccountTransaction t" +
            "   WHERE t.accountTypeId = :accountTypeId")
    AccountTypeDto getAccountTypeDtoByMnemonic(Long mnemonic);
}
