
//===========================================Calculation Input table code start===============================================

//<!-- Calculation Input table Data using Tabulator-->


		let table; // Input table
		let table2; // Output table
		
		$(document).ready(function () {
		    const urlParams = new URLSearchParams(window.location.search);
		    const id = urlParams.get("id");

		    if (!id) {
		        alert("Missing ID in the URL!");
		        return;
		    }

		    table = new Tabulator("#calculationInputData", {
		        layout: "fitColumns",
		        responsiveLayout: "collapse",
		        autoResize: true,
		        rowHeight: 50,
				columns: [
							{ title: "ID", field: "id", hozAlign: "center", width: 100, visible: false},

						        { title: "Sr No.", field: "srNo", hozAlign: "center", width: 100, 
						          formatter: function(cell) { return `<div style="font-size: 15px;background-color: #DCDCDC; padding: 10px;text-align:center;">${cell.getValue()}</div>`; } },

						        { title: "Description", field: "materialDescription", width: 260, 
						          formatter: function(cell) { return `<div style="background-color: #DCDCDC; padding: 10px;text-align:center;">${cell.getValue()}</div>`; } },

						        { title: "Part Number", field: "partNumber", width: 200, 
						          formatter: function(cell) { return `<div style="background-color: #DCDCDC; padding: 10px;text-align:center;">${cell.getValue()}</div>`; } },

						        { title: "Material", field: "materialId", width: 200, 
						          formatter: function(cell) { return `<div style="font-size: 15px;background-color: #DCDCDC; padding: 10px;text-align:center;">${cell.getValue()}</div>`; } },

						        { title: "Supplier", field: "supplier", editor: "input", width: 218 , // Editable field
							      formatter: function(cell) { return `<div style="font-size: 15px;text-align:center; padding: 10px;">${cell.getValue()}</div>`; } },

						        /*{ title: "Estimated Annual<br> Volume", field: "estAnnualVolume", hozAlign: "right", width: 200, 
						          formatter: function(cell) { return `<div style="font-size: 15px;background-color: #DCDCDC; padding: 10px;text-align:center;">${cell.getValue()}</div>`; } },
								*/
								
								{
								    title: "Estimated Annual<br> Volume",
								    field: "estAnnualVolume",
								    hozAlign: "right",
								    width: 200,
								    formatter: function(cell) {
								        // Format the value with commas as thousands separators
								        let formattedValue = parseFloat(cell.getValue()).toLocaleString("en-US");
								
								        return `<div style="font-size: 15px; background-color: #DCDCDC; padding: 10px; text-align:center;">${formattedValue}</div>`;
								    }
								},

						        { title: "Estimated Production<br> Runs per Year", field: "estProductionRunYrs", editor: "number", hozAlign: "right", width: 180 , // Editable field
								  formatter: function(cell) { return `<div style="font-size: 15px;text-align:center; padding: 10px;">${cell.getValue()}</div>`; } },
								
						        { title: "Material Cost ($/Lb)", field: "materialCostLb", editor: "number", hozAlign: "right", width: 180 , // Editable field
								  formatter: function(cell) { return `<div style="font-size: 15px;text-align:center; padding: 10px;">$ ${cell.getValue()}</div>`; } },
								
								  /*{   title: "Part Weight (Lb)", field: "partWeightLb", editor: "number", hozAlign: "right", width: 180 , // Editable field
								  								  formatter: function(cell) { return `<div style="font-size: 15px;text-align:center; padding: 10px;">${cell.getValue()}</div>`; } },
								  								
								  						        { title: "Runner Weight (Lb)",  field: "runnerWeightLb", editor: "number", hozAlign: "right", width: 180 , // Editable field
								  								  formatter: function(cell) { return `<div style="font-size: 15px;text-align:center; padding: 10px;">${cell.getValue()}</div>`; } },
								  								*/
								{ 
								   title: "Part Weight (Lb)", 
								   field: "partWeightLb", 
								   hozAlign: "right", 
								   width: 180, 
								   mutator: function(value, data) { 
								   // Apply formula: partWeight / 454
								   let partWeight = parseFloat(data.partWeight) || 0;
								   return (partWeight / 454).toFixed(2); // Convert to 2 decimal places
								     }, 
								   formatter: function(cell) { 
								  	return `<div style="font-size: 15px;background-color: #DCDCDC; padding: 10px;text-align:center;">${cell.getValue()}</div>`; 
								  	 } 
								  },
								  
							      {  title: "Runner Weight (Lb)", 
									 field: "runnerWeightLb", 
									 hozAlign: "right", 
									 width: 200, 
									 mutator: function(value, data) { 
										 // Apply formula: runnerWeight / 454
										 let runnerWeight = parseFloat(data.runnerWeight) || 0;
										 return (runnerWeight / 454).toFixed(2); // Convert to 2 decimal places
									  }, 
									formatter: function(cell) { 
									return `<div style="font-size: 15px; background-color: #DCDCDC; padding: 10px; text-align:center;">${cell.getValue()}</div>`; 
									} 
								},
								
						        { title: "Machine Size", field: "machineSize", width: 180, 
						          formatter: function(cell) { return `<div style="font-size: 15px;text-align:center;background-color: #DCDCDC; padding: 10px;">${cell.getValue()}</div>`; } },

						        { title: "Machine Rate", field: "machineRate", editor: "number", hozAlign: "right", width: 180,  // Editable field
								  formatter: function(cell) { return `<div style="font-size: 15px;text-align:center; padding: 10px;">$ ${cell.getValue()}</div>`; } },
					
								{ 
								    title: "Scrap Rate",
								    field: "scrapRate",
								    hozAlign: "center",
								    width: 180,
								    formatter: function(cell) {
								        return `<div style="font-size: 15px; text-align:center; padding: 10px; display: flex; justify-content: center; align-items: center;">
								                    ${cell.getValue()}% 
								                    <span style="margin-left: 5px; font-size: 18px; cursor: pointer;">&#9662;</span>  <!-- Dropdown icon -->
								                </div>`;
								    },
								    editor: "select",
								    editorParams: function() {  // Dynamically fetch values
								        return {
								            values: scrapRateOptions // Use dynamically fetched values
								        };
								    }
								},

								  //this below is working for dummy list properly and also saving the selected data into DB								/*  {
								  /*   { title: "Scrap Rate",
								      field: "scrapRate",
								      hozAlign: "center",  // This centers the text horizontally
								      width: 180,
								      formatter: function(cell) {
								          // Center the text and dropdown icon in the cell
								          return `<div style="font-size: 15px; text-align:center; padding: 10px; display: flex; justify-content: center; align-items: center;">
								                      ${cell.getValue()}% 
								                      <span style="margin-left: 5px; font-size: 18px; cursor: pointer;">&#9662;</span>  <!-- Downward arrow icon -->
								                  </div>`;
								      },
								      editor: "select",  // This turns the editor into a dropdown
								      editorParams: {
								          values: [
								              {value: "0", label: "0%"},
								              {value: "5", label: "5%"},
								              {value: "10", label: "10%"},
								              {value: "15", label: "15%"},
								              {value: "20", label: "20%"},
								              {value: "25", label: "25%"}
								          ]
								      }
								  }, */


								  
						      /*  { title: "Machine Efficiency", field: "machineEfficiency", hozAlign: "right", width: 200, 
						          formatter: function(cell) { return `<div style="font-size: 15px;text-align:center; padding: 10px;">${cell.getValue()}</div>`; } },
								*/
								
								/*{
								    title: "Machine Efficiency",
								    field: "machineEfficiency",
								    hozAlign: "right",
								    width: 200,
								    formatter: function(cell) {
										return `<div style="font-size: 15px; text-align:center; padding: 10px; display: flex; justify-content: center; align-items: center;">
																	                      ${cell.getValue()}% 
																	                      <span style="margin-left: 5px; font-size: 18px; cursor: pointer;">&#9662;</span>  <!-- Downward arrow icon -->
																	                  </div>`;								    },
								    editor: "select",  // This turns the editor into a dropdown
								    editorParams: {
								        values: [
											{value: "80", label: "80%"},
								            {value: "90", label: "90%"},
								            {value: "92", label: "92%"},
								            {value: "94", label: "94%"},
								            {value: "96", label: "96%"},
								            {value: "98", label: "98%"},
								            {value: "100", label: "100%"}
								        ]
								    }
								},*/

								{
								    title: "Machine Efficiency",
								    field: "machineEfficiency",
								    hozAlign: "right",
								    width: 200,
								    formatter: function(cell) {
								        return `<div style="font-size: 15px; text-align:center; padding: 10px; display: flex; justify-content: center; align-items: center;">
								                    ${cell.getValue()}% 
								                    <span style="margin-left: 5px; font-size: 18px; cursor: pointer;">&#9662;</span>  <!-- Downward arrow icon -->
								                </div>`;
								    },
								    editor: "select",
								    editorParams: function() {  // Dynamically set values
								        return {
								            values: machineEfficiencyOptions // Use dynamically fetched values
								        };
								    }
								},

						       /* { title: "# FTE", field: "fte", hozAlign: "right", width: 120, 
						           formatter: function(cell) { return `<div style="font-size: 15px; padding: 10px;text-align:center;">${cell.getValue()}</div>`; } },
								  */
								   {
								       title: "# FTE",
								       field: "fte",
								       hozAlign: "right",
								       width: 120,
								       formatter: function(cell) {
										   return `<div style="font-size: 15px; text-align:center; padding: 10px; display: flex; justify-content: center; align-items: center;">
										   																	                      ${cell.getValue()} FTE
										   																	                      <span style="margin-left: 5px; font-size: 18px; cursor: pointer;">&#9662;</span>  <!-- Downward arrow icon -->
										   																	                  </div>`;	
								       },
								       editor: "select",  // This turns the editor into a dropdown
								       editorParams: {
								           values: [
								               {value: "0.5", label: "1/2 FTE"},   // This is for 0.5 FTE
								               {value: "1", label: "1 FTE"},
								               {value: "1.5", label: "1.5 FTE"},   // This is for 1.5 FTE
								               {value: "2", label: "2 FTE"},
								               {value: "3", label: "3 FTE"},
								               {value: "4", label: "4 FTE"},
								               {value: "5", label: "5 FTE"}
								           ]
								       }
								   },
								   
								  /* { title: "Labor Rate", field: "laborRate", hozAlign: "right", width: 120, 
								   	formatter: function(cell) { return <div style="text-align:center;background-color: #DCDCDC; padding: 10px;font-size: 15px;">${cell.getValue()}</div>; } },
								  */
								 
									 {
								       title: "Labor Rate",
								       field: "laborRate",
								       hozAlign: "right",
								       width: 120,
								       formatter: function(cell) {
								           return `<div style="text-align:center; background-color: #DCDCDC; padding: 10px; font-size: 15px;">$ ${cell.getValue()}</div>`;
								       }
								   },

								   
								{ title: "Number of Cavities", field: "numberOfCavities", hozAlign: "right", width: 170, 
								  formatter: function(cell) { return `<div style="text-align:center;background-color: #DCDCDC; padding: 10px;font-size: 15px;">${cell.getValue()}</div>`; } },
								  
								{ title: "Cycle Time <br> (In Seconds)", field: "cycleTime", hozAlign: "right", width: 120, 
								  formatter: function(cell) { return `<div style="text-align:center;background-color: #DCDCDC; padding: 10px;font-size: 15px;">${cell.getValue()}</div>`; } },
													  
								{ title: "Purchased Components <br>Cost Per Part", field: "purchaseComponentCostPart", editor: "number", hozAlign: "right", width: 200, 
								            formatter: function(cell) { return `<div style="font-size: 15px;text-align:center; padding: 10px;">${cell.getValue()}</div>`; } },

								          { title: "Description of Secondary <br>Operation and or<br> External Process", field: "secondaryOperationExternalProcess", editor: "input", width: 240, 
								            formatter: function(cell) { return `<div style="font-size: 15px;text-align:center; padding: 10px;">${cell.getValue()}</div>`; } },

								          { title: "Secondary Operation Labor<br> Rate per hour", field: "secondaryOperationLaborRate", editor: "number", hozAlign: "right", width: 200, 
								            formatter: function(cell) { return `<div style="font-size: 15px;text-align:center; padding: 10px;">${cell.getValue()}</div>`; } },

								          { title: "Secondary Operation <br>Machine Rate per hour", field: "secondaryOperationMachineRate", hozAlign: "right", width: 200, 
								            formatter: function(cell) { return `<div style="font-size: 15px;background-color: #DCDCDC; padding: 10px;text-align:center;">${cell.getValue()}</div>`; } },

								          { title: "Secondary Operation<br> Cycle Time (Second)", field: "secondaryOperationCycleTime", hozAlign: "right", width: 220, 
								            formatter: function(cell) { return `<div style="font-size: 15px;background-color: #DCDCDC; padding: 10px;text-align:center;">${cell.getValue()}</div>`; } },

								          { title: "External Operations <br>Rate Per Part", field: "externalOperationRate", editor: "number", hozAlign: "right", width: 200, 
								             formatter: function(cell) { return `<div style="font-size: 15px;text-align:center; padding: 10px;">${cell.getValue()}</div>`; } },

								          { title: "Preventative Maintenance<br> Frequency", field: "preventativeMaintenanceFrequency", width: 200, 
								             formatter: function(cell) { return `<div style="font-size: 15px;background-color: #DCDCDC; padding: 10px;text-align:center;">${cell.getValue()}</div>`; } },

								          { title: "Preventative Maintenance <br> Cost", field: "preventativeMaintenanceCost", editor: "number", hozAlign: "right", width: 220, 
								             formatter: function(cell) { return `<div style="font-size: 15px;text-align:center; padding: 10px;">${cell.getValue()}</div>`; } },

								         /* { title: "Target Profit", field: "targetProfit", hozAlign: "right", width: 180, 
								             formatter: function(cell) { return `<div style="font-size: 15px;text-align:center; padding: 10px;">${cell.getValue()}</div>`; } },
										  */
											{
											    title: "Target Profit",
											    field: "targetProfit",
											    hozAlign: "right",
											    width: 180,
											    formatter: function(cell) {
													return `<div style="font-size: 15px; text-align:center; padding: 10px; display: flex; justify-content: center; align-items: center;">
																														                      ${cell.getValue()}% 
																														                      <span style="margin-left: 5px; font-size: 18px; cursor: pointer;">&#9662;</span>  <!-- Downward arrow icon -->
																														                  </div>`;												    },
											    editor: "select",  // This turns the editor into a dropdown
											    editorParams: {
											        values: [
											            {value: "10", label: "10%"},
											            {value: "20", label: "20%"},
											            {value: "30", label: "30%"},
											            {value: "40", label: "40%"},
											            {value: "50", label: "50%"}
											        ]
											    }
											},

								         /* { title: "Target Material Markup <br>(leave blank if 0 markup)", field: "targetMaterialMarkup", editor: "number", hozAlign: "right", width: 200, 
								            formatter: function(cell) { return `<div style="font-size: 15px;text-align:center; padding: 10px;">${cell.getValue()}</div>`; } },
											*/
											{
											    title: "Target Material Markup <br>(leave blank if 0 markup)",
											    field: "targetMaterialMarkup",
											    hozAlign: "right",
											    width: 200,
											    formatter: function(cell) {
													return `<div style="font-size: 15px; text-align:center; padding: 10px; display: flex; justify-content: center; align-items: center;">
																														                      ${cell.getValue()}% 
																														                      <span style="margin-left: 5px; font-size: 18px; cursor: pointer;">&#9662;</span>  <!-- Downward arrow icon -->
																														                  </div>`;												    },
											    editor: "select",  // This turns the editor into a dropdown
											    editorParams: {
											        values: [
											            {value: "0", label: "0% (No markup)"},
											            {value: "5", label: "5%"},
											            {value: "10", label: "10%"},
											            {value: "15", label: "15%"},
											            {value: "20", label: "20%"},
											            {value: "25", label: "25%"}
											        ]
											    }
											},


								          { title: "Actual Material Cost", field: "actualMaterialCost", editor: "number", hozAlign: "right", width: 250, 
								             formatter: function(cell) { return `<div style="font-size: 15px;text-align:center; padding: 10px;">${cell.getValue()}</div>`; } },
								      ]
		    });

		    // Listen for edits in the table
		    table.on("cellEdited", function (cell) {
		        let row = cell.getRow().getData();
		        console.log("Input table Cell Edited:", cell.getField(), "New Value:", cell.getValue());
		        saveEditedRow(row);
		    });

			// Event to update Labor Rate when FTE changes
			 table.on("cellEdited", function (cell) {
				// Check if the edited column is "fte"
				  if (cell.getColumn().getField() === "fte") {
				      const fteValue = parseFloat(cell.getValue());  // Convert the FTE value to a float
				      const laborRateValue = fteValue * 24;  // Each FTE = 24

				      // Update the laborRate field
				      const row = cell.getRow();
				      row.update({
				          laborRate: laborRateValue.toFixed(2)  // Ensure the labor rate is displayed with two decimal points
				      });
				  }
			 });
			 
			// fetch input table data ===
		    $.ajax({
		        url: `/rev-aux/api/nt-quote-customer-input-output/getCalculationInputOutputData/${id}`,
		        type: "GET",
		        beforeSend: function (request) {
		            const token = localStorage.getItem("token");
		            request.setRequestHeader("Authorization", token);
		        },
		        success: function (response) {
		            console.log("Data received:", response);
		            table.setData(Array.isArray(response) ? response : [response]);
		        },
		        error: function (xhr, status, error) {
		            console.error("Error fetching Input details:", error);
		        }
		    });
			
			// fetch Srap rate data ===
			let scrapRateOptions = [];  // Global variable to store dropdown values

			function fetchScrapRateOptions() {
			    $.ajax({
			        url: `/rev-aux/api/quoteScrapRate/getQuoteScrapRateData`,
			        type: "GET",
			        beforeSend: function (request) {
			            const token = localStorage.getItem("token");
			            request.setRequestHeader("Authorization", token);
			        },
			        success: function (response) {
			            console.log("Scrap Rate Options received:", response);

			            // Extract unique values for dropdown
			            scrapRateOptions = [...new Set(response.map(item => item.scrapRate))] // Remove duplicates
			                .map(rate => ({
			                    value: rate.replace('%', ''),  // Remove '%' if needed
			                    label: rate
			                }));

			            console.log("Formatted Scrap Rate Dropdown Options:", scrapRateOptions);
			            
			            // Refresh table column definitions to apply new dropdown values
			            table.setColumns(table.getColumns().map(col => col.getDefinition()));
			        },
			        error: function (xhr, status, error) {
			            console.error("Error fetching Scrap Rate options:", error);
			        }
			    });
			}

			// Fetch dropdown values when the page loads
			fetchScrapRateOptions();


         // machine efficiency
		 let machineEfficiencyOptions = []; // Global variable for dropdown values

		 function fetchMachineEfficiencyOptions() {
		     $.ajax({
		         url: `/rev-aux/api/quoteMachineEfficiency/getMachineEfficiencyData`, // Update with correct API URL
		         type: "GET",
		         beforeSend: function (request) {
		             const token = localStorage.getItem("token");
		             request.setRequestHeader("Authorization", token);
		         },
		         success: function (response) {
		             console.log("✅ Machine Efficiency Data received:", response);

		             // Extract unique values for dropdown
		             machineEfficiencyOptions = [...new Set(response.map(item => item.machineEfficiency))] // Remove duplicates
		                 .map(efficiency => ({
		                     value: efficiency.replace('%', ''), // Remove '%' if needed
		                     label: efficiency
		                 }));

		             console.log("📌 Formatted Machine Efficiency Dropdown Options:", machineEfficiencyOptions);
		             
		             // Refresh table column definitions to apply new dropdown values
		             table.setColumns(table.getColumns().map(col => col.getDefinition()));
		         },
		         error: function (xhr, status, error) {
		             console.error("❌ Error fetching Machine Efficiency options:", error);
		         }
		     });
		 }

		 // Fetch Machine Efficiency dropdown values when the page loads
		 fetchMachineEfficiencyOptions();
		
						
		});

	// Save inputable fields  data
		function saveEditedRow(row) {
		    console.log("Saving Input table row data :", row);
		    $.ajax({
		        url: `/rev-aux/api/nt-quote-customer-input-output/saveCalculationInputOutputData/${row.id}`,
		        type: "PUT",
		        contentType: "application/json",
		        data: JSON.stringify(row),
		        beforeSend: function (request) {
		            const token = localStorage.getItem("token");
		            request.setRequestHeader("Authorization", token);
		        },
		        success: function (response) {
		            console.log(`Data for ID ${row.id} saved successfully!`, response);
		        },
		        error: function (xhr, status, error) {
		            console.error(`Error saving data for ID ${row.id}:`, error);
		        }
		    });
		}
	
