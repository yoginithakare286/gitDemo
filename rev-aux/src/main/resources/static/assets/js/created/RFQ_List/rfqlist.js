/*Function for fetching Active RFQ list by Abhishek */
$(document).ready(function() {
    // Fetching data from the backend API
    $.getJSON('/app/rfq_api/RFQDetailsAPI')
        .done(function(data) {
            console.log("Fetched data from backend:", data);
			
            // Optional: Debugging data structure
           // alert('Fetched RFQ Data: ' + JSON.stringify(data, null, 2));
            
            // Iterate over each RFQ entry and dynamically create the HTML
            data.forEach(function(rfq) {
                let rfqCard = `
                    <div class="card-custom">
                        <!-- Icons -->
                        <div class="icon-buttons" style="display: flex; justify-content: space-between; width: calc(100% - 31px); position: absolute; top: 20px; left: 31px; right: 0; max-width: 100%; box-sizing: border-box;">
                            <span style="color: #241D75; font-size: 18px; letter-spacing: 1px; flex-shrink: 0;">RFQ Type : ${rfq.rfq_type}</span>
                            <div style="display: flex; align-items: center; flex-shrink: 0; margin-right: 14px">
							
							<!-- Replaced Font Awesome edit icon with custom SVG -->
					        <img src="assets/css/created/rfq_list/edit_icon.svg" alt="Edit" title="Edit" style="cursor: pointer; width: 20px; height: 20px; margin-right: 10px;" onclick="openEditRFQModal('${rfq.rfq_id}')">

					        <!-- Replaced Font Awesome delete icon with custom SVG -->
					        <img src="assets/css/created/rfq_list/delete_icon.svg" alt="Delete" title="Delete" style="cursor: pointer; width: 25px; height: 25px;" onclick="deleteRFQ('${rfq.rfq_id}')">
							
                            </div>
                        </div>

                        <!-- Main Content -->
                        <div>
                            <br><br>
                            <div class="d-flex flex-wrap justify-content-between align-items-center">
                                <div class="d-flex flex-wrap new_up_test" style="width: 70%; justify-content: space-between;">
                                    <span class="text-primary fs-1" style="color: #241D75; font-size: 18px!important; flex-grow: 1; margin-bottom: 10px;">
                                        RFQ ID &nbsp;: &nbsp;
                                        <a href="#" onclick="redirectToRFQ()"  class="text-decoration-underline text-primary">${rfq.rfq_id}</a>
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
                                        RFQ Status: <span style="color:#0A750E;">${rfq.rfq_status}</span>
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
                                        RA Status : <span style="color:#0A750E;">${rfq.ra_status}</span>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                `;
                // Append the RFQ card to the container
                $('#rfq-container').append(rfqCard);
            });
        })
        .fail(function() {
            console.error("Error fetching RFQ data.");
            //alert("Error fetching data from the backend.");
        });
});

/*Function for fetching last RFQ ID and Auto genetating incremental RFQ ID by Abhishek */

document.addEventListener("DOMContentLoaded", function () {
    const createRFQModal = document.getElementById("createRFQModal");
    const rfqIdInput = document.getElementById("rfqIdInput");

    // Function to fetch the last RFQ ID and generate a new one
    function generateNewRFQId() {
        const prefix = "NT"; // Prefix for RFQ IDs

        // Fetch the last RFQ ID using $.getJSON
        $.getJSON('/app/rfq_api/getLastRfqIdAPI')
            .done(function (data) {
                // Assume the JSON response is { "lastRfqId": "NT1234" }
                const lastRfqId = data.lastRfqId.trim(); // Extract last RFQ ID


                let newRfqIdNumber = 1; // Default to 1 if no valid last RFQ ID
                if (lastRfqId && lastRfqId.startsWith(prefix)) {
                    const numberPart = parseInt(lastRfqId.replace(prefix, ""), 10);
                    newRfqIdNumber = numberPart + 1;
                }

                const newRFQId = prefix + newRfqIdNumber.toString();
                rfqIdInput.value = newRFQId; // Set the new RFQ ID in the input field
            })
            .fail(function () {
                console.error("Error fetching RFQ data.");
            });
    }

    // Attach the event listener to the modal's shown.bs.modal event
    $(createRFQModal).on("shown.bs.modal", function () {
        generateNewRFQId(); // Call the function to generate the RFQ ID
    });
});


