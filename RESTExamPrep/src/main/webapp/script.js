/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {


    $("#svg2").click(function () {
        
        $(event.target).css("fill","ff0000");
        var x = event.target.id;
        console.log(x);
        var y = "http://restcountries.eu/rest/v1/alpha?codes=" + x;
        $.get(y, function(result) {   
                console.log("Name: " + result[0].name + " Population: " + result[0].population);
                $("div").html("Name: " + result[0].name + " Population: " + result[0].population);
            });
    });
});