//=========================================================== Calculation Input table code end here ==========================================================
//===========================================Calculation Output table code start ===============================================

//<!--Calculation Output Data Feb 3 -->
		//let table2;
		  $(document).ready(function () {
		      // Extract query parameters from the URL
		      const urlParams = new URLSearchParams(window.location.search);
		      const id = urlParams.get('id'); // Get the ID from the URL
		      if (!id) {
		          alert("Missing ID in the URL!");
		          return;
		      }
		      table2 = new Tabulator("#calculationOutputData", {
			       layout: "fitColumns",
			       responsiveLayout: "collapse",
			       autoResize: true,
			       rowHeight: 50,  // Increased row height
			       headerVertical: true,  // Allow header text wrapping
			       columns: [
				   { title: "Id", field: "id", hozAlign: "center", width: 100, visible: false},    
				   { title: "Sr No.", field: "srNo", hozAlign: "center", width: 100, 
			             formatter: function(cell) { return `<div style="font-size: 15px; background-color: #DCDCDC; padding: 10px; text-align:center;">${cell.getValue()}</div>`; } 
			           },

			           { title: "Part Name", field: "materialDescription", width: 260, 
			             formatter: function(cell) { return `<div style="font-size: 15px;background-color: #DCDCDC; padding: 10px; text-align:center;">${cell.getValue()}</div>`; } 
			           },

			           { title: "Part Number", field: "partNumber", width: 200, 
			             formatter: function(cell) { return `<div style="font-size: 15px;background-color: #DCDCDC; padding: 10px; text-align:center;">${cell.getValue()}</div>`; } 
			           },

					   /*{ 
					       title: "Parts Per Hour", 
					       field: "partPerHours", 
					       width: 200, 
					       tooltip: "Formula: (3600 / Cycle Time) * (Machine Efficiency / 100) * Number of Cavities",
					       mutator: function(value, data) { 
					           let cycleTime = parseFloat(data.cycleTime) || 1; // Prevent division by zero
					           let machineEfficiency = (parseFloat(data.machineEfficiency) || 0) / 100; // Convert % to decimal
					           let numberOfCavities = parseFloat(data.numberOfCavities) || 0;
					           // Apply formula: (3600 / Cycle Time) * (Machine Efficiency / 100) * Number of Cavities
							   console.log(`cycleTime: ${cycleTime}`);
							   console.log(`machineEfficiency: ${machineEfficiency}`);
							   console.log(`numberOfCavities: ${numberOfCavities}`);
					           return ((3600 / cycleTime) * machineEfficiency * numberOfCavities).toFixed(0);
					       },
					       formatter: function(cell) { 
					           // Format value with commas
					           let formattedValue = parseInt(cell.getValue()).toLocaleString("en-US");
					           return `<div style="font-size: 15px; background-color: #DCDCDC; padding: 10px; text-align:center;">${formattedValue}</div>`; 
					       } 
					   },*/
					   {
					       title: "Parts Per Hour", 
					       field: "partPerHours", 
					       width: 200, 
					       tooltip: "Formula: (3600 / Cycle Time) * (Machine Efficiency / 100) * Number of Cavities",
					       mutator: function(value, data) { 
					           let cycleTime = parseFloat(data.cycleTime) || 1; // Prevent division by zero
					           let machineEfficiency = (parseFloat(data.machineEfficiency) || 0) / 100; // Convert % to decimal
					           let numberOfCavities = parseFloat(data.numberOfCavities) || 0;
					           // Apply formula: (3600 / Cycle Time) * (Machine Efficiency / 100) * Number of Cavities
						          // console.log(`cycleTime: ${cycleTime}`);
						          // console.log(`machineEfficiency: ${machineEfficiency}`);
						          // console.log(`numberOfCavities: ${numberOfCavities}`);
						        return ((3600 / cycleTime) * machineEfficiency * numberOfCavities).toFixed(0);  // Return as integer (rounded)
					       },
					       formatter: function(cell) { 
					           // Format value with commas
					           let formattedValue = parseInt(cell.getValue()).toLocaleString("en-US");
					           return `<div style="font-size: 15px; background-color: #DCDCDC; padding: 10px; text-align:center;">${formattedValue}</div>`; 
					       } 
					   },

					   { 
					       title: "Estimated Lot Size", 
					       field: "estLotSize", 
					       width: 218, 
					       tooltip: "Formula: Estimated Annual Volume / Estimated Production Run Years",
					       mutator: function(value, data) { 
					           let estAnnualVolume = parseFloat(data.estAnnualVolume) || 0;
					           let estProductionRunYrs = parseFloat(data.estProductionRunYrs) || 1; // Prevent division by zero

							 //  console.log(`estAnnualVolume: ${estAnnualVolume}`);
							  // console.log(`estProductionRunYrs: ${estProductionRunYrs}`);
							   
					           // Apply formula: Estimated Lot Size = Estimated Annual Volume / Estimated Production Run Years
					           return (estAnnualVolume / estProductionRunYrs).toFixed(0);
					       },
					       formatter: function(cell) { 
					           // Format value with commas
					           let formattedValue = parseInt(cell.getValue()).toLocaleString("en-US");
					           return `<div style="background-color: #DCDCDC; padding: 10px; text-align:center;">${formattedValue}</div>`; 
					       } 
					   },

			           { title: "Setup Hours", field: "setupHours", hozAlign: "right", width: 200, 
			             formatter: function(cell) { return `<div style="font-size: 15px;background-color: #DCDCDC; padding: 10px; text-align:center;">${cell.getValue()}</div>`; } 
			           },
   
					   {
					       title: "Setup Cost <br>Per Part", 
					       field: "setupCost", 
					       hozAlign: "right", 
					       width: 180, 
					       tooltip: "Formula: (((Extended Material Cost Per Part * Parts Per Hour * 0.5) + (Machine Rate * Setup Hours) + (25 * Setup Hours)) * Estimated Production Run per Year / Estimated Annual Volume)",
					       mutator: function(value, data) { 
					          // console.log("Row Data Before Calculation:", data);  // Log entire row data

					           // Fetch the latest Extended Material Cost dynamically
					           let materialCostLb = parseFloat(data.materialCostLb) || 0;
					           let partWeightLb = parseFloat(data.partWeightLb) || 0;
					           let runnerWeightLb = parseFloat(data.runnerWeightLb) || 0;
					           let extendedMaterialCostPer = (materialCostLb * (partWeightLb + runnerWeightLb)).toFixed(2); 

					           // Use the dynamically computed value instead of stale `data.extendedMaterialCostPer`
					           let partPerHours = parseFloat(data.partPerHours) || 1; // Prevent division by zero
					           let machineRate = parseFloat(data.machineRate) || 0;
					           let setupHours = parseFloat(data.setupHours) || 0;
					           let estProductionRunYrs = parseFloat(data.estProductionRunYrs) || 0;
					           let estAnnualVolume = parseFloat(data.estAnnualVolume) || 1; // Prevent division by zero

					          // console.log(`Updated extendedMaterialCostPer in setupCost: ${extendedMaterialCostPer}`);
							//   console.log(`partPerHours: ${partPerHours}`);
							     //  console.log(`machineRate: ${machineRate}`);
							    //   console.log(`setupHours: ${setupHours}`);
							    //   console.log(`estProductionRunYrs: ${estProductionRunYrs}`);
							     //  console.log(`estAnnualVolume: ${estAnnualVolume}`);

					           let setupCost = (((extendedMaterialCostPer * partPerHours * 0.5) + 
					                             (machineRate * setupHours) + 
					                             (25 * setupHours)) * 
					                             estProductionRunYrs / estAnnualVolume);

					          // console.log(`Computed Setup Cost: ${setupCost}`);

					           return setupCost.toFixed(2);
					       },
					       formatter: function(cell) { 
					           let formattedValue = parseFloat(cell.getValue()).toLocaleString("en-US", {
					               minimumFractionDigits: 2,
					               maximumFractionDigits: 2
					           });

					           return `<div style="font-size: 15px; background-color: #DCDCDC; padding: 10px; text-align:center;">$ ${formattedValue}</div>`; 
					       } 
					   },

					   
					   { 
					       title: "Preventive Maintenance<br> Costs", 
					       field: "preventativeMaintenanceCost", 
					       hozAlign: "right", 
					       width: 200, 
					       tooltip: "Formula: (Preventative Maintenance Frequency * Preventative Maintenance Cost) / Estimated Annual Volume",
					       mutator: function(value, data) {
							
							  // console.log("Row Data Before Calculation:", data);  // Log entire row data 
							   
					           let preventativeMaintenanceFrequency = parseFloat(data.preventativeMaintenanceFrequency) || 0;
					           let preventativeMaintenanceCost = parseFloat(data.preventativeMaintenanceCost) || 0;
					           let estAnnualVolume = parseFloat(data.estAnnualVolume) || 1; // Prevent division by zero

					           let result = (preventativeMaintenanceCost * preventativeMaintenanceFrequency) / estAnnualVolume;
							   
							   //console.log(`preventativeMaintenanceFrequency: ${preventativeMaintenanceFrequency}`);
							 //  console.log(`preventativeMaintenanceCost: ${preventativeMaintenanceCost}`);
							   //console.log(`estAnnualVolume: ${estAnnualVolume}`);
							  // console.log(`Computed preventative Maintenance Cost result: ${result}`);
							   
					           return Math.round(result); // Convert decimal to the nearest integer
					       },
					       formatter: function(cell) { 
					           // Format value with commas
					           let formattedValue = parseInt(cell.getValue()).toLocaleString("en-US");

					           return `<div style="font-size: 15px; background-color: #DCDCDC; padding: 10px; text-align:center;">$ ${formattedValue}</div>`; 
					       } 
					   },

					   { 
					       title: "Secondary Operation and<br> External Process", 
					       field: "secondaryOperationExternalProcess", 
					       hozAlign: "right", 
					       width: 200, 
					       tooltip: "Formula: (((Secondary Operation Labor Rate per hour + Secondary Operation Machine Rate per hour) * Secondary Operation Cycle Time) / 60 / 60)",
					       mutator: function(value, data) { 
					           let secondaryOperationLaborRate = parseFloat(data.secondaryOperationLaborRate) || 0;
					           let secondaryOperationMachineRate = parseFloat(data.secondaryOperationMachineRate) || 0;
					           let secondaryOperationCycleTime = parseFloat(data.secondaryOperationCycleTime) || 0;

					           let result = (((secondaryOperationLaborRate + secondaryOperationMachineRate) * secondaryOperationCycleTime) / 60 / 60);
					          
							   //console.log(`secondaryOperationLaborRate: ${secondaryOperationLaborRate}`);
							   //console.log(`secondaryOperationMachineRate : ${secondaryOperationMachineRate}`);
							   //console.log(`secondaryOperationCycleTime : ${secondaryOperationCycleTime}`);
							   //console.log(`Computed Secondary Operation and External Process = ${result}`);
							   
							    return result.toFixed(2); // Round to 2 decimal places
					       },
						   formatter: function(cell) { 
						           // Format value with commas
						           let formattedValue = parseFloat(cell.getValue()).toLocaleString("en-US", {
						               minimumFractionDigits: 2,
						               maximumFractionDigits: 2
						           });
						           return `<div style="font-size: 15px; background-color: #DCDCDC; padding: 10px; text-align:center;">$ ${formattedValue}</div>`; 
						       } 
					   },
					   { 
					       title: "External Operation <br>Cost per part", 
					       field: "externalOperationCostPer", 
					       hozAlign: "right", 
					       width: 200, 
					       tooltip: "Formula: Directly fetched from External Operation Rate per part field",
					       mutator: function(value, data) { 
					           let externalOperationRate = parseFloat(data.externalOperationRate) || 0;
							   //console.log(`External Operation Cost per part : ${externalOperationRate}`);
					           return externalOperationRate.toFixed(2); // Round to 2 decimal places
					       },
					       formatter: function(cell) { 
					           // Format value with commas
					           let formattedValue = parseFloat(cell.getValue()).toLocaleString("en-US", {
					               minimumFractionDigits: 2,
					               maximumFractionDigits: 2
					           });
					           return `<div style="font-size: 15px; background-color: #DCDCDC; padding: 10px; text-align:center;">${formattedValue}</div>`; 
					       } 
					   },
					   { 
					       title: "Extended Machine<br> Cost per part", 
					       field: "extendedMachineCostPerPart", 
					       hozAlign: "right", 
					       width: 200, 
					       tooltip: "Formula: Machine Rate * (1 / Parts Per Hour)",
					       mutator: function(value, data) { 
					           let machineRate = parseFloat(data.machineRate) || 0;
					           let partPerHours = parseFloat(data.partPerHours) || 1; // Prevent division by zero
					           let extendedMachineCostPerPart = machineRate * (1 / partPerHours);
							  // console.log(`machineRate : ${machineRate}`);
							  // console.log(`partPerHours : ${partPerHours}`);
							  // console.log(`Extended Machine Cost per part: ${extendedMachineCostPerPart}`);
					           return extendedMachineCostPerPart.toFixed(2); // Round to 2 decimal places
					       },
					       formatter: function(cell) { 
					           let formattedValue = parseFloat(cell.getValue()).toLocaleString("en-US", {
					               minimumFractionDigits: 2,
					               maximumFractionDigits: 2
					           });

					           return `<div style="font-size: 15px; background-color: #DCDCDC; padding: 10px; text-align:center;">$ ${formattedValue}</div>`; 
					       } 
					   },

					   { 
					       title: "Extended Labor <br>Cost per part", 
					       field: "extendedLaborCostPer", 
					       hozAlign: "right", 
					       width: 200, 
					       tooltip: "Formula: Labor Rate * (1 / Parts Per Hour)",
					       mutator: function(value, data) { 
					           let laborRate = parseFloat(data.laborRate) || 0;
					           let partPerHours = parseFloat(data.partPerHours) || 1; // Prevent division by zero
					           let extendedLaborCostPer = laborRate * (1 / partPerHours);
							   //console.log(`laborRate : ${laborRate}`);
							   //console.log(`partPerHours : ${partPerHours}`);
							   //console.log(`Extended Labor Cost per part: ${extendedLaborCostPer}`);
							   
					           return extendedLaborCostPer.toFixed(2); // Round to 2 decimal places
					       },
					       formatter: function(cell) { 
					           let formattedValue = parseFloat(cell.getValue()).toLocaleString("en-US", {
					               minimumFractionDigits: 2,
					               maximumFractionDigits: 2
					           });

					           return `<div style="font-size: 15px; background-color: #DCDCDC; padding: 10px; text-align:center;">$ ${formattedValue}</div>`; 
					       } 
					   },

					  /* { 
					       title: "Extended Materials <br>Cost per part <br>including overhead", 
					       field: "extendedMaterialCostPer",  
					       hozAlign: "right", 
					       width: 150, 
					       tooltip: "Formula: Material Cost ($/Lb) * (Part Weight in lb + Runner Weight in lb)",
					       mutator: function(value, data) { 
					           let materialCostLb = parseFloat(data.materialCostLb) || 0;
					           let partWeightLb = parseFloat(data.partWeightLb) || 0;
					           let runnerWeightLb = parseFloat(data.runnerWeightLb) || 0;
					           let extendedMaterialCostPer = materialCostLb * (partWeightLb + runnerWeightLb);
					           return extendedMaterialCostPer.toFixed(2); // Round to 2 decimal places
					       },
					       formatter: function(cell) { 
					           let formattedValue = parseFloat(cell.getValue()).toLocaleString("en-US", {
					               minimumFractionDigits: 2,
					               maximumFractionDigits: 2
					           });

					           return `<div style="font-size: 15px; background-color: #DCDCDC; text-align:center; padding: 10px;">${formattedValue}</div>`; 
					       } 
					   },*/
					   { 
					       title: "Extended Materials <br>Cost per part <br>including overhead", 
					       field: "extendedMaterialCostPer",  
					       hozAlign: "right", 
					       width: 150, 
					       tooltip: "Formula: Material Cost ($/Lb) * (Part Weight in lb + Runner Weight in lb)",
					       mutator: function(value, data) { 
					           let materialCostLb = parseFloat(data.materialCostLb) || 0;
					           let partWeightLb = parseFloat(data.partWeightLb) || 0;
					           let runnerWeightLb = parseFloat(data.runnerWeightLb) || 0;
					           
					           let extendedMaterialCostPer = materialCostLb * (partWeightLb + runnerWeightLb);
					           
					           //  Save the computed value back to data object
					           data.extendedMaterialCostPer = extendedMaterialCostPer;
							   //console.log(`Updated extendedMaterialCostPer in data: ${data.extendedMaterialCostPer.toFixed(2)}`);
							   //console.log(`materialCostLb : ${materialCostLb}`);
							   //console.log(`partWeightLb : ${partWeightLb}`);
							   //console.log(`runnerWeightLb : ${runnerWeightLb}`);
							   //console.log(`Calculated Extended Materials Cost per part <br>including overhead : ${extendedMaterialCostPer}`);
							   
					           return extendedMaterialCostPer.toFixed(2); // Round to 2 decimal places
					       },
					       formatter: function(cell) { 
					           let formattedValue = parseFloat(cell.getValue()).toLocaleString("en-US", {
					               minimumFractionDigits: 2,
					               maximumFractionDigits: 2
					           });

					           return `<div style="font-size: 15px; background-color: #DCDCDC; text-align:center; padding: 10px;">$ ${formattedValue}</div>`; 
					       } 
					   },


					   { 
					       title: "Purchased Component Cost", 
					       field: "purchaseComponentCostPart",  
					       hozAlign: "right", 
					       width: 150, 
					       tooltip: "Formula: Directly fetched from purchaseComponentCostPart field",
					       mutator: function(value, data) { 
					           let purchaseComponentCostPart = parseFloat(data.purchaseComponentCostPart) || 0;
							   //console.log(`Calculated purchaseComponentCostPart : ${purchaseComponentCostPart}`);
					           return purchaseComponentCostPart.toFixed(2); // Round to 2 decimal places
					       },
					       formatter: function(cell) { 
					           let formattedValue = parseFloat(cell.getValue()).toLocaleString("en-US", {
					               minimumFractionDigits: 2,
					               maximumFractionDigits: 2
					           });

					           return `<div style="font-size: 15px; background-color: #DCDCDC; text-align:center; padding: 10px;">${formattedValue}</div>`; 
					       } 
					   },

		   
			           { title: "Pack. & Logistics<br> Cost Per Part", field: "packLogisticCostPer", editor: "number", hozAlign: "right", width: 150, 
			             formatter: function(cell) { return `<div style="font-size: 15px;text-align:center; padding: 10px;">${cell.getValue()}</div>`; } 
			           },

					   { 
					       title: "Total Production Cost", 
					       field: "totalProductionCost",  
					       hozAlign: "right", 
					       width: 150, 
					       tooltip: "Formula: Setup Cost per part + Preventative Maintenance Cost + Secondary Operation & External Process + External Operation Cost Per part + Extended Machine Cost Per Part + Extended Labor Cost Per Part",
					       mutator: function(value, data) { 
					           let setupCost = parseFloat(data.setupCost) || 0;
					           let preventativeMaintenanceCost = parseFloat(data.preventativeMaintenanceCost) || 0;
					           let secondaryOperationExternalProcess = parseFloat(data.secondaryOperationExternalProcess) || 0;
					           let externalOperationCostPer = parseFloat(data.externalOperationCostPer) || 0;
					           let extendedMachineCostPerPart = parseFloat(data.extendedMachineCostPerPart) || 0;
					           let extendedLaborCostPer = parseFloat(data.extendedLaborCostPer) || 0;

					           let totalProductionCost = setupCost + preventativeMaintenanceCost + 
					                                     secondaryOperationExternalProcess + externalOperationCostPer + 
					                                     extendedMachineCostPerPart + extendedLaborCostPer;

														 //console.log(`setupCost : ${setupCost}`);
														 //console.log(`preventativeMaintenanceCost : ${preventativeMaintenanceCost}`);
														 //console.log(`secondaryOperationExternalProcess : ${secondaryOperationExternalProcess}`);
														 //console.log(`externalOperationCostPer : ${externalOperationCostPer}`);
														 //console.log(`extendedMachineCostPerPart : ${extendedMachineCostPerPart}`);
														 //console.log(` extendedLaborCostPer : ${extendedLaborCostPer}`);
														 //console.log(`Calculated totalProductionCost : ${totalProductionCost}`);
														 
					           return totalProductionCost.toFixed(2); // Round to 2 decimal places
					       },
					       formatter: function(cell) { 
					           let formattedValue = parseFloat(cell.getValue()).toLocaleString("en-US", {
					               minimumFractionDigits: 2,
					               maximumFractionDigits: 2
					           });

					           return `<div style="font-size: 15px; background-color: #DCDCDC; text-align:center; padding: 10px;">$ ${formattedValue}</div>`; 
					       } 
					   },

					   { 
					       title: "Total Material <br>Cost including <br>purchased components", 
					       field: "totalMaterialCost",  
					       hozAlign: "right", 
					       width: 250, 
					       tooltip: "Formula: Extended Material Cost Per part including overhead + Purchased Component Cost",
					       mutator: function(value, data) { 
					           let extendedMaterialCostPer = parseFloat(data.extendedMaterialCostPer) || 0;
					           let purchaseComponentCostPart = parseFloat(data.purchaseComponentCostPart) || 0;
					           let totalMaterialCost = extendedMaterialCostPer + purchaseComponentCostPart;
							
							   //console.log(`extendedMaterialCostPer : ${extendedMaterialCostPer}`);
							   //console.log(`purchaseComponentCostPart : ${purchaseComponentCostPart}`);
							   //console.log(`Calculated totalMaterialCost : ${totalMaterialCost}`);
							   
					           return totalMaterialCost.toFixed(2); // Round to 2 decimal places
					       },
					       formatter: function(cell) { 
					           let formattedValue = parseFloat(cell.getValue()).toLocaleString("en-US", {
					               minimumFractionDigits: 2,
					               maximumFractionDigits: 2
					           });

					           return `<div style="font-size: 15px; background-color: #DCDCDC; text-align:center; padding: 10px;">$ ${formattedValue}</div>`; 
					       } 
					   },


					   { 
					       title: "Total Cost Prior <br>to SG&A & Profit", 
					       field: "totalCostSgaProfit", 
					       hozAlign: "right", 
					       width: 250, 
					       tooltip: "Formula: (Total Production Cost + Total Material Cost including purchased components + Pack. & Logistic Cost Per part) * (1 + Scrap Rate / 100)",
					       mutator: function(value, data) { 
					           let totalProductionCost = parseFloat(data.totalProductionCost) || 0;
					           let totalMaterialCost = parseFloat(data.totalMaterialCost) || 0;
					           let packLogisticCostPer = parseFloat(data.packLogisticCostPer) || 0;
					           let scrapRate = (parseFloat(data.scrapRate) || 0) / 100; // Convert % to decimal
					           let totalCostSgaProfit = (totalProductionCost + totalMaterialCost + packLogisticCostPer) * (1 + scrapRate);

							   //console.log(`totalProductionCost : ${totalProductionCost}`);
							   //console.log(`totalMaterialCost : ${totalMaterialCost}`);
							   //console.log(`packLogisticCostPer : ${packLogisticCostPer}`);
							  //console.log(`scrapRate : ${scrapRate}`);
							   //console.log(`Calculated totalCostSgaProfit : ${totalCostSgaProfit}`);
							   
					           return totalCostSgaProfit.toFixed(2); // Round to 2 decimal places
					       },
					       formatter: function(cell) { 
					           let formattedValue = parseFloat(cell.getValue()).toLocaleString("en-US", {
					               minimumFractionDigits: 2,
					               maximumFractionDigits: 2
					           });

					           return `<div style="font-size: 15px; background-color: #DCDCDC; text-align:center; padding: 10px;">$ ${formattedValue}</div>`; 
					       } 
					   },
															   								   
			           /*{ title: "SG&A % Rate", field: "sgaRate", editor: "number", hozAlign: "right", width: 250, 
			             formatter: function(cell) { return `<div style="font-size: 15px;text-align:center; padding: 10px;">${cell.getValue()}</div>`; } 
			           },*/
					   {
					       title: "SG&A % Rate",
					       field: "sgaRate",
					       hozAlign: "right",
					       width: 250,
					       formatter: function(cell) {
							return `<div style="font-size: 15px; text-align:center; padding: 10px; display: flex; justify-content: center; align-items: center;">
																								                      ${cell.getValue()}% 
																								                      <span style="margin-left: 5px; font-size: 18px; cursor: pointer;">&#9662;</span>  <!-- Downward arrow icon -->
																								                  </div>`;						       },
					       editor: "select",  // Switch to "select" for dropdown
					       editorParams: {
					           values: [
					               {value: "1", label: "1%"},
					               {value: "5", label: "5%"},
					               {value: "10", label: "10%"},
					               {value: "15", label: "15%"},
					               {value: "20", label: "20%"},
					               {value: "25", label: "25%"},
					               {value: "30", label: "30%"}
					           ]
					       }
					   },

					   { 
					       title: "SG&A $", 
					       field: "sgaCost", 
					       hozAlign: "right", 
					       width: 250, 
					       tooltip: "Formula: Total Cost Prior to SG&A & Profit * (SG&A % Rate / 100)",
					       mutator: function(value, data) { 
					           let totalCostSgaProfit = parseFloat(data.totalCostSgaProfit) || 0;
					           let sgaRate = (parseFloat(data.sgaRate) || 0) / 100; // Convert % to decimal
					           let sgaCost = totalCostSgaProfit * sgaRate;
							   
							  // console.log(`totalCostSgaProfit : ${totalCostSgaProfit}`);
							 //  console.log(`sgaRate : ${sgaRate}`);
							 //  console.log(`Calculated sgaCost : ${sgaCost}`);
							   
					           return sgaCost.toFixed(2); 
					       },
					       formatter: function(cell) { 
					           let formattedValue = parseFloat(cell.getValue()).toLocaleString("en-US", {
					               minimumFractionDigits: 2,
					               maximumFractionDigits: 2
					           });

					           return `<div style="font-size: 15px; background-color: #DCDCDC; text-align:center; padding: 10px;">$ ${formattedValue}</div>`; 
					       } 
					   },

					   { 
					       title: "Profit $", 
					       field: "profit", 
					       hozAlign: "right", 
					       width: 250, 
					       tooltip: "Formula: Target Profit % * Total Cost Prior to SG&A & Profit",
					       mutator: function(value, data) { 
					           let targetProfit = (parseFloat(data.targetProfit) || 0) / 100; // Convert % to decimal
					           let totalCostSgaProfit = parseFloat(data.totalCostSgaProfit) || 0;
					           let profit = targetProfit * totalCostSgaProfit;

							   //console.log(`targetProfit : ${targetProfit}`);
							   //console.log(`totalCostSgaProfit : ${totalCostSgaProfit}`);
							   //console.log(`Calculated profit : ${profit}`);
							   
					           return profit.toFixed(2); 
					       },
					       formatter: function(cell) { 
					           let formattedValue = parseFloat(cell.getValue()).toLocaleString("en-US", {
					               minimumFractionDigits: 2,
					               maximumFractionDigits: 2
					           });

					           return `<div style="font-size: 15px; background-color: #DCDCDC; text-align:center; padding: 10px;">$ ${formattedValue}</div>`; 
					       } 
					   },

					   { 
					       title: "Part Price", 
					       field: "partPrice", 
					       hozAlign: "right", 
					       width: 250, 
					       tooltip: "Formula: (Total Cost Prior to SG&A & Profit + SG&A $ + Profit $) * 1.15",
					       mutator: function(value, data) { 
					           let totalCostSgaProfit = parseFloat(data.totalCostSgaProfit) || 0;
					           let sgaCost = parseFloat(data.sgaCost) || 0;
					           let profit = parseFloat(data.profit) || 0;
					           let partPrice = (totalCostSgaProfit + sgaCost + profit) * 1.15;

							   //console.log(`totalCostSgaProfit : ${totalCostSgaProfit}`);
							   //console.log(`sgaCost : ${sgaCost}`);
							   //console.log(`profit : ${profit}`);
							   //console.log(`Calculated partPrice : ${partPrice}`);
							   
					           return partPrice.toFixed(2); 
					       },
					       formatter: function(cell) { 
					           let formattedValue = parseFloat(cell.getValue()).toLocaleString("en-US", {
					               minimumFractionDigits: 2,
					               maximumFractionDigits: 2
					           });

					           return `<div style="font-size: 15px; background-color: #DCDCDC; text-align:center; padding: 10px;">$ ${formattedValue}</div>`; 
					       } 
					   },

					   { 
					       title: "Total Cost", 
					       field: "totalCost", 
					       hozAlign: "right", 
					       width: 250, 
					       tooltip: "Formula: (Total Material Cost including purchased components + Total Production Cost + Pack. & Logistic Cost Per part) * Estimated Annual Volume",
					       mutator: function(value, data) { 
					           let totalMaterialCost = parseFloat(data.totalMaterialCost) || 0;
					           let totalProductionCost = parseFloat(data.totalProductionCost) || 0;
					           let packLogisticCostPer = parseFloat(data.packLogisticCostPer) || 0;
					           let estAnnualVolume = parseFloat(data.estAnnualVolume) || 1; // Prevent division by zero
					           let totalCost = (totalMaterialCost + totalProductionCost + packLogisticCostPer) * estAnnualVolume;

							   //console.log(`totalMaterialCost : ${totalMaterialCost}`);
							   //console.log(`totalProductionCost : ${totalProductionCost}`);
							   //console.log(`packLogisticCostPer : ${packLogisticCostPer}`);
							   //console.log(`estAnnualVolume : ${estAnnualVolume}`);
							   //console.log(`Calculated totalCost  : ${totalCost}`);
							   
					           return totalCost.toFixed(2); 
					       },
					       formatter: function(cell) { 
					           let formattedValue = parseFloat(cell.getValue()).toLocaleString("en-US", {
					               minimumFractionDigits: 2,
					               maximumFractionDigits: 2
					           });

					           return `<div style="font-size: 15px; background-color: #DCDCDC; text-align:center; padding: 10px;">$ ${formattedValue}</div>`; 
					       } 
					   },

					   { 
					       title: "Total Sales", 
					       field: "totalSales",  
					       hozAlign: "right", 
					       width: 250, 
					       tooltip: "Formula: Part Price * Estimated Annual Volume",
					       mutator: function(value, data) { 
					           let partPrice = parseFloat(data.partPrice) || 0;
					           let estAnnualVolume = parseFloat(data.estAnnualVolume) || 1; // Prevent division by zero
					           let totalSales = partPrice * estAnnualVolume;

							   //console.log(`partPrice  : ${partPrice}`);
							   //console.log(`estAnnualVolume  : ${estAnnualVolume}`);
							   //console.log(`Calculated totalSales  : ${totalSales}`);
					           return totalSales.toFixed(2); 
					       },
					       formatter: function(cell) { 
					           let formattedValue = parseFloat(cell.getValue()).toLocaleString("en-US", {
					               minimumFractionDigits: 2,
					               maximumFractionDigits: 2
					           });

					           return `<div style="font-size: 15px; background-color: #DCDCDC; text-align:center; padding: 10px;">$ ${formattedValue}</div>`; 
					       } 
					   },

					   { 
					       title: "Total Profit", 
					       field: "totalProfit", 
					       hozAlign: "right", 
					       width: 250, 
					       tooltip: "Formula: (Total Sales - Total Cost)",
					       mutator: function(value, data) { 
					           let totalSales = parseFloat(data.totalSales) || 0;
					           let totalCost = parseFloat(data.totalCost) || 0;
					           let totalProfit = totalSales - totalCost;
							   
							  // console.log(`totalSales  : ${totalSales}`);
							 //  console.log(`totalCost  : ${totalCost}`);
							  // console.log(`Calculated totalProfit  : ${totalProfit}`);
							   
					           return totalProfit.toFixed(2); 
					       },
					       formatter: function(cell) { 
					           let formattedValue = parseFloat(cell.getValue()).toLocaleString("en-US", {
					               minimumFractionDigits: 2,
					               maximumFractionDigits: 2
					           });
					           return `<div style="font-size: 15px; background-color: #DCDCDC; text-align:center; padding: 10px;">$ ${formattedValue}</div>`; 
					       } 
					   },

					   { 
					       title: "% Cost Material", 
					       field: "costMaterial", 
					       hozAlign: "right", 
					       width: 250, 
					       tooltip: "Formula: (Extended Materials Cost Per part including overhead / Part Price) * 100",
					       mutator: function(value, data) { 
					           let extendedMaterialCostPer = parseFloat(data.extendedMaterialCostPer) || 0;
					           let partPrice = parseFloat(data.partPrice) || 1; // Prevent division by zero
					           let costMaterial = (extendedMaterialCostPer / partPrice) * 100;
							   
							   //console.log(`extendedMaterialCostPer  : ${extendedMaterialCostPer}`);
							   //console.log(`partPrice  : ${partPrice}`);
							   //console.log(`Calculated costMaterial  : ${costMaterial}`);
							   
					           return costMaterial.toFixed(2); 
					       },
					       formatter: function(cell) { 
					           return `<div style="font-size: 15px; background-color: #DCDCDC; text-align:center; padding: 10px;">${cell.getValue()}%</div>`; 
					       } 
					   },

					   { 
					       title: "Total Contribution<br> Margin $", 
					       field: "totalContributionMargin",  
					       hozAlign: "right", 
					       width: 250, 
					       tooltip: "Formula: (SG&A $ + Profit $ + Material Contribution Margin($)) * Estimated Annual Volume",
					       mutator: function(value, data) { 
					           let sgaCost = parseFloat(data.sgaCost) || 0;
					           let profit = parseFloat(data.profit) || 0;
					           let materialContributionMargin = parseFloat(data.materialContributionMargin) || 0;
					           let estAnnualVolume = parseFloat(data.estAnnualVolume) || 1; // Prevent division by zero

					           let totalContributionMargin = (sgaCost + profit + materialContributionMargin) * estAnnualVolume * 100;

							   //console.log(`sgaCost  : ${sgaCost}`);
							   //console.log(`profit  : ${profit}`);
							   //console.log(`materialContributionMargin  : ${materialContributionMargin}`);
							   //console.log(`estAnnualVolume : ${estAnnualVolume}`);
							   //console.log(`Calculated totalContributionMargin  : ${totalContributionMargin}`);
							   
					           return totalContributionMargin.toFixed(2); 
					       },
					       formatter: function(cell) { 
					           let formattedValue = parseFloat(cell.getValue()).toLocaleString("en-US", {
					               minimumFractionDigits: 2,
					               maximumFractionDigits: 2
					           });
					           return `<div style="font-size: 15px; text-align:center; background-color: #DCDCDC; padding: 10px;">${formattedValue}%</div>`; 
					       } 
					   },

					   { 
					       title: "Contribution Margin %", 
					       field: "contributionMargin", 
					       hozAlign: "right", 
					       width: 250, 
					       tooltip: "Formula: ((SG&A $ + Profit $ + Material Contribution Margin($)) / Part Price) * 100",
					       mutator: function(value, data) { 
					           let sgaCost = parseFloat(data.sgaCost) || 0;
					           let profit = parseFloat(data.profit) || 0;
					           let materialContributionMargin = parseFloat(data.materialContributionMargin) || 0;
					           let partPrice = parseFloat(data.partPrice) || 1; // Prevent division by zero

					           let contributionMargin = ((sgaCost + profit + materialContributionMargin) / partPrice) * 100;

							   //console.log(`sgaCost  : ${sgaCost}`);
							   //console.log(`profit  : ${profit}`);
							   //console.log(`materialContributionMargin : ${materialContributionMargin}`);
							   //console.log(`partPrice  : ${partPrice}`);
							   //console.log(`Calculated contributionMargin  : ${contributionMargin}`);
							   
					           return contributionMargin.toFixed(2); 
					       },
					       formatter: function(cell) { 
					           return `<div style="font-size: 15px; text-align:center; background-color: #DCDCDC; padding: 10px;">${cell.getValue()}%</div>`; 
					       } 
					   },

					   { 
					       title: "Material Contribution<br> Margin ($)", 
					       field: "materialContributionMargin", 
					       hozAlign: "right", 
					       width: 250, 
					       tooltip: "Formula: (Actual Material Cost * (Target Material Markup / 100)) * (Part Weight in lb + Runner Weight in lb)",
					       mutator: function(value, data) { 
					           let actualMaterialCost = parseFloat(data.actualMaterialCost) || 0;
					           let targetMaterialMarkup = (parseFloat(data.targetMaterialMarkup) || 0) / 100; // Convert % to decimal
					           let partWeightLb = parseFloat(data.partWeightLb) || 0;
					           let runnerWeightLb = parseFloat(data.runnerWeightLb) || 0;
					           let materialContributionMargin = (actualMaterialCost * targetMaterialMarkup) * (partWeightLb + runnerWeightLb);

							   //console.log(`actualMaterialCost  : ${actualMaterialCost}`);
							   //console.log(`targetMaterialMarkup  : ${targetMaterialMarkup}`);
							   //console.log(`partWeightLb  : ${partWeightLb}`);
							   //console.log(`runnerWeightLb  : ${runnerWeightLb}`);
							  // console.log(`Calculated materialContributionMargin  : ${materialContributionMargin}`);
							   
					           return materialContributionMargin.toFixed(2); 
					       },
					       formatter: function(cell) { 
					           let formattedValue = parseFloat(cell.getValue()).toLocaleString("en-US", {
					               minimumFractionDigits: 2,
					               maximumFractionDigits: 2
					           });

					           return `<div style="font-size: 15px;text-align:center; background-color: #DCDCDC;padding: 10px;">$ ${formattedValue}</div>`; 
					       } 
					   },
																																																				      
			           { title: "Comments", field: "comments", editor: "input", hozAlign: "right", width: 250, 
			             formatter: function(cell) { return `<div style="font-size: 15px;text-align:center; padding: 10px;">${cell.getValue()}</div>`; } 
			           }
			       ]
			   });

	            // Fetch Data from API and Load into Tabulator
	            $.ajax({
	                url: `/rev-aux/api/nt-quote-customer-input-output/getCalculationInputOutputData/${id}`,
	                type: 'GET',
	                beforeSend: function (request) {
	                    const token = localStorage.getItem('token');
	                    request.setRequestHeader("Authorization", token);
	                    console.log("Authorization Token:", localStorage.getItem('token'));
	                },
	                success: function (response) {
	                    console.log("Data received using Tabulator:", response);
						table2.setData(Array.isArray(response) ? response : [response]); 
	                },
	                error: function (xhr, status, error) {
	                    console.error('Error fetching details:', error);
	                }
	            });	
				
				table.on("cellEdited", function (cell) {
											       let updatedRow = cell.getRow().getData();
											       console.log("Input table Cell Edited:", cell.getField(), "New Value:", cell.getValue());

											       // Call function to update the second table with formulas
											       updateSecondTable(updatedRow);

											       // Save the updated row in the backend
											       saveEditedRow(updatedRow);
											   });
											   

											   table2.on("cellEdited", function (cell) {
											   			       let updatedRow = cell.getRow().getData();
											   			       console.log("Output table Cell Edited:", cell.getField(), "New Value:", cell.getValue());

											   			       // Call function to update the second table with formulas
											   			       updateSecondTable(updatedRow);

											   			       // Save the updated row in the backend
											   			       saveEditedRow(updatedRow);
											   			   });
														   

											  table2.on("cellEdited", function (cell) {
												        let row = cell.getRow().getData();
												        console.log("Cell Edited:", cell.getField(), "New Value:", cell.getValue());
												        saveEditedRow(row);
												    });

									    // Save inputable fields  data
													function saveEditedRow(row) {
													//	alert("--");
													    console.log("Saving output table row data :", row);

													    $.ajax({
													        url: `/rev-aux/api/nt-quote-customer-input-output/saveCalculationInputOutputData/${row.id}`,
													        type: "PUT",
													        contentType: "application/json",
													        data: JSON.stringify(row),
													        beforeSend: function (request) {
													            const token = localStorage.getItem("token");
													            request.setRequestHeader("Authorization", token);
													        },
													        success: function (response) {
													            console.log(`Data for ID ${row.id} saved successfully!`, response);
													        },
													        error: function (xhr, status, error) {
													            console.error(`Error saving data for ID ${row.id}:`, error);
													        }
													    });
													}
							
		
										
			});
			// After enter data in input table it updates the both table values in the database ---------							
										function updateSecondTable(updatedRow) {
														//alert("updateSecondTable = " + updatedRow);
														console.log("updateSecondTable = " + updatedRow);
													    let calculatedRow = { ...updatedRow }; // Clone to avoid mutation issues

														//Parts Per Hour
														calculatedRow.partPerHours = Math.floor((3600 / (parseFloat(updatedRow.cycleTime) || 1)) * 
																							   ((parseFloat(updatedRow.machineEfficiency) || 0) / 100) * 
														                                       (parseFloat(updatedRow.numberOfCavities) || 0));


									                    // Estimated Lot Size
													    calculatedRow.estLotSize = ((parseFloat(updatedRow.estAnnualVolume) || 0) / 
													                               (parseFloat(updatedRow.estProductionRunYrs) || 1)).toFixed(0);
							           
										                // Setup Hours  -- formula want to add here
														
														//Setup Cost Per Part
													    calculatedRow.setupCost = ((((parseFloat(updatedRow.extendedMaterialCostPer) || 0) * 
													                                 (parseFloat(calculatedRow.partPerHours) || 1) * 0.5) +
													                                 ((parseFloat(updatedRow.machineRate) || 0) * 
													                                  (parseFloat(updatedRow.setupHours) || 0)) +
													                                 (25 * (parseFloat(updatedRow.setupHours) || 0))) *
													                                 (parseFloat(updatedRow.estProductionRunYrs) || 0) /
													                                 (parseFloat(updatedRow.estAnnualVolume) || 1)).toFixed(2);

													    // Preventive Maintenance Costs						 
													    calculatedRow.preventativeMaintenanceCost = Math.round(
													        ((parseFloat(updatedRow.preventativeMaintenanceCost) || 0) * 
													        (parseFloat(updatedRow.preventativeMaintenanceFrequency) || 0)) / 
													        (parseFloat(updatedRow.estAnnualVolume) || 1)
													    );

														// Secondary Operation and External Process
													    calculatedRow.secondaryOperationExternalProcess = (((parseFloat(updatedRow.secondaryOperationLaborRate) || 0) + 
													                                                        (parseFloat(updatedRow.secondaryOperationMachineRate) || 0)) * 
													                                                        (parseFloat(updatedRow.secondaryOperationCycleTime) || 0) / 
													                                                        60 / 60).toFixed(2);

														//External Operation Cost per part
													    calculatedRow.externalOperationCostPer = (parseFloat(updatedRow.externalOperationRate) || 0).toFixed(2);

														// Extended Machine Cost per part
													    calculatedRow.extendedMachineCostPerPart = ((parseFloat(updatedRow.machineRate) || 0) * 
													                                               (1 / (parseFloat(calculatedRow.partPerHours) || 1))).toFixed(2);

														// Extended Labor Cost per part
														calculatedRow.extendedLaborCostPer = ((parseFloat(updatedRow.laborRate) || 0) * 
														                                         (1 / (parseFloat(calculatedRow.partPerHours) || 1))).toFixed(2);
														
														// Extended Materials Cost per part including overhead
														calculatedRow.extendedMaterialCostPer = ((parseFloat(updatedRow.materialCostLb) || 0) * 
														                                            ((parseFloat(updatedRow.partWeightLb) || 0) + 
														                                             (parseFloat(updatedRow.runnerWeightLb) || 0))).toFixed(2);

														// Purchased Component Cost
														calculatedRow.purchaseComponentCostPart = (parseFloat(updatedRow.purchaseComponentCostPart) || 0).toFixed(2);

														
														//Pack. & Logistics Cost Per Part
														
														// Total Production Cost
														calculatedRow.totalProductionCost = (parseFloat(calculatedRow.setupCost) + 
														                                         parseFloat(calculatedRow.preventativeMaintenanceCost) + 
														                                         parseFloat(calculatedRow.secondaryOperationExternalProcess) + 
														                                         parseFloat(calculatedRow.externalOperationCostPer) + 
														                                         parseFloat(calculatedRow.extendedMachineCostPerPart) + 
														                                         parseFloat(calculatedRow.extendedLaborCostPer)).toFixed(2);

														// Total Material Cost including purchased components
														calculatedRow.totalMaterialCost = (parseFloat(calculatedRow.extendedMaterialCostPer) + 
														                                       parseFloat(calculatedRow.purchaseComponentCostPart)).toFixed(2);

														
													   // Total Cost Prior to SG&A & Profit
															calculatedRow.totalCostSgaProfit = (
															(parseFloat(calculatedRow.totalProductionCost) + 
															parseFloat(calculatedRow.totalMaterialCost) + 
															(parseFloat(updatedRow.packLogisticCostPer) || 0)) * 
															(1 + ((parseFloat(updatedRow.scrapRate) || 0) / 100))).toFixed(2);

														// SG&A % Rate
														
														// SG&A $						
															calculatedRow.sgaCost = (parseFloat(calculatedRow.totalCostSgaProfit) * 
															  ((parseFloat(updatedRow.sgaRate) || 0) / 100) // Convert % to decimal
															    ).toFixed(2);


														// Profit $							
														 calculatedRow.profit = (((parseFloat(updatedRow.targetProfit) || 0) / 100) * 
																				 parseFloat(calculatedRow.totalCostSgaProfit)).toFixed(2);


														// Part Price
														calculatedRow.partPrice = (parseFloat(calculatedRow.totalCostSgaProfit) + 
														                               parseFloat(calculatedRow.sgaCost) + 
														                               parseFloat(calculatedRow.profit)*1.15).toFixed(2);

														// Total Cost
														calculatedRow.totalCost = ((parseFloat(calculatedRow.totalMaterialCost) + 
														                               parseFloat(calculatedRow.totalProductionCost) + 
														                               (parseFloat(updatedRow.packLogisticCostPer) || 0)) * 
														                               (parseFloat(updatedRow.estAnnualVolume) || 1)).toFixed(2);

														// Total Sales
														calculatedRow.totalSales = (parseFloat(calculatedRow.partPrice) * 
														                                (parseFloat(updatedRow.estAnnualVolume) || 1)).toFixed(2);

														// Total Profit
														calculatedRow.totalProfit = (parseFloat(calculatedRow.totalSales) - 
														                                parseFloat(calculatedRow.totalCost)).toFixed(2);

														// % Cost Material
														calculatedRow.costMaterial = ((parseFloat(calculatedRow.extendedMaterialCostPer) / 
														                                 parseFloat(calculatedRow.partPrice)) * 100).toFixed(2);

														// Total Contribution Margin $
														calculatedRow.totalContributionMargin = ((parseFloat(calculatedRow.sgaCost) + 
														                                              parseFloat(calculatedRow.profit) + 
														                                              parseFloat(updatedRow.materialContributionMargin) || 0) * 
														                                              (parseFloat(updatedRow.estAnnualVolume) || 1)).toFixed(2);

														// Contribution Margin %
														calculatedRow.contributionMargin = (((parseFloat(calculatedRow.sgaCost) + 
														                                         parseFloat(calculatedRow.profit) + 
														                                         parseFloat(updatedRow.materialContributionMargin) || 0) / 
														                                         parseFloat(calculatedRow.partPrice)) * 100).toFixed(2);

														// Material Contribution Margin ($)
															calculatedRow.materialContributionMargin = (
															(parseFloat(updatedRow.actualMaterialCost) || 0) * 
															((parseFloat(updatedRow.targetMaterialMarkup) || 0) / 100) * // Convert % to decimal
															((parseFloat(updatedRow.partWeightLb) || 0) + 
															(parseFloat(updatedRow.runnerWeightLb) || 0))).toFixed(2);


													
														
													    // Update row in the second table
													    let existingRow = table2.getRow(updatedRow.id);
													    if (existingRow) {
													        existingRow.update(calculatedRow);
													    } else {
													        table2.addRow(calculatedRow);
													    }

													    // Save the calculated row to the database
													    saveEditedRow(calculatedRow);
													}
