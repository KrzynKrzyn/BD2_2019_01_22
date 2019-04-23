$(document).ready(function () {
    $("#package_search_trigger").click(function (e) {
        e.preventDefault();
        let data = new String($("#package_search").val());
        // data = parseInt(data, 10);
        if (data.length == 0) return;
        for (let i = 0; i < data.length; ++i) {
            if (data.charAt(i) < "0" || data.charAt(i) > "9") {
                alert("Numer może składać się tylko z cyfr");
                return;
            }
        }
        data = parseInt(data, 10);
        $.get("order/package/" + data,
            function (data, status) {
                if (status != "success") {
                    alert("Nie znaleziono paczki");
                    return;
                }
                $("#package_number").text("Numer paczki: " + data.id);
                $("#package_info").empty();
                let current_status = $("<p><b>Status: </b></p>").append(data.status);
                let dims = data.dimensionX + "cm x " + data.dimensionY + "cm x " + data.dimensionZ + "cm";
                let dimension = $("<p><b>Wymiary: </b></p>").append(dims);
                let weight =  $("<p><b>Waga: </b></p>").append(data.weight + "kg");
                $("#package_info").append(current_status).append(dimension).append(weight);
                $.get("order/package/content/" + data.contentId, function(data, status) {
                    let content_type = $("<p><b>Typ towaru: </b></p>").append(data.type);
                    let content_description = $("<p><b>Opis: </b></p>").append(data.description);
                    $("#package_info").append(content_type).append(content_description);
                });
                $.get("packagestatus/" + data.id, function(data2, status2) {
                    if(status2 != "success") {
                        return;
                    }
                    $("#package_history").empty();
                    $("#package_history").append("<b>Historia zmian statusów:</b>");
                    for(let i = 0; i < data2.length; ++i) {
                        let history = data2[i];
                        let fragment = "<p>Status: \"" + history.new_status + "\" - dodany dnia: " + history.date + "</p>";
                        $("#package_history").append(fragment);
                    }
                });  
            }).fail(function() {
            alert("Nie znaleziono paczki");
        });
        // alert(new String(data));
    });
});