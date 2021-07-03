/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function checkEmpty() {
    var a = document.getElementById('box').value;
    var form = document.getElementById('form');


    if (a.trim() === "") {
        alert("Please fill Search box!!!");
        form.action = "#";
    } else {
        form.action = "search";
    }
}