//===========================================Calculation Output table code end here===============================================
	  
						
						
 //<!-- input output table excel- export - code start -->
 document.getElementById("exportToExcel").addEventListener("click", function () {
 	    // Find Tabulator instances
 	    let inputTables = Tabulator.findTable("#calculationInputData");
 	    let outputTables = Tabulator.findTable("#calculationOutputData");

 	    if (!inputTables.length || !outputTables.length) {
 	        alert("Tables not initialized properly!");
 	        return;
 	    }

 	    let inputTable = inputTables[0]; // Get first instance
 	    let outputTable = outputTables[0]; // Get first instance

 	    console.log("Input Table Data:", inputTable.getData());
 	    console.log("Output Table Data:", outputTable.getData());

 	    // Create a new Excel workbook
 	    let wb = XLSX.utils.book_new();

 	    // Function to clean up the column title by removing <br> tags
 	    function cleanColumnTitle(title) {
 	        return title.replace(/<br\s*\/?>/g, ''); // Regex to remove <br> and <br/> tags
 	    }

 	    // Function to ensure symbols (currency, percentage, etc.) are preserved
 	    function formatValue(value, columnTitle) {
 	        if (value === undefined || value === null) return "";

 	        // Format as percentage if column title contains "%" or indicates percentage (like "rate", "efficiency", "target profit", "markup")
 	        if (columnTitle.includes("%") || columnTitle.toLowerCase().includes("rate") || columnTitle.toLowerCase().includes("efficiency") || columnTitle.toLowerCase().includes("target profit") || columnTitle.toLowerCase().includes("markup")) {
 	            return `${parseFloat(value).toFixed(2)}%`;  // Add percentage symbol
 	        }

 	        // Format as FTE if column contains "FTE"
 	        if (columnTitle.includes("FTE")) {
 	            return `${parseFloat(value).toFixed(2)} FTE`;  // Append "FTE" to the value
 	        }

 	        // For other columns, return the value without formatting (no percentage or FTE symbol)
 	        return value;
 	    }

 	    // Function to process data and exclude the "id" column
 	    function processDataForExcel(data, columns) {
 	        let filteredColumns = columns.filter(col => col.field !== "id"); // Remove ID column
 	        let headers = filteredColumns.map(col => cleanColumnTitle(col.title));  // Clean column titles by removing <br> tags
 	        
 	        let formattedData = data.map(row => 
 	            filteredColumns.map(col => formatValue(row[col.field], col.title))
 	        );

 	        return { headers, formattedData };
 	    }

 	    // Function to merge tables vertically with a gap
 	    function mergeTablesWithGap(inputData, inputColumns, outputData, outputColumns, gapRows = 5) {
 	        let mergedData = [];

 	        // Process input and output data
 	        let { headers: inputHeaders, formattedData: inputFormattedData } = processDataForExcel(inputData, inputColumns);
 	        let { headers: outputHeaders, formattedData: outputFormattedData } = processDataForExcel(outputData, outputColumns);

 	        // Add Input Table Heading
 	        mergedData.push(["Calculation Input Table"]); 
 	        mergedData.push(inputHeaders); // Add column headers for input table
 	        mergedData = mergedData.concat(inputFormattedData); // Add input table data

 	        // Add empty rows for spacing
 	        for (let i = 0; i < gapRows; i++) {
 	            mergedData.push([]);
 	        }

 	        // Add Output Table Heading
 	        mergedData.push(["Calculation Output Table"]); 
 	        mergedData.push(outputHeaders); // Add column headers for output table
 	        mergedData = mergedData.concat(outputFormattedData); // Add output table data

 	        return mergedData;
 	    }

 	    // Get Data and Column Definitions from Tabulator Tables
 	    let inputData = inputTable.getData();
 	    let inputColumns = inputTable.getColumns().map(col => col.getDefinition());

 	    let outputData = outputTable.getData();
 	    let outputColumns = outputTable.getColumns().map(col => col.getDefinition());

 	    if (inputData.length === 0 && outputData.length === 0) {
 	        alert("Both tables are empty! No data to export.");
 	        return;
 	    }

 	    // Merge both tables with a vertical gap
 	    let finalData = mergeTablesWithGap(inputData, inputColumns, outputData, outputColumns, 5);

 	    // Convert merged data to an Excel sheet
 	    let ws = XLSX.utils.aoa_to_sheet(finalData);

 	    // **Auto-adjust column width based on content length**
 	    let colWidths = finalData[1].map((_, colIndex) => {
 	        let maxLength = Math.max(
 	            ...finalData.map(row => (row[colIndex] ? row[colIndex].toString().length : 10)), // Minimum width of 10
 	            finalData[0][colIndex] ? finalData[0][colIndex].length : 10 // Include header length
 	        );
 	        return { wch: maxLength + 5 }; // Add extra space for readability
 	    });
 	    ws["!cols"] = colWidths;

 	    // **Ensure All Data is Center-Aligned**
 	    let range = XLSX.utils.decode_range(ws["!ref"]);
 	    for (let R = range.s.r; R <= range.e.r; ++R) {
 	        for (let C = range.s.c; C <= range.e.c; ++C) {
 	            let cellAddress = XLSX.utils.encode_cell({ r: R, c: C });
 	            if (!ws[cellAddress]) continue; // Skip if the cell doesn't exist

 	            if (!ws[cellAddress].s) ws[cellAddress].s = {}; // Ensure the style object exists
 	            ws[cellAddress].s = {
 	                alignment: { horizontal: "center", vertical: "center" }, // Center align
 	                font: { name: "Arial", sz: 12 }, // Optional: Adjust font size for readability
 	                border: {
 	                    top: { style: "thin", color: { auto: 1 } },
 	                    bottom: { style: "thin", color: { auto: 1 } },
 	                    left: { style: "thin", color: { auto: 1 } },
 	                    right: { style: "thin", color: { auto: 1 } }
 	                }
 	            };
 	        }
 	    }

 	    // Append sheet to workbook
 	    XLSX.utils.book_append_sheet(wb, ws, "Calculation Data");

 	    // Export as Excel file
 	    XLSX.writeFile(wb, "calculation_data.xlsx");
 	});
	
// ========== input output table excel- export - code end ========================== 		  
	
// onclick on the nt quote menu return the 	NtQuote List Page	 
			 function redirectNtQuoteListPage(){
			  	//	alert("redirectNtQuoteListPage called ");
			  		window.location.href = "/rev-aux/ntQuoteListMainPage"; 
			  	}
		  