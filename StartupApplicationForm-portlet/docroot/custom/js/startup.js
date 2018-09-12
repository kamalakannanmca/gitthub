$(document)
		.ready(
				function() {
					var isNew = false;
					$('#gsr_department_yes').removeAttr('checked');
					$('#gsr_department_no').removeAttr('checked');
					$('#new')
							.click(
									function() {
										isNew = true;
										$("#gsr_row").hide();
										$("#mainForm").show();
										$("#continue_row").hide();
										$("#partial").hide();
										// $("#<portlet:namespace/>configform").reset();
										$('#_startup_WAR_StartupApplicationFormportlet_a')[0]
												.reset();
										console.log($('#_startup_WAR_StartupApplicationFormportlet_a')[0]);
										resetRegNum();
								});

					if (!$("#gsrHide").val()) {
						$("#mainForm").hide();
						$("#continue_row").hide();
						$("#partial").hide();
					} else {
						$("#gsr_row").hide();
						$("#mainForm").show();
						$("#continue_row").hide();
						$("#partial").hide();
						loadfromsession();
					}
					$('#cont').click(function() {
						$("#mainForm").hide();
						$("#continue_row").show();
						$("#partial").show();
					});
					// loadfromsession();
					/* Adding row for Capital infusion- 01/09/16 */
					$("table")
							.delegate(
									'.tr_clone_add',
									'click',
									function(event) {
										event.stopPropagation();
										var rowCount = $('#promotors_list tr').length;
										var rowCountPrev = rowCount - 1;
										console.log(rowCount);
										var thisRow = $(this).closest(
												'.tr_clone')[0];
										$(thisRow).clone().insertAfter(thisRow)
												.find(':input', 'textarea')
												.val('');
										var objTd = $(thisRow).next().closest(
												'.tr_clone');
										objTd
												.find(
														'#ficp_name_'
																+ rowCountPrev)
												.attr("id",
														"ficp_name_" + rowCount);
										objTd
												.find(
														'#ficp_address_'
																+ rowCountPrev)
												.attr(
														"id",
														"ficp_address_"
																+ rowCount);
										objTd.find(
												'#ficp_amount_' + rowCountPrev)
												.attr(
														"id",
														"ficp_amount_"
																+ rowCount);
									});
					$("table")
							.delegate(
									'.tr_clone_remove',
									'click',
									function() {
										if ($(".tr_clone").length > 1) {
											var thisRow = $(this).closest(
													'.tr_clone')[0];
											$(thisRow).clone().before(thisRow)
													.remove();
										}
									});

					$("#typeOfFinancialAssist").hide();

					var options = document
							.getElementById("financial_bank_engagement").options;
					var id = options[options.selectedIndex].id;
					if (parseInt(id) == 1) {
						$("#typeOfFinancialAssist").show();
					}

				});

// var reg_name = /^[A-Za-z\s]{1,}[\_-]{0,1}[A-Za-z\s]{0,}$/;
var reg_name = /^[ A-Za-z.]*$/;
var reg_digit = /^(([1-9]*)|(([1-9]*).([0-9]*)))$/;
var reg_email = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
var reg_specialchar = /^[a-zA-Z0-9 !@,._-]*$/;
var reg_alfanum = /^[a-zA-Z0-9]*$/;
var reg_phone = /^[0-9\-\+]{9,15}$/;
var reg_url = /^(http|https|ftp):\/\/[a-z0-9]+([\-\.]{1}[a-z0-9]+)*\.[a-z]{2,5}(:[0-9]{1,5})?(\/.*)?$/i;
var regex_only_aplha = /^[a-zA-Z]*$/;
var initial_found = /^[A-Za-z\s]{1,}[\_-]{0,1}[A-Za-z\s]{0,}$/;

$(function() {
	$("#date_of_establishment").datepicker({
		dateFormat : 'dd-mm-yy',
		changeMonth : true,
		changeYear : true,
		yearRange : "-100:+0",
		maxDate : '+0d'
	});
});

$(function() {
	$("#valuation_date").datepicker({
		dateFormat : 'dd-mm-yy',
		changeMonth : true,
		changeYear : true,
		yearRange : "-100:+0",
		maxDate : '+0d'
	});
});

