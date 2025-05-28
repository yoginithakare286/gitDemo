package com.yts.revaux.ntQuote.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yts.revaux.ntQuote.entity.NtQuote;
import com.yts.revaux.ntQuote.entity.NtQuoteCustomer_Po;
import com.yts.revaux.ntQuote.entity.NtQuoteVendor_Po;
import com.yts.revaux.ntQuote.entity.NtQuoteVendor_Quote;
import com.yts.revaux.ntQuote.entity.RfqDetailTbl;
import com.yts.revaux.ntQuote.repository.NtQuoteCustomerPoRepository;
import com.yts.revaux.ntQuote.repository.NtQuoteRepository;
import com.yts.revaux.ntQuote.repository.NtQuoteVendorPoRepository;
import com.yts.revaux.ntQuote.repository.NtQuoteVendorQuoteRepository;
import com.yts.revaux.ntQuote.repository.RfqDetailTblRepository;

import jakarta.transaction.Transactional;

@Service
public class NtQuoteService {
    @Autowired
    private RfqDetailTblRepository rfqDetailTblRepository;
    @Autowired
    private NtQuoteCustomerPoRepository customerPoRepository;
    @Autowired
    private NtQuoteVendorPoRepository vendorPoRepository;
    @Autowired
    private NtQuoteVendorQuoteRepository vendorQuoteRepository;
    @Autowired
    private NtQuoteRepository ntQuoteRepository;

    @Transactional
    public NtQuote insertIntoNtQuote(String rfqId) {
        // Fetch data from the first four tables
        Optional<RfqDetailTbl> rfqDetail = rfqDetailTblRepository.findById(rfqId);
        List<NtQuoteCustomer_Po> customerPos = customerPoRepository.findAll();
        List<NtQuoteVendor_Po> vendorPos = vendorPoRepository.findAll();
        List<NtQuoteVendor_Quote> vendorQuotes = vendorQuoteRepository.findAll();

        if (rfqDetail.isPresent()) {
            RfqDetailTbl rfq = rfqDetail.get();
            NtQuote ntQuote = new NtQuote();
            ntQuote.setQuoteKey("QK-" + rfq.getRfqId());
            ntQuote.setCustomerName(rfq.getCustomer());
            ntQuote.setPartNumber(rfq.getPart());
            ntQuote.setQuoteDate(new Date(0));
            ntQuote.setCreatedBy("System");

            // Assign relationships
            customerPos.forEach(po -> po.setNtQuote(ntQuote));
            vendorPos.forEach(po -> po.setNtQuote(ntQuote));
            vendorQuotes.forEach(quote -> quote.setNtQuote(ntQuote));

            ntQuote.setCustomerPos(customerPos);
            ntQuote.setVendorPos(vendorPos);
            ntQuote.setVendorQuotes(vendorQuotes);

            return ntQuoteRepository.save(ntQuote);
        }
        throw new RuntimeException("RFQ not found for ID: " + rfqId);
    }
}
