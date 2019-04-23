$(document).ready(function () {
    let tmp = $("#packages").children().first().clone();
    $("#new_package").click(function(e) {
        e.preventDefault();
        $("#packages").append(tmp.clone());
        $("#packages").append("<br/>");
    });
    $("#make_order").click(function(e) {
        e.preventDefault();
        val = {
            customerId: $(".customer_id").first().val(),
            name: $(".representative_name").first().val(),
            surname: $(".representative_surname").first().val(),
            phoneNumber: $(".representative_phone_number").first().val(),
            sourceAddress: {
                city: $(".source_city").first().val(),
                street: $(".source_street").first().val(),
                buildingNumber: $(".source_building_number").first().val()
            },
            destinationAddress: {
                city: $(".destination_city").first().val(),
                street: $(".destination_street").first().val(),
                buildingNumber: $(".destination_building_number").first().val()
            },
            packageList: []
        };
        if(val.name == "" || val.surname == "" || val.phoneNumber == "") {
        	alert("Niepełne dane osobowe!"); return;
        }
        if(val.sourceAddress.city == "" || val.destinationAddress.city == "") {
        	alert("Brak miasta"); return;
        }
        if(val.sourceAddress.street == "" || val.destinationAddress.street == ""){
        	alert("Brak ulicy"); return;
        }
        if(val.sourceAddress.buildingNumber == "" || val.destinationAddress.buildingNumber == "") {
        		alert("Brak numeru budynku"); return;
        }
        $("#packages").children().each(function (index, element) {
            if(index % 2 == 1)return;
            let elem = {
                weight: $(element).find(".weight").first().val(),
                dimensionX: $(element).find(".dimension_x").first().val(),
                dimensionY: $(element).find(".dimension_y").first().val(),
                dimensionZ: $(element).find(".dimension_z").first().val(),
                type: $(element).find(".type").first().val(),
                description: $(element).find(".description").first().val(),
            };
            val.packageList.push(elem);
        });
        $.ajax({
            type: "post",
            url: "order",
            data: JSON.stringify(val),
            dataType: "json",
            contentType: "application/json",
            success: function (result) {
            	alert("Dodano zlecenie");
            },
            error: function() {
                alert("Nie udało się dodać zlecenia. Spróbuj jeszcze raz.");
            }
        });
        
    });
});