$(function() {
	$("#incorporation_date").datepicker({
		dateFormat : 'dd-mm-yy',
		changeMonth : true,
		changeYear : true,
		yearRange : "-100:+0",
		maxDate : '+0d'
	});
});

function onlyCharacters(id, event) {
	var key = event.keyCode || event.which;
	if ((key > 64 && key < 91) || (key > 96 && key < 123) || key == 32)
		return true;
	else
		event.preventDefault();
}

// JS validation starts



// validate method ends

function ompandrimp() {
	var one = 0;
	var two = 0;

	if (parseInt($("#omp").val()) != null) {
		one = parseInt($("#omp").val());
	}
	if (parseInt($("#rimp").val()) != null) {
		two = parseInt($("#rimp").val());
	}
	$("#nmp").val(one + two);
	if ((one + two) > 24) {
		$("#errdisplay").html(
				"<fmt:message key='err.fault.sbi.startup.rimpomp' />");
		$("#nmp").val(one);
	} else {
		$("#errdisplay").html("");
	}

}

function OnlyNumericEntry(event) {
	var key = event.keyCode || event.which;
	if ((key < 48 || key > 57)) {
		event.preventDefault();
	}
}

function checkRS(id, event) {
	var key = event.keyCode || event.which;
	if ((key < 48 || key > 57) && key != 46) {
		event.preventDefault();
	} else if (key == 46) {
		var inputValue = $(id).val();
		var count = inputValue.split(".").length - 1;
		if (parseInt(count) > 0) {
			event.preventDefault();
		}
	} else {
		event.returnValue = true;
	}
}

function addZero(id, event) {
	var str = $(id).val();
	var check = str.substring(str.indexOf(".") + 1);
	if (check == "") {
		$(id).val(str.replace(".", ""));
	}
}

function hideShowDiv() {
	var options = document.getElementById("financial_bank_engagement").options;
	var id = options[options.selectedIndex].id;

	if (parseInt(id) == 1) {
		$("#typeOfFinancialAssist").show();
		$("#financial_assistance_purpose_id").show();

	} else {
		$("#typeOfFinancialAssist").hide();
		$("#financial_assistance_purpose_id").hide();
	}
}

function hideShowContinueForm(selectedValue) {
	var id = $("input[type='radio'][name='gsr_department']:checked").val();
	if (id == "Yes") {
		$("#not_eligible").hide();
		$("#continue_row").show();
	} else {
		$("#not_eligible").show();
		$("#continue_row").hide();
		$("#partial").hide();
	}
}

function hideShowForm(selectedValue) {
	var id = $("input[type='radio'][name='continue_save_form']:checked").val();
	if (id == "Yes") {
		$("#not_eligible").hide();
		$("#partial").show();
	} else {
		$("#gsr_row").hide();
		$("#not_eligible").hide();
		$("#continue_row").hide();
		$("#partial").hide();
		$("#mainForm").show();
	}
}

function hideShowIncubator(selectedValue) {
	var incubator = $("input[type='radio'][name='startupindia']:checked").val();
	if (incubator == "Yes") {
		$("#incubator_row").show();

	} else {
		$("#incubator_row").hide();
	}
}

function addRowpromotor(tableID1) {

	var table1 = document.getElementById(tableID1);

	var rowCount = table1.rows.length;
	var row = table1.insertRow(rowCount);

	var colCount = table1.rows[0].cells.length;
	console.log(colCount);
	for ( var i = 0; i < colCount; i++) {
		var newcell = row.insertCell(i);
		newcell.innerHTML = table1.rows[0].cells[i].innerHTML;

	}
	for ( var j = 0; j <= rowCount; j++) {
		addClass(tableID1, j);
	}
}

function addClass(tableID3, rownum) {

	// console.log(tableID.rows[rownum].cells[0]);
	var prom_table1 = document.getElementById(tableID3);
	prom_table1.rows[rownum].setAttribute("id", "ficp_row_" + rownum);
	prom_table1.rows[rownum].setAttribute("class", "tr_clone");
	prom_table1.rows[rownum].cells[0].setAttribute("id", "ficp_name_" + rownum);
	prom_table1.rows[rownum].cells[1].setAttribute("id", "ficp_address_"
			+ rownum);
	prom_table1.rows[rownum].cells[2].setAttribute("id", "ficp_amount_"
			+ rownum);

}

