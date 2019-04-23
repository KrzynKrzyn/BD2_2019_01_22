$(document).ready(function () {
    let tmp = $("#packages").children().first().clone();
    $("#new_package").click(function(e) {
        e.preventDefault();
        $("#packages").append(tmp.clone());
        $("#packages").append("<br/>");
    });
    $("#new_status").click(function(e) {
    	
        e.preventDefault();
        val = {
            new_status: $("#status").val(),
            course_id: $("#course_id").val(),
            address: {
                city: $("#city").val(),
                street: $("#street").val(),
                buildingNumber: $("#building_number").val()
            },            
            packages_id: []
        };
        if(val.course_id == "") {
        	alert("Brak numer kursu"); return;
        }
        if(val.address.city == "") {
        	alert("Brak miasta"); return;
        }
        if(val.address.street == ""){
        	alert("Brak ulicy"); return;
        }
        if(val.address.buildingNumber == "") {
        		alert("Brak numeru budynku"); return;
        }
        
        $("#packages").children().each(function (index, element) {
            if(index % 2 == 1)return;
            let elem = $(element).val();
            val.packages_id.push(elem);
        });
        $.ajax({
            type: "post",
            url: "packagestatus",
            data: JSON.stringify(val),
            dataType: "json",
            contentType: "application/json",
            success: function (result) {
            		alert("Zaaktualizowany status.");
            },
            error: function() {
                alert("Nie udało się zaaktualizować statusów. Spróbuj jeszcze raz.");
            }
        });
    });
});