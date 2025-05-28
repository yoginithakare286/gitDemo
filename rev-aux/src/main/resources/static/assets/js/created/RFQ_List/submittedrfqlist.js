/*Function for fetching Submitted RFQ list by Abhishek */
$(document).ready(function() {
    // Fetching data from the backend API
    $.getJSON('/app/rfq_api/submittedRFQDetailsAPI')
        .done(function(data) {
            console.log("Fetched data from backend for submitted RFQ:", data);

            // Iterate over each Submitted RFQ entry and dynamically create the HTML
            data.forEach(function(rfq) {
                let rfqCard = `
				<div class="card-custom">
				                        <!-- Icons -->
				                        <div class="icon-buttons" style="display: flex; justify-content: space-between; width: calc(100% - 31px); position: absolute; top: 20px; left: 31px; right: 0; max-width: 100%; box-sizing: border-box;">
				                            <span style="color: #241D75; font-size: 18px; letter-spacing: 1px; flex-shrink: 0;">RFQ Type : ${rfq.rfq_type}</span>
				                        </div>

				                        <!-- Main Content -->
				                        <div>
				                            <br><br>
				                            <div class="d-flex flex-wrap justify-content-between align-items-center">
				                                <div class="d-flex flex-wrap new_up_test" style="width: 70%; justify-content: space-between;">
				                                    <span class="text-primary fs-1" style="color: #241D75; font-size: 18px!important; flex-grow: 1; margin-bottom: 10px;">
				                                        RFQ ID &nbsp;: &nbsp;
				                                        <a href="rfq_detailed_screen.html" class="text-decoration-underline text-primary">${rfq.rfq_id}</a>
				                                    </span>

				                                    <span class="fs-6" style="color: #000; font-size: 18px!important; flex-grow: 1; margin-bottom: 10px;">
				                                        RFQ Days &nbsp;: &nbsp;
				                                        <a href="#" class="text-decoration-underline text-primary" style="color: #000!important;">${rfq.rfq_time}</a>
				                                    </span>

				                                    <span class="fs-6" style="color: #000; font-size: 18px!important; flex-grow: 1; margin-bottom: 10px;">
				                                        RFQ Start Date &nbsp;: &nbsp;
				                                        <a href="#" class="text-decoration-underline text-primary" style="color: #0075FF!important;">${rfq.start_date}</a>
				                                    </span>

				                                    <span class="fs-6" style="color: #000; font-size: 18px!important; flex-grow: 1; margin-bottom: 10px;">|</span>

				                                    <span class="fs-6" style="color: #000; font-size: 18px!important; flex-grow: 1; margin-bottom: 10px;">
				                                        RFQ End Date &nbsp;: &nbsp;
				                                        <a href="#" class="text-decoration-underline text-primary" style="color: #0075FF!important;">${rfq.end_date}</a>
				                                    </span>
				                                </div>

				                                <div class="d-flex" style="width: 14%; justify-content: flex-start;">
				                                    <span class="fs-6 status-active" style="font-size: 18px!important; font-weight: normal!important;">
				                                        RFQ Status: <span style="color:#D20000;">${rfq.rfq_status}</span>
				                                    </span>
				                                </div>
				                            </div>
				                        </div>

				                        <!-- RFQ Info -->
				                        <div class="rfq-info row justify-content-center" style="margin-left: 40px; margin-top: 20px;">
				                            <div class="col-12 col-md-4 mb-3">
				                                <div class="d-flex" style="padding: 0px; margin: 0px">
				                                    <div style="color: #000; font-size: 18px!important; flex-shrink: 0; width: 40%; font-weight: normal!important;" class="text_class">Customer</div>
				                                    <div style="font-size: 18px!important; color: #241D75; text-align: center; width: 5%;">:</div>
				                                    <div style="color: #000; font-size: 18px!important; width: 55%;">${rfq.customer}</div>
				                                </div>
				                                <div class="d-flex" style="padding: 0px; margin: 0px">
				                                    <div style="color: #000; font-size: 18px!important; flex-shrink: 0; width: 40%;font-weight: normal!important;">RFQ Received Date</div>
				                                    <div style="font-size: 18px!important; color: #241D75; text-align: center; width: 5%;">:</div>
				                                    <div style="color: #000; font-size: 18px!important; width: 55%;">${rfq.rfq_received_date}</div>
				                                </div>
				                                <div class="d-flex" style="padding: 0px; margin: 0px">
				                                    <div style="color: #000; font-size: 18px!important; flex-shrink: 0; width: 40%;font-weight: normal!important;">Quote Due Date</div>
				                                    <div style="font-size: 18px!important; color: #241D75; text-align: center; width: 5%;">:</div>
				                                    <div style="color: #000; font-size: 18px!important; width: 55%;">${rfq.quote_due_date}</div>
				                                </div>
				                                <div class="d-flex" style="padding: 0px; margin: 0px">
				                                    <div style="color: #000; font-size: 18px!important; flex-shrink: 0; width: 40%;font-weight: normal!important;">Part / Program Name</div>
				                                    <div style="font-size: 18px!important; color: #241D75; text-align: center; width: 5%;">:</div>
				                                    <div style="color: #000; font-size: 18px!important; width: 55%;">${rfq.part}</div>
				                                </div>
				                            </div>

				                            <div class="col-12 col-md-4 mb-3">
												<div class="d-flex" style="padding: 0px; margin: 0px">
					                                <div style="color: #000; font-size: 18px!important; flex-shrink: 0; width: 40%; font-weight: normal!important;">Buyer</div>
					                                <div style="font-size: 18px!important; color: #241D75; text-align: center; width: 5%;">:</div>
					                                <div style="color: #000; font-size: 18px!important; width: 55%;">${rfq.buyer}</div>
					                            </div>
				                                <div class="d-flex" style="padding: 0px; margin: 0px">
				                                    <div style="color: #000; font-size: 18px!important; flex-shrink: 0; width: 40%; font-weight: normal!important;">Expected Launch</div>
				                                    <div style="font-size: 18px!important; color: #241D75; text-align: center; width: 5%;">:</div>
				                                    <div style="color: #000; font-size: 18px!important; width: 55%;">${rfq.expected_launch}</div>
				                                </div>
				                                <div class="d-flex" style="padding: 0px; margin: 0px">
				                                    <div style="color: #000; font-size: 18px!important; flex-shrink: 0; width: 40%;font-weight: normal!important;">Requestor</div>
				                                    <div style="font-size: 18px!important; color: #241D75; text-align: center; width: 5%;">:</div>
				                                    <div style="color: #000; font-size: 18px!important; width: 55%;">${rfq.requestor}</div>
				                                </div>
				                            </div>

				                            <div class="col-12 col-md-4 mb-3 text-center">
				                                <div class="d-flex" style=" justify-content: flex-end;">
				                                    <span class="fs-6 status-active" style="font-size: 18px!important; font-weight: normal!important;">
				                                        RA Status : <span style="color:#D20000;">${rfq.ra_status}</span>
				                                    </span>
				                                </div>
				                            </div>
				                        </div>
				                    </div>
                `;
                // Append the RFQ card to the container
                $('#submitted-rfq-container').append(rfqCard);
            });
        })
        .fail(function() {
            console.error("Error fetching Submitted RFQ data.");
            alert("Error fetching data from the backend.");
        });
});