function addRow(tableID) {

	var table = document.getElementById(tableID);
	var rowCount = table.rows.length;

	var row = table.insertRow(rowCount);
	var colCount = table.rows[0].cells.length;
	for ( var i = 0; i < colCount; i++) {
		var newcell = row.insertCell(i);
		newcell.innerHTML = table.rows[0].cells[i].innerHTML;
	}

	for ( var j = 0; j <= rowCount; j++) {
		showMinus(tableID, j);
	}
}

function showMinus(ltableID3, lrownum) {
	var ltable = document.getElementById(ltableID3);

	ltable.rows[lrownum].setAttribute("id", "row_" + lrownum);
	ltable.rows[lrownum].setAttribute("class", "row_" + lrownum);
	ltable.rows[lrownum].cells[0]
			.setAttribute("id", "initial_found_" + lrownum);
	ltable.rows[lrownum].cells[1].setAttribute("id", "chk_prom_" + lrownum);

}

function deleteRow(tableID, i) {
	try {
		// var table = document.getElementById(tableID);

		var table = document.getElementById(tableID);

		var rowCount = table.rows.length;

		if (parseInt(rowCount) <= 1) {
			// alert("Cannot delete all the rows.");
		} else {
			var trid = $(i).closest('tr').attr('id');
			var index = document.getElementById(trid).rowIndex;
			document.getElementById(tableID).deleteRow(index);
		}

	} catch (e) {
		console.log(e);
	}
}

function founder_list() {

	var table = document.getElementById('founders_list');
	var rowCount = table.rows.length;

	// var map = {};
	var map1 = "";
	var map2 = "";

	if (rowCount > 1) {
		for ( var i = 0; i < rowCount; i++) {
			$('#initial_found_' + i).children('#initial_founders').each(
					function() {
						// map[$(this).val()] =
						// $('#chk_prom_'+i).children('#is_promoter').is(':checked');
						map1 += $(this).val() + ",";

						if ($('#chk_prom_' + i).children().children(
								'#is_promoter').is(':checked')) {
							map2 += $(this).val() + ",";
						}

					});

			$("#founders").val(map1);
			$("#promoters").val(map2);
		}
	} else {
		$("#founders").val(
				$('#initial_found_0').children('#initial_founders').val());
		$("#promoters").val(
				$('#initial_found_0').children('#initial_founders').val());
	}

}

function infused_promoter_list() {

	var table = document.getElementById('promotors_list');
	var rowCount = table.rows.length;

	var promap1 = "";
	var promap2 = "";
	var promap3 = "";

	for ( var i = 0; i < rowCount; i++) {
		$('#ficp_name_' + i).children('#cp_promoters_name').each(function() {
			promap1 += $(this).val() + ",";
		});
		$('#ficp_address_' + i).children('#cp_promoters_address').each(
				function() {
					promap2 += $(this).val() + "$";
				});
		$('#ficp_amount_' + i).children('#cp_promoters_amount').each(
				function() {
					promap3 += $(this).val() + ",";
				});

	}

	$("#cp_promoters_names").val(promap1);
	$("#cp_promoters_addresses").val(promap2);
	$("#cp_promoters_amounts").val(promap3);
}

function getDesc(eve) {

	var newID = "#count_" + eve.id;
	if ($(eve).val().length > 1500) {
		$("#" + eve.id).val($("#" + eve.id).val().substring(0, 1500));
	}
	$(newID).text(" " + (1500 - $(eve).val().length));
}

function getModel(eve) {
	var newID = "#count_" + eve.id;
	if ($(eve).val().length > 1500) {
		$("#" + eve.id).val($("#" + eve.id).val().substring(0, 1500));
	}
	$(newID).text(" " + (1500 - $(eve).val().length));
}

function getMonetary(eve) {
	var newID = "#count_" + eve.id;
	if ($(eve).val().length > 1500) {
		$("#" + eve.id).val($("#" + eve.id).val().substring(0, 1500));
	}
	$(newID).text(" " + (1500 - $(eve).val().length));
}