document.addEventListener("DOMContentLoaded", function () {
    const createRFQModal = document.getElementById("createRFQModal");
    const requestorDropdown = document.querySelector("select.form-select[name='requestor']");

    // Function to fetch requestors and populate the dropdown
    function fetchAndPopulateRequestors() {
        // Clear the dropdown before populating
        requestorDropdown.innerHTML = "";

        // Fetch the requestor list
        $.getJSON('/app/rfq_api/getRequestorsAPI')
            .done(function (data) {
                if (data && data.length > 0) {
                    // Populate the dropdown with fetched data
                    data.forEach(function (requestor) {
                        const option = document.createElement("option");
                        option.value = requestor;
                        option.textContent = requestor;
                        requestorDropdown.appendChild(option);
                    });
                } else {
                    alert("No requestors available.");
                }
            })
            .fail(function () {
                alert("Error fetching the requestor list.");
            });
    }

    // Trigger fetching and populating on modal show
    $(createRFQModal).on("shown.bs.modal", function () {
        fetchAndPopulateRequestors();
    });
});

function saveRFQ() {
    
    var start_date = document.getElementById("start_date").value;
    var end_date = document.getElementById("end_date").value;
    var part_name = document.getElementById("part_name").value;
    var customer = document.getElementById("customer").value;
    var quote_due_date = document.getElementById("quote_due_date").value;
    var rfq_received_date = document.getElementById("rfq_received_date").value;

    var requestorSelect = document.getElementById("requestor-options");
    var requestor = requestorSelect.options[requestorSelect.selectedIndex].text;

    var buyer = document.getElementById("buyer").value;

    var status = "ACTIVE";
    
    var rfq_type = "NEW TOOLS";

    var rfq_ID = document.getElementById("rfqIdInput").value;
    
    var launchSelect = document.getElementById("launch-options");
    var expected_launch = launchSelect.options[launchSelect.selectedIndex].text;

    var customer_feedback = document.getElementById("customer_feedback").value;

    if (!start_date || !end_date || !part_name || !customer || !quote_due_date || !rfq_received_date) {
        console.log("Please fill all the required fields!");
        return;
    }

    var timerTime = 0;
    switch (document.getElementById("time-options").value) {
        case "option1": timerTime = 1; break; 
        case "option2": timerTime = 2; break; 
        case "option3": timerTime = 3; break; 
        case "option4": timerTime = 4; break;
        case "option5": timerTime = 5; break; 
        case "option6": timerTime = 6; break;
        case "option7": timerTime = 7; break;
        default:
            timerTime = 1;
    }

    // Log just before the AJAX call
    console.log("Preparing to make AJAX call...");

    $.ajax({
        type: 'POST',
        url: '/app/rfq_api/newRFQAPI',
        contentType: 'application/json',  // the content type is set to JSON
        data: JSON.stringify({  // Convert the data to JSON format
            start_date: start_date,
            end_date: end_date,
            timerTime: timerTime,
            rfq_type: rfq_type,
            rfq_ID: rfq_ID,
            part_name: part_name,
            customer: customer,
            quote_due_date: quote_due_date,
            rfq_received_date: rfq_received_date,
            requestor: requestor,
            buyer: buyer,
            status: status,
            expected_launch: expected_launch,
            customer_feedback: customer_feedback
        }),
        success: function(response) {
            if (response > 0) {
                toastr.success("New RFQ Generated Successfully!", "", { timeOut: 3000 });
                $('#createRFQModal').modal('hide');
                window.location.reload();
                /* $('#rfqlist-info-container').load(document.URL + ' #rfqlist-info-container');*/
				// Dynamically reload the content of #rfq-container
				   $('#rfq-container').load(document.URL + ' #rfq-container'); 
            } else {
                toastr.error("Some error occurred while saving the RFQ!", "", { timeOut: 3000 });
            }
        },
        error: function(xhr, status, error) {
			toastr.error("Error: Unable to communicate with the server.", "", { timeOut: 3000 });
            console.log("Error:", error);
            console.log("Status:", status);
            console.log("Response:", xhr.responseText);  // Check the response from the server
        }
    });
}

