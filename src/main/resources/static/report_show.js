$(document).ready(function() {
    $("#report_show_trigger").click(function (e) { 
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
        $.get("summary/drivers/" + date1 + "/" + date2, function(data, status) {
            if(status != "success") {
                alert("Generowanie nie powiodło się.");
                return;
            }
            $("#report_info").empty();
            for(let i = 0; i < data.length; ++i) {
                let driver = data[i];
                let fragment = $("<div class=\"w3-border w3-border-red\"></div>");
                fragment.append("<p>ID kierowcy: " + driver.id + "</p>");
                fragment.append("<p>Imię i nazwisko: " + driver.name + " " + driver.surname + "</p>");
                fragment.append("<p>Paczki na czas: " + driver.box_ontime + "</p>");
                fragment.append("<p>Paczki opóźnione: " + driver.box_notontime + "</p>");
                fragment.append("<p>Waga paczek: " + driver.box_weight + "</p>");
                fragment.append("<p>Godziny pracy: " + driver.work_hours + "</p>");
                //fragment.append("<p>Przejechane kilometry: " + driver.work_kilometers + "</p>");
                //fragment.append("<p>Średnia prędkość: " + driver.avg_speed + "</p>");

                $("#report_info").append(fragment).append("<br/>");
            }
            alert("Raport wygenerowany")
        }).fail(function() {
            alert("Generowanie nie powiodło się.");
        });
    });
});