function financialAssistance(eve) {
	var newID = "#count_" + eve.id;
	if ($(eve).val().length > 1500) {
		$("#" + eve.id).val($("#" + eve.id).val().substring(0, 1500));
	}
	$(newID).text(" " + (1500 - $(eve).val().length));
}

// added on 1st sept
function saveForm() {

	var registered_name = $("#registered_name").val();
	if (registered_name == "") {
		$("#errdisplay").html(
				"<fmt:message key='err.fault.sbi.startup.registered_name' />");
		return false;
	}

	if (reg_name.test(registered_name) == false) {
		$("#errdisplay")
				.html(
						"<fmt:message key='err.fault.sbi.startup.registered_name_char' />");
		return false;
	}

	var date_of_establishment = $("#date_of_establishment").val();
	if (date_of_establishment == "") {
		$("#errdisplay")
				.html(
						"<fmt:message key='err.fault.sbi.startup.date_of_establishment' />");
		return false;
	}

	var constitution = $('#constitution :selected').val();
	if (constitution == 0) {
		$("#errdisplay").html(
				"<fmt:message key='err.fault.sbi.startup.constitution' />");
		return false;
	}
	// address validations
	var address_line_1 = $("#address_line_1").val();
	if (address_line_1 == "") {
		$("#errdisplay").html(
				"<fmt:message key='err.fault.sbi.startup.address_line_1' />");
		return false;
	}

	var address_city = $("#address_city").val();
	if (address_city == "") {
		$("#errdisplay").html(
				"<fmt:message key='err.fault.sbi.startup.address_city' />");
		return false;
	}
	var address_pin = $("#address_pin").val();
	if (address_pin == "") {
		$("#errdisplay").html(
				"<fmt:message key='err.fault.sbi.startup.address_pin' />");
		return false;
	}
	if (address_pin.length < 6) {
		$("#errdisplay").html(
				"<fmt:message key='err.fault.sbi.startup.address_pin_char' />");
		return false;
	}
	var address_state = $("#address_state :selected").val();
	if (address_state == 0) {
		$("#errdisplay").html(
				"<fmt:message key='err.fault.sbi.startup.address_state' />");
		return false;
	}
	// address validation ends

	var corporate_email = $("#corporate_email").val();
	if (corporate_email == "") {
		$("#errdisplay").html(
				"<fmt:message key='err.fault.sbi.startup.corporate_email' />");
		return false;
	}
	if (reg_email.test(corporate_email) == false) {
		$("#errdisplay")
				.html(
						"<fmt:message key='err.fault.sbi.startup.corporate_email_char' />");
		return false;
	}

	saveData();

}

function enableSaveButton() {

	$(".saveForm").prop('disabled', false);

}

function fetchCapitalInfuTable(capName, capAddress, capAmount, capInfuTotal) {
	if (capName != "") {

	var fieldName = capName.split('$');
	var address = capAddress.split('$');
	var amount = capAmount.split('$');
	var table = document.getElementById('promotors_list');
	if (capInfuTotal == 1) {
	$('#ficp_name_0').children('#cp_promoters_name').val(fieldName[0]);
	$('#ficp_address_0').children('#cp_promoters_address').val(
	address[0]);
	$('#ficp_amount_0').children('#cp_promoters_amount').val(amount[0]);
	} else {
	$('#ficp_name_0').children('#cp_promoters_name').val(fieldName[0]);
	$('#ficp_address_0').children('#cp_promoters_address').val(
	address[0]);
	$('#ficp_amount_0').children('#cp_promoters_amount').val(amount[0]);
	for ( var x = 1; x < capInfuTotal; x++) {
	if (!fieldName[x] == "") {
	var rowCount = table.rows.length;
	var row = table.insertRow(rowCount);
	var colCount = table.rows[0].cells.length;
	for ( var i = 0; i < colCount; i++) {
	var newcell = row.insertCell(i);
	newcell.innerHTML = table.rows[0].cells[i].innerHTML;
	}
	addClass('promotors_list', x);
	$('#ficp_name_' + x).children('#cp_promoters_name').val(
	fieldName[x]);
	$('#ficp_address_' + x).children('#cp_promoters_address').val(
	address[x]);
	$('#ficp_amount_' + x).children('#cp_promoters_amount').val(
	amount[x]);
	}
	}
	}
	}
	}


