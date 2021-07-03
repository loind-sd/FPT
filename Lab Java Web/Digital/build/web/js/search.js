/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//window.onload = function () {
//    var a = document.getElementsByName("titlteSearch");
//    var txt = document.getElementsByClassName("searchBox")[0].value;
//    console.log(a[0].title);
//    var i;
//    for (i = 0; i < a.length; i++) {
//        let title = a[i].title;
//        console.log(title[2]);
//        changeBackgroundSearchWord(i, title.indexOf(txt), txt.length);
//    }
//};
//
//function changeBackgroundSearchWord(index, begin, length) {
//    var a = document.getElementsByName("titlteSearch")[index];
//    var i;
//    for (i = 0; i < length; i++) {
//        a.style.color = "yellow";
//        begin++;
//    }
//}


function checkEmpty() {
    var a = document.getElementById('box').value;
    var form = document.getElementById('form');
    var o = document.getElementById('oldTxt').value;

    if (a.trim() === "") {
        alert("Please fill Search box!!!");
        form.action = "search?txtSearch=" + o;
    } else {
        form.action = "search";
    }
}