function calculateEndDate() {

  var startDateValue = document.getElementById("start_date").value;
  var selectedOption = document.getElementById("time-options").value;

   if (startDateValue && selectedOption) {
       var startDate = new Date(startDateValue);
       var hoursToAdd = 0;

       switch (selectedOption) {
           case "option1": 
               hoursToAdd = 24; // 1 Day
               break;
           case "option2": 
               hoursToAdd = 48; // 2 Days
               break;
           case "option3": 
               hoursToAdd = 72; // 3 Days
               break;
           case "option4": 
               hoursToAdd = 96; // 4 Days
               break;
           case "option5": 
               hoursToAdd = 120; // 5 Days
               break;
           case "option6": 
               hoursToAdd = 144; // 6 Days
               break;
           case "option7": 
               hoursToAdd = 168; // 7 Days
               break;
           default:
               hoursToAdd = 0;
       }

        startDate.setHours(startDate.getHours() + hoursToAdd);

     // Format the end date as "MM-DD-YYYY"
    	var endDateFormatted = ('0' + (startDate.getMonth() + 1)).slice(-2) + '-' + 
    	('0' + startDate.getDate()).slice(-2) + '-' + 
    	startDate.getFullYear();


        // Update the end date input field with the proper format
        document.getElementById("end_date").value = endDateFormatted;
    } else {
        document.getElementById("end_date").value = "";
    }
}


$(function () {
    // Initialize datepickers with custom format
    $("#rfq_received_date, #quote_due_date, #start_date, #end_date").datepicker({
        dateFormat: 'mm-dd-yy', // Set the format to mm-dd-yyyy
        changeMonth: true,
        changeYear: true
    });
});


// Edit Function Begins By Abhishek - Jan 27

function openEditRFQModal(rfqId) {
    // Show the modal immediately
    $('#editRFQModal').modal('show');

    // Fetch requestor options first
    $.ajax({
        url: '/app/rfq_api/getRequestorsAPI',
        method: 'GET',
        success: function (data) {
            console.log('Requestor Data:', data);

            var requestorSelect = $('#edit_requestor_options');
            requestorSelect.empty(); // Clear the dropdown before populating

            // Populate the requestor dropdown with options from the database
            $.each(data, function (index, requestor) {
                requestorSelect.append('<option value="' + requestor + '">' + requestor + '</option>');
            });

            // Once the requestor options are populated, fetch the RFQ details based on rfqId
            $.ajax({
                type: 'GET',
                url: '/app/rfq_api/RFQFetchEditDetailsAPI',
                data: { rfqId: rfqId },
                success: function (response) {
                    console.log('RFQ Details Data:', response);

                    if (Array.isArray(response) && response.length > 0) {
                        var rfqData = response[0]; // Extract the first item
                        console.log('RFQ Data Object:', rfqData);

                        // Populate modal fields with RFQ data
                        $('#edit_rfq_id').val(rfqData.rfq_id || '');
                        $('#edit_customer').val(rfqData.customer || '');
                        $('#edit_rfq_received_date').val(formatDateToMMDDYYYY(rfqData.rfq_received_date));
                        $('#edit_start_date').val(formatDateToMMDDYYYY(rfqData.start_date));
                        $('#edit_end_date').val(formatDateToMMDDYYYY(rfqData.end_date));
                        $('#edit_part_name').val(rfqData.part || '');
                        $('#edit_quote_due_date').val(formatDateToMMDDYYYY(rfqData.quote_due_date));
                        $('#edit_buyer').val(rfqData.buyer || '');
                        $('#edit_customer_feedback').val(rfqData.customer_feedback || '');
                        $('#edit_time_options').val(rfqData.rfq_time || '');
                        $('#edit_launch_options').val(rfqData.expected_launch || '');
                        $('#edit_requestor_options').val(rfqData.requestor || '');
                    } else {
                        toastr.error('No data found for the given RFQ ID.', '', { timeOut: 3000 });
                    }
                },
                error: function () {
                    toastr.error('Error: Unable to fetch RFQ details.', '', { timeOut: 3000 });
                }
            });
        },
        error: function (xhr, status, error) {
            console.error('Error fetching requestors:', error);
        }
    });
}