function fetchPromoterTable(initialFounders, current_promoters,
		initialFoundersTotal) {

		if (initialFounders != "") {
		var field = initialFounders.split(",");
		var cp = current_promoters.split(",");
		var table = document.getElementById('founders_list');

		if (initialFoundersTotal == 1) {
		$('#initial_found_0').children('#initial_founders').val(field[0]);
		if ($.inArray(field[0], cp) !== -1) {
		$('#chk_prom_0').children().children('#is_promoter').prop(
		"checked", true);
		}
		} else {
		$('#initial_found_0').children('#initial_founders').val(field[0]);
		if ($.inArray(field[0], cp) !== -1) {
		$('#chk_prom_0').children().children('#is_promoter').prop(
		"checked", true);
		}
		for ( var x = 1; x <= initialFoundersTotal; x++) {
		if (!field[x] == "") {
		var rowCount = table.rows.length;
		var row = table.insertRow(rowCount);
		var colCount = table.rows[0].cells.length;
		for ( var i = 0; i < colCount; i++) {
		var newcell = row.insertCell(i);
		newcell.innerHTML = table.rows[0].cells[i].innerHTML;
		}
		showMinus('founders_list', x);
		$('#initial_found_' + x).children('#initial_founders').val(
		field[x]);
		if ($.inArray(field[x], cp) !== -1) {
		$('#chk_prom_' + x).children().children('#is_promoter')
		.prop("checked", true);
		}
		}
		}
		}
		}
		}


function reset(){
	$('#founders').val("");
	$('#promoters').val("");
	$('#cp_promoters_names').val("");
	$('#cp_promoters_addresses').val("");
	$('#cp_promoters_amounts').val("");
	$('#gsrHide').val("");
	$('#registered_name').val("");
	$('#date_of_establishment').val("");
	$('#constitution').val("");
	$('#corporate_website').val("");
	$('#corporate_email').val("");
	$('#initial_founders').val("");
	
	$('#excluding_promoters').val("");
	$('#description_of_product').val("");
	$('#financial_assi_purp').val("");
	$('#initial_capital').val("");
	$('#monetary_value').val("");
	$('#business_model').val("");
	$('#current_capital').val("");
	
	$('#capital_infusion').val("");
	$('#gross_revenue_year2_investors').val("");
	$('#valuation_amount').val("");
	$('#Loans_availed').val("");
	$('#valuer_name').val("");
	$('#valuation_date').val("");
	$('#valuation_amount_rs').val("");
	
	$('#loan_avail_source').val("");
	$('#loan_avail_rs').val("");
	$('#revenue_project_year1').val("");
	$('#revenue_project_year2').val("");
	$('#revenue_project_year3').val("");
	$('#gross_projected_revenue_rs1').val("");
	$('#gross_projected_revenue_rs2').val("");
	
	$('#gross_projected_revenue_rs3').val("");
	$('#gross_revenue_year1').val("");
	$('#gross_revenue_rs1').val("");
	$('#gross_revenue_year2').val("");
	$('#gross_revenue_rs2').val("");
	$('#gross_revenue_year3').val("");
	$('#gross_revenue_rs3').val("");
	
	$('#ebidta_rs1').val("");
	$('#ebidta_rs2').val("");
	$('#cp_promoters_amounts').val("");
	$('#cp_promoters_addresses').val("");
	$('#cp_promoters_names').val("");
	$('#noofemp').val("");
	$('#ebidta_rs3').val("");

	$('#net_profit').val("");
	$('#net_profit_rs1').val("");
	$('#net_profit_rs2').val("");
	$('#net_profit_rs3').val("");
	$('#financial_bank_engagement').val("");
	$('#financial_assistance').val("");
	$('#revenue_projections').val("");
	
	$('#agreeable_process').val("");
	$('#startupindia').val("");
	$('#incubator').val("");
	$('#address_line_1').val("");
	$('#address_line_2').val("");
	$('#address_city').val("");
	$('#address_pin').val("");
	$('#address_landmark').val("");
	$('#address_state').val("");
	
	
	
}
