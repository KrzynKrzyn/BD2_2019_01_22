$(document).ready(function() {
    $("#order_search_trigger").click(function (e) { 
        e.preventDefault();
        let date1 = $("#date_begin").val();
        let date2 = $("#date_end").val();
        // alert($("#date_begin").val());
        if(date1 == "") {
            alert("Podaj zakres początkowy");
            return;
        }
        if(date2 == "") {
            alert("Podaj zakres końcowy");
            return;
        }
        date1 = new Date(date1);
        date2 = new Date(date2);
        $.get("order/" + date1 + "/" + date2, function(data, status) {
            if(status != "success") {
                alert("Wyszukiwanie nie powiodło się.");
                return;
            }
            $("#order_info").empty();
            for(let i = 0; i < data.length; ++i) {
                let order = data[i];
                let fragment = $("<div class=\"w3-border w3-border-red\"></div>");
                fragment.append("<p>Numer zamówienia: " + order.id + "</p>");
                fragment.append("<p>Numer klienta: " + order.customerId + "</p>");
                fragment.append("<p>Osoba odpowiedzialna: " + order.representativeName + " " + order.representativeSurname+ "</p>");
                fragment.append("<p>Numer telefonu: " + order.representativePhoneNumber + "</p>");
                $.get("order/list/" + order.id, function(data, status) {
                    if(status != "success")return;
                    fragment.append("<p>Paczki: ");
                    for(let i = 0; i < data.length; ++i) {
                        fragment.append(data[i] + " ");
                    }
                    fragment.append("</p>");
                });
                $("#order_info").append(fragment).append("<br/>");
            }
        }).fail(function() {
            alert("Wyszukiwanie nie powiodło się.");
        });
    });
});