function saveEditRFQ() {
    var rfq_ID = $('#edit_rfq_id').val();
    var start_date = $('#edit_start_date').val();
    var end_date = $('#edit_end_date').val();
    var rfq_received_date = $('#edit_rfq_received_date').val();
    var quote_due_date = $('#edit_quote_due_date').val();
    var customer = $('#edit_customer').val();
    var customer_feedback = $('#edit_customer_feedback').val();
    var part_name = $('#edit_part_name').val();
    var buyer = $('#edit_buyer').val();
    var rfq_days = $('#edit_time_options').val();
    var requestor = $('#edit_requestor_options').val();
    var expected_launch = $('#edit_launch_options').val();

	
    if (!start_date || !end_date || !rfq_received_date || !customer || !part_name || !buyer) {
        toastr.error("Please fill all the required fields!", "", { timeOut: 3000 });
        return;
    }

	$.ajax({
	    type: 'PUT',
	    url: '/app/rfq_api/editRFQAPI',
	    contentType: 'application/json',  // Ensure Content-Type is application/json
	    data: JSON.stringify({
	        rfq_ID: rfq_ID,
	        start_date: start_date,
	        end_date: end_date,
	        rfq_received_date: rfq_received_date,
	        quote_due_date: quote_due_date,
	        customer: customer,
	        customer_feedback: customer_feedback,
	        part_name: part_name,
	        buyer: buyer,
	        rfq_days: parseInt(rfq_days),
	        requestor: requestor,
	        status: "ACTIVE",
	        expected_launch: expected_launch
	    }),
	    success: function(response) {
	        console.log('Response:', response);
			toastr.success(response, "", { timeOut: 3000 });
			$('#editRFQModal').modal('hide');  // Close the modal
			// Dynamically reload the content of #rfq-container
				window.location.reload();
			   $('#rfq-container').load(document.URL + ' #rfq-container'); 
	    },
	    error: function(xhr) {
	        console.error('Error:', xhr);
	        if (xhr.status === 500) {
	            toastr.error("Internal Server Error: Unable to update RFQ.", "", { timeOut: 3000 });
	        } else {
	            toastr.error("Error: Unable to communicate with the server.", "", { timeOut: 3000 });
	        }
	    }
	});

}

function calculateEditEndDate() {
    var startDateValue = $('#edit_start_date').val();
    var daysToAdd = parseInt($('#edit_time_options').val());

    if (startDateValue && daysToAdd) {
        var startDate = new Date(startDateValue);
        startDate.setDate(startDate.getDate() + daysToAdd);

        $('#edit_end_date').val(formatDateToMMDDYYYY(startDate));
    } else {
        $('#edit_end_date').val("");
    }
}

function formatDateToMMDDYYYY(date) {
    if (!date) return '';
    var d = new Date(date);
    var month = ('0' + (d.getMonth() + 1)).slice(-2);
    var day = ('0' + d.getDate()).slice(-2);
    var year = d.getFullYear();
    return `${month}-${day}-${year}`;
}

// Edit Function Ends By Abhishek - Jan 27


// Delete function Begins by Abhishek - Jan 27

function deleteRFQ(rfqId) {
    if (confirm("Are you sure you want to delete this RFQ?")) {
        $.ajax({
            type: 'POST',
            url: '/app/rfq_api/deleteRFQAPI',
            data: JSON.stringify({ rfqId: rfqId }),
            contentType: 'application/json',
            success: function(response) {
                if (response.status === 'SUCCESS') {
                    toastr.success("RFQ deleted successfully.", "", { timeOut: 3000 });
					// Dynamically reload the content of #rfq-container
					   window.location.reload();
					   $('#rfq-container').load(document.URL + ' #rfq-container'); 
                } else {
                    toastr.error("Failed to delete RFQ. Please try again.", "", { timeOut: 3000 });
                }
            },
            error: function(xhr) {
                console.error('Error:', xhr);
                toastr.error("Error: Unable to delete RFQ.", "", { timeOut: 3000 });
            }
        });
    }
}




function redirectToRFQ() {
        window.location.href = "/rev-aux/login2"; // Redirects to your Spring Boot controller
    }


